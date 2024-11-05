package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursTestApplikationPage {
	
	private WebDriver driver;
	
	// MenuButton
	@FindBy (id = "portaltab-burger-menu")
	private WebElement buttonMenu;
	
	// Link Navigation zu Selenium Test Form1
	@FindBy (linkText = "Selenium Test Form1")
	private WebElement linkSeleniumTestForm1;
	
	// Link Navigation zu Selenium Drag and Drop Beipsiel
	@FindBy (linkText = "Drag and Drop Beispiel")
	private WebElement linkDragAndDropBeispiel;
	
	// Link Navigation zu Selenium IFrame Beispiel
	@FindBy (linkText = "IFrame Beispiel")
	private WebElement linkIFrameBeispiel;
	
	// Link Navigation zu Web Elemente
	@FindBy (linkText = "Web Elemente")
	private WebElement linkWebElemente;
	
	// Link Katzensuche Testseite (AJAX)
	@FindBy (linkText = "Katzensuche Testseite (AJAX)")
	private WebElement linkKatzensucheTestseite;
	
	@FindBy (linkText = "Webshop Testseite")
	private WebElement linkWebshopTestseite;
	
	@FindBy (linkText = "Fluent Wait Testseite")
	private WebElement linkFluentWaitTestseite;
	
	@FindBy (linkText= "Testform3 DataDriven")
	private WebElement linkTestForm3;
	
	
	
	

	public SeleniumKursTestApplikationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void menuAusklappen() {
		buttonMenu.click();
	}
	
	public void seleniumTestForm1Anklicken() {
		linkSeleniumTestForm1.click();
	}
	
	public void dragANdDropAnklicken() {
		this.linkDragAndDropBeispiel.click();
	}
	
	public void iFrameBeipsielAnklicken() {
		this.linkIFrameBeispiel.click();
	}
	
	public void webElementeAnklicken() {
		this.linkWebElemente.click();
	}
	
	public void katzensucheTestseiteAnklicken() {
		this.linkKatzensucheTestseite.click();
	}
	
	public void webshopTestseiteAnklicken() {
		linkWebshopTestseite.click();
	}
	
	public void fluentWaitTEstseiteAnklicken() {
		linkFluentWaitTestseite.click();
	}
	
	public void testForm3Anklicken() {
		linkTestForm3.click();
	}

}
