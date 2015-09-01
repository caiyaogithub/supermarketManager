package providreManager.dao;

import javax.sql.rowset.CachedRowSet;

import providerManager.vo.Provider;

/**
 * 
 * @description 供应商管理相关数据库操作 
 * 
 * @author caiyao
 *
 */
public interface ProviderManagerDAO {
	/**
	 * 查询所有供应商信息
	 * @return 可存储的结果集
	 */
	public CachedRowSet selectAllProvider() throws Exception ;
	/**
	 * 添加供应商
	 * @param provider
	 * @throws Exception
	 */
	public void insertProvider( Provider provider ) throws Exception ;
	/**
	 * 更改供应商信息
	 * @param provider
	 * @throws Exception
	 */
	public void updateProvider( Provider provider ) throws Exception ;
	/**
	 * 根据供应商ID查询用户
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	public CachedRowSet findProviderById(double providerId ) throws Exception ;
	/**
	 * 根据供应商ID删除供应商
	 * @param providerId
	 * @throws Exception
	 */
	public void deleteProviderById(double providerId ) throws Exception ;
	/**
	 * 根据供应商名查找用户
	 * @param providerName 供应商名
	 * @return 查询结果集
	 * @throws Exception
	 */
	public CachedRowSet selectProviderByName(String providerName ) throws Exception ;
	/**
	 * 根据供应商名称和描述模糊查询供应商
	 * @param name 供应商名称
	 * @param desc 描述
	 * @return
	 */
	public CachedRowSet selectAProviderByNameOrDesc(String name , String desc ) throws Exception  ;
}
