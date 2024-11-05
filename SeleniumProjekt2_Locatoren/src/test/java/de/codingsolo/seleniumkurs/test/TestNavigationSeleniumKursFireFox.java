package de.codingsolo.seleniumkurs.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestForm1Page;

public class TestNavigationSeleniumKursFireFox {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver!");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
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
	}

}
