package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Project;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectDAOImp projectDAOImp;
	 
 
	 @Test
		public void addNewProjectServiceTest() 
		 {
	
		 
		 Project project = new Project();
		 
		 project.setProjectName("Sherwood Project");
		 
		 Date date= new Date();
		Timestamp createdDate = new Timestamp(date.getTime());	
		 project.setCreatedDate(createdDate);
		 
		 Timestamp startDate = new Timestamp(date.getTime());	
		 project.setStartDate(startDate);
		 
		 
		 Timestamp endDate = new Timestamp(date.getTime());	
		 project.setEndDate(endDate);
		 
		 project.setCreatedBy("userEmail@gmail.com");
		 
		 project.setDescription("Description coming soon");
		 
	
			 Container<T> projectInformationContainer = projectDAOImp.addProjectDetails(project);
			String typeOfObject = projectInformationContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				Project resultprojectInformation=	(Project)projectInformationContainer.getObject();
		
			 assertEquals("Sherwood Project", resultprojectInformation.getProjectName());
			 assertEquals(createdDate, resultprojectInformation.getCreatedDate());
			 assertEquals(startDate, resultprojectInformation.getStartDate());
			 assertEquals(endDate, resultprojectInformation.getEndDate());
			 assertEquals("userEmail@gmail.com",resultprojectInformation.getCreatedBy());
			 assertEquals("Description coming soon", resultprojectInformation.getDescription());
			}
			
			
			
		
			//checks for unique constraint
			
			 project = new Project();
			 
			 project.setProjectName("Sherwood Project");
			 
			 date= new Date();
			createdDate = new Timestamp(date.getTime());	
			 project.setCreatedDate(createdDate);
			 
			  startDate = new Timestamp(date.getTime());	
			 project.setStartDate(startDate);
			 
			 
			  endDate = new Timestamp(date.getTime());	
			 project.setEndDate(endDate);
			 
			 project.setCreatedBy("userEmail@gmail.com");
			 
			 project.setDescription("Description coming soon");
			 
			 	projectInformationContainer = projectDAOImp.addProjectDetails(project);
				typeOfObject = projectInformationContainer.getObjectType();
			 if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)projectInformationContainer.getObject();
					assertEquals("Persistence Error", apiError.getStatus());
				}
				
			
		 }
		

	 
	

}
