package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectStatusDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStatusDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectStatusDAOImp projectStatusDAOImp;
	 
 
		
	
	 
	 
	 @Test 
	 public void addNewProjectStatusServiceTest() 
	 {

	
		
	 Date date= new Date();
		
	 
	 ProjectStatus projectStatus = new ProjectStatus();
	 
	 Timestamp completedDate = new Timestamp(date.getTime());
	 projectStatus.setCompletedDate(completedDate);
	 projectStatus.setDescription("fggfbfb");
	 projectStatus.setDonePercentage(40.45);
	 projectStatus.setProjectName("Sherwood Project");
	 projectStatus.setSupervisorName("userAEmail@gmail.com");
	 
	 Timestamp updatedDate = new Timestamp(date.getTime());
	 projectStatus.setUpdatedDate(updatedDate);
	 



		 Container<T> projectStatusContainer = projectStatusDAOImp.addProjectStatusDetails(projectStatus);
		String typeOfObject = projectStatusContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			ProjectStatus resultProjectStatusDetail=	(ProjectStatus)projectStatusContainer.getObject();
		 assertEquals("fggfbfb", resultProjectStatusDetail.getDescription());
		 assertEquals(40.45,resultProjectStatusDetail.getDonePercentage(),0.00);
		 assertEquals(completedDate, resultProjectStatusDetail.getCompletedDate());
		 assertEquals(updatedDate, resultProjectStatusDetail.getUpdatedDate());
		assertEquals("Sherwood Project", resultProjectStatusDetail.getProjectName());
		}
		else if(typeOfObject.equalsIgnoreCase("Error Object"))
		{
			 
			
			
			ApiError apiError = (ApiError)projectStatusContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
	 }

	 
	 
	
}
