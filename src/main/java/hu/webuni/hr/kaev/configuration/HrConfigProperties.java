package hu.webuni.hr.kaev.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "hr")
@Component
public class HrConfigProperties {

	private Raise raise = new Raise();
	
	//getter and setter
	public Raise getRaise() {
		return raise;
	}

	public void setRaise(Raise raise) {
		this.raise = raise;
	}

	//Raise osztály
	public static class Raise {
		
		private Default dflt = new Default();
		private Smart smrt = new Smart();
		private Multismart mltsmrt = new Multismart();
		
		//getters and setters
		public Default getDflt() {
			return dflt;
		}
		public void setDflt(Default dflt) {
			this.dflt = dflt;
		}
		public Smart getSmrt() {
			return smrt;
		}
		public void setSmrt(Smart smrt) {
			this.smrt = smrt;
		}
		public Multismart getMltsmrt() {
			return mltsmrt;
		}
		public void setMltsmrt(Multismart mltsmrt) {
			this.mltsmrt = mltsmrt;
		}

	}
	
	//Default osztály
	public static class Default{
		
		private int percent;

		//getter and setter
		public int getPercent() {
			return percent;
		}

		public void setPercent(int percent) {
			this.percent = percent;
		}
		
	}
	
	//Smart osztály
	public static class Smart{
	
		private float criteria1;
		private int percent1;
		private int criteria2;
		private int percent2;
		private int criteria3;
		private int percent3;
		
		public float getCriteria1() {
			return criteria1;
		}
		public void setCriteria1(float criteria1) {
			this.criteria1 = criteria1;
		}
		public int getPercent1() {
			return percent1;
		}
		public void setPercent1(int percent1) {
			this.percent1 = percent1;
		}
		public int getCriteria2() {
			return criteria2;
		}
		public void setCriteria2(int criteria2) {
			this.criteria2 = criteria2;
		}
		public int getPercent2() {
			return percent2;
		}
		public void setPercent2(int percent2) {
			this.percent2 = percent2;
		}
		public int getCriteria3() {
			return criteria3;
		}
		public void setCriteria3(int criteria3) {
			this.criteria3 = criteria3;
		}
		public int getPercent3() {
			return percent3;
		}
		public void setPercent3(int percent3) {
			this.percent3 = percent3;
		}
	
	}
	
	//Multismart osztály
	public static class Multismart{
	
		private Map<String, Level> levels = new HashMap();

		//getter and setter
		public Map<String, Level> getLevels() {
			return levels;
		}

		public void setLevels(Map<String, Level> levels) {
			this.levels = levels;
		}
		
	}
	
	//Level osztály
	public static class Level{
		
		private float year;
		private float percent;
		
		//getters and setters
		public float getYear() {
			return year;
		}
		public void setYear(float year) {
			this.year = year;
		}
		public float getPercent() {
			return percent;
		}
		public void setPercent(float percent) {
			this.percent = percent;
		}
		
	}
	
}
