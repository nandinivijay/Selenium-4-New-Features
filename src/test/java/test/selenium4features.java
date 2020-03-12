package test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium4features {
	

	WebDriver driver=null;
	
	@BeforeTest
	public void BeforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test(priority = 1, enabled = false)
	public void screenShotTest() throws IOException, InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		// Capturing the screen shot of the CRM logo
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		
		File file=logo.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("logo.png");
		
		FileUtils.copyFile(file, destFile);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.google.com");
		
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 2 ,enabled = false)
	public void newWindow() throws IOException, InterruptedException {
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.google.com");
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
	@Test(priority = 3 ,enabled = true)
	public void location() throws IOException, InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		// Capturing the screen shot of the CRM logo
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		
		System.out.println("height of the element"+logo.getRect().getDimension().getHeight());
		System.out.println("Width of the element"+logo.getRect().getDimension().getWidth());
		
		System.out.println("Get X location"+logo.getRect().getX());
		System.out.println("Get Y location"+logo.getRect().getY());
		
		Thread.sleep(5000);
	}
}
