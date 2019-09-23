package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.SupervisorAppraisalsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepo;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepo;




@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorAppraisalsDetailsTest 
{
	@Autowired
	TaskAssignedMemberRepo taskAssignedMemberRepo;
	
	@Autowired
	SupervisorTasksRepo supervisorTasksRepo;
	
	@Test
	public void testSettersGetters() 
	{

		 Date date= new Date();
		 SupervisorAppraisalsDetails supervisorAppraisalsDetails=new SupervisorAppraisalsDetails();
			supervisorAppraisalsDetails.setStandardA("QuestionA");
			supervisorAppraisalsDetails.setStandardAPoint(4);
			supervisorAppraisalsDetails.setStandardB("QuestionB");
			supervisorAppraisalsDetails.setStandardBPoint(3);
			supervisorAppraisalsDetails.setStandardC("QuestionC");
			supervisorAppraisalsDetails.setStandardCPoint(4);
			supervisorAppraisalsDetails.setStandardD("QuestionD");
			supervisorAppraisalsDetails.setStandardDPoint(2);
			supervisorAppraisalsDetails.setStandardE("QuestionE");
			supervisorAppraisalsDetails.setStandardEPoint(3);
			supervisorAppraisalsDetails.setStandardF("QuestionF");
			supervisorAppraisalsDetails.setStandardFPoint(4);
			supervisorAppraisalsDetails.setStandardG("QuestionG");
			supervisorAppraisalsDetails.setStandardGPoint(5);
			supervisorAppraisalsDetails.setStandardH("QuestionH");
			supervisorAppraisalsDetails.setStandardHPoint(2);
			supervisorAppraisalsDetails.setStandardI("QuestionI");
			supervisorAppraisalsDetails.setStandardIPoint(1);
			supervisorAppraisalsDetails.setStandardJ("QuestionJ");
			supervisorAppraisalsDetails.setStandardJPoint(2);
			TaskAssignedMembersDetails findTaskAssignedMembersDetails = taskAssignedMemberRepo.findTaskAssignedMember("Sherwood Project","userHEmail@gmail.com","Sub Task1");
			supervisorAppraisalsDetails.setTaskAssignedMembersDetails(findTaskAssignedMembersDetails);
			SupervisorTasksDetails findSupervisorTasksDetails = supervisorTasksRepo.findSupervisorsByProjectnameAndSupervisorNameAndTaskName("Sherwood Project", "userAEmail@gmail.com", "Sub Task1");
			supervisorAppraisalsDetails.setSupervisorTasksDetails(findSupervisorTasksDetails);
			
			
			supervisorAppraisalsDetails.setDescription("fdgdjdydtf");
			Timestamp appraisedStartDate = new Timestamp(date.getTime());
			supervisorAppraisalsDetails.setAppraisedStartDate(appraisedStartDate);
		
			Timestamp appraisedEndDate = new Timestamp(date.getTime());
			supervisorAppraisalsDetails.setAppraisedEndDate(appraisedEndDate);
			
			
			
			assertEquals("QuestionA", supervisorAppraisalsDetails.getStandardA());
			assertEquals(4, supervisorAppraisalsDetails.getStandardAPoint());
			assertEquals("QuestionB",supervisorAppraisalsDetails.getStandardB());
			assertEquals(3, supervisorAppraisalsDetails.getStandardBPoint());
			assertEquals("QuestionC", supervisorAppraisalsDetails.getStandardC());
			assertEquals(4, supervisorAppraisalsDetails.getStandardCPoint());
			assertEquals("QuestionD", supervisorAppraisalsDetails.getStandardD());
			assertEquals(2, supervisorAppraisalsDetails.getStandardDPoint());
			assertEquals("QuestionE", supervisorAppraisalsDetails.getStandardE());
			assertEquals(3, supervisorAppraisalsDetails.getStandardEPoint());
			assertEquals("QuestionF", supervisorAppraisalsDetails.getStandardF());
			assertEquals(4, supervisorAppraisalsDetails.getStandardFPoint());
			assertEquals("QuestionH", supervisorAppraisalsDetails.getStandardH());
			assertEquals(2, supervisorAppraisalsDetails.getStandardHPoint());
			assertEquals("QuestionI", supervisorAppraisalsDetails.getStandardI());
			assertEquals(1, supervisorAppraisalsDetails.getStandardIPoint());
			assertEquals("QuestionJ", supervisorAppraisalsDetails.getStandardJ());
			assertEquals(2, supervisorAppraisalsDetails.getStandardJPoint());
			assertEquals("QuestionG", supervisorAppraisalsDetails.getStandardG());
			assertEquals(5, supervisorAppraisalsDetails.getStandardGPoint());
			assertEquals(appraisedEndDate, supervisorAppraisalsDetails.getAppraisedEndDate());
			assertEquals(appraisedStartDate, supervisorAppraisalsDetails.getAppraisedStartDate());
			assertEquals(findTaskAssignedMembersDetails, supervisorAppraisalsDetails.getTaskAssignedMembersDetails());
			assertEquals(findSupervisorTasksDetails, supervisorAppraisalsDetails.getSupervisorTasksDetails());
			
		
	}

}
