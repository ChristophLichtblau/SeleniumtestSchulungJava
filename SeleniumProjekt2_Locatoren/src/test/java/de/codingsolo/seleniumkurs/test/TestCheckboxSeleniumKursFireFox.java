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
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestForm1Page;
import de.codingsolo.seleniumkurs.pages.SeleniumKursWebElementePage;

public class TestCheckboxSeleniumKursFireFox {

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
	public void testCheckbox() {
		System.out.println("...Test läuft...");

		// Arrange
			// -> Navigation

		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
		loginPage.loginButtonAnklicken();

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.webElementeAnklicken();

		// Act
		
		SeleniumKursWebElementePage webElementePage = new SeleniumKursWebElementePage(driver);
		webElementePage.klickCheckbox1();
		webElementePage.klickCheckbox1();
		webElementePage.klickCheckbox2();
		webElementePage.klickCheckbox3();

		// Assert


		
		assertEquals(webElementePage.getCheckBox1().isSelected(),false);
		assertEquals(webElementePage.getCheckBox2().isSelected(), true);
		assertEquals(webElementePage.getCheckBox3().isSelected(), true);
		
		

	}

}
