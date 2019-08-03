package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectDetailsDAO {
	public <T> Container<T> addProjectDetails(ProjectInformation projectInformation);
}
