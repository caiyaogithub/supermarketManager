package billManager.dao;

import javax.sql.rowset.CachedRowSet;

import billManager.vo.Bill;

/**
 * 
 * @description 订单管理相关数据库操作 
 * 
 * @author caiyao
 *
 */
public interface BillManagerDAO {
	/**
	 * 查询所有订单信息
	 * @return 可存储的结果集
	 */
	public CachedRowSet selectAllBill() throws Exception ;
	/**
	 * 添加订单
	 * @param bill
	 * @throws Exception
	 */
	public void insertBill( Bill bill ) throws Exception ;
	/**
	 * 更改订单信息
	 * @param bill
	 * @throws Exception
	 */
	public void updateBill( Bill bill ) throws Exception ;
	/**
	 * 根据订单ID查询订单
	 * @param billId
	 * @return
	 * @throws Exception
	 */
	public CachedRowSet findBillById(int billId ) throws Exception ;
	/**
	 * 根据订单ID删除订单
	 * @param billId
	 * @throws Exception
	 */
	public void deleteBillById(int billId ) throws Exception ;
	/**
	 * 根据商品名和是否付款查询订单信息
	 * @param goodName 商品名
	 * @param isPay 是否付款
	 * @return
	 * @throws Exception
	 */
	public CachedRowSet selectBillByNameAndIsPay(String goodName , String isPay ) throws Exception ;
}
