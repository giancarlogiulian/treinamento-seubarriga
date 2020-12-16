package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import core.Propriedades;
import core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	private WebDriver driver;
	
	public static final String URL_BROWSERSTACK = 
			"https://giancarlogiulian1:X@hub-cloud.browserstack.com/wd/hub";
	
	public static final String URL_SAUCELABS = 
			"https://giancarlogiulian:X@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public DriverFactory() {	
		
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Propriedades.BROWSER) {
			case FIREFOX:
				driver = new FirefoxDriver();	
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().setSize(new Dimension(1200, 765));		
		}
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			Capabilities caps = null;
			switch (Propriedades.BROWSER) {
			case FIREFOX:
				caps = new FirefoxOptions();	
				break;
			case CHROME:
				caps = new ChromeOptions();
				break;
			}			
			
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.185:4444/wd/hub"), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}			
		}
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.BROWSERSTACK) {
			Capabilities caps = null;
			switch (Propriedades.BROWSER) {
			case FIREFOX:
				caps = new FirefoxOptions();
				break;
			case CHROME:
				caps = new ChromeOptions();
				break;
			}			
			
			try {
				driver = new RemoteWebDriver(new URL(URL_BROWSERSTACK), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}			
		}
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.SAUCELABS) {
			Capabilities caps = null;
			switch (Propriedades.BROWSER) {
			case FIREFOX:
				caps = new FirefoxOptions();	
				break;
			case CHROME:
				caps = new ChromeOptions();
				break;
			}			
			
			try {
				driver = new RemoteWebDriver(new URL(URL_SAUCELABS), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}			
		}		
		driver.get("http://seubarriga.wcaquino.me");
	}	
	
	public void quit() {
		driver.quit();
	}
}
