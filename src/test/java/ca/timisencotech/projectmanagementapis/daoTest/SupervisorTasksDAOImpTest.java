package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.SupervisorTasksDAOImp;
import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorTasksDAOImpTest<T> {
	
	
	 @Autowired
	 SupervisorTasksDAOImp supervisorTasksDAODAOImp;
	 
	 
	
	
	
	
	 
	 
	 @Test
	 public void addSupervisorTasksTest() 
	 {

	
			SupervisorTasks supervisorTasks = new  SupervisorTasks();
			supervisorTasks.setProjectName("Sherwood Project");
			supervisorTasks.setSupervisorName("userAEmail@gmail.com");
			supervisorTasks.setTaskName("Sub Task2");
			
		
		
		 Container<T> supervisorTasksContainer = supervisorTasksDAODAOImp.addSupervisorTask(supervisorTasks);
		String typeOfObject = supervisorTasksContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			SupervisorTasks resultSupervisorTasks=	(SupervisorTasks)supervisorTasksContainer.getObject();
			assertEquals("Sherwood Project", resultSupervisorTasks.getProjectName());
			assertEquals("userAEmail@gmail.com", resultSupervisorTasks.getSupervisorName());
			assertEquals("Sub Task2", resultSupervisorTasks.getTaskName());
		
		}
		
		
		// checks for unique constraints
		
		supervisorTasks = new  SupervisorTasks();
		supervisorTasks.setProjectName("Sherwood Project");
		supervisorTasks.setSupervisorName("userAEmail@gmail.com");
		supervisorTasks.setTaskName("Sub Task2");
		
		supervisorTasksContainer = supervisorTasksDAODAOImp.addSupervisorTask(supervisorTasks);
		typeOfObject = supervisorTasksContainer.getObjectType();
	
		if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)supervisorTasksContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
			
		
	 }








	
	 
	 
	 
}
