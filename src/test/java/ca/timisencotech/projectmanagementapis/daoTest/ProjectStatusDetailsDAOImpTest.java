package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectStatusDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatusDetail;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStatusDetailsDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectStatusDetailsDAOImp projectStatusDetailsDAOImp;
	 
 
		
	
	 @Test
		public void addProjectGroupTest() 
		 {
		 //checks for add new project group
		 addNewProjectStatusServiceTest();
		 
		 //checks for updatedDate null test
		 addNewProjectGroupUpdatedDateNullValueConstraintTest();
		 
		 
		 //checks for description null test
		 addNewProjectGroupDescriptionNullValueConstraintTest();
		
		 //checks for done percentage null test
		 addNewProjectGroupDonePercentageNullValueConstraintTest() ;
		 
		 
		
		 }
	 
	 
	 private void addNewProjectStatusServiceTest() 
	 {

	
		
	 Date date= new Date();
		
	 
	 ProjectStatusDetail projectStatusDetail = new ProjectStatusDetail();
	 
	 Timestamp completedDate = new Timestamp(date.getTime());
	 projectStatusDetail.setCompletedDate(completedDate);
	 projectStatusDetail.setDescription("fggfbfb");
	 projectStatusDetail.setDonePercentage(40.45);
	 projectStatusDetail.setProjectName("Sherwood Project");
	 Timestamp updatedDate = new Timestamp(date.getTime());
	 projectStatusDetail.setUpdatedDate(updatedDate);
	 



		 Container<T> projectInformationContainer = projectStatusDetailsDAOImp.addProjectStatusDetails(projectStatusDetail);
		String typeOfObject = projectInformationContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			ProjectStatusDetail resultProjectStatusDetail=	(ProjectStatusDetail)projectInformationContainer.getObject();
		 assertEquals("fggfbfb", resultProjectStatusDetail.getDescription());
		 assertEquals(40.45,resultProjectStatusDetail.getDonePercentage(),0.00);
		 assertEquals(completedDate, resultProjectStatusDetail.getCompletedDate());
		 assertEquals(updatedDate, resultProjectStatusDetail.getUpdatedDate());
		assertEquals("Sherwood Project", resultProjectStatusDetail.getProjectName());
		}
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			
			ApiError apiError = (ApiError)projectInformationContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
		
	 }
	

	 

		private void addNewProjectGroupUpdatedDateNullValueConstraintTest() 
		 {
	
			Date date= new Date();
			
			 
			 ProjectStatusDetail projectStatusDetail = new ProjectStatusDetail();
			 
			 Timestamp completedDate = new Timestamp(date.getTime());
			 projectStatusDetail.setCompletedDate(completedDate);
			 projectStatusDetail.setDescription("fggfbfb");
			 projectStatusDetail.setDonePercentage(40.45);
			 projectStatusDetail.setProjectName("Sherwood Project");
		//	 Timestamp updatedDate = new Timestamp(date.getTime());
			// projectStatusDetail.setUpdatedDate(updatedDate);
			 



				 Container<T> projectInformationContainer = projectStatusDetailsDAOImp.addProjectStatusDetails(projectStatusDetail);
				String typeOfObject = projectInformationContainer.getObjectType();
				
				if(typeOfObject.equalsIgnoreCase("Error Object"))
				{
				 
					
					
					ApiError apiError = (ApiError)projectInformationContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
			
			
		 }
		
		
		private void addNewProjectGroupDescriptionNullValueConstraintTest() 
		 {
	
			Date date= new Date();
			
			 
			 ProjectStatusDetail projectStatusDetail = new ProjectStatusDetail();
			 
			 Timestamp completedDate = new Timestamp(date.getTime());
			 projectStatusDetail.setCompletedDate(completedDate);
			// projectStatusDetail.setDescription("fggfbfb");
			 projectStatusDetail.setDonePercentage(40.45);
			 projectStatusDetail.setProjectName("Sherwood Project");
			 Timestamp updatedDate = new Timestamp(date.getTime());
			 projectStatusDetail.setUpdatedDate(updatedDate);
			 



				 Container<T> projectInformationContainer = projectStatusDetailsDAOImp.addProjectStatusDetails(projectStatusDetail);
				String typeOfObject = projectInformationContainer.getObjectType();
				
				if(typeOfObject.equalsIgnoreCase("Error Object"))
				{
				 
					
					
					ApiError apiError = (ApiError)projectInformationContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
			
			
		 }
	  
		private void addNewProjectGroupDonePercentageNullValueConstraintTest() 
		 {
	
			Date date= new Date();
			
			 
			 ProjectStatusDetail projectStatusDetail = new ProjectStatusDetail();
			 
			 Timestamp completedDate = new Timestamp(date.getTime());
			 projectStatusDetail.setCompletedDate(completedDate);
			 projectStatusDetail.setDescription("fggfbfb");
			// projectStatusDetail.setDonePercentage(40.45);
			 projectStatusDetail.setProjectName("Sherwood Project");
			 Timestamp updatedDate = new Timestamp(date.getTime());
			 projectStatusDetail.setUpdatedDate(updatedDate);
			 



				 Container<T> projectInformationContainer = projectStatusDetailsDAOImp.addProjectStatusDetails(projectStatusDetail);
				String typeOfObject = projectInformationContainer.getObjectType();
				
				if(typeOfObject.equalsIgnoreCase("Error Object"))
				{
				 
					
					
					ApiError apiError = (ApiError)projectInformationContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
			
			
		 }
	  
		
		
		
	  
		/*
	 private void addNewProjectGroupProjectNameNullValueConstraintTest() 
	 {

	  Date date= new Date();
		
	 
	 ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
	 projectGroupDetail.setCreatedBy("checkidowu@gmail.com");
	 Timestamp createdDate = new Timestamp(date.getTime());
	 projectGroupDetail.setCreatedDate(createdDate);
	 projectGroupDetail.setDescription("ddfdfdfdf");
	 projectGroupDetail.setGroupName("group1");
	 projectGroupDetail.setIsActive(true);
	 projectGroupDetail.setProjectName("Ayo Project");
	


		 Container<T> projectInformationContainer = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
		String typeOfObject = projectInformationContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Null Object"))
		{
		 
		
			ApiError apiError = (ApiError)projectInformationContainer.getObject();
			assertEquals("We dont have this project name: Ayo Project in our database", apiError.getMessage());
		}
		
		
		
	 }
	 
	 private void addNewProjectGroupCreatedDateNullValueConstraintTest() 
	 {

	 // Date date= new Date();
		
	 
	 ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
	 projectGroupDetail.setCreatedBy("checkidowu@gmail.com");
	 //Timestamp createdDate = new Timestamp(date.getTime());
	 //projectGroupDetail.setCreatedDate(createdDate);
	 projectGroupDetail.setDescription("ddfdfdfdf");
	 projectGroupDetail.setGroupName("group3");
	 projectGroupDetail.setIsActive(true);
	 projectGroupDetail.setProjectName("Sherwood Project");
	


		 Container<T> projectInformationContainer = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
		String typeOfObject = projectInformationContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Error Object"))
		{
		 
			
			
			ApiError apiError = (ApiError)projectInformationContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
		
	 }
	 
	 
	 private void addNewProjectGroupProjectAndGroupNameUniqueConstraintTest() 
	 {

	  Date date= new Date();
		
	 
	 ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
	 projectGroupDetail.setCreatedBy("checkidowu@gmail.com");
	 Timestamp createdDate = new Timestamp(date.getTime());
	 projectGroupDetail.setCreatedDate(createdDate);
	 projectGroupDetail.setDescription("ddfdfdfdf");
	 projectGroupDetail.setGroupName("group1");
	 projectGroupDetail.setIsActive(true);
	 projectGroupDetail.setProjectName("Sherwood Project");
	


		 Container<T> projectInformationContainer = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
		String typeOfObject = projectInformationContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Error Object"))
		{
		 
			
			
			ApiError apiError = (ApiError)projectInformationContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
		
	 }
  	 
*/
}
