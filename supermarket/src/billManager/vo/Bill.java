package billManager.vo;

import java.sql.Timestamp;


/**
 * 
 * @description 订单实体类
 *
 * @author hello world
 *
 */
public class Bill {
	private int billId ;
	private int providerId ;
	private String providerName ;
	private double price ;
	private String goodsUnit ;
	private int goodsNum ;
	private String isPay ;
	private String goodsName ;
	private String goodsDesc ;
	private Timestamp billTime ;
	public Bill() {
		super();
	}
	public Bill(int billId, int providerId, String providerName, double price,
			String goodsUnit, int goodsNum, String isPay, String goodsName,
			String goodsDesc, Timestamp billTime) {
		super();
		this.billId = billId;
		this.providerId = providerId;
		this.providerName = providerName;
		this.price = price;
		this.goodsUnit = goodsUnit;
		this.goodsNum = goodsNum;
		this.isPay = isPay;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.billTime = billTime;
	}
	// 用于构建插入订单数据时
	public Bill(int providerId, double price, String goodsUnit, int goodsNum,
			String isPay, String goodsName, String goodsDesc,
			Timestamp billTime) {
		super();
		this.providerId = providerId;
		this.price = price;
		this.goodsUnit = goodsUnit;
		this.goodsNum = goodsNum;
		this.isPay = isPay;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.billTime = billTime;
	}
	// 用于显示订单信息
	public Bill(int billId, String providerName, double price,
			String goodsUnit, int goodsNum, String isPay, String goodsName,
			String goodsDesc, Timestamp billTime) {
		super();
		this.billId = billId;
		this.providerName = providerName;
		this.price = price;
		this.goodsUnit = goodsUnit;
		this.goodsNum = goodsNum;
		this.isPay = isPay;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.billTime = billTime;
	}
	// 用于存放修改订单信息
	public Bill(int billId, int providerId, double price, String goodsUnit,
			int goodsNum, String isPay, String goodsName, String goodsDesc,
			Timestamp billTime) {
		super();
		this.billId = billId;
		this.providerId = providerId;
		this.price = price;
		this.goodsUnit = goodsUnit;
		this.goodsNum = goodsNum;
		this.isPay = isPay;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.billTime = billTime;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public Timestamp getBillTime() {
		return billTime;
	}
	public void setBillTime(Object billTime)  {
		try {
			this.billTime = ((oracle.sql.TIMESTAMP)billTime).timestampValue() ;
		} catch (Exception e) {
			e.printStackTrace() ;
		}
			
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", providerId=" + providerId
				+ ", providerName=" + providerName + ", price=" + price
				+ ", goodsUnit=" + goodsUnit + ", goodsNum=" + goodsNum
				+ ", isPay=" + isPay + ", goodsName=" + goodsName
				+ ", goodsDesc=" + goodsDesc + ", billTime=" + billTime + "]";
	}
	
}
