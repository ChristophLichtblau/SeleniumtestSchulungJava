package SeleniumKursTest;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import SeleniumKursPages.SeleniumKursFluentWaitTestseite;
import SeleniumKursPages.SeleniumKursHomePage;
import SeleniumKursPages.SeleniumKursLoginPage;
import SeleniumKursPages.SeleniumKursTestApplikationPage;

public class TestFluentWaitSeleniumKursFirefox {
	
	WebDriver driver;
	

	@Before
	public void setUp() throws Exception {
		System.out.println("Lade Webdriver...");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("...Schließe Webdriver");
		driver.close();
	}

	@Test
	public void test() {
		System.out.println("...Test läuft...");
		
		// Arrange
			// -> Login + Navigation
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
		loginPage.loginButtonAnklicken();
		
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
		
		SeleniumKursTestApplikationPage applikationPage = new SeleniumKursTestApplikationPage(driver);
		applikationPage.fluentWaitTEstseiteAnklicken();
		
		SeleniumKursFluentWaitTestseite fluentWaitPage = new SeleniumKursFluentWaitTestseite(driver);
		
		
		// Act
		
		fluentWaitPage.btnStartAnklicken();
		
		// Assert
	}

}
