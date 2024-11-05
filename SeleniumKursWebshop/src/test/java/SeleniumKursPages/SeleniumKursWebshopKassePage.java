package SeleniumKursPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKursWebshopKassePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	

	public SeleniumKursWebshopKassePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath ="//input[@placeholder='Coupon Eingeben']")
	private WebElement inputCouponEingeben;

	@FindBy (className = "promoBtn")
	private WebElement btnAktivieren;
	
	@FindBy (xpath = "(//button[normalize-space()='Bestellen'])[1]")
	private WebElement btnBestellen;
	
	@FindBy (className = "promoInfo")
	private WebElement infotextCouponAktiviert;
	
	@FindBy (className = "discountAmt")
	private WebElement gesamtpreis;
	
	
	
	
	public void couponEingeben(String code) {
		inputCouponEingeben.sendKeys(code);
	}
	
	public void btnAktivierenAnklicken() {
		btnAktivieren.click();
	}
	
	public void btnBestellenAnklicken() {
		btnBestellen.click();
	}
	
	public String textCouponAktiviertAuslesen() {
		wait.until(ExpectedConditions.elementToBeClickable(infotextCouponAktiviert));
		return infotextCouponAktiviert.getText();
	}
	public String gesamtpreisAuslesen() {
		return gesamtpreis.getText();
	}
	
}
