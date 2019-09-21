package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.TaskAssignedMembersDAOImp;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskAssignedMembersDAOImpTest<T> {
	
	
	 @Autowired
	 TaskAssignedMembersDAOImp taskAssignedMembersDAOImp;
	 
 
	 @Test
		public void assignedTaskToMembersTest() 
		 {
	
		 
		 Date date= new Date();
			Timestamp dateAssigned = new Timestamp(date.getTime());
			
			
			TaskAssignedMembers taskAssignedMembers = new TaskAssignedMembers();
			taskAssignedMembers.setActive(true);
			taskAssignedMembers.setAssignedBy("userAEmail@gmail.com");
			taskAssignedMembers.setAssignedTo("userABEmail@gmail.com");
			taskAssignedMembers.setDateAssigned(dateAssigned);
			taskAssignedMembers.setDescription("gfghftdrdg");
			taskAssignedMembers.setProjectName("Sherwood Project");
			taskAssignedMembers.setTaskName("Sub task1");
			
			 Container<T> taskAssignedMembersContainer = taskAssignedMembersDAOImp.assignedTaskToMembers(taskAssignedMembers);
					
			String typeOfObject = taskAssignedMembersContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				TaskAssignedMembers resultTaskAssignedMembers=	(TaskAssignedMembers)taskAssignedMembersContainer.getObject();
				assertTrue(resultTaskAssignedMembers.getIsActive());
			 assertEquals("userAEmail@gmail.com", resultTaskAssignedMembers.getAssignedBy());
			 assertEquals("userABEmail@gmail.com", resultTaskAssignedMembers.getAssignedTo());
			 assertEquals(dateAssigned, resultTaskAssignedMembers.getDateAssigned());
			 assertEquals("gfghftdrdg", resultTaskAssignedMembers.getDescription());
			 assertEquals("Sherwood Project",resultTaskAssignedMembers.getProjectName());
			 assertEquals("Sub task1", resultTaskAssignedMembers.getTaskName());
			}
			
			
			
		
			//checks for unique constraint
			
			 date= new Date();
			dateAssigned = new Timestamp(date.getTime());
			taskAssignedMembers = new TaskAssignedMembers();
			taskAssignedMembers.setActive(true);
			taskAssignedMembers.setAssignedBy("userAEmail@gmail.com");
			taskAssignedMembers.setAssignedTo("userAAAEmail@gmail.com");
			taskAssignedMembers.setDateAssigned(dateAssigned);
			taskAssignedMembers.setDescription("gfghftdrdg");
			taskAssignedMembers.setProjectName("Sherwood Project");
			taskAssignedMembers.setTaskName("Sub task1");
				
			taskAssignedMembersContainer = taskAssignedMembersDAOImp.assignedTaskToMembers(taskAssignedMembers);
						
			typeOfObject = taskAssignedMembersContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)taskAssignedMembersContainer.getObject();
					assertEquals("Persistence Error", apiError.getStatus());
				}
				
			
		 }
		

	 
	

}
