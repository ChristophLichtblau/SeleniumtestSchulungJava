package christophlichtblau.SeleniumKurs.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;

public class NewTest2 {
	
	
	
	
	@Test (priority = 2, groups = {"daily"})
  public void g1() {
		System.out.println("Starte Testfall g1..");
  }
  @Test (priority = 3, groups = {"gitlabrunner"})
  public void g2() {
	  System.out.println("Starte Testfall g2..");
  }
  @Test (priority = 1, groups = {"weekly"})
  public void g3() {
	  System.out.println("Starte Testfall g3..");
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  
  @AfterSuite
  public void aSuite() {
	  System.out.println("After Suite (im Testfall deklariert)");
  }
  

}
