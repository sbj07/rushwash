package com.rushwash.app.order.vo;

public class OrderVo {
	
	private String memberNo;		//주문번호(유저번호)
	private String item;			//상품(품목)
	private String price;			//결제내역
	private String ea;				//수량(세탁물)
	private String name;			//수령인
	private String address;			//주소
	private String tel;				//핸드폰번호
	private String request;			//요청사항
	private String expDate ;		//예상 세탁 완료일
	private String status;			//주문상태(신청상태 5)
	private String laundryStatus;	//진행상태(세탁상태 3)
	private String paymentDate;		//주문일
	private String diliveryDate;	//발송일
	private String collectDate;		//수거일자
	private String receiveDate ;	//수령일(완료일)
	private String delYn;			//추소
	
	public OrderVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderVo(String memberNo, String item, String price, String ea, String name, String address, String tel,
			String request, String expDate, String status, String laundryStatus, String paymentDate,
			String diliveryDate, String collectDate, String receiveDate, String delYn) {
		super();
		this.memberNo = memberNo;
		this.item = item;
		this.price = price;
		this.ea = ea;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.request = request;
		this.expDate = expDate;
		this.status = status;
		this.laundryStatus = laundryStatus;
		this.paymentDate = paymentDate;
		this.diliveryDate = diliveryDate;
		this.collectDate = collectDate;
		this.receiveDate = receiveDate;
		this.delYn = delYn;
	}
	
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getEa() {
		return ea;
	}
	public void setEa(String ea) {
		this.ea = ea;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLaundryStatus() {
		return laundryStatus;
	}
	public void setLaundryStatus(String laundryStatus) {
		this.laundryStatus = laundryStatus;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getDiliveryDate() {
		return diliveryDate;
	}
	public void setDiliveryDate(String diliveryDate) {
		this.diliveryDate = diliveryDate;
	}
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	@Override
	public String toString() {
		return "OrderVo [memberNo=" + memberNo + ", item=" + item + ", price=" + price + ", ea=" + ea + ", name=" + name
				+ ", address=" + address + ", tel=" + tel + ", request=" + request + ", expDate=" + expDate
				+ ", status=" + status + ", laundryStatus=" + laundryStatus + ", paymentDate=" + paymentDate
				+ ", diliveryDate=" + diliveryDate + ", collectDate=" + collectDate + ", receiveDate=" + receiveDate
				+ ", delYn=" + delYn + "]";
	}
	
	
	
	
}
