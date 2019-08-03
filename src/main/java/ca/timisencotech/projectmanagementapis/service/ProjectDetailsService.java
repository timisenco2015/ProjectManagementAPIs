package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectDetailsService {
	public <T> Container<T> addProjectpDetails(ProjectInformation projectInformation,BindingResult result);
}
