package SeleniumKursPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursLoginPage {
	
	private WebDriver driver;
	
	// Eingabefeld Benutzername
	@FindBy(css = "input.form-control[type='text']")
	private WebElement inputBenutzername;
	
	
	// Eingabefeld Passwort
	@FindBy (css = "input.form-control[type='password']")
	private WebElement inputPasswort;
	
	// Anmeldebutton für den Login
	@FindBy (css = "input.btn-primary") 
	private WebElement buttonAnmeldung;
	
	// Statusmeldung
	@FindBy (css = "div.portalMessage:nth-child(1)")
	private WebElement statusmeldung;
	
	
	
	

	public SeleniumKursLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void zugangsdatenEingeben(String benutzername, String passwort) {
		inputBenutzername.sendKeys(benutzername);
		inputPasswort.sendKeys(passwort);
	}
	
	public void loginButtonAnklicken() {
		buttonAnmeldung.click();
	}
	
	public String statusMeldungAuslesen() {
		return statusmeldung.getText();
	}
	
}
