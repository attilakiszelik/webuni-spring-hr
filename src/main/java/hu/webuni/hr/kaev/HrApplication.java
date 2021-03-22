package hu.webuni.hr.kaev;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.kaev.model.Employee;
import hu.webuni.hr.kaev.service.SalaryService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner{
	
	@Autowired
	SalaryService salaryService;
	
	private Employee employee1 = new Employee((long) 100001,"Kigug Liza", "senior software engineer",1200000,LocalDate.of(2005, Month.JANUARY, 1));
	private Employee employee2 = new Employee((long) 100002,"Csakmó Kolgat", "software engineer",800000,LocalDate.of(2015, Month.JANUARY, 1));
	private Employee employee3 = new Employee((long) 100003,"Tesztel Geti", "test engineer",600000,LocalDate.of(2018, Month.JANUARY, 1));
	private Employee employee4 = new Employee((long) 100004,"Jóáron Eladja", "sales manager",750000,LocalDate.of(2021, Month.JANUARY, 1));

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*		
		//test DefaultEmployeeService
		System.out.println("1.200.000 + 5% = 1.260.000 -> " + salaryService.getNewSalary(employee1));
		System.out.println("800.000 + 5% = 840.000 -> " + salaryService.getNewSalary(employee2));
		System.out.println("600.000 + 5% = 630.000 -> " + salaryService.getNewSalary(employee3));
		System.out.println("750.000 + 5% = 787.500 -> " + salaryService.getNewSalary(employee4));
*/		
		//test SmartEmployeeService
		System.out.println("1.200.000 + 10% (10+ év) = 1.320.000 -> " + salaryService.getNewSalary(employee1));
		System.out.println("800.000 + 5% (5-10 év) = 840.000 -> " + salaryService.getNewSalary(employee2));
		System.out.println("600.000 + 2% (2-5 év) = 612.000 -> " + salaryService.getNewSalary(employee3));
		System.out.println("750.000 + 0% (0-2 év) = 750.000 -> " + salaryService.getNewSalary(employee4));
		
	}

}
