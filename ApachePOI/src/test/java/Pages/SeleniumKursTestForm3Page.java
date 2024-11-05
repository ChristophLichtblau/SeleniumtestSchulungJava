package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumKursTestForm3Page {

	WebDriver driver;

	public SeleniumKursTestForm3Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "form-widgets-bezeichnung")
	private WebElement inputBezeichnung;
	
	@FindBy(id = "form-widgets-kennung")
	private WebElement inputKennNR;
	
	@FindBy(id = "form-widgets-anschrift")
	private WebElement inputAnschrift;
	
	@FindBy (id = "form-widgets-telefon")
	private WebElement inputTelefon1;
	
	@FindBy (id = "form-widgets-str")
	private WebElement inputStrasse1;
	
	@FindBy (id = "form-widgets-plz")
	private WebElement inputPLZ1;
	
    @FindBy (id = "form-widgets-ort")
    private WebElement inputOrt1;
	
	@FindBy (id = "form-widgets-auswahl1")
	private WebElement selectArbeitsverhaeltnis;
	
	@FindBy (id = "form-widgets-name")
	private WebElement inputNachname;
	
	@FindBy (id = "form-widgets-vorname")
	private WebElement inputVorname;
	
	@FindBy (id ="form-widgets-geburt")
	private WebElement inputGeburtsdatum;
	
	@FindBy (id = "form-widgets-telefonv")
	private WebElement inputTelefon2;
	
	@FindBy (id = "form-widgets-strv")
	private WebElement inputStrasse2;
	
	@FindBy (id = "form-widgets-plzv")
	private WebElement inputPLZ2;
	
    @FindBy (id = "form-widgets-ortv")
    private WebElement inputOrt2;
    
    @FindBy (xpath = "//input[@class='btn btn-primary']")
    private WebElement btnSpeichern;
    
    @FindBy (xpath = "//div[@id='message']//span")
    private WebElement txt_status;
    
    @FindBy (id = "auswahl")
    private WebElement txt_erstesElement;
    
    public void inputBezeichnung(String text) {
    	inputBezeichnung.sendKeys(text);
    }
    public void inputKennNR(String text) {
    	inputKennNR.sendKeys(text);
    }
    public void inputAnschrift(String text) {
    	inputAnschrift.sendKeys(text);
    }
    public void inputTelefon(String text) {
    	inputTelefon1.sendKeys(text);
    }
    public void inputStrasse1(String text) {
    	inputStrasse1.sendKeys(text);
    }
    public void inputPLZ1(String text) {
    	inputPLZ1.sendKeys(text);
    }
    public void inputOrt1(String text) {
    	inputOrt1.sendKeys(text);
    }
    public void selectArbeitsverhaeltnis(String text) {
    	Select select = new Select(selectArbeitsverhaeltnis);
    	select.selectByVisibleText(text);
    }
    public void inputNachname(String text) {
    	inputNachname.sendKeys(text);
    }
    public void inputVorname(String text) {
    	inputVorname.sendKeys(text);
    }
    public void inputGeburtstdatum(String text) {
    	inputGeburtsdatum.sendKeys(text);
    }
    public void inputTelefon2(String text) {
    	inputTelefon2.sendKeys(text);
    }
    public void inputStrasse2(String text) {
    	inputStrasse2.sendKeys(text);
    }
    public void inputPLZ2(String text) {
    	inputPLZ2.sendKeys(text);
    }
    public void inputOrt2(String text) {
    	inputOrt2.sendKeys(text);
    }
    public void btnSpeichernAnklicken() {
    	btnSpeichern.click();
    }
    public String txt_statusAuslesen() {
    	return txt_status.getText();
    }
    public String txt_erstesElementAuslesen() {
    	return txt_erstesElement.getText();
    }
}
