
package com.common.www.dto;

public class employeeDTO {

	private String storeCode;
	private String manager;
	private String phone;
	private int seqTime;

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSeqTime() {
		return seqTime;
	}

	public void setSeqTime(int seqTime) {
		this.seqTime = seqTime;
	}

	@Override
	public String toString() {
		return "employeeDTO [storeCode=" + storeCode + ", manager=" + manager + ", phone=" + phone + ", seqTime="
				+ seqTime + "]";
	}

}
