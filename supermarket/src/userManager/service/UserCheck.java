package userManager.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import userManager.vo.User;

/**
 * 
 * @description 检查User对象中属性的合法性
 *
 * @author hello world
 *
 */
public class UserCheck {
	/**
	 * 检查User对象的合法性
	 * @param user
	 * @return
	 */
	public boolean checkUser(User user){
		
		return  checkUserName(user.getUserName()) &&
				checkPassword(user.getUserPassword()) &&
				checkGender(user.getGender()) &&
				checkAge(user.getAge()) &&
				checkTelephone(user.getTelephoneNum()) &&
				checkAddress(user.getAddress()) ;
	}
	/**
	 * 校验用户名是否合法
	 * @param userName
	 * @return
	 */
	public boolean checkUserName(String userName){
		/*
		 * 用户名需要满足的规则：
		 * 1. 长度1~20个字符（包括中英文）以内
		 * 2. 用户名只能包括英文、中文、下划线、数字
		 */
		String regex = "[a-zA-Z_\u4E00-\u9FA50-9]{1,20}" ;
		Matcher matcher = Pattern.compile(regex).matcher(userName) ;
		return matcher.matches() ;
	}
	/**
	 * 校验用户密码是否正确
	 * @param password 待校验的密码字符串
	 * @return 
	 */
	public boolean checkPassword(String password){
		/*
		 * 用户密码需要满足的规则：
		 * 1. 长度6~20以内
		 * 2. 必须包括数字、英文字符
		 */
		String regex = "([0-9]+)|([a-z]+)" ;
		Matcher matcher = Pattern.compile(regex).matcher(password) ;
		return !matcher.matches() ;
	}
	/**
	 * 校验性别
	 * @param gender
	 * @return
	 */
	public boolean checkGender(String gender ){
		/*
		 * 用户性别需要满足的规则：
		 * 1. 必须在男、女之间的一个值
		 */
		return gender.equals("男") || gender.equals("女") ;
	}
	/**
	 * 校验年龄
	 * @param age
	 * @return
	 */
	public boolean checkAge(double age ){
		/*
		 * 用户年龄需要满足的规则：
		 * 1. 年龄需要在10~150之间
		 */
		return age <= 150 && age >= 10 ; 
	}
	/**
	 * 校验用户电话号码
	 * @param telephone
	 * @return
	 */
	public boolean checkTelephone(String telephone ){
		/*
		 * 用户电话需要满足的规则：
		 * 1. 可以是电话号和手机号
		 * 2. 
		 * TODO: 校验电话的正则表达式
		 */
		
		return true ;
	}
	/**
	 * 校验地址合法性
	 * @param address
	 * @return
	 */
	public boolean checkAddress(String address ){
		/*
		 * 暂时没有想到地址需要满足的规则
		 */
		return true ;
	}
}
