package com.model;


public class Department {
	private Integer departmentId;
	private String departmentName;
	private String departmentLocation;
	public Department() {

	}
	public Department(Integer id,String name,String location)
	{
		this.departmentId=id;
		this.departmentName=name;
		this.departmentLocation=location;
		
	}
	
	public void setDepartmentId(Integer id)
	{
		departmentId=id;
		
	}
	public Integer getDepartmentId()
	{
		return departmentId;
	}
	public void setDepartmentName(String name)
	{
		departmentName=name;
	}
	public String getepartmentName()
	{
		return departmentName;
	}
	public void setDepartmentLocation(String location)
	{
		departmentLocation=location;
	}
	public String getDepartmentLocation()
	{
		return departmentLocation;
	}
	public String toString()
	{
		return departmentId+" "+" "+departmentName+" "+departmentLocation+" ";
	}

}
