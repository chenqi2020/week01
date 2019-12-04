package com.chenqi.week01.domain;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class Users {

	private Integer uid;
	@NotBlank(message = "店名不能为空")
	private String uname;
	@NotBlank(message = "时间店名不能为空")
	private String dates;
	private List<Shop> shop;
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", dates=" + dates + "]";
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public List<Shop> getShop() {
		return shop;
	}
	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
	
}
