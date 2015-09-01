package authority.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBManager;
import authority.dao.AdminLoginDAO;

public class AdminLoginDAOImpl implements AdminLoginDAO {
	@Override
	public boolean selectAdmin(String name, String password) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "select user_name, user_password from supermarket_user where user_role=1 and user_name = ? and user_password = fun_get_md5(?)" ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, password);
		return preparedStatement.executeQuery().next() ;
	}
}
