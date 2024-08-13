package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactWithSupportDateTest {
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
		FileInputStream fis1=new FileInputStream("C:\\Users\\ADMIN\\Desktop\\contact.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh= wb.getSheet("contact");
		Row row=sh.getRow(4);
		String lastName = row.getCell(2).toString() + randomint;
		
	//launching the browser
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
		
   //step2:navigate to Contacts module
		driver.findElement(By.linkText("Contacts")).click();
		
   //step3:click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	//step4:enter all the details and create a contacts
		Date dateobj=new Date();
	    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	    String startdate=sim.format(dateobj);
	    //System.out.println(actdate); 
	
	     Calendar cal = sim.getCalendar();  
	     cal.add(Calendar.DAY_OF_MONTH,30);
	     String enddate = sim.format(cal.getTime());
	     //System.out.println(dateRequired); 
		
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys("startdate");
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys("enddate");
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
	//verify the start date with expected result
		String actstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartdate.equals(startdate))
		{
			System.out.println( startdate+ "is created===pass");
		}
		else
		{
			System.out.println(startdate+ "is not created===fail");
		}
	//verify the end date with expected result
		String actenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actenddate.equals(enddate))
		{
			System.out.println( enddate+ "is created===pass");
		}
		else
		{
			System.out.println(enddate+ "is not created===fail");
		}
		

		driver.quit();
	}
	}


