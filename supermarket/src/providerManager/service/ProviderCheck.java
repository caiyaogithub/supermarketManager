package providerManager.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import providerManager.vo.Provider;

/**
 * 
 * @description 检查Provider对象中属性的合法性
 *
 * @author hello world
 *
 */
public class ProviderCheck {
	/**
	 * 检查Provider对象的合法性
	 * @param provider
	 * @return
	 */
	public boolean checkProvider(Provider provider){
		
		return checkProviderName(provider.getProviderName()) &&
				checkProviderDesc(provider.getProviderDesc()) &&
				checkProviderLinkman(provider.getLinkman()) &&
				checkProviderTel(provider.getTelephone()) &&
				checkProviderFax(provider.getFax()) &&
				checkProviderAddress(provider.getAddress());
	}
	/**
	 * 校验传真号合法性
	 * @param fax
	 * @return
	 */
	public boolean checkProviderFax(String fax ){
		/*
		 * ^(0[0-9]{2,3}\\-)? 区号
		 * ([2-9][0-9]{6,7})+ 座机号
		 * (\\-[0-9]{1,4})?$ 分机号
		 */
		String regex = "^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?$" ;
		return Pattern.compile(regex).matcher(fax).matches() ;
	}
	/**
	 * 校验供应商联系人名合法性
	 * @param linkman
	 * @return
	 */
	public boolean checkProviderLinkman(String linkman) {
		/*
		 * 供应商联系人名需要满足的规则：
		 * 1. 长度1~50个字符（包括中英文）以内
		 * 2. 供应商联系人名只能包括英文、中文、下划线、数字
		 */
		String regex = "[a-zA-Z_\u4E00-\u9FA50-9]{1,20}" ;
		Matcher matcher = Pattern.compile(regex).matcher(linkman) ;
		return matcher.matches() ;
	}
	/**
	 * 校验供应商描述合法性
	 * @param desc
	 * @return
	 */
	public boolean checkProviderDesc(String desc) {
		/*
		 * 暂时不对其筛选
		 * TODO : 校验
		 */
		return true ;
	}
	/**
	 * 校验供应商名是否合法
	 * @param providerName
	 * @return
	 */
	public boolean checkProviderName(String providerName){
		/*
		 * 供应商名需要满足的规则：
		 * 1. 长度1~20个字符（包括中英文）以内
		 * 2. 用户名只能包括英文、中文、下划线、数字
		 */
		String regex = "[a-zA-Z_\u4E00-\u9FA50-9]{1,20}" ;
		Matcher matcher = Pattern.compile(regex).matcher(providerName) ;
		return matcher.matches() ;
	}

	/**
	 * 校验供应商电话号码
	 * @param telephone
	 * @return
	 */
	public boolean checkProviderTel(String telephone ){
		/*
		 * 用户电话需要满足的规则：
		 * 1. 可以是电话号和手机号
		 */
		return Pattern.compile("1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}").matcher(telephone).matches() ;
	}
	/**
	 * 校验地址合法性
	 * @param address
	 * @return
	 */
	public boolean checkProviderAddress(String address ){
		/*
		 * 暂时没有想到地址需要满足的规则
		 */
		return true ;
	}
	private static class Test {
		public static void main(String[] args) {
			ProviderCheck demo = new ProviderCheck() ;
			System.out.println(demo.checkProviderFax("4215030")) ;
		}
	}
}
