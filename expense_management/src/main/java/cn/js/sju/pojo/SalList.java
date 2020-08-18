package cn.js.sju.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//¹¤×Ê
public class SalList {
	private int uid;
	private String name;
	private String username;
	private String userid;
	private double sal;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sdata;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hire;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Date getSdata() {
		return sdata;
	}
	public void setSdata(Date sdata) {
		this.sdata = sdata;
	}
	public Date getHire() {
		return hire;
	}
	public void setHire(Date hire) {
		this.hire = hire;
	}
	@Override
	public String toString() {
		return "SalList [name=" + name + "]";
	}

	
}
