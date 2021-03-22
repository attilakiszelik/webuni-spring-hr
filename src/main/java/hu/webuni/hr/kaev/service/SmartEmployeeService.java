package hu.webuni.hr.kaev.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kaev.configuration.HrConfigProperties;
import hu.webuni.hr.kaev.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService {

	private LocalDate now = LocalDate.now();
	
	@Autowired
	HrConfigProperties config;
	
	@Override
	public int getPayRaisePercent(Employee employee) {

	    LocalDate joindate = employee.getJoindate();
	    Period period = Period.between(now, joindate);
	    double years = Math.abs(period.getYears());
		
		if (years >= config.getRaise().getSmrt().getCriteria3()) return config.getRaise().getSmrt().getPercent3();
		if (years >= config.getRaise().getSmrt().getCriteria2()) return config.getRaise().getSmrt().getPercent2();
		if (years >= config.getRaise().getSmrt().getCriteria1()) return config.getRaise().getSmrt().getPercent1();
		
		return 0;
		
	}

}
