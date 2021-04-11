package hu.webuni.hr.kaev.web;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.kaev.dto.EmployeeDto;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private Map<Long, EmployeeDto> employees = new HashMap<>();
	
	{
		employees.put(100000L, new EmployeeDto(100000L,"Ötlet Gazda", "managing director",2000000, LocalDate.of(2000, Month.JANUARY, 1)));
		employees.put(100001L, new EmployeeDto(100001L,"Kigug Liza", "senior software engineer",1200000, LocalDate.of(2008, Month.JANUARY, 1)));
		employees.put(100002L, new EmployeeDto(100002L,"Csakmó Kolgat", "software engineer",800000, LocalDate.of(2015, Month.JANUARY, 1)));
		employees.put(100003L, new EmployeeDto(100003L,"Tesztel Geti", "test engineer",600000, LocalDate.of(2018, Month.SEPTEMBER, 28)));
		employees.put(100004L, new EmployeeDto(100004L,"Jóáron Eladja", "sales manager",750000, LocalDate.of(2018, Month.SEPTEMBER, 29)));
	}
	
	@GetMapping
	public List<EmployeeDto> getEmployees (@RequestParam(required=false) Integer salary){
		
		if(salary != null) {
			
			List<EmployeeDto> employeesWithGreaterSalary = employees.values()
					.stream()
					.filter(e -> e.getSalary() > salary)
					.collect(Collectors.toList());
					
			return employeesWithGreaterSalary;
			
		}
		
		return new ArrayList<>(employees.values());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id){
		
		EmployeeDto employeeDto = employees.get(id);
		
		if(employeeDto != null)
			return ResponseEntity.ok(employeeDto);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public EmployeeDto addNewEmployee(@RequestBody EmployeeDto employeeDto) {
		
		employees.put(employeeDto.getId(), employeeDto);
		
		return employeeDto;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto){
		
		if(!employees.containsKey(id)) return ResponseEntity.notFound().build();
		
		employeeDto.setId(id);
		employees.put(id, employeeDto);
		return ResponseEntity.ok(employeeDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		
		employees.remove(id);
		
	}

}
