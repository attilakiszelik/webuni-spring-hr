package hu.webuni.hr.kaev.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.kaev.service.EmployeeService;
import hu.webuni.hr.kaev.service.SmartEmployeeService;

@Configuration
@Profile("smart")
public class SmartEmplConfig {

	@Bean
	EmployeeService employeeService() {
		return new SmartEmployeeService();
	}
	
}
