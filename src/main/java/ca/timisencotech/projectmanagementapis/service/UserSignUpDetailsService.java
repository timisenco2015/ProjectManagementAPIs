package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserSignUpDetailsService {
	public <T> Container<T> addUserSignUpDetails(UserSignUpDetail userSignUpDetail,BindingResult result);
	public <T> Container<T> updateUserPassword(UserSignUpDetail userSignUpDetail,BindingResult result);	
}
