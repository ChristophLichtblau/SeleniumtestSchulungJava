package Tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import Pages.SeleniumKursHomePage;
import Pages.SeleniumKursLoginPage;
import Pages.SeleniumKursTestApplikationPage;
import Pages.SeleniumKursTestForm3Page;
import conf.DriverHelper;

@RunWith(Parameterized.class)
public class TestTestform3ApachePOI {

	WebDriver driver;

	String testName;
	String browsername;
	String username;
	String password;
	String bezeichnung;
	String kennNR;
	String anschrift;
	String telefon;
	String strasse1;
	String plz1;
	String ort1;
	String arbeitsverhaeltnis;
	String nachname;
	String vorname;
	String geburtsdatum;
	String telefon2;
	String strasse2;
	String plz2;
	String ort2;
	String assert_txt_status;
	String assert_txt_erstesElement;

	public TestTestform3ApachePOI(String testName, String browsername, String username, String password,
			String bezeichnung, String kennNR, String anschrift, String telefon, String strasse1, String plz1,
			String ort1, String arbeitsverhaeltnis, String nachname, String vorname, String geburtsdatum,
			String telefon2, String strasse2, String plz2, String ort2, String assert_txt_status,
			String assert_txt_erstesElement) {
		this.testName = testName;
		this.browsername = browsername;
		this.username = username;
		this.password = password;
		this.bezeichnung = bezeichnung;
		this.kennNR = kennNR;
		this.anschrift = anschrift;
		this.telefon = telefon;
		this.strasse1 = strasse1;
		this.plz1 = plz1;
		this.ort1 = ort1;
		this.arbeitsverhaeltnis = arbeitsverhaeltnis;
		this.nachname = nachname;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.telefon2 = telefon2;
		this.strasse2 = strasse2;
		this.plz2 = plz2;
		this.ort2 = ort2;
		this.assert_txt_status = assert_txt_status;
		this.assert_txt_erstesElement = assert_txt_erstesElement;
	}

	@Before
	public void setUp() {
		System.out.println("Initialisiere WebDriver für " + testName + " ...");
		driver = DriverHelper.getDriver(browsername);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(conf.Config.getBaseURL());
	}

	@After
	public void tearDown() {
		System.out.println("... " + testName + " beendet. Driver wird geschlossen");
		driver.close();
	}

	@Test
	public void testTestform3() {
		System.out.println("...Test für " + testName + " startet...");

		// Arrange

		// -> Navigation zum Formular
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben(username, password);
		loginPage.loginButtonAnklicken();

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.testForm3Anklicken();

		SeleniumKursTestForm3Page testform3Page = new SeleniumKursTestForm3Page(driver);
		// Act

		testform3Page.inputBezeichnung(bezeichnung);
		testform3Page.inputKennNR(kennNR);
		testform3Page.inputAnschrift(anschrift);
		testform3Page.inputTelefon(telefon);
		testform3Page.inputStrasse1(strasse1);
		testform3Page.inputPLZ1(plz1);
		testform3Page.inputOrt1(ort1);
		testform3Page.selectArbeitsverhaeltnis(arbeitsverhaeltnis);
		testform3Page.inputNachname(nachname);
		testform3Page.inputVorname(vorname);
		testform3Page.inputGeburtstdatum(geburtsdatum);
		testform3Page.inputTelefon2(telefon2);
		testform3Page.inputStrasse2(strasse2);
		testform3Page.inputPLZ2(plz2);
		testform3Page.inputOrt2(ort2);
		testform3Page.btnSpeichernAnklicken();

		// Assert

		assertTrue(testform3Page.txt_statusAuslesen().contains(assert_txt_status));
		assertTrue(testform3Page.txt_erstesElementAuslesen().contains(assert_txt_erstesElement));
	}

	@Parameterized.Parameters
	public static Collection<Object[]> provideTestDate() throws Exception {
		Collection<Object[]> collection;

		Object[][] daten = {

				/*
				 * { "testTestform3 Firefox Test 1", "firefox", "selenium42", "R5vxI0j60",
				 * "Formular 43", "33454", "Krankenkasse XY", "0178/5566477",
				 * "Nackichgasse 666", "02589", "Nudefelde", "Selbststaendiger", "Nohr",
				 * "Maksimal", "06.06.1966", "0176/66666666", "Willemsplatz 66", "02299",
				 * "Glitz", "Danke", "Formular 43" },
				 * 
				 * { "testTestform3 Edge Test 1", "edge", "selenium42", "R5vxI0j60",
				 * "Formular 43", "33454", "Krankenkasse XY", "0178/5566477",
				 * "Nackichgasse 666", "02589", "Nudefelde", "Selbststaendiger", "Nohr",
				 * "Maksimal", "06.06.1966", "0176/66666666", "Willemsplatz 66", "02299",
				 * "Glitz", "Danke", "Formular 43" },
				 * 
				 * { "testTestform3 Chrome Test 1", "chrome", "selenium42", "R5vxI0j60",
				 * "Formular 43", "33454", "Krankenkasse XY", "0178/5566477",
				 * "Nackichgasse 666", "02589", "Nudefelde", "Selbststaendiger", "Nohr",
				 * "Maksimal", "06.06.1966", "0176/66666666", "Willemsplatz 66", "02299",
				 * "Glitz", "Danke", "Formular 43" },
				 * 
				 * { "testTestform3 Firefox Test 2", "firefox", "selenium42", "R5vxI0j60",
				 * "Formular 43", "33454", "Krankenkasse XY", "0178/5566477",
				 * "Nackichgasse 666", "02589", "Nudefelde", "Arbeitnehmer", "Nohr", "Maksimal",
				 * "06.06.1966", "0176/66666666", "Willemsplatz 66", "02299", "Glitz", "Danke",
				 * "Formular 43" },
				 * 
				 * { "testTestform3 Edge Test 2", "edge", "selenium42", "R5vxI0j60",
				 * "Formular 43", "33454", "Krankenkasse XY", "0178/5566477",
				 * "Nackichgasse 666", "02589", "Nudefelde", "Arbeitnehmer", "Nohr", "Maksimal",
				 * "06.06.1966", "0176/66666666", "Willemsplatz 66", "02299", "Glitz", "Danke",
				 * "Formular 43" },
				 * 
				 * { "testTestform3 Chrome Test 2", "chrome", "selenium42", "R5vxI0j60",
				 * "Formular 43", "33454", "Krankenkasse XY", "0178/5566477",
				 * "Nackichgasse 666", "02589", "Nudefelde", "Arbeitnehmer", "Nohr", "Maksimal",
				 * "06.06.1966", "0176/66666666", "Willemsplatz 66", "02299", "Glitz", "Danke",
				 * "Formular 43" },
				 */
		};

		// List<Object[]> listObjects = Arrays.asList(daten);
		ApachePOI excelReader = new ApachePOI();

		List<Object[]> listObjects = excelReader.getExcelData("./TestCaseTestform3.xlsx");
		collection = new ArrayList<Object[]>(listObjects);

		return collection;
	}

}
