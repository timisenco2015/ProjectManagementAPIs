package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.UserLogin;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserLoginService {
	public <T> Container<T> confirmedUserLogin(UserLogin userLogin,BindingResult result);
	
}
