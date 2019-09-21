package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.Project;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectService {
	public <T> Container<T> addProjectpDetails(Project project,BindingResult result);
	public <T> Container<T> updateProjectDetails(Project project,BindingResult result);
	}
