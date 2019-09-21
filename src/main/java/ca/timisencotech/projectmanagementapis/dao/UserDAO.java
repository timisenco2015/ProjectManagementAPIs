package ca.timisencotech.projectmanagementapis.dao;
import ca.timisencotech.projectmanagementapis.domain.User;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface UserDAO {
	public <T> Container<T> addNewUser(User user);
}
