package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectGroupDetailsDAO {
	public <T> Container<T> addProjectGroupDetails(ProjectGroupDetail projectGroupDetail);
	
}
