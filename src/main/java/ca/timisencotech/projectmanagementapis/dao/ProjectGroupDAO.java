package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectGroupDAO {
	public <T> Container<T> addProjectGroupDetails(ProjectGroup projectGroup);
	
}
