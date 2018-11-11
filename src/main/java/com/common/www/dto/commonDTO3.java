
package com.common.www.dto;

public class commonDTO3 {

	private String storecode;
	private String manager;
	private String phone;
	private int seqtime;

	public String getStorecode() {
		return storecode;
	}

	public void setStorecode(String storecode) {
		this.storecode = storecode;
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

	public int getSeqtime() {
		return seqtime;
	}

	public void setSeqtime(int seqtime) {
		this.seqtime = seqtime;
	}

	@Override
	public String toString() {
		return "commonDTO3 [storecode=" + storecode + ", manager=" + manager + ", phone=" + phone + ", seqtime="
				+ seqtime + "]";
	}
}
