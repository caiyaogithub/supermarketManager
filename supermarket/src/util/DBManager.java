package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @description 数据库连接管理 
 * 
 * @author caiyao
 *
 */
public class DBManager {
	/**
	 * TODO: 数据库连接池
	 * 获取数据库连接
	 * @return Connection 
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
			Class.forName("oracle.jdbc.OracleDriver") ;
			String url = "jdbc:oracle:thin:@localhost:1521:caiyao" ;
			/*
			 * TODO: 从xml文件中读取
			 * 
			 */
			Connection conn = DriverManager.getConnection(url, "supermarketuser", "supermarket_password") ;
			return conn ;
	}
	/**
	 * 释放数据库连接
	 * @param conn
	 */
	public static void releaseConn(Connection conn ){
		try{
			conn.close(); 
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
}
