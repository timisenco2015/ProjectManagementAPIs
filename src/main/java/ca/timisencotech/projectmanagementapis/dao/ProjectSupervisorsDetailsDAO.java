package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisorsDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectSupervisorsDetailsDAO {
	public <T> Container<T> addProjectSupervisorsDetails(ProjectSupervisorsDetail projectSupervisorsDetail);
	
}
