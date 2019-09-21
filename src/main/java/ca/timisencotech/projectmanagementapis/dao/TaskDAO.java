package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface TaskDAO {
	public <T> Container<T> addTaskDetails(Task task);
	public <T> Container<T> updateTaskDetails(Task task);
		
}
