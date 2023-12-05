package com.rushwash.app.board.notice.vo;

public class UserNoticeVo {
	@Override
	public String toString() {
		return "UserNoticeVo [no=" + no + ", adminNo=" + adminNo + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", delYn=" + delYn + "]";
	}
	public UserNoticeVo(String no, String adminNo, String title, String content, String enrollDate, String delYn) {
		super();
		this.no = no;
		this.adminNo = adminNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	private String no;
	private String adminNo;
	private String title;
	private String content;
	private String enrollDate;
	private String delYn;
	
	
	
}
