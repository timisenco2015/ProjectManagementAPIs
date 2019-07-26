package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.UserDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface UserDetailsService {
	public <T> Container<T> addNewUser(UserDetail userDetail,BindingResult result);
}
