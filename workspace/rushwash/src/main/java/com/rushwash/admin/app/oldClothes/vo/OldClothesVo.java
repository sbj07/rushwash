package com.rushwash.admin.app.oldClothes.vo;

public class OldClothesVo {
	private String no;
	private String memberNo;
	private String requestCode;
	private String requestDate;
	private String collectDate;
	private String weight;
	private String delYn;
	private String status;
	private String statusNo;
	
	@Override
	public String toString() {
		return "OldClothesVo [no=" + no + ", memberNo=" + memberNo + ", requestCode=" + requestCode + ", requestDate="
				+ requestDate + ", collectDate=" + collectDate + ", weight=" + weight + ", delYn=" + delYn + ", status="
				+ status + ", statusNo=" + statusNo + "]";
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
	public String getRequestCode() {
		return requestCode;
	}
	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusNo() {
		return statusNo;
	}
	public void setStatusNo(String statusNo) {
		this.statusNo = statusNo;
	}
	public OldClothesVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OldClothesVo(String no, String memberNo, String requestCode, String requestDate, String collectDate,
			String weight, String delYn, String status, String statusNo) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.requestCode = requestCode;
		this.requestDate = requestDate;
		this.collectDate = collectDate;
		this.weight = weight;
		this.delYn = delYn;
		this.status = status;
		this.statusNo = statusNo;
	}
}
