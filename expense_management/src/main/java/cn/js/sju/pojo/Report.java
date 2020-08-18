package cn.js.sju.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Report {
	private int month;
	private int reid;
	private int finallys;
	private String userid;
	private String name;
	private Double money;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date redate;
	private String tips;
	private int jingli;
	private int caiwu;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getFinallys() {
		return finallys;
	}
	public void setFinallys(int finallys) {
		this.finallys = finallys;
	}
	public int getReid() {
		return reid;
	}
	public void setReid(int reid) {
		this.reid = reid;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
	public int getJingli() {
		return jingli;
	}
	public void setJingli(int jingli) {
		this.jingli = jingli;
	}
	public int getCaiwu() {
		return caiwu;
	}
	public void setCaiwu(int caiwu) {
		this.caiwu = caiwu;
	}
	
}
