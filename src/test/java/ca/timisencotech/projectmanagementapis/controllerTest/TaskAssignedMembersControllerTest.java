package ca.timisencotech.projectmanagementapis.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import ca.timisencotech.projectmanagementapis.controller.TaskAssignedMemberController;
import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;
import ca.timisencotech.projectmanagementapis.service.TaskAssignedMembersService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskAssignedMembersControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private TaskAssignedMembersService taskAssignedMembersService;
		
		@InjectMocks
		private TaskAssignedMemberController taskAssignedMemberController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(taskAssignedMemberController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			Date date= new Date();
			Timestamp dateAssigned = new Timestamp(date.getTime());
			
			
			TaskAssignedMembers taskAssignedMembers = new TaskAssignedMembers();
			taskAssignedMembers.setActive(true);
			taskAssignedMembers.setAssignedBy("userAEmail@gmail.com");
			taskAssignedMembers.setAssignedTo("userAAAEmail@gmail.com");
			taskAssignedMembers.setDateAssigned(dateAssigned);
			taskAssignedMembers.setDescription("gfghftdrdg");
			taskAssignedMembers.setProjectName("Sherwood Project");
			taskAssignedMembers.setTaskName("Sub task1");
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/assignTaskToMember")
				      .content(asJsonString(taskAssignedMembers))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk());
				     
		
		}
		
		public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
		

}
