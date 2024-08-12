package com.comcast.crm.BaseClassUtility;

	import java.io.IOException;
	import java.sql.SQLException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.camcast.crm.generic.databaseutility.DataBaseUtility;
	import com.camcast.crm.generic.wedriverutility.JavaUtility;
import com.camcast.crm.generic.wedriverutility.UtilityClassObject;
import com.camcast.crm.generic.wedriverutility.WebDriverUtility;
	import com.cancast.crm.generic.fileutility.ExcelUtility;
	import com.cancast.crm.generic.fileutility.FileUtility;
	import com.comcast.crm.objectrepositoryutility.HomePage;
	import com.comcast.crm.objectrepositoryutility.LoginPage;

	public class BaseClass {
		public WebDriverUtility wLib=new WebDriverUtility();
		public DataBaseUtility dbLib=new DataBaseUtility();
		public FileUtility fLib=new FileUtility();
		public ExcelUtility eLib = new ExcelUtility();
		public  JavaUtility jLib = new JavaUtility();
		public WebDriver driver=null;
		public static WebDriver sdriver=null;
		
		//Declare globally so that other method also able to access

		@BeforeSuite(groups= {"smokeTest","regressionTest"})
		public void configBS() throws SQLException
		{
			System.out.println("===connect to DB, Report config===");
			dbLib.getDbconnection();
		}
		
		
		
		@BeforeClass(groups= {"smokeTest","regressionTest"})
		public void configBC() throws IOException
		{
			System.out.println("===Launch the browser===");
	        String BROWSER=fLib.getDataFromPropertiesFile("browser");
			
			if (BROWSER.equals("chrome")) {
				driver = new ChromeDriver(); // This decision of initialization is happening at runtime
			} else if (BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (BROWSER.equals("edge")) {
				driver = new EdgeDriver();
			} else {
				driver = new ChromeDriver();
			}
			sdriver=driver; 
			UtilityClassObject.setdriver(driver);//to call multiple threads in parallel execution
		}
		/*@Parameters("BROWSER")
		@BeforeClass(groups= {"smokeTest","regressionTest"})
		public void configBC(String browser) throws IOException
		{
			System.out.println("===Launch the browser===");
			
			String BROWSER=browser;
					//fLib.getDataFromPropertiesFile("browser");
			
			if (BROWSER.equals("chrome")) {
				driver = new ChromeDriver(); // This decision of initialization is happening at runtime
			} else if (BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (BROWSER.equals("edge")) {
				driver = new EdgeDriver();
			} else {
				driver = new ChromeDriver();
			}
		}*/
		
		@BeforeMethod(groups= {"smokeTest","regressionTest"})
		public void configBM() throws IOException
		{
			System.out.println("===login to Application====");
			String BROSER = fLib.getDataFromPropertiesFile("browser");
			String URL = fLib.getDataFromPropertiesFile("url");
			String USERNAME = fLib.getDataFromPropertiesFile("us");
			String PASSWORD= fLib.getDataFromPropertiesFile("pwd");
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(driver, URL, USERNAME, PASSWORD);
		}
		@AfterMethod(groups= {"smokeTest","regressionTest"})
		public void configAM()
		{
			System.out.println("===logout to Application===");
			HomePage hp=new HomePage(driver);
			hp.logout(driver, wLib);
		}

		@AfterClass(groups= {"smokeTest","regressionTest"})
		public void configFC()
		{
			System.out.println("===close the browser===");
			driver.quit();
		}
		@AfterSuite(groups= {"smokeTest","regressionTest"})
		public void configAS() throws SQLException
		{
			System.out.println("===close Db,Report backup===");
			dbLib.closeDbconnection();
			
		}
	}

