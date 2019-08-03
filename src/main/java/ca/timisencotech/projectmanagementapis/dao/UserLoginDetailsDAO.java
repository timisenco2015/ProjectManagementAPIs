package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserLoginDetailsDAO {
	public <T> Container<T> addUserLoginDetails(UserLoginDetail userLoginDetail);
	public <T> Container<T> confirmedUserLoginDetails(UserLoginDetail userLoginDetail);
}
