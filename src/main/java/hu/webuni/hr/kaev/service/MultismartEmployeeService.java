package hu.webuni.hr.kaev.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
//import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kaev.configuration.HrConfigProperties;
import hu.webuni.hr.kaev.configuration.HrConfigProperties.Level;
import hu.webuni.hr.kaev.model.Employee;

@Service
public class MultismartEmployeeService implements EmployeeService {

	private LocalDate now = LocalDate.now();
	private int percent = 0;

	public void setPercent(int percent) {
		this.percent = percent;
	}

	@Autowired
	HrConfigProperties config;
	
	@Override
	public int getPayRaisePercent(Employee employee) {

		setPercent(0);
		
	    LocalDate joindate = employee.getJoindate();
	    Period period = Period.between(now, joindate);
	    double years = Math.abs(period.getYears());
	    
	    Map<String, Level> map = config.getRaise().getMltsmrt().getLevels();

		/* forEach:	  
	    for (Entry<String, Level> entry : map.entrySet()) {
			
	    	Level level = entry.getValue();
	    	
	    	if (years > level.getYear()) {
	    		
	    		if( percent < level.getPercent() ) {
	    			
	    			percent = (int)level.getPercent();
	    			
	    		}
	    	}
		}
		*/	    
	    
	    /* stream: */
	    map.entrySet()
	    .stream()
	    .sorted(Map.Entry.<String, Level>comparingByKey())
	    .forEach(entry -> {
	    		if (entry.getValue().getYear() <= years) {
	    			setPercent((int) entry.getValue().getPercent());
	    		};
	    		});
	    
	    return percent;
	    
	}

}