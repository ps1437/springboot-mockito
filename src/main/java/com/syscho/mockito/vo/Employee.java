package com.syscho.mockito.vo;

public class Employee {

	private String empNo;
	private String empName;

	public Employee(String empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

}
