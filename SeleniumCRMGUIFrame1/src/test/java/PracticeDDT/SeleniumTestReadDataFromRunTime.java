package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
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
import org.testng.annotations.Test;


public class SeleniumTestReadDataFromRunTime
{
@Test

public void seleniumTest() throws IOException, InterruptedException
{
	
		String BROWSER =System.getProperty("url"); 
		String URL = System.getProperty("browser"); 
		String UN = System.getProperty("username"); 
		String PWD = System.getProperty("password"); 
		
		//generate random numbers
				Random random= new Random();
			int	randomint=random.nextInt(1000);
			
			//read test script data from excel file for testcase
			FileInputStream fis1=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumCRMGUIFrame1\\src\\test\\resources\\testscriptdata1.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh= wb.getSheet("org");
			Row row=sh.getRow(1);
			Cell cel = row.getCell(2);
			String orgname = cel.getStringCellValue()+randomint;
			wb.close();

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
		
		//step1:login to application
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(URL);
				Thread.sleep(2000);
				driver.findElement(By.name("user_name")).sendKeys(UN);
		        driver.findElement(By.name("user_password")).sendKeys(PWD);
				driver.findElement(By.id("submitButton")).click();
				
		   //step2:navigate to organization module
				driver.findElement(By.linkText("Organizations")).click();
				
		   //step3:click on create organization button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
			//step4:enter all the details and create an organization
				driver.findElement(By.name("accountname")).sendKeys("orgname");
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
			//step5:logout from the application
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				
			//After clicking on the icon move to Sing out
				Actions act=new Actions(driver);
				act.moveToElement(driver.findElement(By.linkText("Sign Out"))).click().perform();
				Thread.sleep(2000);
				driver.quit();
			}

			}


