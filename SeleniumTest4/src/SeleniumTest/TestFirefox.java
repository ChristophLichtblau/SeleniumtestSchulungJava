package SeleniumTest;

import org.openqa.selenium.WebDriver;

public class TestFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test startet!");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

	}

}
