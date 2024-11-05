package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursDragAndDropPage {

	private WebDriver driver;

	@FindBy(id = "portaltab-burger-menu")
	private WebElement buttonMenu;

	@FindBy(id = "white-logo")
	private WebElement imgLogoWhite;

	@FindBy(id = "red-logo")
	private WebElement imgLogoRed;

	@FindBy(id = "green-logo")
	private WebElement imgLogoGreen;

	@FindBy(id = "blue-logo")
	private WebElement imgLogoBlue;

	@FindBy(id = "coding-logo")
	private WebElement imgCodingLogo;

	@FindBy(id = "droppable")
	private WebElement boxAblage;

	@FindBy(xpath = "//div[@id='droppable']/p")
	private WebElement textBoxAblage;

	@FindBy(xpath = "//h1[@class='documentFirstHeading']")
	private WebElement ueberschriftDragAndDropPage;

	public SeleniumKursDragAndDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		;
	}

	public void schiebeWhiteLogoInBox() {
		Actions action = new Actions(driver);
		action.dragAndDrop(this.imgLogoWhite, this.boxAblage).build().perform();
	}

	public void schiebeRedLogoInBox() {
		// this.action.dragAndDrop(this.imgLogoRed, boxAblage).build().perform();
		Actions action = new Actions(driver);
		action.dragAndDropBy(this.imgLogoRed, 250, 6).build().perform();
		;
	}

	public void schiebeGreenLogoInBox() {
		// this.action.dragAndDrop(this.imgLogoGreen, boxAblage).build().perform();
		Actions action = new Actions(driver);
		action.clickAndHold(this.imgLogoGreen).perform();
		action.moveByOffset(240, 5).perform();
		action.release(this.imgLogoGreen).perform();
	}

	public void schiebeBlueLogoInBox() {
		Actions action = new Actions(driver);
		action.dragAndDrop(this.imgLogoBlue, boxAblage).build().perform();
	}

	public void schiebeCodingLogoInBox() {
		Actions action = new Actions(driver);
		action.dragAndDrop(this.imgCodingLogo, boxAblage).build().perform();
	}

	public String textLetztesVerschobenesElementInBox() {
		return this.textBoxAblage.getText();
	}

	public String ueberschriftDragANdDropPageAuslesen() {
		return this.ueberschriftDragAndDropPage.getText();
	}
}
