package christophlichtblau.SeleniumKurs.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	@BeforeGroups("gitlabrunner")
	public void setup() {
		System.out.println("Before Group Gitlabrunner");
	}
  @Test (groups = {"gitlabrunner","daily"})
  public void f1() {
	  System.out.println("Starte Testfall f1..");
  }
  @Test (enabled = false, groups = {"weekly"})
  public void f2() {
	  System.out.println("Starte Testfall f2..");
  }
  @Test (groups = {"daily"})
  public void f3() {
	  System.out.println("Starte Testfall f3..");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
