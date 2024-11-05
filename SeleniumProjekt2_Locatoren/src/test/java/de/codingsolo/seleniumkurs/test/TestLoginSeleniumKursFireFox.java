package de.codingsolo.seleniumkurs.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;

public class TestLoginSeleniumKursFireFox {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver!");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
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
		
		// Act
		loginPage.loginButtonAnklicken();
	
		
		//Assert
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		String erfolgsmeldung = homePage.statusMeldungAuslesen();
		assertTrue(erfolgsmeldung.contains("Willkommen"));
	}

}
