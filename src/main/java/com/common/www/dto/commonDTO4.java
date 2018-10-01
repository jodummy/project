package com.common.www.dto;

import java.sql.Date;

public class commonDTO4 {

	private String storecode;
	private int goodsnumber;
	private Date deliverytime;
	private int ordernum;

	public String getStorecode() {
		return storecode;
	}

	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}

	public int getGoodsnumber() {
		return goodsnumber;
	}

	public void setGoodsnumber(int goodsnumber) {
		this.goodsnumber = goodsnumber;
	}

	public Date getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	@Override
	public String toString() {
		return "commonDTO4 [storecode=" + storecode + ", goodsnumber=" + goodsnumber + ", deliverytime=" + deliverytime
				+ ", ordernum=" + ordernum + "]";
	}

}
