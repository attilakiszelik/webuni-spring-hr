package hu.webuni.hr.kaev.model;

import java.time.LocalDate;

public class Employee {

	private Long id;
	private String name;
	private String position;
	private int salary;
	private LocalDate joindate;
	
	//constructor
	public Employee(Long id, String name, String position, int salary, LocalDate joindate) {
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
