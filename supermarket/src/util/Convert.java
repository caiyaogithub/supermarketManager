package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 
 * 使用这个类要求：
 * 	1. 数据库中列名两个单词之间用下划线分割
 * 	2. 数据库表对应的实体类属性命名使用驼峰命名
 * 	3. 单个单词都小些
 * @author caiyao 
 *
 * @function 类型转换
 * 
 * @version 2.1
 * 
 * @modifyTime : 2015-9-1
 */
public class Convert {
	/**
	 * 将CachedRowSetImpl中的多条记录存储进List中
	 * @param cachedRS CachedRowSetImpl结果集
	 * @param c List中元素类型
	 * @return ArrayList对象
	 * @throws SQLException  cachedRS.next()导致的异常
	 * @throws RuntimeException 
	 * @throws InvocationTargetException 
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T> ArrayList<T> RStoList(CachedRowSet cachedRS , Class<T> c)
			throws SQLException, InstantiationException, IllegalAccessException, 
			NoSuchMethodException, ClassNotFoundException, InvocationTargetException, 
			RuntimeException{
		if(!cachedRS.next()){
			return null ;
		}
		cachedRS.previous() ;// 由于上面执行了next，所有这里需要将指针移动到上一行
		ArrayList<T> store = new ArrayList<T>() ;
		while(cachedRS.next()){
			T object = RStoObject(cachedRS , c ) ;
			store.add(object) ;
		}
		return store ;
	}
	
	/**
	 * 将ResultSet类型的结果集转换成Object类型的对象
	 *  注： 
	 * 1. 该方法只能转换只有一条结果的CachedRowSet。 
	 * 2.rs结果集中得到的值xxx，在类中要有相应的setXxx方法
	 * 
	 * @param rs
	 *            结果集
	 * @param c
	 *            Class类型的值，可以通过Class.forName(类名)获取，要确定该类有无参的构造方法，
	 *            否则会出现InstantiationException异常
	 * @return 转换之后的对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws RuntimeException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 * @throws InvocationTargetException
	 *             注： 
	 * 			   1. 该方法只能转换只有一条结果的CachedRowSet。 
	 * 			   2.rs结果集中得到的值xxx，在类中要有相应的setXxx方法
	 *             3. 在单独调用这个方法的时候（不是通过RStoList的间接调用）。
	 *             需要在传递CachedRowSet这个参数之前调用rs的next()方法。否则会出现指针无效的错误
	 *             4. 使用该方法将结果集中的数据转储到对象中时，要对象中属性get/set方法要和数据库中
	 *             列名相对应。例如数据库列名为user_name,那么对象的方法就应该是setUserName/getUserName
	 */
	public static <T> T RStoObject(CachedRowSet rs , Class<T> c)
			throws InstantiationException, IllegalAccessException, 
			SQLException, NoSuchMethodException, RuntimeException, 
			ClassNotFoundException, InvocationTargetException{
		 // 要确定该类有无参的构造方法
		T instance = c.newInstance() ;
		// 获取元数据，以便得到列的信息
		ResultSetMetaData metaData = rs.getMetaData() ;
		// 获取列数
		int columnNum = metaData.getColumnCount() ;
		
		for(int i = 1 ; i <= columnNum ; i ++ ){
			String columnName = getColumnName(metaData.getColumnName(i)) ;
			Class<?> columnClassType = SQLTypeToClass(metaData.getColumnType(i)) ;
			columnClassType = getColumnClassType(columnName , columnClassType , c ) ;
			String columnTypeName = columnTypeToGetter(metaData.getColumnTypeName(i)) ;
			// 反射获取对象的set方法
			Method objectMethod = c.getMethod(
							"set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1), 
							columnClassType
							) ;
			// 反射获取CachedRowSetImpl的get方法
			Method RSGetter = CachedRowSetImpl.class.getMethod(
							"get"+columnTypeName.substring(0,1).toUpperCase()+columnTypeName.substring(1), 
							 int.class) ;
			// 执行RS的get方法获取属性值
			Object value = RSGetter.invoke(rs,i) ;
			// 执行Object的set方法为对象赋值
			objectMethod.invoke(instance, value) ;
		}
		// 返回对象
		return instance ;
	}
	
	/**
	 * 判断类c是否存在set'columnName'('columnClassType' x)方法。
	 * 如果不存在，再寻找是否存在set'columnName'('cloumnClassType的父类' x)方法，如果存在返回cloumnClassType的父类。
	 * 如果存在，则返回cloumnClassType原值。
	 * @param columnName 类c的属性名
	 * @param columnClassType 类c set方法的参数类型
	 * @param c 类c
	 * @return set方法的属性类型
	 */
	private static Class<?> getColumnClassType(String columnName , Class<?> columnClassType , Class<?> c ){
		/*
		 * 写该方法的原因：
		 * int/double 在oracle数据库中都是用Number表示。
		 * 所以从数据库中查询出来的数据无法辨别是int还是double， 也就导致无法正确通过反射获取对象的set方法，因为方法参数无法确定。
		 * 例如： Student表中有两个属性 int a , double b ;
		 * 存入数据库中就是都是Number，从数据库中取出也都是Number。
		 * 如果将Number对应于java的int，那么SQLTypeToClass（）方法返回的就是int.class,
		 * 无论从数据库中查询出来的是int还是double，因此，下面获取set方法就只能获取以int为参数的方法。 所以就无法获取到double
		 * b 的set方法。 反射获取方法是确定的，不会在找不到int参数方法时转而去找double参数方法。
		 * 该方法为了在找不到int为参数的方法时，继而找以double类型参数的方法。
		 * 或者以后会添加找不到子类类型为参数的方法继而找以其父类为参数的方法。
		 */
			try {
				c.getMethod("set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1), columnClassType).getName() ;
			} catch (NoSuchMethodException e) {
				return getSuperColumnClassType(columnClassType) ;
			} catch (SecurityException e) {}
			return columnClassType ;
	}
	/**
	 * 获取columnClassType的父类
	 * @param columnClassType 
	 * @return
	 */
	private static Class<?> getSuperColumnClassType(Class<?> columnClassType){
		if(columnClassType.equals(int.class)){
			return double.class ;
		}else{
			return columnClassType.getSuperclass() ;
		}
		
	}
	/**
	 * 获取与数据库列名对应的属性名。
	 * 例如：
	 * 		数据库列名				属性名
	 * 		user_name/username		userName
	 * @param rawColumnName 数据库列名
	 * @return 与数据库列名对应的对象属性名
	 */
	public static String getColumnName(String rawColumnName ){
		if(rawColumnName.matches(".*_.*")){
			String[] words = rawColumnName.split("_") ;
			String firstWord = words[0].toLowerCase() ;
			String lastWord = words[1].substring(0, 1).toUpperCase() + words[1].substring(1).toLowerCase() ;
			String attributeName = firstWord + lastWord ;
			return attributeName ;
		}else{
			/*
			 * 如果数据库列名不包含下划线，有可能只有一个单词，那么将首字母大写然后直接返回就行。
			 * 使用这个工具类要求数据库列名两个单词之间必须使用下划线分割。
			 */
			return rawColumnName.substring(0,1).toUpperCase() + rawColumnName.substring(1).toLowerCase() ;
		}
	}
	public static String columnTypeToGetter(String columnType){
		/**
		 * mysql数据库中存储字符串只有varchar，但是ResultSet接口中没有定义getVarchar（）方法所以将varchar转换成String即可，
		 */
		if(columnType.equals("VARCHAR")){
			return "String" ;
		}
		if(columnType.equals("NVARCHAR2")){
			return "String" ;
		}
		// oracle数据库NUMBER字段类型对应Java中int
		if(columnType.equals("NUMBER")){
			return "int" ;
		}
		if(columnType.toLowerCase().equals("timestamp")){
			return "object" ;
		}
		return columnType.toLowerCase() ;
	}
	/**
	 * 将封装后的原始类型名称转换成原始类型的class
	 * @param columnType 封装后的对象名称例如"java.lang.Integer" , "java.lang.Float" , "java.lang.Double"
	 * @return 原始类型class类型 例如int.class float.class double.class
	 * @throws ClassNotFoundException 
	 */
	public static Class<?> getColumnClassType(String columnType) throws ClassNotFoundException{
		/**
		 * 数据库中的int、float、double等原始列类型当通过getColumnClassName()方法获取时，会将原始类型打包成其基础类型封装对象 
		 * 例如 int --> Integer float --> Float double --> Double
		 * 该方法是为了将获取的基础类型封装类名转换成原始类型的class
		 */
		if(columnType.equals("java.lang.Integer")){
			 return int.class ;
		}
		if(columnType.equals("java.lang.Float")){
			return float.class ;
		}
		if(columnType.equals("java.lang.Double")){
			 return double.class ;
		}
		return Class.forName(columnType) ;
	}
	/**
	 * 将java.sql.Types类型转化成相应的Java中对应的Class
	 * @param SQLType java.sql.Types类型
	 * @return Class类型的实例例如 int.class
	 */
	public static  Class<?> SQLTypeToClass(int SQLType){
		switch(SQLType){
		case java.sql.Types.ARRAY : return String.class ;
		
		case java.sql.Types.BIGINT : return int.class ;
		
		case java.sql.Types.BIT : return byte.class ;
		
		case java.sql.Types.BOOLEAN : return boolean.class ;
		
		case java.sql.Types.CHAR : return char.class ;
		
		case java.sql.Types.DOUBLE : return double.class ;
		
		case java.sql.Types.FLOAT : return float.class ;
		
		case java.sql.Types.INTEGER : return int.class ;
		
		case java.sql.Types.LONGNVARCHAR : return String.class ;
		
		case java.sql.Types.LONGVARCHAR : return String.class ;
		
		case java.sql.Types.NCHAR : return String.class ;
		
		case java.sql.Types.NVARCHAR :return String.class ;
		
		case java.sql.Types.VARCHAR : return String.class ;
		// 通过rs.getDate()获取到的java.sql.Date能够直接将其赋值到java.util.Date会进行自动转换
		case java.sql.Types.DATE : return Date.class ;
		// oracle数据库的Number字段类型对应NUMERIC类型，
		//但是在数据库中整数和浮点数都是Number，
		//所以在应用中无法判断从数据库中取出的是整数还是浮点数.
		//处理方法是：在应用中都使用浮点数
		case java.sql.Types.NUMERIC : return int.class ;
		// 由于sun包中提供的CachedRowSetImpl类存在bug，当getTimestamp()字段时会出现类转换异常。
		// 解决方案有：
		// 1. 换类。oracle驱动包oracle.jdbc.rowset.OracleCachedRowSet类（大概是这个名字）可以正确执行。
		// 2. 换oracle驱动版本。10.0以上，这个我没有试过，有些人说可以。
		// 3. 如果使用sun提供的这个类，获取Timestamp时使用getObject()。然后再转换。
		// 因为考虑到该类的通用性，所以采用第三种解决方案。
		case java.sql.Types.TIMESTAMP : return Object.class ;
		
		default :return String.class ;
		}
	}
	public static Date StringTodate(String dateString , String format ) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);  
		  // 将时间字符串转换成java.util.Date对象  
        Date date = sdf.parse(dateString);  
		return date ;
	}
	public static java.sql.Date utildateTosqldate(Date date){
	    return new java.sql.Date(date.getTime());
	}
}