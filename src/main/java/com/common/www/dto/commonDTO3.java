package com.common.www.dto;

public class commonDTO3 {

	private String storecode;
	private String employeename;
	private String employeetel;
	private int authority;
	private int worksequence;

	public String getStorecode() {
		return storecode;
	}

	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeetel() {
		return employeetel;
	}

	public void setEmployeetel(String employeetel) {
		this.employeetel = employeetel;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getWorksequence() {
		return worksequence;
	}

	public void setWorksequence(int worksequence) {
		this.worksequence = worksequence;
	}

	@Override
	public String toString() {
		return "commonDTO3 [storecode=" + storecode + ", employeename=" + employeename + ", employeetel=" + employeetel
				+ ", authority=" + authority + ", worksequence=" + worksequence + "]";
	}

}
