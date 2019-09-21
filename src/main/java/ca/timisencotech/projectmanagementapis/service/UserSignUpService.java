package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserSignUpService {
	public <T> Container<T> addUserSignUpDetails(UserSignUp userSignUp,BindingResult result);
	public <T> Container<T> updateUserPassword(UserSignUp userSignUp,BindingResult result);	
}
