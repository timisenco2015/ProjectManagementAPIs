package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.SelfAppraisalsDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.repository.SelfAppraisalsRepository;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelfAppraisalsRepositoryTest {
		 
	@Autowired
	TaskAssignedMemberRepository taskAssignedMemberRepository;
	
	
	@Autowired
	SelfAppraisalsRepository SelfAppraisalsRepo;
	
	
		  @Test
		  public void saveTest() {
			  
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
					
					SelfAppraisalsRepo.save(selfAppraisalsDetails);
				assertNotNull(SelfAppraisalsRepo.findUserAppraisalsDetails("Winnipeg Project","Sub Task1","userHEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
				assertNotNull(SelfAppraisalsRepo.findUserAppraisalsDetails("Winnipeg Project","Sub Task1","userHEmail@gmail.com"));
				  }
	
	}



