package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.Project;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectDAO {
	public <T> Container<T> addProject(Project project);
	public <T> Container<T> updateProject(Project project);
		
}
