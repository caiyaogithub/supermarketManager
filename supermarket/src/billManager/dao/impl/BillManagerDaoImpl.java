package billManager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.rowset.CachedRowSet;

import util.DBManager;
import billManager.dao.BillManagerDAO;
import billManager.vo.Bill;

import com.sun.rowset.CachedRowSetImpl;

public class BillManagerDaoImpl implements BillManagerDAO {
	@Override
	public CachedRowSet selectAllBill() throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"select "
				+ "BILL_ID,b.PROVIDER_NAME,PRICE,GOODS_UNIT,GOODS_NUM,IS_PAY,GOODS_NAME,GOODS_DESC,BILL_TIME "
				+ "FROM supermarket_bill a "
				+ "inner join supermarket_provider b "
				+ "on a.PROVIDER = b.PROVIDER_ID " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery());
		preparedStatement.close();
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
	@Override
	public void insertBill(Bill bill) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = "insert into supermarket_bill values(BILLID_SEQ.Nextval,?,?,?,?,?,?,?,?)" ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setDouble(1, bill.getProviderId());
		preparedStatement.setDouble(2, bill.getPrice()) ;
		preparedStatement.setString(3, bill.getGoodsUnit());
		preparedStatement.setDouble(4, bill.getGoodsNum());
		preparedStatement.setString(5, String.valueOf(bill.getIsPay())) ;
		preparedStatement.setString(6, bill.getGoodsName());
		preparedStatement.setString(7, bill.getGoodsDesc());
		preparedStatement.setTimestamp(8, bill.getBillTime() ) ;
		preparedStatement.execute() ;
		preparedStatement.close() ;
		DBManager.releaseConn(conn) ;
	}
	@Override
	public void updateBill(Bill bill) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"update supermarket_bill set PROVIDER=?,PRICE=?,GOODS_UNIT=?,GOODS_NUM=?,IS_PAY=?,GOODS_NAME=?,GOODS_DESC=?,BILL_TIME=? where Bill_ID = ?" ;
			PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
			preparedStatement.setDouble(1, bill.getProviderId()) ;
			preparedStatement.setDouble(2, bill.getPrice()) ;
			preparedStatement.setString(3, bill.getGoodsUnit()) ;
			preparedStatement.setDouble(4, bill.getGoodsNum()) ;
			preparedStatement.setString(5, String.valueOf(bill.getIsPay())) ;
			preparedStatement.setString(6, bill.getGoodsName()) ;
			preparedStatement.setString(7, bill.getGoodsDesc()) ;
			preparedStatement.setTimestamp(8, bill.getBillTime()) ;
			preparedStatement.setDouble(9, bill.getBillId()) ;
			preparedStatement.execute() ;
			preparedStatement.close() ;
			DBManager.releaseConn(conn) ;
	}
	@Override
	public CachedRowSet findBillById(int billId ) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"select "
						+ "BILL_ID,b.PROVIDER_NAME,PRICE,GOODS_UNIT,GOODS_NUM,IS_PAY,GOODS_NAME,GOODS_DESC,BILL_TIME "
						+ "FROM supermarket_bill a "
						+ "inner join supermarket_provider b "
						+ "on a.PROVIDER = b.PROVIDER_ID where BILL_ID = ? " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setInt(1, billId ) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery()) ;
		preparedStatement.close() ;
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
	@Override
	public void deleteBillById(int billId) throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"delete from supermarket_bill where BILL_ID = ? " ;
			PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
			preparedStatement.setInt(1, billId) ;
			preparedStatement.execute() ;
			preparedStatement.close() ;
			DBManager.releaseConn(conn) ;
	}
	@Override
	public CachedRowSet selectBillByNameAndIsPay(String goodName, String isPay)
			throws Exception {
		Connection conn = DBManager.getConnection() ;
		String sql = 
				"select "
						+ "BILL_ID,b.PROVIDER_NAME,PRICE,GOODS_UNIT,GOODS_NUM,IS_PAY,GOODS_NAME,GOODS_DESC,BILL_TIME "
						+ "FROM supermarket_bill a "
						+ "inner join supermarket_provider b "
						+ "on a.PROVIDER = b.PROVIDER_ID where GOODS_NAME like ? and IS_PAY = ? " ;
		PreparedStatement preparedStatement = conn.prepareStatement(sql) ;
		preparedStatement.setString(1, "%" + goodName + "%") ;
		preparedStatement.setString(2, isPay ) ;
		CachedRowSetImpl cachedRowSet = new CachedRowSetImpl() ;
		cachedRowSet.populate(preparedStatement.executeQuery()) ;
		preparedStatement.close() ;
		DBManager.releaseConn(conn) ;
		return cachedRowSet ;
	}
}
