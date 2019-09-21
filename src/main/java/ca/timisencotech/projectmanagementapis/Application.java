package ca.timisencotech.projectmanagementapis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration
@Configuration


@ComponentScan(basePackages={"ca.timisencotech.projectmanagementapis","ca.timisencotech.projectmanagemetapis.controller","ca.timisencotech.projectmanagemetapis.domain","ca.timisencotech.projectmanagemetapis.dto","ca.timisencotech.projectmanagemetapis.repository","ca.timisencoTech.Projectmanagemetapis.service","ca.timisencotech.Projectmanagemetapis.dao","ca.timisencotech.projectmanagemetapis.validation","ca.timisencotech.projectmanagemetapis.exception"})
@EntityScan(basePackageClasses = {
		ca.timisencotech.projectmanagementapis.dto.Countries.class,
		ca.timisencotech.projectmanagementapis.dto.StatesProvinces.class,
		ca.timisencotech.projectmanagementapis.dto.Cities.class,
		ca.timisencotech.projectmanagementapis.dto.UserLoginDetails.class,	
		ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails.class,
		ca.timisencotech.projectmanagementapis.dto.UserDetails.class,
		ca.timisencotech.projectmanagementapis.dto.ProjectDetails.class,
		ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails.class,
		ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails.class,
		ca.timisencotech.projectmanagementapis.dto.ProjectStatusDetails.class,
		ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails.class,
		ca.timisencotech.projectmanagementapis.dto.TaskDetails.class,
		ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails.class,
		ca.timisencotech.projectmanagementapis.dto.SupervisorsPrivilegesDetails.class,
		ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails.class,
		ca.timisencotech.projectmanagementapis.dto.CompaniesDetails.class,
		ca.timisencotech.projectmanagementapis.dto.TaskStatusDetails.class,
		ca.timisencotech.projectmanagementapis.dto.SelfAppraisalsDetails.class,		
		ca.timisencotech.projectmanagementapis.dto.SupervisorAppraisalsDetails.class,
		ca.timisencotech.projectmanagementapis.dto.SupervisorsMembersDetails.class
})

@EnableJpaRepositories(basePackageClasses = {
		ca.timisencotech.projectmanagementapis.repository.CountriesRepository.class,
		ca.timisencotech.projectmanagementapis.repository.StatesProvincesRepository.class,
		ca.timisencotech.projectmanagementapis.repository.CitiesRepository.class,
		ca.timisencotech.projectmanagementapis.repository.CompaniesRepository.class,
		ca.timisencotech.projectmanagementapis.repository.UserLoginRepository.class,
		ca.timisencotech.projectmanagementapis.repository.UserRepository.class,
		ca.timisencotech.projectmanagementapis.repository.ProjectRepository.class,
		ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository.class,
		ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository.class,
		ca.timisencotech.projectmanagementapis.repository.ProjectGroupRepository.class,
		ca.timisencotech.projectmanagementapis.repository.ProjectStatusRepository.class,
		ca.timisencotech.projectmanagementapis.repository.TaskStatusRepository.class,
		ca.timisencotech.projectmanagementapis.repository.ProjectGroupMemberRepo.class,
		ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepository.class,
		ca.timisencotech.projectmanagementapis.repository.SupervisorAppraisalsRepository.class,
		ca.timisencotech.projectmanagementapis.repository.SelfAppraisalsRepository.class,
		ca.timisencotech.projectmanagementapis.repository.SupervisorsMembersRepository.class,
		ca.timisencotech.projectmanagementapis.repository.SupervisorsPrivilegesRepository.class,
		ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepository.class,
		ca.timisencotech.projectmanagementapis.repository.TaskRepository.class})

public class Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
    public static Logger getLogger() {

		return logger;
		
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
