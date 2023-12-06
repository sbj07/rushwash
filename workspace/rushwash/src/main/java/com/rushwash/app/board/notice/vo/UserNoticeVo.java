package com.rushwash.app.board.notice.vo;

public class UserNoticeVo {

	@Override
	public String toString() {
		return "UserNoticeVo [no=" + no + ", managerId=" + managerId + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", delYn=" + delYn + "]";
	}
	public UserNoticeVo(String no, String managerId, String title, String content, String enrollDate, String delYn) {
		super();
		this.no = no;
		this.managerId = managerId;
		this.title = title;
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
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
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
	private String managerId;
	private String title;
	private String content;
	private String enrollDate;
	private String delYn;
	
	
	
}
