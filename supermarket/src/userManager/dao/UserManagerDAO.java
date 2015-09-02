package userManager.dao;

import javax.sql.rowset.CachedRowSet;

import userManager.vo.User;

/**
 * 
 * @description 用户管理相关数据库操作 
 * 
 * @author caiyao
 *
 */
public interface UserManagerDAO {
	/**
	 * 查询所有用户(除管理员)信息
	 * @return 可存储的结果集
	 */
	public CachedRowSet selectAllUser() throws Exception ;
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void insertUser( User user ) throws Exception ;
	/**
	 * 更行用户信息
	 * @param user
	 * @throws Exception
	 */
	public void updateUser(User user) throws Exception ;
	/**
	 * 根据用户ID查询用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public CachedRowSet findUserById(int userId ) throws Exception ;
	/**
	 * 根据用户ID删除用户
	 * @param userId
	 * @throws Exception
	 */
	public void deleteUserById(int userId ) throws Exception ;
	/**
	 * 根据用户名查找用户
	 * @param userName 用户名
	 * @return 查询结果集
	 * @throws Exception
	 */
	public CachedRowSet selectUserByName(String userName ) throws Exception ;
	/**
	 * 查询用户名为userName而且用户ID不为id的用户
	 * @param userName 用户名
	 * @param id 用户ID
	 * @return 
	 * @throws Exception
	 */
	public CachedRowSet selectUserByNameExceptId(String userName , int id ) throws Exception ;
}
