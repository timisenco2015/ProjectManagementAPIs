package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.UserSignUp;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserSignUpDAO {
	public <T> Container<T> addUserSignUpDetails(UserSignUp userSignUp);
	public <T> Container<T> updateUserPassword(UserSignUp userSignUp);
	
}
