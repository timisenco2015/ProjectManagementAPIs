package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface TaskDAO {
	public <T> Container<T> addTask(Task task);
	public <T> Container<T> updateTask(Task task);
		
}
