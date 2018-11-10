package com.common.www.dto;

public class commonDTO {

	private String storecode;
	private String location;
	private String tel;
	private int income;

	public String getStorecode() {
		return storecode;
	}

	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "commonDTO [storecode=" + storecode + ", location=" + location + ", tel=" + tel + ", income=" + income
				+ ", getStorecode()=" + getStorecode() + ", getLocation()=" + getLocation() + ", getTel()=" + getTel()
				+ ", getIncome()=" + getIncome() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
