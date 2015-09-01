package userManager.vo;
/**
 * 
 * @description 普通用户实体类 
 * 
 * @author caiyao
 *
 */
public class User {
	private int userId  ;
    private String userName  ;
    private String userPassword  ;
    private String gender  ;
    private int age  ;
    private String telephoneNum ;
    private String address  ; 
    private int userRole ;
	public User() {
		super();
	}
	public User(int userId, String userName, String userPassword,
			String gender, int age, String telephoneNum, String address,
			int userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.age = age;
		this.telephoneNum = telephoneNum;
		this.address = address;
		this.userRole = userRole;
	}
	
	public User(String userName, String userPassword, String gender, int age,
			String telephoneNum, String address, int userRole) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.age = age;
		this.telephoneNum = telephoneNum;
		this.address = address;
		this.userRole = userRole;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTelephoneNum() {
		return telephoneNum;
	}
	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", gender=" + gender
				+ ", age=" + age + ", telephoneNum=" + telephoneNum
				+ ", address=" + address + ", userRole=" + userRole + "]";
	}
    
}
