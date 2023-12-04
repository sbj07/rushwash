package com.rushwash.admin.app.member.vo;

public class MemberVo {

	
	
	public MemberVo(String no, String name, String address, String email, String tel, String planDate, String subGrade,
			String point, String delYn, String id, String pwd, String enrollDate, String modifyDate,
			String modifyMemo) {
		this.no = no;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.planDate = planDate;
		this.subGrade = subGrade;
		this.point = point;
		this.delYn = delYn;
		this.id = id;
		this.pwd = pwd;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.modifyMemo = modifyMemo;
	}
	
	public MemberVo() {
	}
	
	private String no;
	private String name;
	private String address;
	private String email;
	private String tel;
	private String planDate; //구독일자 - plan_info
	private String subGrade; //플랜등급 - plan_grade
	private String point;
	private String delYn; //여기까지 일반정보
	private String id;
	private String pwd;
	private String enrollDate;
	private String modifyDate;
	private String modifyMemo;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public String getSubGrade() {
		return subGrade;
	}
	public void setSubGrade(String subGrade) {
		this.subGrade = subGrade;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyMemo() {
		return modifyMemo;
	}
	public void setModifyMemo(String modifyMemo) {
		this.modifyMemo = modifyMemo;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", address=" + address + ", email=" + email + ", tel=" + tel
				+ ", planDate=" + planDate + ", subGrade=" + subGrade + ", point=" + point + ", delYn=" + delYn
				+ ", id=" + id + ", pwd=" + pwd + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate
				+ ", modifyMemo=" + modifyMemo + "]";
	}
	
	
}
