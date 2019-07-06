package action;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import entity.MemberBean;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	private HttpSession sessionUser;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() {
		if (userId.equalsIgnoreCase("userId") && password.equalsIgnoreCase("password")) {
			MemberBean mb = new MemberBean(userId, password);
			sessionUser.setAttribute("LoginOK", mb);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
