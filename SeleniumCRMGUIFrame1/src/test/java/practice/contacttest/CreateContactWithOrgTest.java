package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrgTest
{
//precondition should be automated because when new build 
//comes there is no data available in the database if not the test case will be failed

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
    //read the data from property file for common data
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
	//System.out.println(randomint );
				
	//read test script data from excel file for testcase
		FileInputStream fis1=new FileInputStream("‪‪C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumCRMGUIFrame1\\src\\test\\resources\\contact.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh= wb.getSheet("contact");
		Row row=sh.getRow(7);
		String orgname = row.getCell(2).toString() + randomint;
		String contactLastName = row.getCell(3).toString() + randomint;
		
	//lunching the browser
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
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//verify header msg expected result
		String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname))
		{
			System.out.println(orgname + "is created===pass");
		}
		else
		{
			System.out.println(orgname + "is not created===fail");
		}
		
	//step5:navigate to contact module
		
				driver.findElement(By.linkText("Contacts")).click();
				
     //step6:click on create organization button
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
	 //step7:enter all the details and create a contacts
				driver.findElement(By.name("lastname")).sendKeys(contactLastName);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				 
				//switch to child window
				Set<String> set = driver.getWindowHandles();
				Iterator<String> it = set.iterator();
				while(it.hasNext())
				{
					String windowid=it.next();
					driver.switchTo().window(windowid);
					//capture title
					String acturl = driver.getCurrentUrl();
					if(acturl.contains("module=Accounts"))
					{
						break;
					}
				}
				driver.findElement(By.name("search_text")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();// it is a static x-path u have to 
	  //create dynamic x-path it should also created during run time called as dynamic x-path
			
				//switch to parent window
				Set<String> set1 = driver.getWindowHandles();
				Iterator<String> it1 = set1.iterator();
				while(it.hasNext())
				{
					String windowid=it1.next();
					driver.switchTo().window(windowid);
					//capture title
					String acturl = driver.getCurrentUrl();
					if(acturl.contains("module=Contacts&action"))
					{
						break;
					}
				}
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
    
				
				//verify the lastName with expected result
		headerinfo=driver.findElement(By.xpath("//span[@class=dvHeaderText]")).getText();
				if(headerinfo.equals(contactLastName))
				{
					System.out.println( contactLastName+ "is created===pass");
				}
				else
				{
					System.out.println(contactLastName+ "is not created===fail");
				}	
		
	//verify header orgname info expected result
		String actorgname=driver.findElement(By.id("dtlview_Organization Name")).getText();
		System.out.println(actorgname);
		if(actorgname.equals(orgname))
			
		{
			System.out.println(orgname + "is created===pass");
		}
		else
		{
			System.out.println(orgname + "is not created===fail");
		}
		

		driver.quit();
	}
	}

	
	



