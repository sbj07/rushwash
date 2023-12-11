package com.rushwash.app.board.qna.vo;

public class QnaVo {
	
	public QnaVo(String no, String managerNo, String managerId, String commt, String enrollDate, String delYn,
			String title, String content, String secretYn, String memberNo, String modifyDate) {
		super();
		this.no = no;
		this.managerNo = managerNo;
		this.managerId = managerId;
		this.commt = commt;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
		this.title = title;
		this.content = content;
		this.secretYn = secretYn;
		this.memberNo = memberNo;
		this.modifyDate = modifyDate;
	}
	public QnaVo() {
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
	public String getCommt() {
		return commt;
	}
	public void setCommt(String commt) {
		this.commt = commt;
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
	public String getSecretYn() {
		return secretYn;
	}
	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	private String no;
	private String managerNo;
	private String managerId;
	private String commt;
	private String enrollDate;
	private String delYn;
	private String title;
	private String content;
	private String secretYn;
	private String memberNo;
	private String modifyDate;
	
}
