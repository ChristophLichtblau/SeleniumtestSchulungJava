package SeleniumKursPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKursWebshopPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	

	public SeleniumKursWebshopPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Hier')]")
	private WebElement inputSuchleiste;
	
	@FindBy (xpath = "//tbody/tr[last()]//strong")
	private WebElement textPreis;
	
	@FindBy (xpath = "//a[@class='cart-icon']//img")
	private WebElement linkZumWarenkorbHinzufuegen;
	
	@FindBy (xpath ="//div[@class='action-block']//button")
	private WebElement btnZurKasse;
	


	public void produktsucheAusfuehren(String name) {
		inputSuchleiste.sendKeys(name);
	}
	
	public void produktanzahlAuswaehlen(String name, int anzahl) {
		WebElement btnPlus = driver.findElement(By.xpath(String.format("//h4[normalize-space()='%s']/..//*[@class='increment']", name)));
		for(int i = 1; i < anzahl; i++) {
			btnPlus.click();
		}

	}
	
	public void produktInWarenkorbLegen(String produktname) {
		
		WebElement addWarenkorb = driver.findElement(By.xpath(String.format("//h4[normalize-space()='%s']/..//*[@type='button']", produktname)));
		addWarenkorb.click();
	}
	
	public String preisWarenkorbAuslesen() {
		return textPreis.getText();
	}
	
	public void zumWarenkorbGehenAnklicken() {
		linkZumWarenkorbHinzufuegen.click();
	}
	
	public void btnZurKasseAnklicken() {
		btnZurKasse.click();
	}
}
