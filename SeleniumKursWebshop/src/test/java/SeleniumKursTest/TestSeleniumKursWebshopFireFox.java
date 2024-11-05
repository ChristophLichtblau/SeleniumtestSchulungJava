package SeleniumKursTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumKursPages.SeleniumKursHomePage;
import SeleniumKursPages.SeleniumKursLoginPage;
import SeleniumKursPages.SeleniumKursTestApplikationPage;
import SeleniumKursPages.SeleniumKursWebshopKasseAGBPage;
import SeleniumKursPages.SeleniumKursWebshopKassePage;
import SeleniumKursPages.SeleniumKursWebshopPage;





public class TestSeleniumKursWebshopFireFox {
	
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver...");
		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("...Test abgeschlossen");
		driver.close();
	}

	@Test
	public void test() {
		System.out.println("...Starte Test für den Webshop...");
		
		//Arrange
			// -> Login + Navigation
		
		// Navigation
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
		loginPage.loginButtonAnklicken();
		
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
		
		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.webshopTestseiteAnklicken();
		
		SeleniumKursWebshopPage webshopPage = new SeleniumKursWebshopPage(driver);
		
		//Act
		webshopPage.produktsucheAusfuehren("Brems");
		
		webshopPage.produktanzahlAuswaehlen("Bremssattel Hinten Audi", 4);
		webshopPage.produktInWarenkorbLegen("Bremssattel Hinten Audi");
		
		webshopPage.produktanzahlAuswaehlen("Bremsscheiben Set Vorne Audi", 2);
		webshopPage.produktInWarenkorbLegen("Bremsscheiben Set Vorne Audi");
		
		String preis1 = webshopPage.preisWarenkorbAuslesen();
		
		webshopPage.zumWarenkorbGehenAnklicken();
		webshopPage.btnZurKasseAnklicken();
		
		
		
		SeleniumKursWebshopKassePage webshopKassePage = new SeleniumKursWebshopKassePage(driver);
		
		webshopKassePage.couponEingeben("codingsolo");
		webshopKassePage.btnAktivierenAnklicken();
		
		String erfolgsnachrichtCoupon = webshopKassePage.textCouponAktiviertAuslesen();
		
		String gesamtpreis = webshopKassePage.gesamtpreisAuslesen();
		
		webshopKassePage.btnBestellenAnklicken();
		
		SeleniumKursWebshopKasseAGBPage agbPage = new SeleniumKursWebshopKasseAGBPage(driver);
		agbPage.selectLand("Germany");
		agbPage.selectCheckboxAGB();
		agbPage.btnWeiterAnklicken();
		
		String danke = driver.findElement(By.className("wrapperTwo")).getText();
		
		//Assert
		
		// 760.58
		assertEquals(preis1, "760.58");
		
		assertTrue(erfolgsnachrichtCoupon.contains("aktiviert"));
		
		// 684
		assertEquals(gesamtpreis, "684");
		
		
		
	}

}
