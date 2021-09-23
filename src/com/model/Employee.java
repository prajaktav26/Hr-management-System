package com.model;

public class Employee {

	private int empId;
	private String empName;
	private int empAge;
	private int empSalary;
	private String empAdress;
	private String empMobile;
	private String empEmail;
	private int roleid;
	private int dptid;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, int empAge, int empSalary, String empAdress, String empMobile,
			String empEmail) {
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
		this.empAdress = empAdress;
		this.empMobile = empMobile;
		this.empEmail = empEmail;
	}
	public Employee(int empId2, String empName2, int empSalary2, int empAge2, String empAddress, String empMobile2,
			String empEmail2, int rid,int did) {
		this.empId=empId2;
		this.empName=empName2;
		this.empSalary=empSalary2;
		this.empAge=empAge2;
		this.empAdress=empAddress;
		this.empMobile=empMobile2;
		this.empEmail=empEmail2;
		this.roleid=rid;
		this.dptid=did;
		
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpAdress() {
		return empAdress;
	}
	public void setEmpAdress(String empAdress) {
		this.empAdress = empAdress;
	}
	public String getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public void setroleid(int rid)
	{
		this.roleid=rid;
	}
	public int getroleid()
	{
		return roleid;
	}
	public void setdeptId(int did)
	{
		this.dptid=did;
	}
	public int getdeptdid()
	{
		return dptid;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary
				+ ", empAdress=" + empAdress + ", empMobile=" + empMobile + ", empEmail=" + empEmail + "]";
	}
	

}
