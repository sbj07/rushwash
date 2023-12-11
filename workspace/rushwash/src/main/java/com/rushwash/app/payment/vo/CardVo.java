package com.rushwash.app.payment.vo;

public class CardVo {
	
	private String no;
	private String memberNo;
	private String cardCompany;
	private String cardNo;
	private String cvcNo;
	private String cardPwd;
	private String validityPeriod;
	private String paymentDate;
	
	
	public CardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardVo(String no, String memberNo, String cardCompany, String cardNo, String cvcNo, String cardPwd,
			String validityPeriod, String paymentDate) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.cardCompany = cardCompany;
		this.cardNo = cardNo;
		this.cvcNo = cvcNo;
		this.cardPwd = cardPwd;
		this.validityPeriod = validityPeriod;
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "CardVo [no=" + no + ", memberNo=" + memberNo + ", cardCompany=" + cardCompany + ", cardNo=" + cardNo
				+ ", cvcNo=" + cvcNo + ", cardPwd=" + cardPwd + ", validityPeriod=" + validityPeriod + ", paymentDate="
				+ paymentDate + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getCardCompany() {
		return cardCompany;
	}
	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}
	public String getCardNo() {
		String lastCardNo = cardNo.substring(cardNo.length()-4, cardNo.length());
		
		return lastCardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCvcNo() {
		return cvcNo;
	}
	public void setCvcNo(String cvcNo) {
		this.cvcNo = cvcNo;
	}
	public String getCardPwd() {
		return cardPwd;
	}
	public void setCardPwd(String cardPwd) {
		this.cardPwd = cardPwd;
	}
	public String getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(String validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
