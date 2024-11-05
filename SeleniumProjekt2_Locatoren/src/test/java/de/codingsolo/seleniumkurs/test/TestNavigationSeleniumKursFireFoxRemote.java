package de.codingsolo.seleniumkurs.test;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestForm1Page;

public class TestNavigationSeleniumKursFireFoxRemote {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver!");
		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		//driver = new FirefoxDriver();
		
		FirefoxOptions options = new FirefoxOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
		
		/*
		 Wichtig: Man muss den Server via Eingabeaufforderung vorher starten:
		 1. Navigiere zum Pfad dedr vorher geladenen Selenium Grid Server Jar:
		 
		 		-> cd "C:\Program Files\Java"
		  
		 2. anschließend gib folgenden Befehl mit dem kompletten Namen der JAr ein:

          		-> C:\Program Files\Java>java -jar selenium-server-4.25.0.jar standalone
          		
         3. dann starte den Test
		 */
		
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Schließe Driver!");
		driver.close();
		
	}

	@Test
	public void testLogin() {
		System.out.println("...Test läuft...");
		
		
		//Arrange
		
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
		loginPage.loginButtonAnklicken();
				
		// Act
				
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
				
		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.seleniumTestForm1Anklicken();
				
		// Assert
				
		SeleniumKursTestForm1Page form1Page = new SeleniumKursTestForm1Page(driver);
	
			// -> Testet, ob "Selenium Test Form 1 in der Überschrift enthalten ist"
		assertTrue(form1Page.ueberschriftAuslesen().contains("Selenium Test Form1"));
			// -> Testet, ob Selenium Test Form1 == der Überschrift ist
		assertEquals(form1Page.ueberschriftAuslesen(), "Selenium Test Form1");
		
		System.out.println("Test beendet..............");
	}

}
