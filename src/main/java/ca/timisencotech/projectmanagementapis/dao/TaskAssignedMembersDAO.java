package ca.timisencotech.projectmanagementapis.dao;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface TaskAssignedMembersDAO {
	public <T> Container<T> assignedTaskToMembers(TaskAssignedMembers taskAssignedMembers);
		
}
