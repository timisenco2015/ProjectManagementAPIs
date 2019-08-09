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
import ca.timisencotech.projectmanagementapis.controller.ProjectSupervisorsDetailsController;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisorsDetail;
import ca.timisencotech.projectmanagementapis.service.ProjectSupervisorsDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectSupervisorsDetailsControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private ProjectSupervisorsDetailsService projectSupervisorsDetailsService;
		
		@InjectMocks
		private ProjectSupervisorsDetailsController projectSupervisorsDetailsController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(projectSupervisorsDetailsController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			ProjectSupervisorsDetail projectSupervisorsDetail = new  ProjectSupervisorsDetail();
			
			
			projectSupervisorsDetail.setIsActive(true);
			projectSupervisorsDetail.setProjectName("Sherwoord Project");
			projectSupervisorsDetail.setSupervisorName("Test2@gmail.com");
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/updateProjectStatus")
				      .content(asJsonString(projectSupervisorsDetail))
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
