package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.User;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface UserService {
	public <T> Container<T> addNewUser(User user,BindingResult result);
}
