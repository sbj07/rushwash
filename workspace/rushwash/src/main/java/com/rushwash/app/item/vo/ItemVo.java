package com.rushwash.app.item.vo;

public class ItemVo {
	private String itemNo;
	private String name;
	private String price;
	private String delYn;
	private String categoryCode;
	private String ea;
	
	public ItemVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemVo(String itemNo, String name, String price, String delYn, String categoryCode, String ea) {
		super();
		this.itemNo = itemNo;
		this.name = name;
		this.price = price;
		this.delYn = delYn;
		this.categoryCode = categoryCode;
		this.ea = ea;
	}
	// toString
	@Override
	public String toString() {
		return "ItemVo [itemNo=" + itemNo + ", name=" + name + ", price=" + price + ", delYn=" + delYn
				+ ", categoryCode=" + categoryCode + ", ea=" + ea + "]";
	}
	// getter/setter
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getEa() {
		return ea;
	}
	public void setEa(String ea) {
		this.ea = ea;
	}
	
	
}
