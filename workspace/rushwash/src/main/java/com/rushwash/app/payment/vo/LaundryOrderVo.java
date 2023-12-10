package com.rushwash.app.payment.vo;

public class LaundryOrderVo {
	private String no; 
	private String price;
	private String paymentDate;
	private String request;
	private String address;
	private String memberNo;
	
	
	public LaundryOrderVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LaundryOrderVo(String no, String price, String paymentDate, String request, String address,
			String memberNo) {
		super();
		this.no = no;
		this.price = price;
		this.paymentDate = paymentDate;
		this.request = request;
		this.address = address;
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "LaundryOrderVo [no=" + no + ", price=" + price + ", paymentDate=" + paymentDate + ", request=" + request
				+ ", address=" + address + ", memberNo=" + memberNo + "]";
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
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
