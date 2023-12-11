package com.rushwash.admin.app.laundry.vo;

public class OrderVo {
	
	public OrderVo(String orderNo, String memberNo, String price, String paymentDate, String collectDate,
			String expDate, String diliveryDate, String receiveDate, String orderRequset, String address, String status,
			String delYn) {
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.price = price;
		this.paymentDate = paymentDate;
		this.collectDate = collectDate;
		this.expDate = expDate;
		this.diliveryDate = diliveryDate;
		this.receiveDate = receiveDate;
		this.orderRequset = orderRequset;
		this.address = address;
		this.status = status;
		this.delYn = delYn;
	}
	
	public OrderVo() {
	}
	
	private String orderNo;
	private String memberNo;
	private String status;
	private String price;
	private String paymentDate;
	private String collectDate;
	private String expDate;
	private String diliveryDate;
	private String receiveDate;
	private String orderRequset;
	private String address;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getDiliveryDate() {
		return diliveryDate;
	}
	public void setDiliveryDate(String diliveryDate) {
		this.diliveryDate = diliveryDate;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getOrderRequset() {
		return orderRequset;
	}
	public void setOrderRequset(String orderRequset) {
		this.orderRequset = orderRequset;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", memberNo=" + memberNo + ", status=" + status + ", price=" + price
				+ ", paymentDate=" + paymentDate + ", collectDate=" + collectDate + ", expDate=" + expDate
				+ ", diliveryDate=" + diliveryDate + ", receiveDate=" + receiveDate + ", orderRequset=" + orderRequset
				+ ", address=" + address + ", delYn=" + delYn + ", memberName=" + memberName + "]";
	}
	
	

}
