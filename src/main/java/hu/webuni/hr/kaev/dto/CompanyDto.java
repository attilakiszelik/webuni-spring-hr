package hu.webuni.hr.kaev.dto;

import java.util.List;

public class CompanyDto {

	private Long id;
	private String regnum;
	private String name;
	private String address;
	private List<EmployeeDto> employees;
	
	//constructors
	public CompanyDto() {
	}

	public CompanyDto(Long id, String regnum, String name, String address, List<EmployeeDto> employees) {
		this.id = id;
		this.regnum = regnum;
		this.name = name;
		this.address = address;
		this.employees = employees;
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}

	
}
