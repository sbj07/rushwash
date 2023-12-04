package com.rushwash.admin.app.manager.vo;

public class ManagerVo {

	public ManagerVo() {
	}
	
	public ManagerVo(String no, String name, String id, String pwd, String pwd2, String delYn) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.delYn = delYn;
	}

	private String no;
	private String name;
	private String id;
	private String pwd;
	private String pwd2;
	private String delYn;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	
	@Override
	public String toString() {
		return "ManagerVo [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", delYn="
				+ delYn + "]";
	}
}
