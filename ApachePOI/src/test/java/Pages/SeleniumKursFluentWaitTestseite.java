package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SeleniumKursFluentWaitTestseite {

	WebDriver driver;
	
	

	public SeleniumKursFluentWaitTestseite(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css = "div > button")
	private WebElement btnStart;
	
	@FindBy (id = "status")
	private WebElement statusMeldung;
	
	
	public void btnStartAnklicken() {
		btnStart.click();
	}
	

	
	
	
}
