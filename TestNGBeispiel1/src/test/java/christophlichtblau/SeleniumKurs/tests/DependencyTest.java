package christophlichtblau.SeleniumKurs.tests;

import org.testng.annotations.Test;

public class DependencyTest {

	@Test (dependsOnGroups = {"gitlabrunner"})
	public void preparedMethod1() {
		System.out.println("Preperation Done in Method 1");
	}
	@Test (dependsOnMethods = {"preparedMethod1"})
	public void preparedMethod2() {
		System.out.println("Preperation Done in Method 2");
	}
	
	@Test (dependsOnMethods = {"preparedMethod1","preparedMethod2"})
	public void methodFinal() {
		System.out.println("Start after Preparations");
	}
	
	
}
