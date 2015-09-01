package authority.dao;

import java.sql.Connection;


/**
 * 
 * @description 定义管理员登录相关数据库操作 
 * 
 * @author caiyao
 *
 */
public interface AdminLoginDAO {
	/**
	 * 查询Admin信息
	 * @param name 用户名
	 * @param password 密码
	 * @return 是否存在结果集
	 */
	public boolean selectAdmin(String name , String password ) throws Exception ;
}
