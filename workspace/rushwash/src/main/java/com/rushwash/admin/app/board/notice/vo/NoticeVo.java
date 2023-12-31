package com.rushwash.admin.app.board.notice.vo;

public class NoticeVo {
	private String no;
	private String managerId;
	private String title;
	private String content;
	private String delYn;
	private String enrollDate;
	
	
	public NoticeVo(String no, String managerId, String title, String content, String delYn, String enrollDate) {
		this.no = no;
		this.managerId = managerId;
		this.title = title;
		this.content = content;
		this.delYn = delYn;
		this.enrollDate = enrollDate;
	}
	public NoticeVo() {
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "NoticeVo [no=" + no + ", managerId=" + managerId + ", title=" + title + ", content=" + content
				+ ", delYn=" + delYn + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
	
}
