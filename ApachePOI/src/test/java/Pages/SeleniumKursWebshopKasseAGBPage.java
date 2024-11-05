package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKursWebshopKasseAGBPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	

	public SeleniumKursWebshopKasseAGBPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css ="div > select")
	private WebElement selectLandAuswaehlen;
	
	@FindBy (css = "input.chkAgree")
	private WebElement checkboxAGbAgree;
	
	@FindBy (css = "div.wrapperTwo > button")
	private WebElement btnWeiter;
	
	public void selectLand(String land) {
		Select select = new Select(selectLandAuswaehlen);
		select.selectByValue(land);
	}
	
	public void selectCheckboxAGB() {
		checkboxAGbAgree.click();
	}
	
	public void btnWeiterAnklicken() {
		btnWeiter.click();
	}


	
}
