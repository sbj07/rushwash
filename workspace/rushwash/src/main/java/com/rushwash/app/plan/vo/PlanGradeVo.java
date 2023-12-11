package com.rushwash.app.plan.vo;

public class PlanGradeVo {
	private String no;
	private String subGrade;
	private String discountRate;
	private String price;
	
	public PlanGradeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlanGradeVo(String no, String subGrade, String discountRate, String price) {
		super();
		this.no = no;
		this.subGrade = subGrade;
		this.discountRate = discountRate;
		this.price = price;
	}
	@Override
	public String toString() {
		return "PlanGradeVo [no=" + no + ", subGrade=" + subGrade + ", discountRate=" + discountRate + ", price="
				+ price + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSubGrade() {
		return subGrade;
	}
	public void setSubGrade(String subGrade) {
		this.subGrade = subGrade;
	}
	public String getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
