package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserLoginDetailsService {
	public <T> Container<T> addUserLoginDetails(UserLoginDetail userLoginDetail,BindingResult result);
}
