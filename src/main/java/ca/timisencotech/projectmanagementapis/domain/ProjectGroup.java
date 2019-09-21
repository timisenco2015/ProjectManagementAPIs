package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;
import java.sql.Timestamp;


public class ProjectGroup implements Serializable{
	


/**
	 * 
	 */
	private static final long serialVersionUID = 3175290653909084867L;



	private String groupName;
	private Timestamp createdDate;
	private String description;
	private boolean isActive;
	private String projectName;
	
	private String createdBy;




	@Override
	public String toString()
	{
		return "{ groupName:"+groupName+", createdBy:"+createdBy+", createdDate:"+createdDate+", description:"+description
				+", projectName:"+projectName+", isActive:"+isActive+"}";
	}




	public String getGroupName() {
		return groupName;
	}




	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}




	public Timestamp getCreatedDate() {
		return createdDate;
	}




	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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




	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}




	public String getProjectName() {
		return projectName;
	}




	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}




	public String getCreatedBy() {
		return createdBy;
	}




	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



}
