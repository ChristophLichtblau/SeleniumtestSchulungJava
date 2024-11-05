package christophlichtblau.SeleniumKurs.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest3 {
	
	@Parameters ({"TAG"})
	@BeforeTest 
	public void setupTest(String tag) {
		System.out.println("Thread mit Tagname: " + tag);
		
	}

	@Test (dataProvider = "Data-Provider")
	public void driverSetup2(String[] params) {
		System.out.println("Setting up URL");
		for (String string : params) {
			System.out.println(string);
		}
		// TODO
	}
	@DataProvider (name = "Data-Provider")
	public Object[][] testProvider(){
		
		return new Object[][] {
			{"FireFox", "Benutzernamen", "Passwort", "https://seleniumkurs.codingsolo.de", "Anweisungen AB"},
			{"FireFox", "Benutzernamen", "Passwort", "https://seleniumkurs.codingsolo.de", "Anweisungen CD"},
			{"FireFox", "Benutzernamen", "Passwort", "https://seleniumkurs.codingsolo.de", "Anweisungen XY"}
		};
	}
	
}
