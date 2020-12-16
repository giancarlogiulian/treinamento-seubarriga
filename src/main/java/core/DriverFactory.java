package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	
	private WebDriver driver;
	
	public static final String USERNAME = "giancarlogiulian1";
	public static final String AUTOMATE_KEY = "iAnxhF2pHcq94xSQxx1P";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public WebDriver getDriver() {
		return driver;
	}

	public DriverFactory(Capabilities caps) {	
		
		try {
			driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			driver.get("http://seubarriga.wcaquino.me");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public DriverFactory() {	
		
		/*String pathDriver = System.getProperty("user.dir") + "/src/main/resources/geckodriver";
		System.setProperty("webdriver.gecko.driver", pathDriver);
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));*/
		
		Capabilities caps = DesiredCapabilities.firefox();
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.1.185:4444/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("http://seubarriga.wcaquino.me");
	}	
	
	public void quit() {
		driver.quit();
	}
}
