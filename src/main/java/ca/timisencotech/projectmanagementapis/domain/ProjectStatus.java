package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;
import java.sql.Timestamp;






public class ProjectStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7106156476771257795L;

	

	
	private Timestamp updatedDate;
	

	private String description;
	
	
	private double donePercentage;
	

	private Timestamp completedDate;
	
	
	private String projectName;
	
	private String supervisorName;
	
	
	
	
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}




	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}




	public String getSupervisorName() {
		return supervisorName;
	}




	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public double getDonePercentage() {
		return donePercentage;
	}




	public void setDonePercentage(double donePercentage) {
		this.donePercentage = donePercentage;
	}




	public Timestamp getCompletedDate() {
		return completedDate;
	}




	public void setCompletedDate(Timestamp completedDate) {
		this.completedDate = completedDate;
	}




	public String getProjectName() {
		return projectName;
	}




	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}




	@Override
	public String toString()
	{
		return "{projectName:"+projectName+", supervisorName:"+supervisorName+", updatedDate:"+updatedDate+"description:"+ description+", donePercentage:"+donePercentage+", completedDate:"+completedDate+"}";
	}
	
	
	
	
	
	
}
