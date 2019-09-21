package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class TaskAssignedMembers implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 5043983034811138426L;

	private Timestamp dateAssigned;

	private String description;

	private boolean isActive;
	
	private String assignedBy;

	private String projectName;
	
	private String taskName;

	private String assignedTo;
	
	
	
	public Timestamp getDateAssigned() {
		return dateAssigned;
	}



	public void setDateAssigned(Timestamp dateAssigned) {
		this.dateAssigned = dateAssigned;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean getIsActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public String getAssignedBy() {
		return assignedBy;
	}



	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getTaskName() {
		return taskName;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	public String getAssignedTo() {
		return assignedTo;
	}



	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}



	public String toString()
	{
		return "{projectName:"+projectName+", dateAssigned:"+dateAssigned+", isActive:"+isActive+", assignedBy:"+
				assignedBy+", assignedTo:"+assignedTo+", description:"+description+", taskName:"+taskName+"}";
	}

	


	
}
