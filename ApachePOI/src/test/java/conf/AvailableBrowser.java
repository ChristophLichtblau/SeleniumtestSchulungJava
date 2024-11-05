package conf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum AvailableBrowser {

	FIREFOX {
		
		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			return driver;
		}
	},
	CHROME {
		
		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			return driver;
		}
	},
	EDGE {
		
		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			
			return driver;
		}
	};
	
	public abstract WebDriver createDriver();
	
}
