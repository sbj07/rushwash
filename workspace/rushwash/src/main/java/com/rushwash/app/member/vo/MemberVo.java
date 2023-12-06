package com.rushwash.app.member.vo;

public class MemberVo {

	private String no;
	private String memberId;
	private String memberPwd;
	private String memberPwd2;
	private String memberEmail;
	private String memberAddress;
	private String memberName;
	private String memberTel;
	private String enrollDate;
	private String delYn;
	private String modifyDate;
	private String point;
	
	public MemberVo() {

	}

	public MemberVo(String no, String memberId, String memberPwd, String memberPwd2, String memberEmail,
			String memberAddress, String memberName, String memberTel, String enrollDate, String delYn,
			String modifyDate, String point) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberPwd2 = memberPwd2;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberName = memberName;
		this.memberTel = memberTel;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
		this.modifyDate = modifyDate;
		this.point = point;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberPwd2() {
		return memberPwd2;
	}

	public void setMemberPwd2(String memberPwd2) {
		this.memberPwd2 = memberPwd2;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberPwd2="
				+ memberPwd2 + ", memberEmail=" + memberEmail + ", memberAddress=" + memberAddress + ", memberName="
				+ memberName + ", memberTel=" + memberTel + ", enrollDate=" + enrollDate + ", delYn=" + delYn
				+ ", modifyDate=" + modifyDate + ", point=" + point + "]";
	}
}
