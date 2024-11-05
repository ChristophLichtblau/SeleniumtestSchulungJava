package christophlichtblau.SeleniumKurs.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest2 {

	@Parameters({"URL"})
	@Test
	public void driverSetup2(String url) {
		System.out.println("Setting up URL");
		// TODO
		
		System.out.println(url);
	}
	
}
