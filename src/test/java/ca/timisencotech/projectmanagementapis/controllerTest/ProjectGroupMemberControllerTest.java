package ca.timisencotech.projectmanagementapis.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import ca.timisencotech.projectmanagementapis.controller.ProjectGroupMemberController;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupMemberService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectGroupMemberControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		ProjectGroupMemberService projectGroupMemberService;
		
		@InjectMocks
		private ProjectGroupMemberController projectGroupMemberController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(projectGroupMemberController).build();
		}

		
		@Test
		public void testAddMemberToProjectGroup() throws Exception
		{
			
			ProjectGroupMembers projectGroupMembers = new ProjectGroupMembers();
			
			projectGroupMembers.setIsActive(true);
			projectGroupMembers.setGroupName("group1");
			projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
			projectGroupMembers.setMemberName("userHEmail@gmail.com");
			projectGroupMembers.setProjectName("Sherwood Project");
			
			
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectgroupmember/addmembertoprojectgroup")
				      .content(asJsonString(projectGroupMembers))
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
