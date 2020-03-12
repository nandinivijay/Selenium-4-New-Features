package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Optional;
import com.google.common.graph.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeDevToolsDemo {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
	}
	
	@Test
	public void enableNetworkOffline() {
		driver = new ChromeDriver();
		
		DevTools  devTools = ((ChromiumDriver) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.of(1000000),Optional.empty(),Optional.empty()));
		
	}

}
