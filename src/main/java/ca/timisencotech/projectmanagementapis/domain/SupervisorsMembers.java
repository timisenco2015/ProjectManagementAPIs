package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;



public class SupervisorsMembers implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -169622322936550703L;

 private String projectName;
 private String supervisorName;
 private String memberName;	
 








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


public String getMemberName() {
	return memberName;
}


public void setMemberName(String memberName) {
	this.memberName = memberName;
}


	@Override
	public String toString()
	{
		return "{projectName:"+projectName+", supervisorName:"+supervisorName+", membername:"+ memberName+"}";
	}
	
	
}
