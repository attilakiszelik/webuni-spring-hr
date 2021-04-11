package hu.webuni.hr.kaev.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.kaev.service.EmployeeService;
import hu.webuni.hr.kaev.service.MultismartEmployeeService;

@Configuration
@Profile("multismart")
public class MultismartEmplConfig {

	@Bean
	EmployeeService employeeService() {
		return new MultismartEmployeeService();
	}
	
}