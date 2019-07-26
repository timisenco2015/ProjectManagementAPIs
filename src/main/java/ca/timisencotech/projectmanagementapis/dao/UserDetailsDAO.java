package ca.timisencotech.projectmanagementapis.dao;
import ca.timisencotech.projectmanagementapis.domain.UserDetail;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserDetailsDAO {
	public <T> Container<T> addNewUser(UserDetail userDetail);
}
