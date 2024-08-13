package automationFramework;

import org.testng.annotations.Test;

public class Testcase_Grouping {
	@Test(groups= {"Car"})
	  public void Car1() {
	    System.out.println("Batch CAR - Test car 1");
	  }
	@Test(groups= {"Car"})
	  public void Car2() {
	    System.out.println("Batch CAR - Test car 2");
	  }
	@Test(groups= {"Scooter"})
	  public void Scooter1() {
	    System.out.println("Batch Scooter - Test scooter 1");
	  }
	@Test(groups= {"Car"})
	  public void Scooter2() {
	    System.out.println("Batch Scooter - Test scooter 2");
	  }
	
	@Test(groups= {"Car","Sedan Car"})
	  public void Sedan1() {
	    System.out.println("Batch Sedan CAR - Test sedan 1");
	  }		
}
