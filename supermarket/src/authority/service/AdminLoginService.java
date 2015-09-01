package authority.service;

import authority.dao.AdminLoginDAO;
import authority.dao.impl.AdminLoginDAOImpl;

/**
 * 
 * @description 管理员登录的功能 
 * 
 * @author caiyao
 *
 */
public class AdminLoginService {
	public boolean checkExist(String name , String password ) throws Exception {
		AdminLoginDAO adminDao = new AdminLoginDAOImpl() ;
		return adminDao.selectAdmin(name, password) ;
	}
}
