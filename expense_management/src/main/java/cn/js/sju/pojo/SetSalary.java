package cn.js.sju.pojo;

import java.util.Date;


public class SetSalary {
	private String name;
	private String username;
	private double sal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Salary [name=" + name + ", username=" + username + ", sal=" + sal + "]";
	}
	
	
}
