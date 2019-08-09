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
import ca.timisencotech.projectmanagementapis.controller.ProjectGroupDetailsController;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupDetailsService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectGroupDetailsControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private ProjectGroupDetailsService projectGroupDetailsService;
		
		@InjectMocks
		private ProjectGroupDetailsController projectGroupDetailsController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(projectGroupDetailsController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			Date date= new Date();
			
			ProjectGroupDetail projectGroupDetail = new  ProjectGroupDetail();
			projectGroupDetail.setCreatedBy("test@gmail.com");
			
			Timestamp createdDate = new Timestamp(date.getTime());
			projectGroupDetail.setCreatedDate(createdDate);
			
			projectGroupDetail.setDescription("sdvddvdv");
			projectGroupDetail.setGroupName("Group A");
			projectGroupDetail.setIsActive(true);
			projectGroupDetail.setProjectName("Calgary Project");
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/createProjectGroup")
				      .content(asJsonString(projectGroupDetail))
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
