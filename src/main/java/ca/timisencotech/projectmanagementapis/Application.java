package ca.timisencotech.projectmanagementapis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration


@ComponentScan(basePackages={"ca.timisencotech.projectmanagementapis","ca.timisencotech.projectmanagemetapis.controller","ca.timisencotech.projectmanagemetapis.domain","ca.timisencotech.projectmanagemetapis.dto","ca.timisencotech.projectmanagemetapis.repository","ca.timisencoTech.Projectmanagemetapis.service","ca.timisencotech.Projectmanagemetapis.dao","ca.timisencotech.projectmanagemetapis.validation","ca.timisencotech.projectmanagemetapis.exception"})
@EntityScan(basePackageClasses = {
		ca.timisencotech.projectmanagementapis.dto.Countries.class,
		ca.timisencotech.projectmanagementapis.dto.StatesProvinces.class,
		ca.timisencotech.projectmanagementapis.dto.Cities.class
		})

@EnableJpaRepositories(basePackageClasses = {
		ca.timisencotech.projectmanagementapis.repository.CountriesRepository.class,
		ca.timisencotech.projectmanagementapis.repository.StatesProvincesRepository.class,
		ca.timisencotech.projectmanagementapis.repository.CitiesRepository.class
		})

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
