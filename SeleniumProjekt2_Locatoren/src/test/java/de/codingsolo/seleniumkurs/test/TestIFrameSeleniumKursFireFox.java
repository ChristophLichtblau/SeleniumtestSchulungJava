package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursIFramePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationPage;

public class TestIFrameSeleniumKursFireFox {

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
	public void testIFrame() {
		System.out.println("...Test läuft...");

		// Arrange

		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
		loginPage.loginButtonAnklicken();

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.iFrameBeipsielAnklicken();

		// Act
		
		SeleniumKursIFramePage iframePage = new SeleniumKursIFramePage(driver);
		iframePage.wechsleZuIframe();
		iframePage.alertBeispielEingabeName("Christoph Lichtblau");
		iframePage.alertBeispielDrueckeAlertButton();

		// Assert
		
		assertTrue(iframePage.alertBeispielAlertTextAuslesen().contains("42"));
		iframePage.alertBeispielDrückeOKButtonBeiAlert();
	
	}

}
