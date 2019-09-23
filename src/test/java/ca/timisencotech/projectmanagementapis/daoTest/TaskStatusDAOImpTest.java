package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.TaskStatusDAOImp;
import ca.timisencotech.projectmanagementapis.domain.TaskStatus;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskStatusDAOImpTest<T> {
	
	
	 @Autowired
	 TaskStatusDAOImp taskStatusDAOImp;
	 
 
		
	
	 
	 
	 @Test 
	 public void addNewTaskStatusServiceTest() 
	 {

	
		 Date date= new Date();
	
			TaskStatus  taskStatus = new  TaskStatus();
			Timestamp completedDate = new Timestamp(date.getTime());
			taskStatus.setCompletedDate(completedDate);
			taskStatus.setDescription("bdbdbbcxvb");
			taskStatus.setDonePercentage(30.34);
			taskStatus.setMemberName("userHEmail@gmail.com");
			taskStatus.setProjectName("Sherwood Project");
			taskStatus.setTaskName("Sub Task1");
			Timestamp updatedDate = new Timestamp(date.getTime());
			taskStatus.setUpdatedDate(updatedDate);

	
		 Container<T> taskStatusContainer = taskStatusDAOImp.addTaskStatus(taskStatus);
				
		String typeOfObject = taskStatusContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			TaskStatus resultTaskStatus=	(TaskStatus)taskStatusContainer.getObject();
		 assertEquals(completedDate, resultTaskStatus.getCompletedDate());
		 assertEquals("bdbdbbcxvb",resultTaskStatus.getDescription());
		 assertEquals(30.34, resultTaskStatus.getDonePercentage(),0.0);
		 assertEquals("userHEmail@gmail.com", resultTaskStatus.getMemberName());
		assertEquals("Sherwood Project", resultTaskStatus.getProjectName());
		assertEquals("Sub Task1", resultTaskStatus.getTaskName());
		assertEquals(updatedDate, resultTaskStatus.getUpdatedDate());
		}
		else if(typeOfObject.equalsIgnoreCase("Error Object"))
		{
		 
			
			
			ApiError apiError = (ApiError)taskStatusContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
		
	 }
	

	 
	 
	
}
