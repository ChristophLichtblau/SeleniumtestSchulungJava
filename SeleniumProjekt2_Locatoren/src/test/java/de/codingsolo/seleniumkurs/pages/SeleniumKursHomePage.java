package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursHomePage {
	
	private WebDriver driver;
	
	

	// Statusmeldung
	@FindBy (css = "div.portalMessage:nth-child(1)")
	private WebElement statusmeldung;
	
	// MenuButton
	@FindBy (id = "portaltab-burger-menu")
	private WebElement buttonMenu;
	
	// SeleniumTestapplikatuionen Link
	@FindBy (linkText = "Selenium Testapplikationen")
	private WebElement linkSideMenSeleniumTestapplikationen;
	
	public SeleniumKursHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String statusMeldungAuslesen() {
		return statusmeldung.getText();
	}
	
	public void menuAusklappen() {
		buttonMenu.click();
	}
	
	public void seleniumTestAppLinkAnklicken() {
		linkSideMenSeleniumTestapplikationen.click();
	}
}
