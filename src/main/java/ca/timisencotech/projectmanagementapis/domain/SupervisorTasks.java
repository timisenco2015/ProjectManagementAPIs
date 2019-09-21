package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;




public class SupervisorTasks implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;













	public String getTaskName() {
		return taskName;
	}






	public void setTaskName(String taskName) {
		this.taskName = taskName;
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






	private String taskName;
	private String projectName;
	private String supervisorName;

	
	

	
	
	@Override
	public String toString()
	{
		return "{projectName:"+projectName+", supervisorName:"+supervisorName+", taskName:"+ taskName+"}";
	}
	
	
	
}
