package practice.orgtest;



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
	
	public class CreateOrganizationTest
	
	{
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
			FileInputStream fis1=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumCRMGUIFrame1\\src\\test\\resources\\testscriptdata1.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh= wb.getSheet("org");
			Row row=sh.getRow(1);
			String orgname = row.getCell(2).toString() + randomint;
			
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
			
			//verify header orgname info expected result
			String actorgnameinfo=driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actorgnameinfo.equals(orgname))
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
