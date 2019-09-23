package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectSupervisorsService {
	public <T> Container<T> addProjectSupervisors(ProjectSupervisors projectSupervisors,BindingResult result);
	}
