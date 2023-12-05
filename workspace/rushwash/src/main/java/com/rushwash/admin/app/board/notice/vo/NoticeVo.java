package com.rushwash.admin.app.board.notice.vo;

public class NoticeVo {
	private String no;
	private String managerNo;
	private String title;
	private String content;
	private String delYn;
	private String enrollDate;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(String admin_no) {
		this.managerNo = admin_no;
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
	public NoticeVo(String no, String admin_no, String title, String content, String delYn, String enrollDate) {
		this.no = no;
		this.managerNo = admin_no;
		this.title = title;
		this.content = content;
		this.delYn = delYn;
		this.enrollDate = enrollDate;
	}
	public NoticeVo() {
		super();
	}
	@Override
	public String toString() {
		return "NoticeVo [no=" + no + ", admin_no=" + managerNo + ", title=" + title + ", content=" + content
				+ ", delYn=" + delYn + ", enrollDate=" + enrollDate + "]";
	}
	
	
}
