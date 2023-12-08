package com.rushwash.app.plan.vo;

public class PlanVo {
	private String no;
	private String gradeNo;
	private String memberNo;
	private String planDate;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	@Override
	public String toString() {
		return "PlanVo [no=" + no + ", gradeNo=" + gradeNo + ", memberNo=" + memberNo + ", planDate=" + planDate + "]";
	}
	public PlanVo(String no, String gradeNo, String memberNo, String planDate) {
		super();
		this.no = no;
		this.gradeNo = gradeNo;
		this.memberNo = memberNo;
		this.planDate = planDate;
	}
	public PlanVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
