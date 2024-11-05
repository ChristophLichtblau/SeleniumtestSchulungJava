package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursWebElementePage {

	private WebDriver driver;

	@FindBy(id = "checkBoxOption1")
	private WebElement checkBox1;

	@FindBy(id = "checkBoxOption2")
	private WebElement checkBox2;

	@FindBy(id = "checkBoxOption3")
	private WebElement checkBox3;
	
	@FindBy(xpath = "//input[@value='radio1']")
	private WebElement radioButton1;
	
	@FindBy(xpath = "//input[@value='radio2']")
	private WebElement radioButton2;
	
	@FindBy(xpath = "//input[@value='radio3']")
	private WebElement radioButton3;

	public SeleniumKursWebElementePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void klickCheckbox1() {
		this.checkBox1.click();
	}

	public void klickCheckbox2() {
		this.checkBox2.click();
	}

	public void klickCheckbox3() {
		this.checkBox3.click();
	}

	public WebElement getCheckBox1() {
		return checkBox1;
	}

	public WebElement getCheckBox2() {
		return checkBox2;
	}

	public WebElement getCheckBox3() {
		return checkBox3;
	}
	
	public void klickRadioButton1() {
		this.radioButton1.click();
	}
	public void klickRadioButton2() {
		this.radioButton2.click();
	}

	public void klickRadioButton3() {
		this.radioButton3.click();
	}

	public WebElement getRadioButton1() {
		return radioButton1;
	}

	public WebElement getRadioButton2() {
		return radioButton2;
	}

	public WebElement getRadioButton3() {
		return radioButton3;
	}


}
