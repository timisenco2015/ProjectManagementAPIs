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
import ca.timisencotech.projectmanagementapis.controller.UserDetailsController;
import ca.timisencotech.projectmanagementapis.domain.UserDetail;
import ca.timisencotech.projectmanagementapis.service.UserDetailsService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserDetailsControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private UserDetailsService userDetailsService;
		
		@InjectMocks
		private UserDetailsController userDetailsController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(userDetailsController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			UserDetail  userDetail = new  UserDetail();
			 userDetail.setCountryPhoneCode("+1");
			 userDetail.setFirstName("Ayobami");
			 userDetail.setMiddleName("O");
			 userDetail.setLastName("Idowu");
			 userDetail.setPhoneNo("2049623755");
			 userDetail.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
			userDetail.setUserEmail("ayobami.o.idowu@gmail.com");	
			userDetail.setUserGender("Male");
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/addUser")
				      .content(asJsonString(userDetail))
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
