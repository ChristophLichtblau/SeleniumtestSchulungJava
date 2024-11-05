package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursIFramePage {


	private WebDriver driver;

	@FindBy(id = "name")
	private WebElement alertBeispielInputName;

	@FindBy(id = "alertbtn")
	private WebElement alertBeipsielAlertButton;

	@FindBy(id = "confirmbtn")
	private WebElement alertBeispielConfirmButton;

	public SeleniumKursIFramePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void wechsleZuIframe() {
		this.driver.switchTo().frame("iframe");
	}

	public void alertBeispielEingabeName(String name) {
		this.alertBeispielInputName.sendKeys(name);
	}

	public void alertBeispielDrueckeAlertButton() {
		this.alertBeipsielAlertButton.click();
	}

	public String alertBeispielAlertTextAuslesen() {
		return driver.switchTo().alert().getText();
	}

	public void alertBeispielDrückeOKButtonBeiAlert() {
		driver.switchTo().alert().accept();
	}

}
