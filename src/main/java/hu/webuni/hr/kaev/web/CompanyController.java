package hu.webuni.hr.kaev.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

import hu.webuni.hr.kaev.dto.CompanyDto;
import hu.webuni.hr.kaev.dto.EmployeeDto;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	private Map<Long, CompanyDto> companies = new HashMap<>();
	
	{
		companies.put(100001L, new CompanyDto(100001L, "123456-01-00", "ABC company","1221 Budapest, Arany János u. 50.", new ArrayList<EmployeeDto>()));
		companies.put(100002L, new CompanyDto(100002L, "123456-02-00", "DEF company","1221 Budapest, Arany János u. 52.", new ArrayList<EmployeeDto>()));
		companies.put(100003L, new CompanyDto(100003L, "123456-03-00", "GHI company","1221 Budapest, Arany János u. 54.", new ArrayList<EmployeeDto>()));
	}
	
	@GetMapping
	public List<CompanyDto> getCompanies(@RequestParam(required=false) Boolean full){
		
		if (full != null && full) {
			
			return new ArrayList<>(companies.values());
			
		} else {
			
			return companies.values().stream().map(c -> new CompanyDto(c.getId(), c.getRegnum(), c.getName(), c.getAddress(), null))
				   .collect(Collectors.toList());
			
		}
		
	}

	@GetMapping("/{compid}")
	public ResponseEntity<CompanyDto> getCompanyById(@RequestParam(required=false) Boolean full, @PathVariable Long compid){
		
		CompanyDto CompanyDto = companies.get(compid);
		
		if(CompanyDto == null) {
			
			return ResponseEntity.notFound().build();
			
		} else {
			
			if (full != null && full) {
				
				return ResponseEntity.ok(CompanyDto);
				
			} else {
				
				return ResponseEntity.ok(new CompanyDto(CompanyDto.getId(), CompanyDto.getRegnum(), CompanyDto.getName(), CompanyDto.getAddress(), null));
		
			}
			
		}
		
	}
	
	@PostMapping
	public CompanyDto addNewCompany(@RequestBody CompanyDto CompanyDto) {
		
		companies.put(CompanyDto.getId(), CompanyDto);
		
		return CompanyDto;
		
	}
	
	@PutMapping("/{compid}")
	public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long compid, @RequestBody CompanyDto CompanyDto){
		
		if(!companies.containsKey(compid)) return ResponseEntity.notFound().build();
		
		CompanyDto.setId(compid);
		companies.put(compid, CompanyDto);
		return ResponseEntity.ok(CompanyDto);
		
	}
	
	@DeleteMapping("/{compid}")
	public void deleteCompany(@PathVariable Long compid) {
		
		companies.remove(compid);
		
	}
	
	@PostMapping("/{compid}/employee")
	public ResponseEntity<CompanyDto> addEmployeeToCompany(@PathVariable Long compid, @RequestBody EmployeeDto employee) {
		
		CompanyDto CompanyDto = companies.get(compid);
		
		if(CompanyDto == null) {
			
			return ResponseEntity.notFound().build();
			
		} else {
			
			CompanyDto.getEmployees().add(employee);
			return ResponseEntity.ok(CompanyDto);
			
		}
	}
	
	@DeleteMapping("/{compid}/employee/{emplid}")
	public ResponseEntity<CompanyDto> deleteEmployeeFromCompany(@PathVariable Long compid, @PathVariable Long emplid) {

		CompanyDto CompanyDto = companies.get(compid);
		
		if(CompanyDto == null) {
			
			return ResponseEntity.notFound().build();
			
		} else {
			
			for (Iterator<EmployeeDto> iterator = CompanyDto.getEmployees().iterator(); iterator.hasNext();) {
				EmployeeDto employee = iterator.next();
				if(employee.getId() == emplid) {
					iterator.remove();
					break;
				}
			}
			
			return ResponseEntity.ok(CompanyDto);
			
		}	
	
	}
	
	@PutMapping("/{compid}/employees")
	public ResponseEntity<CompanyDto> replaceEmployeesInCompany(@PathVariable Long compid, @RequestBody List<EmployeeDto> employees) {
		
		CompanyDto CompanyDto = companies.get(compid);
		
		if(CompanyDto == null) {
			return ResponseEntity.notFound().build();
		} else {
			
			CompanyDto.setEmployees(employees);
			
			return ResponseEntity.ok(CompanyDto);
		}
		
	}
		
}
