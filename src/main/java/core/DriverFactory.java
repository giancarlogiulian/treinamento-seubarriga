package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public DriverFactory() {
		
		String pathDriver = System.getProperty("user.dir") + "/src/main/resources/geckodriver";
		System.setProperty("webdriver.gecko.driver", pathDriver);
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://seubarriga.wcaquino.me/");
	}
	
	public void quit() {
		driver.quit();
	}
}
