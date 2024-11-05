package SeleniumKursTest;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import SeleniumKursPages.SeleniumKursHomePage;
import SeleniumKursPages.SeleniumKursLoginPage;
import christophlichtblau.SeleniumKurs.configuration.Config;
import christophlichtblau.SeleniumKurs.configuration.DriverHelper;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class LoginSeleniumKursFehlschlag {
	
	private static final Logger logger = LogManager.getLogger(LoginSeleniumKursFehlschlag.class.getName());
	
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void testLogin(String benutzername, String passwort, String assertTest) {
	  logger.info("Starte Test für fehlerhaften Login");
	  
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
  public void beforeMethod(String browser) {
	  logger.info("Initialisiere WebDriver");
	  driver = DriverHelper.getDriver(browser);
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(Config.getBaseURL());
	  
  }

  @AfterMethod
  public void afterMethod() {
	  logger.info("Schließe Driver. Test abgeschlossen");
	  driver.close();
	  
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	{"selenium42","RvxI0j60", "Anmeldung fehlgeschlagen"},
    	{"selenium42","R5vx0j60", "Anmeldung fehlgeschlagen"},
    	{"selenium2","R5vxI0j60", "Anmeldung fehlgeschlagen"}
    };
  }
}
