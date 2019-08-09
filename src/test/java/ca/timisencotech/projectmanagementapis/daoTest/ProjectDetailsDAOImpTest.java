package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDetailsDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectDetailsDAOImp projectDetailsDAOImp;
	 
 
	 @Test
		public void addNewProjectServiceTest() 
		 {
	
		 
		 ProjectInformation projectInformation = new ProjectInformation();
		 
		 projectInformation.setProjectName("Sherwood Project");
		 
		 Date date= new Date();
		Timestamp createdDate = new Timestamp(date.getTime());	
		 projectInformation.setCreatedDate(createdDate);
		 
		 Timestamp startDate = new Timestamp(date.getTime());	
		 projectInformation.setStartDate(startDate);
		 
		 
		 Timestamp endDate = new Timestamp(date.getTime());	
		 projectInformation.setEndDate(endDate);
		 
		 projectInformation.setCreatedBy("userEmail@gmail.com");
		 
		 projectInformation.setDescription("Description coming soon");
		 
	
			 Container<T> projectInformationContainer = projectDetailsDAOImp.addProjectDetails(projectInformation);
			String typeOfObject = projectInformationContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				ProjectInformation resultprojectInformation=	(ProjectInformation)projectInformationContainer.getObject();
		
			 assertEquals("Sherwood Project", resultprojectInformation.getProjectName());
			 assertEquals(createdDate, resultprojectInformation.getCreatedDate());
			 assertEquals(startDate, resultprojectInformation.getStartDate());
			 assertEquals(endDate, resultprojectInformation.getEndDate());
			 assertEquals("userEmail@gmail.com",resultprojectInformation.getCreatedBy());
			 assertEquals("Description coming soon", resultprojectInformation.getDescription());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)projectInformationContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			
			
		 }
		

	 
	 @Test
		public void addNewProjectConstraintErrorTest() 
		 {
			
		
		
		 //checks for field(s) null test
		 addNewProjectNullConstraintTest();
			
		 }
		 

		 private void addNewProjectNullConstraintTest()
		 {
			 ProjectInformation projectInformation = new ProjectInformation();
			 
			 projectInformation.setProjectName("Edmonton Project");
			 
			 Date date= new Date();
			
			 Timestamp startDate = new Timestamp(date.getTime());	
			 projectInformation.setStartDate(startDate);
			 
			 
			 Timestamp endDate = new Timestamp(date.getTime());	
			 projectInformation.setEndDate(endDate);
			 
			 projectInformation.setCreatedBy("userEmail@gmail.com");
			 
			 projectInformation.setDescription("Description coming soon");
			 
		
				 Container<T> projectInformationContainer = projectDetailsDAOImp.addProjectDetails(projectInformation);
				String typeOfObject = projectInformationContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					ProjectInformation resultprojectInformation=	(ProjectInformation)projectInformationContainer.getObject();

					 assertEquals("Edmonton Project", resultprojectInformation.getProjectName());
					assertEquals(startDate, resultprojectInformation.getStartDate());
					 assertEquals(endDate, resultprojectInformation.getEndDate());
					 assertEquals("userEmail@gmail.com",resultprojectInformation.getCreatedBy());
					 assertEquals("Description coming soon", resultprojectInformation.getDescription());
					}
				else if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)projectInformationContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
				
		 }
		 
		

}
