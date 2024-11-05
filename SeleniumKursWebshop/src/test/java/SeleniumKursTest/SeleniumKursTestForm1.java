package SeleniumKursTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumKursPages.SeleniumKursHomePage;
import SeleniumKursPages.SeleniumKursLoginPage;
import SeleniumKursPages.SeleniumKursTestApplikationPage;
import SeleniumKursPages.SeleniumKursTestForm1Page;
import christophlichtblau.SeleniumKurs.configuration.Config;
import christophlichtblau.SeleniumKurs.configuration.DriverHelper;

public class SeleniumKursTestForm1 {
	@Test (dataProvider ="Data-Provider") 
	public void ftestForm1(Object [] params) {

		String browsername = (String) params[1];
		String username = (String) params[2];
		String password = (String) params[3];
		String betreff = (String) params[4];
		String name = (String) params[5];
		String kursTitel = (String) params[6];
		int[] firmenbox1 = (int[]) params[7];
		int[] firmenbox2 = (int[]) params[8];
		String assert1 = (String) params[9];
		String assert2 = (String) params[10];
		String testName = (String) params[0];
		
		System.out.println("Initialisiere Webdriver!");
		//System.setProperty(Config.getBrowserName(browsername), Config.getDriverPfad(browserdriver));
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Config.getBaseURL());
		
System.out.println("...Test " + testName + " läuft...");
		
		// Arrange
			// -> Navigation zum Formular
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben(username, password);
		loginPage.loginButtonAnklicken();

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
		
		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.seleniumTestForm1Anklicken();
		
		// Act
		// -> Erstellen der Form1 Seite
		SeleniumKursTestForm1Page form1Page = new SeleniumKursTestForm1Page(driver);
		form1Page.eingabeBetreff(betreff);
		form1Page.eingabeName(name);
		form1Page.kursAUswaehlen(kursTitel);
		form1Page.selectFirmaBoxLinks(firmenbox1);
		form1Page.firmenInRechteBoxUebernehmen();
		form1Page.selectFirmaBoxRechts(firmenbox2);
		form1Page.elementNachObenSchieben();
		form1Page.firmenSpeichern();
	
		//Assert
		
		String erfolgsmeldung = form1Page.statusmeldungAuslesen();
		assertTrue(erfolgsmeldung.contains(assert1));
		assertEquals(assert2, form1Page.erstesListenelementAuslesen());

		System.out.println("Schließe Driver!");
		driver.close();
		
	}

	@DataProvider(name = "Data-Provider", parallel = true)
	public Object[][] testProvider() {
		return new Object[][] {
				{ "Test Form 1 Test 1 Firefox", "firefox", "selenium42", "R5vxI0j60", "Parametrisierter Test 1",
						"Christoph Lichtblau", "Java Grundlagen Kurs mit Dieter", new int[] { 3, 5, 9 },
						new int[] { 1 }, "Java Grundlagen Kurs", "Sony" },
				{ "Test Form 1 Test 2 Chrome", "chrome", "selenium42", "R5vxI0j60", "Parametrisierter Test 2",
						"Maks Schnaks", "Python Grundlagen Kurs mit Dieter", new int[] { 3, 5, 9, 8 }, new int[] { 1 },
						"Python Grundlagen Kurs", "Sony" },
				{ "Test Form 1 Test 3 Edge", "edge", "selenium42", "R5vxI0j60", "Parametrisierter Test 2",
						"Maks Schnaks", "Python Grundlagen Kurs mit Dieter", new int[] { 3, 5, 9, 8 }, new int[] { 1 },
						"Python Grundlagen Kurs", "Sony" } };

	}
}
