package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface SelfAppraisalsService {
	public <T> Container<T> addSelfAppraisals(SelfAppraisals selfAppraisals,BindingResult result);
}
