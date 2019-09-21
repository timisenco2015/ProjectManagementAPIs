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
import ca.timisencotech.projectmanagementapis.controller.UserController;
import ca.timisencotech.projectmanagementapis.domain.User;
import ca.timisencotech.projectmanagementapis.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private UserService userService;
		
		@InjectMocks
		private UserController userController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			User  user = new  User();
			 user.setFirstName("Ayobami");
			 user.setMiddleName("O");
			 user.setLastName("Idowu");
			 user.setPhoneNo("2049623755");
			 user.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
			user.setUserEmail("ayobami.o.idowu@gmail.com");	
			user.setUserGender("Male");
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/addNewUser")
				      .content(asJsonString(user))
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
