package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursKatzenSuchePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationPage;

public class TestKatzensucheExcplizitAsyncTestSeleniumKursFireFox {

	WebDriver driver;
	
	
	@Before
	public void setUp() {
		System.out.println("Initialisiere Webdriver...");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}
	
	@After
	public void tearDown() {
		System.out.println("...Test abgeschlossen!");
		driver.close();
	}
	
	@Test
	public void testImplizitWait() {
		System.out.println("...Starte Test AJAX-Anwendung mit Impizit Wait...");
	    
		// Arrange
			// ->Navigation
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
		loginPage.loginButtonAnklicken();

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.katzensucheTestseiteAnklicken();
		
		SeleniumKursKatzenSuchePage katzenSuchePage = new SeleniumKursKatzenSuchePage(driver);
		
		String beschreibung = katzenSuchePage.getUeberschrift().getText();
		String srcLinkImgKatze1 = katzenSuchePage.getImgKatze1().getAttribute("src");
		
		// Act
		
		katzenSuchePage.buttonNextAnklicken();
		String srcLinkImgKatze2 = katzenSuchePage.srcLinkImgKatze2Auslesen();
		
		katzenSuchePage.reihenfolgeAendern("Asc");
		String srcLinkImgKatze3 = katzenSuchePage.srcLinkImgKatze3Auslesen();
	
		
		// Assert
		assertTrue(beschreibung.contains("Lieblingskatze"));
		assertTrue(srcLinkImgKatze1.contains("ECqe13G5B"));
		assertTrue(srcLinkImgKatze2.contains("Wd_Py_Mj8"));
		assertTrue(srcLinkImgKatze3.contains("6"));
		
		
		
	
	}
}
