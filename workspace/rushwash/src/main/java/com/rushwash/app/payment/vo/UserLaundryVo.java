package com.rushwash.app.payment.vo;

public class UserLaundryVo {
	
	private String orderNo;
	private String itemNo;
	private String ea;
	private String memberNo;
	
	public UserLaundryVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public UserLaundryVo(String orderNo, String itemNo, String ea, String memberNo) {
		super();
		this.orderNo = orderNo;
		this.itemNo = itemNo;
		this.ea = ea;
		this.memberNo = memberNo;
	}


	@Override
	public String toString() {
		return "UserLaundryVo [orderNo=" + orderNo + ", itemNo=" + itemNo + ", ea=" + ea + ", memberNo=" + memberNo
				+ "]";
	}


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getEa() {
		return ea;
	}

	public void setEa(String ea) {
		this.ea = ea;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

		
}
