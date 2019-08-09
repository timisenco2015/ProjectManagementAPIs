package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectGroupDetailsService {
	public <T> Container<T> addProjectGroupDetails(ProjectGroupDetail projectGroupDetail,BindingResult result);
	}
