package hu.webuni.hr.kaev.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.kaev.service.DefaultEmployeeService;
import hu.webuni.hr.kaev.service.EmployeeService;

@Configuration
@Profile("default")
public class DefaultEmplConfig {

	@Bean
	EmployeeService employeeService() {
		return new DefaultEmployeeService();
	}
	
}
