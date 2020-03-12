package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class takingScreenshots {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
	}
	

	@Test(enabled = false , description = "screen shot of complete web page screenshot")
	public void screenshotOfaPage() throws IOException {
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		TakesScreenshot tScreenshot = (TakesScreenshot)driver;
		
		File src=tScreenshot.getScreenshotAs(OutputType.FILE);
		
		File target= new File("Homepage.png");
		
		FileUtils.copyFile(src, target);
		
	}
	
	@Test(enabled = false , description = "screen shot of a section of a web page")
	public void screenshotOfSectionInaPage() throws IOException {
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		WebElement pageSection=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]"));
		File src=pageSection.getScreenshotAs(OutputType.FILE);
		
		File trg= new File("FeatureProducts.png");
		 
		FileUtils.copyFile(src, trg);
	}
	
	@Test(enabled = true , description = "screen shot of a section of a web page")
	public void screenshotOfSpecificWebElement() throws IOException {
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		WebElement pageSection=driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
		
		highlightWebelement(pageSection, driver);
		
		File src=pageSection.getScreenshotAs(OutputType.FILE);
		
		File trg= new File("FeatureProductsLogo.png");
		
		FileUtils.copyFile(src, trg);
	}
	
	// highlight element red boundaries
	void highlightWebelement(WebElement element, WebDriver eDriver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
	}
}
