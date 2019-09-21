package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;
import java.sql.Timestamp;



public class TaskStatus implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5244351468369891607L;





	


	
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}






	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
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






	public String getMemberName() {
		return memberName;
	}






	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}






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






	private Timestamp updatedDate;
	private String description;
	private double donePercentage;
	private Timestamp completedDate;
	private String memberName;
	private String taskName;
	private String projectName;
	
	
	
	
	
	
	@Override
	public String toString()
	{
		return "{projectName:"+projectName+", taskname"+taskName+", memberName:"+memberName+", updatedDate:"+updatedDate+"description:"+ description+", donePercentage:"+donePercentage+", completedDate:"+completedDate+"}";
	}
	
	

}
