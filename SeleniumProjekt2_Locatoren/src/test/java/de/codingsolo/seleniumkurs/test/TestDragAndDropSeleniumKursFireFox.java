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

import de.codingsolo.seleniumkurs.pages.SeleniumKursDragAndDropPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationPage;

public class TestDragAndDropSeleniumKursFireFox {

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
	public void testDragAndDrop() {
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
		applikationPage.dragANdDropAnklicken();

		// Act
		// -> Drag and Drop

		SeleniumKursDragAndDropPage dragAndDropePage = new SeleniumKursDragAndDropPage(driver);
		dragAndDropePage.schiebeGreenLogoInBox();
		dragAndDropePage.schiebeRedLogoInBox();
		dragAndDropePage.schiebeCodingLogoInBox();

		// Assert
		// -> überprüfe die Überschrift der Box auf letztes Element das verschoben wurde

		String ueberschriftBox = dragAndDropePage.textLetztesVerschobenesElementInBox();
		assertTrue(ueberschriftBox.contains("coding-logo"));

	}

}
