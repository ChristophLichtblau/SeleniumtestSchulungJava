package SeleniumKursTest;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;


import SeleniumKursPages.SeleniumKursHomePage;
import SeleniumKursPages.SeleniumKursLoginPage;
import SeleniumKursPages.SeleniumKursTestApplikationPage;
import SeleniumKursPages.SeleniumKursTestForm1Page;
import christophlichtblau.SeleniumKurs.configuration.Config;
import christophlichtblau.SeleniumKurs.configuration.DriverHelper;

@RunWith(Parameterized.class)
public class TestForm1ParameterizedSeleniumKursFireFox {
	
	WebDriver driver;
	
	String browsername;
	String username;
	String password;
	String betreff;
	String name;
	String kursTitel;
	int[] firmenbox1;
	int[] firmenbox2;
	String assert1;
	String assert2;
	String testName;
	
	
	

	public TestForm1ParameterizedSeleniumKursFireFox(String testName, String browsername, String username, String password, String betreff, String name,
			String kursTitel, int[] firmenbox1, int[] firmenbox2, String assert1, String assert2) {
		
		this.browsername = browsername;
		this.username = username;
		this.password = password;
		this.betreff = betreff;
		this.name = name;
		this.kursTitel = kursTitel;
		this.firmenbox1 = firmenbox1;
		this.firmenbox2 = firmenbox2;
		this.assert1 = assert1;
		this.assert2 = assert2;
		this.testName = testName;
	}
	
	

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver!");
		//System.setProperty(Config.getBrowserName(browsername), Config.getDriverPfad(browserdriver));
		//driver = new FirefoxDriver();
		driver = DriverHelper.getDriver(browsername);
		driver.manage().window().maximize();
		driver.get(Config.getBaseURL());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Schließe Driver!");
		driver.close();
		
	}

	@Test
	public void testForm1() {
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
	
	}
	
	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception{
		Collection<Object[]> collection;
		
		Object[][] daten = {
				{"Test Form 1 Test 1 Firefox" ,"firefox", "selenium42", "R5vxI0j60", "Parametrisierter Test 1", "Christoph Lichtblau", "Java Grundlagen Kurs mit Dieter",
					new int[] {3,5,9}, new int[] {1}, "Java Grundlagen Kurs", "Sony"},
				{"Test Form 1 Test 2 Chrome" , "chrome", "selenium42", "R5vxI0j60", "Parametrisierter Test 2", "Maks Schnaks", "Python Grundlagen Kurs mit Dieter",
						new int[] {3,5,9, 8}, new int[] {1}, "Python Grundlagen Kurs", "Sony"},
				{"Test Form 1 Test 3 Edge" , "edge", "selenium42", "R5vxI0j60", "Parametrisierter Test 2", "Maks Schnaks", "Python Grundlagen Kurs mit Dieter",
							new int[] {3,5,9, 8}, new int[] {1}, "Python Grundlagen Kurs", "Sony"}
		};
		
		List<Object[]> listObjects = Arrays.asList(daten);
		collection = new ArrayList<Object[]> (listObjects);
		
		return collection;
	}

}
