package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectGroupService {
	public <T> Container<T> addProjectGroup(ProjectGroup projectGroup,BindingResult result);
	}
