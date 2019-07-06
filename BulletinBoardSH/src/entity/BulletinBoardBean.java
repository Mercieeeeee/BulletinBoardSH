package entity;

import java.util.Date;

public class BulletinBoardBean {
	
	private int no;
	private String title;
	private String author;
	private Date publishDate;
	private Date deadDate;
	private String content;
	
	public BulletinBoardBean() {
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public Date getDeadDate() {
		return deadDate;
	}
	
	public void setDeadDate(Date deadDate) {
		this.deadDate = deadDate;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
