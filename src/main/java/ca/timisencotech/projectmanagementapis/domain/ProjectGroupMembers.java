package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;



public class ProjectGroupMembers implements Serializable{
	
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 7772279192252276453L;


	
	private boolean isActive;
	private String projectName;
	private String groupName;
	private String memberName;
	
	private String activitiesUpdate;
	
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


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	

	
	public String getActivitiesUpdate() {
		return activitiesUpdate;
	}


	public void setActivitiesUpdate(String activitiesUpdate) {
		this.activitiesUpdate = activitiesUpdate;
	}


	@Override
	public String toString()
	{
		return "{ groupName:"+groupName+", projectName:"+projectName+", memberName:"+memberName+", isActive:"+isActive+", activitiesUpdate:"+activitiesUpdate+"}";
	}



}
