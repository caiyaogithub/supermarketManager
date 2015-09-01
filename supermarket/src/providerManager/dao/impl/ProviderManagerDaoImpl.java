package providerManager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import providerManager.vo.Provider;
import providreManager.dao.ProviderManagerDAO;
import util.Convert;
import util.DBManager;

import com.sun.rowset.CachedRowSetImpl;

public class ProviderManagerDaoImpl implements ProviderManagerDAO {
	@Override
	public CachedRowSet selectAllProvider() throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "select PROVIDER_ID , PROVIDER_NAME, PROVIDER_DESC ,LINKMAN ,TELEPHONE, FAX ,ADDRESS from supermarket_Provider" ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery());
		preparedStatement.close();
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
	@Override
	public void insertProvider(Provider provider) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "insert into supermarket_Provider values(PROVIDER_SEQ.Nextval,?,?,?,?,?,?)" ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setString(1, provider.getProviderName());
		preparedStatement.setString(2, provider.getProviderDesc());
		preparedStatement.setString(3, provider.getLinkman());
		preparedStatement.setString(4, provider.getTelephone());
		preparedStatement.setString(5, provider.getFax());
		preparedStatement.setString(6, provider.getAddress());
		preparedStatement.execute() ;
		preparedStatement.close();
		DBManager.releaseConn(conn) ;
	}
	@Override
	public void updateProvider(Provider provider) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"update supermarket_Provider set PROVIDER_NAME =?, PROVIDER_DESC =? ,LINKMAN =? ,TELEPHONE =?, FAX =?,ADDRESS =? where Provider_ID = ?" ;
			PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
			preparedStatement.setString(1, provider.getProviderName()) ;
			preparedStatement.setString(2, provider.getProviderDesc()) ;
			preparedStatement.setString(3, provider.getLinkman()) ;
			preparedStatement.setString(4, provider.getTelephone()) ;
			preparedStatement.setString(5, provider.getFax()) ;
			preparedStatement.setString(6, provider.getAddress()) ;
			preparedStatement.setDouble(7, provider.getProviderId()) ;
			preparedStatement.execute() ;
			preparedStatement.close() ;
			DBManager.releaseConn(conn) ;
	}
	@Override
	public CachedRowSet findProviderById(double providerId ) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "select PROVIDER_ID,PROVIDER_NAME,PROVIDER_DESC,LINKMAN,TELEPHONE,FAX,ADDRESS from supermarket_provider where PROVIDER_ID = ? " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setDouble(1, providerId ) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery()) ;
		preparedStatement.close() ;
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
	@Override
	public void deleteProviderById(double providerId) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"delete from supermarket_provider where provider_id = ? " ;
			PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
			preparedStatement.setDouble(1, providerId) ;
			preparedStatement.execute() ;
			preparedStatement.close() ;
			DBManager.releaseConn(conn) ;
	}
	@Override
	public CachedRowSet selectProviderByName(String providerName) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "select PROVIDER_ID , PROVIDER_NAME, PROVIDER_DESC ,LINKMAN ,TELEPHONE, FAX ,ADDRESS  from supermarket_provider where PROVIDER_NAME = ? " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setString(1, providerName ) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery()) ;
		preparedStatement.close() ;
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
	@Override
	public CachedRowSet selectAProviderByNameOrDesc(String name, String desc) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "select PROVIDER_ID , PROVIDER_NAME, PROVIDER_DESC ,LINKMAN ,TELEPHONE, FAX ,ADDRESS  from supermarket_provider where (PROVIDER_NAME like ? and PROVIDER_DESC like ?) " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setString(1, "%" + name + "%" ) ;
		preparedStatement.setString(2, "%" + desc + "%" ) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery()) ;
		preparedStatement.close() ;
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
	static class Test{
		public static void main(String[] args) {
			try{
				CachedRowSet cachedRows = new ProviderManagerDaoImpl().selectAProviderByNameOrDesc("2","") ;
				ArrayList<Provider> providers = Convert.RStoList(cachedRows, Provider.class) ;
				for(Provider provider : providers ){
					System.out.println(provider) ;
				}
			}catch(Exception e ){
				e.printStackTrace() ; 
			}
		}
	}
}
