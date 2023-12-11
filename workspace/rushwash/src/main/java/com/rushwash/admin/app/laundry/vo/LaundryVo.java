package com.rushwash.admin.app.laundry.vo;

public class LaundryVo {

	public LaundryVo() {
	}
	public LaundryVo(String orderNo, String memberNo, String no, String item, String ea, String washStartDate,
			String washEndDate, String statusNo, String status, String delYn) {
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.no = no;
		this.item = item;
		this.ea = ea;
		this.washStartDate = washStartDate;
		this.washEndDate = washEndDate;
		this.statusNo = statusNo;
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
	private String statusNo;
	private String status;
	private String delYn;
	private String memberName;
	
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
	
	public String getStatusNo() {
		return statusNo;
	}
	public void setStatusNo(String statusNo) {
		this.statusNo = statusNo;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "LaundryVo [orderNo=" + orderNo + ", memberNo=" + memberNo + ", no=" + no + ", item=" + item + ", ea="
				+ ea + ", washStartDate=" + washStartDate + ", washEndDate=" + washEndDate + ", statusNo=" + statusNo
				+ ", status=" + status + ", delYn=" + delYn + ", memberName=" + memberName + "]";
	}
	
	

}
