package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface TaskService {
	public <T> Container<T> addTask(Task tasks,BindingResult result);
	public <T> Container<T> updateTask(Task task,BindingResult result);	

}
