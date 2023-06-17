package com.imageinnovate.demo.response;

public interface EmployeeResponse {
	public Integer getEid();
	public String getFullName();
	public String getTax();
//	public Date getDoj();
	public Double getSalary();
	public Double getTotalSalary();
	public String getCess();
	public String getTotalSalaryWithMonths();
	public String getLossOfPayPerDay();
}
