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
	
	private Employee employee0 = new Employee((long) 100000,"Ötlet Gazda", "managing director",2000000,LocalDate.of(2000, Month.JANUARY, 1));
	private Employee employee1 = new Employee((long) 100001,"Kigug Liza", "senior software engineer",1200000,LocalDate.of(2008, Month.JANUARY, 1));
	private Employee employee2 = new Employee((long) 100002,"Csakmó Kolgat", "software engineer",800000,LocalDate.of(2015, Month.JANUARY, 1));
	private Employee employee3 = new Employee((long) 100003,"Tesztel Geti", "test engineer",600000,LocalDate.of(2018, Month.SEPTEMBER, 28));
	private Employee employee4 = new Employee((long) 100004,"Jóáron Eladja", "sales manager",750000,LocalDate.of(2018, Month.SEPTEMBER, 29));

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println();
		System.out.println("test for profile: default");
		System.out.println("1.200.000 + 5% => 1.260.000 = " + salaryService.getNewSalary(employee1));
		System.out.println("800.000 + 5% => 840.000 = " + salaryService.getNewSalary(employee2));
		System.out.println("600.000 + 5% => 630.000 = " + salaryService.getNewSalary(employee3));
		System.out.println("750.000 + 5% => 787.500 = " + salaryService.getNewSalary(employee4));
		System.out.println("------------------------------------------------------------");
		
		System.out.println("test for profile: smart");
		System.out.println("1.200.000 + 10% (10+ év) => 1.320.000 = " + salaryService.getNewSalary(employee1));
		System.out.println("800.000 + 5% (5.0-9.99 év) => 840.000 = " + salaryService.getNewSalary(employee2));
		System.out.println("600.000 + 2% (2.5-4.99 év) => 612.000 = " + salaryService.getNewSalary(employee3));
		System.out.println("750.000 + 0% (0.0-2.49 év) => 750.000 = " + salaryService.getNewSalary(employee4));
		System.out.println("------------------------------------------------------------");

		System.out.println("test for profile: multismart");
		System.out.println("100.000 + 0% (0-5 év) => 100.000 = " + salaryService.getNewSalary(new Employee((long) 10000,"xy", "N/A",100000,LocalDate.of(2021, Month.JANUARY, 1))));
		System.out.println("100.000 + 5% (5-10 év) => 105.000 = " + salaryService.getNewSalary(new Employee((long) 10000,"xy", "N/A",100000,LocalDate.of(2016, Month.JANUARY, 1))));
		System.out.println("100.000 + 10% (10-15 év) => 110.000 = " + salaryService.getNewSalary(new Employee((long) 10000,"xy", "N/A",100000,LocalDate.of(2011, Month.JANUARY, 1))));
		System.out.println("100.000 + 15% (15-20 év) => 115.000 = " + salaryService.getNewSalary(new Employee((long) 10000,"xy", "N/A",100000,LocalDate.of(2006, Month.JANUARY, 1))));
		System.out.println("100.000 + 20% (20-25 év) => 120.000 = " + salaryService.getNewSalary(new Employee((long) 10000,"xy", "N/A",100000,LocalDate.of(2001, Month.JANUARY, 1))));
		System.out.println("100.000 + 25% (25+ év) => 125.000 = " + salaryService.getNewSalary(new Employee((long) 10000,"xy", "N/A",100000,LocalDate.of(1996, Month.JANUARY, 1))));
		
	}

}
