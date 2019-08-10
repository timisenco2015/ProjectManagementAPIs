package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatusDetail;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStatusDetailTest 
{
	@Test
	public void testSettersGetters() 
	{
		ProjectStatusDetail projectStatusDetail = new ProjectStatusDetail();
		Date date= new Date();
		
	
		//check setter and getter for completed by
		Timestamp completedDate = new Timestamp(date.getTime());
		projectStatusDetail.setCompletedDate(completedDate);
		assertEquals(completedDate,projectStatusDetail.getCompletedDate());
		
		//check setter and getter for description
		projectStatusDetail.setDescription("dfghjk");
		String	testResult1 = "dfghjk";
		assertEquals(testResult1,projectStatusDetail.getDescription());
				
		//check setter and getter for done percentage
		projectStatusDetail.setDonePercentage(40.28);
		double	testResult2 = 40.28;
		assertEquals(testResult2,projectStatusDetail.getDonePercentage(),0.00);
		
		//check setter and getter for project name
		projectStatusDetail.setProjectName("Sherwood Project");
		testResult1 = "Sherwood Project";
		assertEquals(testResult1,projectStatusDetail.getProjectName());
		
		//check setter and getter for completed date
		Timestamp updatedDate = new Timestamp(date.getTime());
		projectStatusDetail.setUpdatedDate(updatedDate);
		assertEquals(updatedDate,projectStatusDetail.getUpdatedDate());
		
		assertEquals(completedDate,projectStatusDetail.getCompletedDate());
		assertEquals("dfghjk",projectStatusDetail.getDescription());
		assertEquals(40.28,projectStatusDetail.getDonePercentage(),0.00);
		assertEquals("Sherwood Project",projectStatusDetail.getProjectName());
		assertEquals(updatedDate,projectStatusDetail.getUpdatedDate());
			
		
	}

}
