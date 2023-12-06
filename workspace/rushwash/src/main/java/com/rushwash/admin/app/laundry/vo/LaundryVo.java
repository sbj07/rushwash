package com.rushwash.admin.app.laundry.vo;

public class LaundryVo {
	
	public LaundryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LaundryVo(String orderNo, String memberNo, String no, String item, String ea, String washStartDate,
			String washEndDate, String status, String delYn) {
		super();
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.no = no;
		this.item = item;
		this.ea = ea;
		this.washStartDate = washStartDate;
		this.washEndDate = washEndDate;
		this.status = status;
		this.delYn = delYn;
	}
	
	private String orderNo;
	private String memberNo;
	private String no;
	private String item;
	private String ea;
	private String washStartDate;
	private String washEndDate;
	private String status;
	private String delYn;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getEa() {
		return ea;
	}
	public void setEa(String ea) {
		this.ea = ea;
	}
	public String getWashStartDate() {
		return washStartDate;
	}
	public void setWashStartDate(String washStartDate) {
		this.washStartDate = washStartDate;
	}
	public String getWashEndDate() {
		return washEndDate;
	}
	public void setWashEndDate(String washEndDate) {
		this.washEndDate = washEndDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "LaundryVo [orderNo=" + orderNo + ", memberNo=" + memberNo + ", no=" + no + ", item=" + item + ", ea="
				+ ea + ", washStartDate=" + washStartDate + ", washEndDate=" + washEndDate + ", status=" + status
				+ ", delYn=" + delYn + "]";
	}
	
	

}
