package com.rushwash.app.order.vo;

public class OrderVo {
	
	private String no;				//주문번호(요펑관리번호)
	private String item;			//상품(품목)
	private String priceItem;			//결제내역
	private String price;			//결제내역
	private String ea;				//수량(세탁물)
	private String memberName;		//수령인
	private String address;			//주소
	private String tel;				//핸드폰번호
	private String request;			//요청사항
	private String expDate ;		//예상 세탁 완료일
	private String orderStatus;		//주문상태(신청상태 5)
	private String laundryStatus;	//진행상태(세탁상태 3)
	private String paymentDate;		//주문일
	private String diliveryDate;	//발송일
	private String collectDate;		//수거일자
	private String receiveDate ;	//수령일(완료일)
	private String delYn;			//취소
	public OrderVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderVo(String no, String item, String priceItem, String price, String ea, String memberName, String address,
			String tel, String request, String expDate, String orderStatus, String laundryStatus, String paymentDate,
			String diliveryDate, String collectDate, String receiveDate, String delYn) {
		super();
		this.no = no;
		this.item = item;
		this.price = price;
		this.priceItem = priceItem;
		this.ea = ea;
		this.memberName = memberName;
		this.address = address;
		this.tel = tel;
		this.request = request;
		this.expDate = expDate;
		this.orderStatus = orderStatus;
		this.laundryStatus = laundryStatus;
		this.paymentDate = paymentDate;
		this.diliveryDate = diliveryDate;
		this.collectDate = collectDate;
		this.receiveDate = receiveDate;
		this.delYn = delYn;
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
	public String getPriceItem() {
		return priceItem;
	}
	public void setPriceItem(String priceItem) {
		this.priceItem = priceItem;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
		return "OrderVo [no=" + no + ", item=" + item + ", priceItem=" + priceItem + ", price=" + price + ", ea=" + ea
				+ ", memberName=" + memberName + ", address=" + address + ", tel=" + tel + ", request=" + request
				+ ", expDate=" + expDate + ", orderStatus=" + orderStatus + ", laundryStatus=" + laundryStatus
				+ ", paymentDate=" + paymentDate + ", diliveryDate=" + diliveryDate + ", collectDate=" + collectDate
				+ ", receiveDate=" + receiveDate + ", delYn=" + delYn + "]";
	}
	
	
	
}
