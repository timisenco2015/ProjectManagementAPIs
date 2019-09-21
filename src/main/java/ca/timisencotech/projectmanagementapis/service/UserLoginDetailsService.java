package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.UserLogin;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserLoginDetailsService {
	public <T> Container<T> confirmedUserLoginDetails(UserLogin userLogin,BindingResult result);
	
}
