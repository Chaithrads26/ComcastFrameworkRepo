package practice.testng;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	public class AssignmentDemoWebShop {
		@Test
		public void workWithDemoWebShopApplication() throws IOException, InterruptedException 
		{
			WebDriver driver = new ChromeDriver();
			driver.get("https://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
			
			//Register to DemoApp
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("gender-female")).click();
			driver.findElement(By.id("FirstName")).sendKeys("abcd");
			driver.findElement(By.id("LastName")).sendKeys("xyz");
			driver.findElement(By.id("Email")).sendKeys("chaithrads26@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
			driver.findElement(By.id("register-button")).click();
			
			//Login with created credentials
			driver.findElement(By.linkText("Log in")).click();
			driver.findElement(By.id("Email")).sendKeys("chaithrads26@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			
			//click on electronics menu
			driver.findElement(By.xpath("(//a[@href='/electronics'])[1]")).click();
			driver.findElement(By.xpath("(//a[@href='/cell-phones'])[5]")).click();
			
			
		    //Select dropDown 
			Select sel=new Select(driver.findElement(By.id("products-orderby")));
			
	        sel.selectByVisibleText("Name: A to Z");
	      
	        
			
			//take screenshot of selected image
			TakesScreenshot ts = (TakesScreenshot) driver;
		    File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/dropdown.png");
		    FileHandler.copy(src, dest);
	        driver.quit();
		}

	}


