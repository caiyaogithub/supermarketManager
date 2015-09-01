package providerManager.vo;

/**
 * 
 * @description 供应商实体类
 *
 * @author hello world
 *
 */
public class Provider {
	 private int providerId ;
	 private String providerName ;
	 private String providerDesc ;
	 private String linkman ;
	 private String telephone ;
	 private String fax ;
	 private String address ;
	public Provider() {
		super();
	}
	
	public Provider(int providerId, String providerName, String providerDesc,
			String linkMan, String telephone, String fax, String address) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerDesc = providerDesc;
		this.linkman = linkMan;
		this.telephone = telephone;
		this.fax = fax;
		this.address = address;
	}

	
	public Provider(String providerName, String providerDesc, String linkMan,
			String telephone, String fax, String address) {
		super();
		this.providerName = providerName;
		this.providerDesc = providerDesc;
		this.linkman = linkMan;
		this.telephone = telephone;
		this.fax = fax;
		this.address = address;
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

	public String getProviderDesc() {
		return providerDesc;
	}

	public void setProviderDesc(String providerDesc) {
		this.providerDesc = providerDesc;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkMan) {
		this.linkman = linkMan;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", providerName="
				+ providerName + ", providerDesc=" + providerDesc
				+ ", linkMan=" + linkman + ", telephone=" + telephone
				+ ", fax=" + fax + ", address=" + address + "]";
	}
	 
}
