package com.rushwash.app.board.price.vo;

public class PriceVo {
	

	@Override
	public String toString() {
		return "PriceVo [no=" + no + ", categoryCode=" + categoryCode + ", name=" + name + ", price=" + price
				+ ", discount=" + discount + ", delYn=" + delYn + "]";
	}
	public PriceVo(String no, String categoryCode, String name, String price, String discount, String delYn) {
		super();
		this.no = no;
		this.categoryCode = categoryCode;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.delYn = delYn;
	}
	public PriceVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	private String no;
	private String categoryCode;
	private String name;
	private String price;
	private String discount;
	private String delYn;
	
}
