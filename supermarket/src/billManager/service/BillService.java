package billManager.service;

import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import util.Convert;
import billManager.dao.BillManagerDAO;
import billManager.dao.impl.BillManagerDaoImpl;
import billManager.vo.Bill;

/**
 * 
 * @description 订单管理相关功能 
 * 
 * @author caiyao
 *
 */
public class BillService {
	/**
	 * 查询所有订单信息
	 * @return ArrayList
	 */
	public ArrayList<Bill> allBill() throws Exception {
		BillManagerDAO BillManagerDao = new BillManagerDaoImpl() ;
		CachedRowSet cachedRowSet = BillManagerDao.selectAllBill() ;
		ArrayList<Bill> Bills = Convert.RStoList(cachedRowSet, Bill.class) ;
		return Bills ;
	}
	/**
	 * 添加订单
	 * @param bill
	 */
	public void addBill(Bill bill ) throws Exception {
		BillManagerDAO BillManagerDao = new BillManagerDaoImpl() ;
		BillManagerDao.insertBill(bill) ;
	}
	/**
	 * 根据ID修改订单信息
	 * @param bill
	 * @throws Exception
	 */
	public void modifyBill(Bill bill ) throws Exception {
		BillManagerDAO BillManagerDao = new BillManagerDaoImpl() ;
		BillManagerDao.updateBill(bill) ;
	}
	/**
	 * 根据BillID查询Bill信息
	 * @param id
	 * @return
	 */
	public Bill findBillById(int id ) throws Exception {
		BillManagerDAO BillManagerDao = new BillManagerDaoImpl() ;
		CachedRowSet cachedRowSet = BillManagerDao.findBillById(id) ;
		cachedRowSet.next() ; // 将指针定位到第一行
		Bill Bills = Convert.RStoObject(cachedRowSet, Bill.class) ;
		return Bills ;
	}
	/**
	 * 根据订单ID删除订单信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteBillById(int id ) throws Exception {
		BillManagerDAO BillManagerDao = new BillManagerDaoImpl() ;
		BillManagerDao.deleteBillById(id) ;
	}
	/**
	 * 根据商品名和是否付款查询订单
	 * @return ArrayList
	 */
	public ArrayList<Bill> findBillByNameAndIsPay(String goodName , String isPay ) throws Exception {
		BillManagerDAO BillManagerDao = new BillManagerDaoImpl() ;
		CachedRowSet cachedRowSet = BillManagerDao.selectBillByNameAndIsPay(goodName , isPay ) ;
		ArrayList<Bill> Bills = Convert.RStoList(cachedRowSet, Bill.class) ;
		// 设置Bill的providerName属性值
		return Bills ;
	}
}