package com.rushwash.app.board.notice.vo;

public class UserNoticeVo {
	private String no;
	@Override
	public String toString() {
		return "UserNoticeVo [no=" + no + ", adminNo=" + adminNo + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + "]";
	}
	public UserNoticeVo(String no, String adminNo, String title, String content, String enrollDate) {
		super();
		this.no = no;
		this.adminNo = adminNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
	}
	public UserNoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	private String adminNo;
	private String title;
	private String content;
	private String enrollDate;
	
	
}
