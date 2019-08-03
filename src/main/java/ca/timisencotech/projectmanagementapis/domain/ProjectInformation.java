package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;
import java.sql.Timestamp;


public class ProjectInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1165084139687142802L;

	private String projectName;
	
	private Timestamp createdDate;
	
	private Timestamp startDate;
	
	private Timestamp endDate;
	
	private String description;
	
	private String createdBy;


	
	public String getProjectName() {
		return projectName;
	}

	
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	

	
	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Timestamp getStartDate() {
		return startDate;
	}

	
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	
	public Timestamp getEndDate() {
		return endDate;
	}


	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}


	
	public String getDescription() {
		return description;
	}
	

	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
    @Override
	public String toString()
	{
		return "{ projectName:"+projectName+", createdDate:"+createdDate+", startDate:"+startDate+", endDate:"+
				", endDate:"+endDate+", description:"+description+", createdBy:"+createdBy;
	}


}
