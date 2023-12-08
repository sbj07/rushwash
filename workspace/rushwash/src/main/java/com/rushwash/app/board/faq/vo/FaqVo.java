package com.rushwash.app.board.faq.vo;

public class FaqVo {

	@Override
	public String toString() {
		return "FaqVo [no=" + no + ", managerNo=" + managerNo + ", managerId=" + managerId + ", title=" + title
				+ ", content=" + content + ", delYn=" + delYn + ", enrollDate=" + enrollDate + "]";
	}
	public FaqVo(String no, String managerNo, String managerId, String title, String content, String delYn,
			String enrollDate) {
		super();
		this.no = no;
		this.managerNo = managerNo;
		this.managerId = managerId;
		this.title = title;
		this.content = content;
		this.delYn = delYn;
		this.enrollDate = enrollDate;
	}
	public FaqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
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
	private String no;
	private String managerNo;
	private String managerId;
	private String title;
	private String content;
	private String delYn;
	private String enrollDate;
}
