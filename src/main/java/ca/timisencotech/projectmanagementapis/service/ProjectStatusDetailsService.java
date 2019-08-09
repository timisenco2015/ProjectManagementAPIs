package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatusDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectStatusDetailsService {
	public <T> Container<T> addProjectStatusDetails(ProjectStatusDetail projectStatusDetail,BindingResult result);
	}
