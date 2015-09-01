package userManager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.rowset.CachedRowSet;

import userManager.dao.UserManagerDAO;
import userManager.vo.User;
import util.DBManager;

import com.sun.rowset.CachedRowSetImpl;

public class UserManagerDaoImpl implements UserManagerDAO {
	@Override
	public CachedRowSet selectAllUser() throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "select USER_ID , USER_NAME , USER_PASSWORD , GENDER , AGE , TELEPHONE_NUM , ADDRESS from supermarket_user where USER_ROLE = 0 " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery());
		preparedStatement.close();
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
	@Override
	public void insertUser(User user) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "insert into supermarket_user values(Userid_Seq.Nextval,?,?,?,?,?,?,?)" ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getUserPassword());
		preparedStatement.setString(3, user.getGender());
		preparedStatement.setDouble(4, user.getAge());
		preparedStatement.setString(5, user.getTelephoneNum());
		preparedStatement.setString(6, user.getAddress());
		preparedStatement.setDouble(7, user.getUserRole());
		preparedStatement.execute() ;
		preparedStatement.close();
		DBManager.releaseConn(conn) ;
	}
	@Override
	public void updateUser(User user) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"update supermarket_user set USER_NAME = ? ,USER_PASSWORD = ? , GENDER = ? ,AGE = ? ,TELEPHONE_NUM = ?, ADDRESS = ? ,USER_ROLE = ? where USER_ID = ?" ;
			PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
			preparedStatement.setString(1, user.getUserName()) ;
			preparedStatement.setString(2, user.getUserPassword()) ;
			preparedStatement.setString(3, user.getGender()) ;
			preparedStatement.setDouble(4, user.getAge()) ;
			preparedStatement.setString(5, user.getTelephoneNum()) ;
			preparedStatement.setString(6, user.getAddress()) ;
			preparedStatement.setDouble(7, user.getUserRole()) ;
			preparedStatement.setDouble(8, user.getUserId()) ;
			preparedStatement.execute() ;
			preparedStatement.close() ;
			DBManager.releaseConn(conn) ;
	}
	@Override
	public CachedRowSet findUserById(int userId ) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "select USER_ID ,USER_NAME ,USER_PASSWORD ,GENDER, AGE ,TELEPHONE_NUM, ADDRESS ,USER_ROLE from supermarket_user where USER_ID = ? " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setInt(1, userId ) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery()) ;
		preparedStatement.close() ;
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
	@Override
	public void deleteUserById(int userId) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"delete from supermarket_user where user_id = ? " ;
			PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
			preparedStatement.setInt(1, userId) ;
			preparedStatement.execute() ;
			preparedStatement.close() ;
			DBManager.releaseConn(conn) ;
	}
	@Override
	public CachedRowSet selectUserByName(String userName) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "select USER_ID ,USER_NAME ,USER_PASSWORD ,GENDER, AGE ,TELEPHONE_NUM, ADDRESS ,USER_ROLE from supermarket_user where USER_NAME = ? " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setString(1, userName ) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery()) ;
		preparedStatement.close() ;
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
}
