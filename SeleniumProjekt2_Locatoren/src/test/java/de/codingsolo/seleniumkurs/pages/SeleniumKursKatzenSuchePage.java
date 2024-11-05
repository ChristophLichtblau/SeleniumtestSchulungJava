package de.codingsolo.seleniumkurs.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;






public class SeleniumKursKatzenSuchePage {

	WebDriver driver;
	WebDriverWait driverWait;
	
	
	
	@FindBy(css = "p.lead")
	private WebElement ueberschrift;
	
	@FindBy (id = "ECqe13G5B")
	private WebElement imgKatze1;
	
	@FindBy (linkText = "Next")
	private WebElement buttonNext;
	
	@FindBy (linkText = "Previous")
	private WebElement buttonPrevious;
	
	@FindBy (id = "anzahlSelect")
	private WebElement selectAnzahl;
	
	@FindBy (id = "tJbzb7FKo")
	private WebElement bildLinksOben;
	
	@FindBy (id = "sortSelect")
	private WebElement selectReihenfolgeSortierung;
	
	@FindBy (id = "Wd_Py_Mj8")
	private WebElement imgKatze2;
	
	@FindBy (id = "h6")
	private WebElement imgKatze3;


	

	public SeleniumKursKatzenSuchePage(WebDriver driver) {
		this.driver = driver;
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUeberschrift() {
		return ueberschrift;
	}
	
	public WebElement getBildLinksOben() {
		return bildLinksOben;
	}
	
	public WebElement imgKatze2() {
		return imgKatze2;
	}
	
	public WebElement imgKatze3() {
		return imgKatze3;
	}
	
	public WebElement getImgKatze1() {
		return imgKatze1;
	}

	public String srcLinkImgKatze1Auslesen() {
		return imgKatze1.getAttribute("src");
	}
	
	public String srcLinkImgKatze2Auslesen() {
		return imgKatze2.getAttribute("src");
	}
	
	public String srcLinkImgKatze3Auslesen() {
		driverWait.until(ExpectedConditions.elementToBeClickable(imgKatze3));
		return imgKatze3.getAttribute("src");
	}
	
	public void buttonNextAnklicken() {
		buttonNext.click();
	}
	
	public void buttonPreviousAnklicken() {
		buttonPrevious.click();
	}
	 
	public void anzahlBilderAngeben(String anzahl) {
		Select select = new Select(this.selectAnzahl);
		select.selectByValue(anzahl);
	}
	public void reihenfolgeAendern(String reihenfolge) {
		Select select = new Select(this.selectReihenfolgeSortierung);
		select.selectByValue(reihenfolge);
		// Asc ODER Desc ODER Rand
	}
	
	
}
