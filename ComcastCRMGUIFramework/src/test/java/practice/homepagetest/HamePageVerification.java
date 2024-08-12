package practice.homepagetest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HamePageVerification {

@Test
public void homePageTest(Method mtd)//get method coming from java.reflect
{
	System.out.println(mtd.getName()+"Test starts");//capture the name of the method
	String expectedPage="Home Page";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("http://localhost:8888/");
	driver.manage().window().maximize();
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	
	//HardAssert
	Assert.assertEquals(actTitle, expectedPage);
	
//	if(actTitle.trim().equals(expectedPage))
//	{
//		System.out.println(expectedPage+"page is verified==PASS");
//	}
//	else
//	{
//		System.out.println(expectedPage+"page is not verified==FAIL");
//	}
	driver.close();
   System.out.println(mtd.getName()+"Test ends");
}

@Test
public void verifyHomePageLogoTest(Method mtd)
{
	System.out.println(mtd.getName()+"Test starts");//capture the name of the method
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("http://localhost:8888/");
	driver.manage().window().maximize();
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
	//Hartd Assert
	//Assert.assertEquals(true, status);
	Assert.assertTrue(status);
	
//	if(status)
//	{
//		System.out.println("Logo is verified==PASS");
//	}
//	else
//	{
//		System.out.println("Logo is not verified==FAIL");
//	}
	driver.close();
	System.out.println(mtd.getName()+"Test ends");
	
}
}
