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
import ca.timisencotech.projectmanagementapis.controller.ProjectGroupController;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectGroupControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private ProjectGroupService projectGroupService;
		
		@InjectMocks
		private ProjectGroupController projectGroupController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(projectGroupController).build();
		}

		
		@Test
		public void testAddProjectGroupTest() throws Exception
		{
			Date date= new Date();
			
			ProjectGroup projectGroup = new  ProjectGroup();
			projectGroup.setCreatedBy("test@gmail.com");
			
			Timestamp createdDate = new Timestamp(date.getTime());
			projectGroup.setCreatedDate(createdDate);
			
			projectGroup.setDescription("sdvddvdv");
			projectGroup.setGroupName("Group A");
			projectGroup.setIsActive(true);
			projectGroup.setProjectName("Calgary Project");
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectgroup/createprojectgroup")
				      .content(asJsonString(projectGroup))
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
