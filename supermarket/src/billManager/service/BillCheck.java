package billManager.service;

import providerManager.service.ProviderService;
import billManager.vo.Bill;

/**
 * 
 * @description 校验账单的合法性
 *
 * @author hello world
 *
 */
public class BillCheck {
	/**
	 * 校验Bill的合法性
	 * @param bill
	 * @return
	 */
	public boolean checkBill(Bill bill ) throws Exception {
		/*private int billId ;
		private String provider ;
		private double price ;
		private String priceUnit ;
		private int goodsNum ;
		private boolean isPay ;
		private String goodsName ;
		private String goodsDesc ;
		private Timestamp billTime ;*/
		return  checkProviderId(bill.getProviderId()) ;
	}
	/**
	 * 根据ID检查Provider是否存在
	 * @param provider
	 * @return
	 */
	public boolean checkProviderId(double providerId ) throws Exception {
		return new ProviderService().findProviderById(providerId) == null ? false : true ;
	}
}
