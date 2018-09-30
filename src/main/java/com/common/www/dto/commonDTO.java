package com.common.www.dto;

public class commonDTO {

	private String storecode;
	private String inlocation;
	private String tel;
	private int daylysales;
	private int monthyslaes;

	public String getStorecode() {
		return storecode;
	}

	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}

	public String getInlocation() {
		return inlocation;
	}

	public void setInlocation(String inlocation) {
		this.inlocation = inlocation;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getDaylysales() {
		return daylysales;
	}

	public void setDaylysales(int daylysales) {
		this.daylysales = daylysales;
	}

	public int getMonthyslaes() {
		return monthyslaes;
	}

	public void setMonthyslaes(int monthyslaes) {
		this.monthyslaes = monthyslaes;
	}

	@Override
	public String toString() {
		return "commonDTO [storecode=" + storecode + ", inlocation=" + inlocation + ", tel=" + tel + ", daylysales="
				+ daylysales + ", monthyslaes=" + monthyslaes + "]";
	}

}
