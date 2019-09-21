package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectSupervisorsDAO {
	public <T> Container<T> addProjectSupervisorsDetails(ProjectSupervisors projectSupervisors);
	
}
