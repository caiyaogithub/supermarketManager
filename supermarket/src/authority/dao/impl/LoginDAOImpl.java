package authority.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBManager;
import authority.dao.LoginDAO;

public class LoginDAOImpl implements LoginDAO {
	@Override
	public boolean selectUser(String name, String password , int role ) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "" ;
		if(role == 1 ){
			sql = "select user_name, user_password from supermarket_user where user_role= ? and user_name = ? and user_password = fun_get_md5(?)" ;
		}else if(role == 0 ){
			sql = "select user_name, user_password from supermarket_user where user_role= ? and user_name = ? and user_password = ?" ;
		}
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setInt(1, role);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, password);
		return preparedStatement.executeQuery().next() ;
	}
}
