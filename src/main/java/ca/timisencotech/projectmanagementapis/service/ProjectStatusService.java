package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectStatusService {
	public <T> Container<T> addProjectStatus(ProjectStatus projectStatus,BindingResult result);
	}
