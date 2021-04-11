package hu.webuni.hr.kaev.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeDto {

	private Long id;
	private String name;
	private String position;
	private int salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joindate;
	
	//constructors
	public EmployeeDto() {
	
	}
	
	public EmployeeDto(Long id, String name, String position, int salary, LocalDate joindate) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.joindate = joindate;
	}
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDate getJoindate() {
		return joindate;
	}
	public void setJoindate(LocalDate joindate) {
		this.joindate = joindate;
	}
	
}
