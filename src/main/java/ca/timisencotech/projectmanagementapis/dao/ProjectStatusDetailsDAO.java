package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.ProjectStatusDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectStatusDetailsDAO {
	public <T> Container<T> addProjectStatusDetails(ProjectStatusDetail projectStatusDetail);
	
}
