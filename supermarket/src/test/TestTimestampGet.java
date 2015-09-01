package test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.sun.rowset.CachedRowSetImpl;
import util.DBManager;

public class TestTimestampGet {
	public static void main(String[] args) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"select "
				+ "BILL_ID,PROVIDER,PRICE,GOODS_UNIT,GOODS_NUM,IS_PAY,GOODS_NAME,GOODS_DESC,BILL_TIME "
				+ "FROM supermarket_bill " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		ResultSet rs = preparedStatement.executeQuery() ;
		CachedRowSetImpl cached = new CachedRowSetImpl() ;
		cached.populate(rs) ;
		rs.close() ;
		cached.next() ;
		Object obj = cached.getObject(9) ;
		/*Method method = ResultSet.class.getMethod("getTimestamp", int.class) ;
		Object obj = method.invoke(cached,9) ;*/
		System.out.println(obj);
	}
}
