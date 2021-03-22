package hu.webuni.hr.kaev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kaev.configuration.HrConfigProperties;
import hu.webuni.hr.kaev.model.Employee;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Autowired
	HrConfigProperties config;
	
	@Override
	public int getPayRaisePercent(Employee employee) {
		
		return config.getRaise().getDflt().getPercent();
		
	}

}
