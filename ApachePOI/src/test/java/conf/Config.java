package conf;

import java.io.InputStream;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class Config {
		
	private static String configfile = "myconfig.properties";
	
	private static Properties properties = loadProperties();
	
	public static String getBaseURL() {
		 String baseURL = (String) properties.get("baseurl");
		 throwExceptionWhenNull("baseurl", baseURL);
		 return baseURL;
	}
	
	public static String getBrowserName(String browsername) {
		 String browser = (String) properties.get(browsername);
		 throwExceptionWhenNull(browsername, browser);
		 return browser;
	}
	
	public static String getDriverPfad(String drivername) {
		 String driver = (String) properties.get(drivername);
		 throwExceptionWhenNull(drivername, driver);
		 return driver;
	}
	
	private static void throwExceptionWhenNull(String property, String parameter) {
		if(parameter == null) {
			throw new RuntimeException("Parameter: " + property + " nicht in der Configurationsdatei gefunden!");
		}
	}
	
	
	
	private static Properties loadProperties() {
		try {
			
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			
			Properties probs = new Properties();
			
			InputStream is = loader.getSystemResourceAsStream(configfile);
			
			probs.load(is);
			
			return probs;
			
		} catch (Exception e) {
			throw new RuntimeException("keine Configurationsdatei gefunden!",e);
		}
	}
	
}
