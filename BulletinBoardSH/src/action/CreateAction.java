package action;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

public class CreateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private HttpSession sessionUser;

	public String execute() throws Exception {
		if (sessionUser.getAttribute("LoginOK") != null ) {
			return "CreateOK";
		} else {
			return "CreateNO";
		}
	}
}
