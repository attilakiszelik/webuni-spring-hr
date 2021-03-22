package hu.webuni.hr.kaev.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.kaev.model.Employee;

@Service
public class SalaryService {

	private EmployeeService employeeService;
	
	public SalaryService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public int getNewSalary(Employee employee) {
		
		return (int)(employee.getSalary() * (100 + employeeService.getPayRaisePercent(employee))/100f);

	}
	
}
