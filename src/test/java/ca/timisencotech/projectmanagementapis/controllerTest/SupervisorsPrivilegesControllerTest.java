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
import ca.timisencotech.projectmanagementapis.controller.SupervisorsPrivilegesController;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsPrivileges;
import ca.timisencotech.projectmanagementapis.dto.Privileges;
import ca.timisencotech.projectmanagementapis.service.SupervisorsPrivilegesService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SupervisorsPrivilegesControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private SupervisorsPrivilegesService supervisorsPrivilegesService;
		
		@InjectMocks
		private SupervisorsPrivilegesController supervisorsPrivilegesController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(supervisorsPrivilegesController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			SupervisorsPrivileges supervisorsPrivileges = new SupervisorsPrivileges();
			Privileges privileges; 
			
			//supervisorsPrivileges.setPrivileges(privileges.);
			supervisorsPrivileges.setProjectName("Sherwood Project");
			supervisorsPrivileges.setSupervisorName("userEmail@gmail.com");
			
			
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/assignPrivilegesToSupervisor")
				      .content(asJsonString(supervisorsPrivileges))
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
