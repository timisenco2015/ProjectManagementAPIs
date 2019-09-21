package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.SelfAppraisalsDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepository;




@RunWith(SpringRunner.class)
@SpringBootTest
public class SelfAppraisalsDetailsTest 
{
	@Autowired
	TaskAssignedMemberRepository taskAssignedMemberRepository;
	
	@Test
	public void testSettersGetters() 
	{

		 Date date= new Date();
		 SelfAppraisalsDetails selfAppraisalsDetails=new SelfAppraisalsDetails();
			selfAppraisalsDetails.setStandardA("QuestionA");
			selfAppraisalsDetails.setStandardAPoint(4);
			selfAppraisalsDetails.setStandardB("QuestionB");
			selfAppraisalsDetails.setStandardBPoint(3);
			selfAppraisalsDetails.setStandardC("QuestionC");
			selfAppraisalsDetails.setStandardCPoint(4);
			selfAppraisalsDetails.setStandardD("QuestionD");
			selfAppraisalsDetails.setStandardDPoint(2);
			selfAppraisalsDetails.setStandardE("QuestionE");
			selfAppraisalsDetails.setStandardEPoint(3);
			selfAppraisalsDetails.setStandardF("QuestionF");
			selfAppraisalsDetails.setStandardFPoint(4);
			selfAppraisalsDetails.setStandardG("QuestionG");
			selfAppraisalsDetails.setStandardGPoint(5);
			selfAppraisalsDetails.setStandardH("QuestionH");
			selfAppraisalsDetails.setStandardHPoint(2);
			selfAppraisalsDetails.setStandardI("QuestionI");
			selfAppraisalsDetails.setStandardIPoint(1);
			selfAppraisalsDetails.setStandardJ("QuestionJ");
			selfAppraisalsDetails.setStandardJPoint(2);
			TaskAssignedMembersDetails findTaskAssignedMembersDetails = taskAssignedMemberRepository.findTaskAssignedMember("Sherwood Project","userHEmail@gmail.com","Sub Task1");
			selfAppraisalsDetails.setTaskAssignedMembersDetails(findTaskAssignedMembersDetails);
			selfAppraisalsDetails.setDescription("fdgdjdydtf");
			Timestamp appraisedStartDate = new Timestamp(date.getTime());
			selfAppraisalsDetails.setAppraisedStartDate(appraisedStartDate);
		
			Timestamp appraisedEndDate = new Timestamp(date.getTime());
			selfAppraisalsDetails.setAppraisedEndDate(appraisedEndDate);
			
			
			
			assertEquals("QuestionA", selfAppraisalsDetails.getStandardA());
			assertEquals(4, selfAppraisalsDetails.getStandardAPoint());
			assertEquals("QuestionB",selfAppraisalsDetails.getStandardB());
			assertEquals(3, selfAppraisalsDetails.getStandardBPoint());
			assertEquals("QuestionC", selfAppraisalsDetails.getStandardC());
			assertEquals(4, selfAppraisalsDetails.getStandardCPoint());
			assertEquals("QuestionD", selfAppraisalsDetails.getStandardD());
			assertEquals(2, selfAppraisalsDetails.getStandardDPoint());
			assertEquals("QuestionE", selfAppraisalsDetails.getStandardE());
			assertEquals(3, selfAppraisalsDetails.getStandardEPoint());
			assertEquals("QuestionF", selfAppraisalsDetails.getStandardF());
			assertEquals(4, selfAppraisalsDetails.getStandardFPoint());
			assertEquals("QuestionH", selfAppraisalsDetails.getStandardH());
			assertEquals(2, selfAppraisalsDetails.getStandardHPoint());
			assertEquals("QuestionI", selfAppraisalsDetails.getStandardI());
			assertEquals(1, selfAppraisalsDetails.getStandardIPoint());
			assertEquals("QuestionJ", selfAppraisalsDetails.getStandardJ());
			assertEquals(2, selfAppraisalsDetails.getStandardJPoint());
			assertEquals("QuestionG", selfAppraisalsDetails.getStandardG());
			assertEquals(5, selfAppraisalsDetails.getStandardGPoint());
			assertEquals(appraisedEndDate, selfAppraisalsDetails.getAppraisedEndDate());
			assertEquals(appraisedStartDate, selfAppraisalsDetails.getAppraisedStartDate());
			assertEquals(findTaskAssignedMembersDetails, selfAppraisalsDetails.getTaskAssignedMembersDetails());
			
		
	}

}
