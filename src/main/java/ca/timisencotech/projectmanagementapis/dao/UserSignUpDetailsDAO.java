package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserSignUpDetailsDAO {
	public <T> Container<T> addUserSignUpDetails(UserSignUpDetail userSignUpDetail);
	public <T> Container<T> updateUserPassword(UserSignUpDetail userSignUpDetail);
	
}
