package entity;

public class MemberBean {
	String userId;
	String password;
	
	public MemberBean() {
		
	}
	
	public MemberBean(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}
}
