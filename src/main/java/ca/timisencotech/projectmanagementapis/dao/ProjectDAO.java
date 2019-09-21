package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.Project;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectDAO {
	public <T> Container<T> addProjectDetails(Project project);
	public <T> Container<T> updateProjectDetails(Project project);
		
}
