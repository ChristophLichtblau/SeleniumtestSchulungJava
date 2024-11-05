import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class TestaufrufCodingSoloEdge {
	
	WebDriver driver;
	
	@Before
	public void initTests() {
			System.out.println("initialisiere Webdriver");
			System.setProperty("webdriver.msedge.driver","./drivers/msedge.driver.exe");
			driver = new EdgeDriver();
			driver .get("https://codingsolo.de");
			
	}
	
	@After
	public void afterTest() {
		System.out.println("Driver wird gechlossen");
		driver.quit();
	}

	@Test
	public void testTitleRight() {
		System.out.println("Starte Test vergleiche Titel");
		String expect = "coding freelancer - Coding Solo";
		assertEquals(expect, driver.getTitle());
	}
	
	
	/*
	@Test
	public void testTitleWrong() {
		System.out.println("Starte Test vergleiche Titel");
		String expect = "coding blog - Coding solo | proframmierblog | tutorials | Videos";
		assertEquals(expect, driver.getTitle());
	}*/
	

}
