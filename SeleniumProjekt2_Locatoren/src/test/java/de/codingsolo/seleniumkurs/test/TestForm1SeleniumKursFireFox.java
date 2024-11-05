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
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestForm1Page;

public class TestForm1SeleniumKursFireFox {
	
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
		//driver.close();
		
	}

	@Test
	public void testForm1() {
		System.out.println("...Test läuft...");
		
		// Arrange
			// -> Navigation zum Formular
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
		loginPage.loginButtonAnklicken();

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
		
		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.seleniumTestForm1Anklicken();
		
		// Act
		// -> Erstellen der Form1 Seite
		SeleniumKursTestForm1Page form1Page = new SeleniumKursTestForm1Page(driver);
		form1Page.eingabeBetreff("Manueller Test");
		form1Page.eingabeName("Christoph Lichtblau");
		form1Page.kursAUswaehlen("Java Grundlagen Kurs mit Dieter");
		int[] auswahlFirmenLinks = {3,5,9};
		form1Page.selectFirmaBoxLinks(auswahlFirmenLinks);
		form1Page.firmenInRechteBoxUebernehmen();
		int[] auswahlFirmenRechts = {1};
		form1Page.selectFirmaBoxRechts(auswahlFirmenRechts);
		form1Page.elementNachObenSchieben();
		form1Page.firmenSpeichern();
	
		//Assert
		
		String erfolgsmeldung = form1Page.statusmeldungAuslesen();
		assertTrue(erfolgsmeldung.contains("Java Grundlagen Kurs"));
		assertEquals("Sony", form1Page.erstesListenelementAuslesen());
		
	}

}
