package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;

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
import ca.timisencotech.projectmanagementapis.repository.SupervisorAppraisalsRepository;
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepository;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorAppraisalsRepositoryTest {
		 
	@Autowired
	TaskAssignedMemberRepository taskAssignedMemberRepository;
	
	@Autowired
	SupervisorTasksRepository supervisorTasksRepository;
	
	
	@Autowired
	SupervisorAppraisalsRepository supervisorAppraisalsRepo;
	
	
		  @Test
		  public void saveTest() {
			  
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
					TaskAssignedMembersDetails findTaskAssignedMembersDetails = taskAssignedMemberRepository.findTaskAssignedMember("Sherwood Project","userHEmail@gmail.com","Sub Task1");
					supervisorAppraisalsDetails.setTaskAssignedMembersDetails(findTaskAssignedMembersDetails);
					SupervisorTasksDetails findSupervisorTasksDetails = supervisorTasksRepository.findSupervisorsByProjectnameAndSupervisorNameAndTaskName("Sherwood Project", "userAEmail@gmail.com", "Sub Task1");
					supervisorAppraisalsDetails.setSupervisorTasksDetails(findSupervisorTasksDetails);
					
					
					supervisorAppraisalsDetails.setDescription("fdgdjdydtf");
					Timestamp appraisedStartDate = new Timestamp(date.getTime());
					supervisorAppraisalsDetails.setAppraisedStartDate(appraisedStartDate);
				
					Timestamp appraisedEndDate = new Timestamp(date.getTime());
					supervisorAppraisalsDetails.setAppraisedEndDate(appraisedEndDate);
					
					
					supervisorAppraisalsRepo.save(supervisorAppraisalsDetails);
				
					
					assertNotNull(supervisorAppraisalsRepo.findSupervisorAppraisalsDetails("Winnipeg Project","Sub Task1","userHEmail@gmail.com","userAEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
				assertNotNull(supervisorAppraisalsRepo.findSupervisorAppraisalsDetails("Winnipeg Project","Sub Task1","userHEmail@gmail.com","userAEmail@gmail.com"));
				  }
	
	}



