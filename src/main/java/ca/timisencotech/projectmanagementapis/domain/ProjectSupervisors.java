package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;




public class ProjectSupervisors implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public boolean getIsActive() {
		return isActive;
	}






	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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






	private boolean isActive;
	private String projectName;
	private String supervisorName;

	
	

	
	
	@Override
	public String toString()
	{
		return "{projectName:"+projectName+", supervisorName:"+supervisorName+", isActive:"+ isActive+"}";
	}
	
	
	
}
