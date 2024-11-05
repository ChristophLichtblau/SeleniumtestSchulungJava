package christophlichtblau.SeleniumKurs.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest1 {

	@Parameters({"URL"})
	@Test
	public void driverSetup1(String url) {
		System.out.println("Setting up URL");
		// TODO
		
		System.out.println(url);
	}
	
}
