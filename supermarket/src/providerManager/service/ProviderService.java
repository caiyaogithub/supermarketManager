package providerManager.service;

import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import providerManager.dao.impl.ProviderManagerDaoImpl;
import providerManager.vo.Provider;
import providreManager.dao.ProviderManagerDAO;
import util.Convert;

/**
 * 
 * @description 供应商管理相关功能 
 * 
 * @author caiyao
 *
 */
public class ProviderService {
	/**
	 * 查询所有供应商信息
	 * @return ArrayList
	 */
	public ArrayList<Provider> allProvider() throws Exception {
		ProviderManagerDAO ProviderManagerDao = new ProviderManagerDaoImpl() ;
		CachedRowSet cachedRowSet = ProviderManagerDao.selectAllProvider() ;
		ArrayList<Provider> Providers = Convert.RStoList(cachedRowSet, Provider.class) ;
		return Providers ;
	}
	/**
	 * 添加供应商
	 * @param provider
	 */
	public void addProvider(Provider provider ) throws Exception {
		ProviderManagerDAO ProviderManagerDao = new ProviderManagerDaoImpl() ;
		ProviderManagerDao.insertProvider(provider) ;
	}
	/**
	 * 根据ID修改供应商信息
	 * @param provider
	 * @throws Exception
	 */
	public void modifyProvider(Provider provider ) throws Exception {
		ProviderManagerDAO ProviderManagerDao = new ProviderManagerDaoImpl() ;
		ProviderManagerDao.updateProvider(provider) ;
	}
	/**
	 * 根据ProviderID查询Provider信息
	 * @param id
	 * @return
	 */
	public Provider findProviderById(double id ) throws Exception {
		ProviderManagerDAO ProviderManagerDao = new ProviderManagerDaoImpl() ;
		CachedRowSet cachedRowSet = ProviderManagerDao.findProviderById(id) ;
		if(!cachedRowSet.next()){
			return null ;
		}
		Provider Providers = Convert.RStoObject(cachedRowSet, Provider.class) ;
		return Providers ;
	}
	/**
	 * 根据供应商ID删除供应商信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteProviderById(double id ) throws Exception {
		ProviderManagerDAO ProviderManagerDao = new ProviderManagerDaoImpl() ;
		ProviderManagerDao.deleteProviderById(id) ;
	}
	/**
	 * 检查供应商表中是否已经存在给定的供应商名
	 * @param providerName
	 * @return
	 */
	public boolean checkProviderNameExist(String providerName ) throws Exception {
		ProviderManagerDAO ProviderManagerDao = new ProviderManagerDaoImpl() ;
		CachedRowSet cachedRowSet = ProviderManagerDao.selectProviderByName(providerName) ;
		return cachedRowSet.next() ;
	}
	/**
	 * 根据供应商名称和描述查询供应商信息
	 * @return ArrayList
	 */
	public ArrayList<Provider> findProviderByNameOrDesc(String providerName , String providerDesc ) throws Exception {
		ProviderManagerDAO ProviderManagerDao = new ProviderManagerDaoImpl() ;
		CachedRowSet cachedRowSet = ProviderManagerDao.selectAProviderByNameOrDesc(providerName , providerDesc) ;
		ArrayList<Provider> Providers = Convert.RStoList(cachedRowSet, Provider.class) ;
		return Providers ;
	}
	
	/*static class Test{
		public static void main(String[] args) {
			ProviderService demo = new ProviderService() ;
			try {
				System.out.println(demo.findProviderById(3)) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/
}