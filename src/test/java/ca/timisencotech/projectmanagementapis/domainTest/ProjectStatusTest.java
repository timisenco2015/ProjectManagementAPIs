package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStatusTest 
{
	@Test
	public void testSettersGetters() 
	{
		ProjectStatus projectStatus = new ProjectStatus();
		Date date= new Date();
		
	
		//check setter and getter for completed by
		Timestamp completedDate = new Timestamp(date.getTime());
		projectStatus.setCompletedDate(completedDate);
		assertEquals(completedDate,projectStatus.getCompletedDate());
		
		//check setter and getter for description
		projectStatus.setDescription("dfghjk");
		String	testResult1 = "dfghjk";
		assertEquals(testResult1,projectStatus.getDescription());
				
		//check setter and getter for done percentage
		projectStatus.setDonePercentage(40.28);
		double	testResult2 = 40.28;
		assertEquals(testResult2,projectStatus.getDonePercentage(),0.00);
		
		//check setter and getter for project name
		projectStatus.setProjectName("Sherwood Project");
		testResult1 = "Sherwood Project";
		assertEquals(testResult1,projectStatus.getProjectName());
		
		//check setter and getter for completed date
		Timestamp updatedDate = new Timestamp(date.getTime());
		projectStatus.setUpdatedDate(updatedDate);
		assertEquals(updatedDate,projectStatus.getUpdatedDate());
		
		
		
		assertEquals(completedDate,projectStatus.getCompletedDate());
		assertEquals("dfghjk",projectStatus.getDescription());
		assertEquals(40.28,projectStatus.getDonePercentage(),0.00);
		assertEquals("Sherwood Project",projectStatus.getProjectName());
		assertEquals(updatedDate,projectStatus.getUpdatedDate());
			
		
	}

}
