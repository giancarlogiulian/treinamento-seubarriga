package core;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesFactory {
	
	private DesiredCapabilities caps;

	public DesiredCapabilitiesFactory(String nameTest) {
		
		this.caps = new DesiredCapabilities();
        
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Firefox");
		caps.setCapability("browser_version", "80");
		caps.setCapability("name", nameTest);
	}
	
	public DesiredCapabilities getCaps() {
		return this.caps;
	}
}
