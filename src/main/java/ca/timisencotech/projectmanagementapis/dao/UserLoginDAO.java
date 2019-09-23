package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.UserLogin;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserLoginDAO {
	public <T> Container<T> confirmedUserLogin(UserLogin userLogin);
}
