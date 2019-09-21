package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;

import ca.timisencotech.projectmanagementapis.dto.Privileges;



public class SupervisorsPrivileges implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -505100839168911789L;
	
	private Privileges privileges;
	private String projectName;
	private String supervisorName;
	

	
	
	public  SupervisorsPrivileges()
	{
		
	}
	
	
	
	public Privileges getPrivileges() {
		return privileges;
	}


	
	public void setPrivileges(Privileges privileges) {
		this.privileges = privileges;
	}


	

	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getSupervisorName() {
		return supervisorName;
	}



	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}



	@Override
	public String toString()
	{
		return "{projectName:"+projectName+", supervisorName:"+supervisorName+", privileges:"+ privileges+"}";
	}
	
	
	
	
}
