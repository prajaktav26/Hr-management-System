package com.model;


public class roles {
	private Integer roleId;
	private String roleName;
	public roles()
	{
		
	}
	roles(Integer id,String name)
	{
		this.roleId=id;
		this.roleName=name;
	}
	public void setRoleId(Integer rid)
	{
		roleId=rid;
	}
	public Integer getRoleId()
	{
		return roleId;
	}
	public void setRoleName(String name)
	{
		roleName=name;
		
	}
	public String getRoleName()
	{
		return roleName;
	}

}
