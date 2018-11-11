package com.common.www.dto;

import java.sql.Date;

public class commonDTO2 {

	private int goodsnumber;
	private String goodsname;
	private int price;
	private int nowstock;
	private String inputgoods;
	private String expirationdate;
	private int soldnum;
	private int newitem;
	private int calorie;
	private int rankgoods;
	private String goodsinfo;

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

	public String getInputgoods() {
		return inputgoods;
	}

	public void setInputgoods(String inputgoods) {
		this.inputgoods = inputgoods;
	}

	public String getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(String expirationdate) {
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

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public int getRankgoods() {
		return rankgoods;
	}

	public void setRankgoods(int rankgoods) {
		this.rankgoods = rankgoods;
	}

	public String getGoodsinfo() {
		return goodsinfo;
	}

	public void setGoodsinfo(String goodsinfo) {
		this.goodsinfo = goodsinfo;
	}

	@Override
	public String toString() {
		return "commonDTO2 [goodsnumber=" + goodsnumber + ", goodsname=" + goodsname + ", price=" + price
				+ ", nowstock=" + nowstock + ", inputgoods=" + inputgoods + ", expirationdate=" + expirationdate
				+ ", soldnum=" + soldnum + ", newitem=" + newitem + ", calorie=" + calorie + ", rankgoods=" + rankgoods
				+ ", goodsinfo=" + goodsinfo + "]";
	}

}
