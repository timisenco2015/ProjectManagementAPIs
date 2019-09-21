package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface SupervisorAppraisalsService {
	public <T> Container<T> addSupervisorAppraisals(SupervisorAppraisals supervisorAppraisals,BindingResult result);
}
