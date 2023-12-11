package com.rushwash.admin.app.board.faq.vo;

public class FaqVo {
	private String no;
	private String managerId;
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
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
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
	public FaqVo(String no, String managerId, String managerNo, String title, String content, String delYn,
			String enrollDate) {
		super();
		this.no = no;
		this.managerId = managerId;
		this.managerNo = managerNo;
		this.title = title;
		this.content = content;
		this.delYn = delYn;
		this.enrollDate = enrollDate;
	}
	public FaqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FaqVo [no=" + no + ", managerId=" + managerId + ", managerNo=" + managerNo + ", title=" + title
				+ ", content=" + content + ", delYn=" + delYn + ", enrollDate=" + enrollDate + "]";
	}
	
	
}
