package action;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String author;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String execute() throws Exception {
		if (userId != null) {
			if (userId == author) {
				return "DeleteOK";
			} else {
				return "DeleteNO";
			}
		} else {
			return "DeleteNO";
		}
	}
}
