package PracticeDDT;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleDDT {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// read the data from property file
	FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumCRMGUIFrame1\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String UN = pobj.getProperty("us");
		String PWD = pobj.getProperty("pwd");

		//generate random numbers
		Random random= new Random();
	    int	randomint=random.nextInt(1000);
	    System.out.println(randomint );
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
			driver=new ChromeDriver();
		//step1:login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		//Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		//Thread.sleep(2000);
		
		driver.findElement(By.id("submitButton")).click();
		//Thread.sleep(2000);
		
		//step2:navigation to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step3:click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//step4:enter all the details n create an organization
		driver.findElement(By.name("accountname")).sendKeys("facebook_"+randomint);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//step5:logout from the app
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Sign Out"))).perform();
		Thread.sleep(2000);
		
		
		driver.quit();
	}
}


