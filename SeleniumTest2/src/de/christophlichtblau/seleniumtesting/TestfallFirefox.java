package de.christophlichtblau.seleniumtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestfallFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Info als Ausgabe, dass der test nun startet
			System.out.println("Test startet!");
		// die Art des drivers, sowie der Pfad zum driver werden angegeben
			System.setProperty("WebDriver.gecko.driver", "./drivers/geckodriver.exe");
		// der driver wird instanziiert
			WebDriver driver = new FirefoxDriver();
		// dem driver wird der Pfad zur Webseite gegeben
			driver.get("https://seleniumkurs.codingsolo.de/selenium-tests/benzinreichweiten-rechner-testseite");
		// Rückgabe des Titels der Webseite
			System.out.println(driver.getTitle());
			
	}

}
