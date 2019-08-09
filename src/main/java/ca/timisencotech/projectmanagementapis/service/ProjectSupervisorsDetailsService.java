package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisorsDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectSupervisorsDetailsService {
	public <T> Container<T> addProjectSupervisorsDetails(ProjectSupervisorsDetail projectSupervisorsDetail,BindingResult result);
	}
