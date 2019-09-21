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
import ca.timisencotech.projectmanagementapis.controller.ProjectSupervisorsController;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;
import ca.timisencotech.projectmanagementapis.service.ProjectSupervisorsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectSupervisorsControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private ProjectSupervisorsService projectSupervisorsService;
		
		@InjectMocks
		private ProjectSupervisorsController projectSupervisorsController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(projectSupervisorsController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			ProjectSupervisors projectSupervisors = new  ProjectSupervisors();
			
			
			projectSupervisors.setIsActive(true);
			projectSupervisors.setProjectName("Sherwoord Project");
			projectSupervisors.setSupervisorName("Test2@gmail.com");
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/newProjectSupervisor")
				      .content(asJsonString(projectSupervisors))
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
