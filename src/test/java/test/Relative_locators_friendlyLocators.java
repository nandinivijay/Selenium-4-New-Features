package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_locators_friendlyLocators {
	
	WebDriver driver;
	
	@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://automationbookstore.dev/");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	@Test(priority = 1, enabled = true)
	public void testCase() {
		
		// Test book 5 is below book 1 and left of book 5
		WebElement book5 =	driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
		String book5_id= book5.getAttribute("id");
		Assert.assertEquals("pid5",book5_id);
	}
	
	@Test(priority = 2, enabled = true)
	public void testcase2() {
		// test book 2 is above book and right of book 1
				WebElement book2 =	driver.findElement(RelativeLocator.withTagName("li").toRightOf(By.id("pid1")).above(By.id("pid6")));
				String book2_id= book2.getAttribute("id");
				Assert.assertEquals("pid2",book2_id);
	}

}
