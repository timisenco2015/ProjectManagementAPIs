package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.TaskDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDAOImpTest<T> {
	
	
	 @Autowired
	 TaskDAOImp taskDAOImp;
	 
 
	 @Test
		public void addNewProjectServiceTest() 
		 {
	
		 
		 Task task = new Task();
		 
		 task.setProjectName("Sherwood Project");
		 
		 Date date= new Date();
		Timestamp createdDate = new Timestamp(date.getTime());	
		task.setCreatedDate(createdDate);
		 
		 Timestamp startDate = new Timestamp(date.getTime());	
		 task.setStartDate(startDate);
		 
		 
		 Timestamp endDate = new Timestamp(date.getTime());	
		 task.setEndDate(endDate);
		 
		 task.setCreatedBy("userEmail@gmail.com");
		 
		 task.setDescription("Description coming soon");
		 
		 task.setTaskName("Sub Task1");
	
			 Container<T> taskContainer = taskDAOImp.addTask(task);
			String typeOfObject = taskContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				Task resultTask=	(Task)taskContainer.getObject();
		
			 assertEquals("Sherwood Project", resultTask.getProjectName());
			 assertEquals(createdDate, resultTask.getCreatedDate());
			 assertEquals(startDate, resultTask.getStartDate());
			 assertEquals(endDate,resultTask.getEndDate());
			 assertEquals("userEmail@gmail.com",resultTask.getCreatedBy());
			 assertEquals("Description coming soon", resultTask.getDescription());
			 assertEquals("Sub Task1", resultTask.getTaskName());
				
			}
			
			
			
		
			//checks for unique constraint
			
			task = new Task();
			 
			 task.setProjectName("Sherwood Project");
			 
			 date= new Date();
			createdDate = new Timestamp(date.getTime());	
			task.setCreatedDate(createdDate);
			 
			 startDate = new Timestamp(date.getTime());	
			 task.setStartDate(startDate);
			 
			 
			 endDate = new Timestamp(date.getTime());	
			 task.setEndDate(endDate);
			 
			 task.setCreatedBy("userEmail@gmail.com");
			 
			 task.setDescription("Description coming soon");
			 
			 task.setTaskName("Sub Task2");
			 taskContainer = taskDAOImp.addTask(task);
			typeOfObject = taskContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)taskContainer.getObject();
					assertEquals("Persistence Error", apiError.getStatus());
				}
				
			
		 }
		

	 
	

}
