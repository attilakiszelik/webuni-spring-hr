package hu.webuni.hr.kaev.web;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hu.webuni.hr.kaev.model.Employee;

@Controller
public class EmployeeThymeLeafController {
	
	private List<Employee> allEmployees= new ArrayList<>();
	
	{
		allEmployees.add(new Employee(100000L,"Ötlet Gazda", "managing director",2000000, LocalDate.of(2000, Month.JANUARY, 1)));
		allEmployees.add(new Employee(100001L,"Kigug Liza", "senior software engineer",1200000, LocalDate.of(2008, Month.JANUARY, 1)));
		allEmployees.add(new Employee(100002L,"Csakmó Kolgat", "software engineer",800000, LocalDate.of(2015, Month.JANUARY, 1)));
		allEmployees.add(new Employee(100003L,"Tesztel Geti", "test engineer",600000, LocalDate.of(2018, Month.SEPTEMBER, 28)));
		allEmployees.add(new Employee(100004L,"Jóáron Eladja", "sales manager",750000, LocalDate.of(2018, Month.SEPTEMBER, 29)));
	}
	
	@GetMapping("/employees")
	public String Employees(Map<String, Object> model){
		model.put("employees", allEmployees);
		model.put("newEmployee", new Employee());
		return "employees";
	}
	
	@PostMapping("/employees")
	public String addEmployee(Employee employee){
		allEmployees.add(employee);
		return "redirect:employees"; 
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable long id){
		
		for (Iterator<Employee> iterator = allEmployees.iterator(); iterator.hasNext();) {
			Employee employee = iterator.next();
			if(employee.getId() == id) {
				iterator.remove();
				break;
			}
		}
		
		return "redirect:/employees"; 
	}
	
	@GetMapping("/employees/{id}")
	public String selectEmployee(@PathVariable long id, Map<String, Object> model){
		
		Employee selectedEmployee = null;
		
		for (Iterator<Employee> iterator = allEmployees.iterator(); iterator.hasNext();) {
			Employee employee = iterator.next();
			if(employee.getId() == id) {
				selectedEmployee = employee;
				break;
			}
		}
		
		model.put("employee", selectedEmployee);
		return "employee"; 
	}
	
	@PostMapping("/modifyEmployee")
	public String modifyEmployee(Employee employee){	
		
		for (int i = 0; i < allEmployees.size(); i++) {
			
			System.out.println(allEmployees.get(i).getId() + "," + employee.getId());
			
			if(allEmployees.get(i).getId() == employee.getId()) {
				System.out.println(allEmployees.get(i).getId() + "=" + employee.getId());
				allEmployees.set(i, employee);
				break;
			}
			
		}
		
		return "redirect:employees"; 
	}
	
}
