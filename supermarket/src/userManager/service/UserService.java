package userManager.service;

import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import userManager.dao.UserManagerDAO;
import userManager.dao.impl.UserManagerDaoImpl;
import userManager.vo.User;
import util.Convert;

/**
 * 
 * @description 用户管理相关功能 
 * 
 * @author caiyao
 *
 */
public class UserService {
	/**
	 * 查询所有用户（除管理员以外）信息
	 * @return ArrayList
	 */
	public ArrayList<User> allUser() throws Exception {
		UserManagerDAO userManagerDao = new UserManagerDaoImpl() ;
		CachedRowSet cachedRowSet = userManagerDao.selectAllUser() ;
		ArrayList<User> users = Convert.RStoList(cachedRowSet, User.class) ;
		return users ;
	}
	/**
	 * 添加用户(普通用户)
	 * @param user
	 */
	public void addUser(User user ) throws Exception {
		UserManagerDAO userManagerDao = new UserManagerDaoImpl() ;
		userManagerDao.insertUser(user) ;
	}
	/**
	 * 根据ID修改用户信息
	 * @param user
	 * @throws Exception
	 */
	public void modifyUser(User user ) throws Exception {
		UserManagerDAO userManagerDao = new UserManagerDaoImpl() ;
		userManagerDao.updateUser(user) ;
	}
	/**
	 * 根据userID查询User信息
	 * @param id
	 * @return
	 */
	public User findUserById(int id ) throws Exception {
		UserManagerDAO userManagerDao = new UserManagerDaoImpl() ;
		CachedRowSet cachedRowSet = userManagerDao.findUserById(id) ;
		cachedRowSet.next() ; // 将指针定位到第一行
		User users = Convert.RStoObject(cachedRowSet, User.class) ;
		return users ;
	}
	/**
	 * 根据用户ID删除用户信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserById(int id ) throws Exception {
		UserManagerDAO userManagerDao = new UserManagerDaoImpl() ;
		userManagerDao.deleteUserById(id) ;
	}
	/**
	 * 检查用户表中是否已经存在给定的用户名
	 * @param userName
	 * @return
	 */
	public boolean checkUserNameExist(String userName ) throws Exception {
		UserManagerDAO userManagerDao = new UserManagerDaoImpl() ;
		CachedRowSet cachedRowSet = userManagerDao.selectUserByName(userName) ;
		return cachedRowSet.next() ;
	}
	static class Test{
		public static void main(String[] args) {
			UserService demo = new UserService() ;
			try{
				for(User user : demo.allUser()){
					System.out.println(user);
				}
			}catch(Exception e ){
				e.printStackTrace();
			}
		}
	}
}