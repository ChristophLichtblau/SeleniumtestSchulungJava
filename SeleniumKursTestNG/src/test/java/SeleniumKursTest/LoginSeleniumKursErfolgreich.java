package SeleniumKursTest;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import SeleniumKursPages.SeleniumKursHomePage;
import SeleniumKursPages.SeleniumKursLoginPage;


import org.testng.annotations.BeforeMethod;

import java.net.URL;


import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class LoginSeleniumKursErfolgreich {
	
	private static final Logger logger = LogManager.getLogger(LoginSeleniumKursErfolgreich.class.getName());
	
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void testLogin(String benutzername, String passwort, String assertTest) {
	  logger.info("Starte TEst für erfolgreichen Login");
	  
	  // Arrange
	  
	  SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
	  loginPage.zugangsdatenEingeben(benutzername, passwort);
	  
	  
	  // Act
	  
	  loginPage.loginButtonAnklicken();
	  
	  // Assert
	  
	  SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
	  String statusmeldung = homePage.statusMeldungAuslesen();
	  assertTrue(statusmeldung.contains(assertTest));
  }
  
  @Parameters("BROWSER")
  @BeforeMethod
  public void beforeMethod(String browser) throws Exception{
	  logger.info("Initialisiere WebDriver");
	  
	  URL linkHub = new URL("http://localhost:4444/wd/hub");
	  FirefoxOptions options = new FirefoxOptions();
	  driver = new RemoteWebDriver(linkHub, options);
	  
	  
	  
	
	driver.get("https://seleniumkurs.codingsolo.de");
	  driver.manage().window().maximize();
	 
	  
  }

  @AfterMethod
  public void afterMethod() {
	  logger.info("Schließe Driver. Test abgeschlossen");
	  driver.close();
	  
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	{"selenium42","R5vxI0j60", "Willkommen"},
    	{"selenium42","R5vxI0j60", "Willkommen"},
    	{"selenium42","R5vxI0j60", "Willkommen"}
    };
  }
}
