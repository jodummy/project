package com.common.www.dto;

public class storeDTO {

	private String storeCode;
	private String location;
	private String tel;
	private int inCome;

	public String getstoreCode() {
		return storeCode;
	}

	public void setstoreCode(String storeCode) {
		this.storeCode = storeCode;
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

	public int getinCome() {
		return inCome;
	}

	public void setinCome(int inCome) {
		this.inCome = inCome;
	}

	@Override
	public String toString() {
		return "commonDTO [storeCode=" + storeCode + ", location=" + location + ", tel=" + tel + ", inCome=" + inCome
				+ ", getstoreCode()=" + getstoreCode() + ", getLocation()=" + getLocation() + ", getTel()=" + getTel()
				+ ", getinCome()=" + getinCome() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
