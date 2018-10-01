package com.common.www.dto;

import java.sql.Date;

public class commonDTO2 {

	private int goodsnumber;
	private String goodsname;
	private int price;
	private int nowstock;
	private Date inputgoods;
	private Date expirationdate;
	private int soldnum;
	private int newitem;

	public int getGoodsnumber() {
		return goodsnumber;
	}

	public void setGoodsnumber(int goodsnumber) {
		this.goodsnumber = goodsnumber;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNowstock() {
		return nowstock;
	}

	public void setNowstock(int nowstock) {
		this.nowstock = nowstock;
	}

	public Date getInputgoods() {
		return inputgoods;
	}

	public void setInputgoods(Date inputgoods) {
		this.inputgoods = inputgoods;
	}

	public Date getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}

	public int getSoldnum() {
		return soldnum;
	}

	public void setSoldnum(int soldnum) {
		this.soldnum = soldnum;
	}

	public int getNewitem() {
		return newitem;
	}

	public void setNewitem(int newitem) {
		this.newitem = newitem;
	}

	@Override
	public String toString() {
		return "commonDTO2 [goodsnumber=" + goodsnumber + ", goodsname=" + goodsname + ", price=" + price
				+ ", nowstock=" + nowstock + ", inputgoods=" + inputgoods + ", expirationdate=" + expirationdate
				+ ", soldnum=" + soldnum + ", newitem=" + newitem + "]";
	}

}
