package christophlichtblau.SeleniumKurs.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class NewTest3 {
	
	@AfterTest
	public void aTest() {
		System.out.println("After Test x....");
	}
	@BeforeTest
	public void bTest() {
		System.out.println("Gleich startet Testreihe x...");
	}
	
	@BeforeSuite
	public void bSuite() {
		System.out.println("Vor der Suite (im testfall x deklariert)");
	}
	
  @Test (groups = {"gitlabrunner"})
  public void x1() {
	  System.out.println("Starte Testfall x1..");
  }
  @Test (groups = {"daily"})
  public void x2() {
	  System.out.println("Starte Testfall x2..");
  }
  @Test (groups = {"weekly"})
  public void x3() {
	  System.out.println("Starte Testfall x3..");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

}
