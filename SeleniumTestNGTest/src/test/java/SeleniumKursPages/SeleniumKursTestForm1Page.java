package SeleniumKursPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumKursTestForm1Page {
	


	private WebDriver driver;
	
	
	
		// MenuButton
		@FindBy (id = "portaltab-burger-menu")
		private WebElement buttonMenu;
		
		@FindBy (tagName = "h1")
		private WebElement testForm1Headline; 
		
		@FindBy (id = "form-widgets-betreff")
		private WebElement inputBetreff;
		
		@FindBy (id = "form-widgets-name")
		private WebElement inputName;
		
		@FindBy (id = "form-widgets-auswahl1")
		private WebElement selectKurswahl;
		
		@FindBy (id = "form-widgets-auswahl2-from")
		private WebElement selectFirmaBoxLinks;
		
		@FindBy (id = "form-widgets-auswahl2-to")
		private WebElement selectFirmaBoxRechts;
		
		@FindBy (name = "from2toButton")
		private WebElement buttonNachechts;
		
		@FindBy (name = "to2fromButton")
		private WebElement buttonNachLinks;
		
		@FindBy (name = "upButton")
		private WebElement buttonNachOben;
		
		@FindBy (name = "downButton")
		private WebElement buttonNachUnten;
		
		@FindBy (name = "form.buttons.speichern")
		private WebElement buttonSpeichern;
		
		@FindBy (xpath = "//div[@id='message']/span")
		private WebElement statusmeldungNachSpeichern;
		
		@FindBy (xpath = "//ul[@id='companies']/li[1]")
		private WebElement textErstesElementListeFirma;
		
		@FindBy (xpath = "//h1[@class='documentFirstHeading']")
		private WebElement h1UeberschriftForm1Page;
		
		
		public SeleniumKursTestForm1Page(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	
		public void menuAusklappen() {
			buttonMenu.click();
		}
		
		public void eingabeBetreff(String betreff) {
			inputBetreff.sendKeys(betreff);
		}
		
		public void eingabeName(String name) {
			inputName.sendKeys(name);
		}
		
		public void kursAUswaehlen(String kursName) {
			// selectKurswahl.findElement(By.linkText(kursaName));
			Select selectKurs = new Select(this.selectKurswahl);
			selectKurs.selectByVisibleText(kursName);
		}
		
		public void selectFirmaBoxLinks(int[] firmennameIndex) {
			Select selectFirmenname = new Select(this.selectFirmaBoxLinks);
			
			for (int i : firmennameIndex) {
				selectFirmenname.selectByIndex(i);
			}
		}
		
		public void selectFirmaBoxRechts(int[] firmennameIndex) {
			Select selectFirmenname = new Select(this.selectFirmaBoxRechts);
			
			for (int i : firmennameIndex) {
				selectFirmenname.selectByIndex(i);
			}
		}
		
		public void firmenInRechteBoxUebernehmen() {
			this.buttonNachechts.click();
		}
		
		public void firmenAusRechterBoxEntfernen() {
			this.buttonNachLinks.click();
		}
		
		public void elementNachObenSchieben() {
			this.buttonNachOben.click();
		}
		
		public void elementNachUntenSchieben() {
			this.buttonNachUnten.click();
		}
		
		public void firmenSpeichern() {
			this.buttonSpeichern.click();
		}
		
		public String statusmeldungAuslesen() {
			return this.statusmeldungNachSpeichern.getText();
		}
		
		public String erstesListenelementAuslesen() {
			return this.textErstesElementListeFirma.getText();
		}
		
		public String ueberschriftAuslesen() {
			return this.h1UeberschriftForm1Page.getText();
		}

}
