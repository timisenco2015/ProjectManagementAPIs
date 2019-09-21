package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectStatusDAO {
	public <T> Container<T> addProjectStatusDetails(ProjectStatus projectStatus);
	
}
