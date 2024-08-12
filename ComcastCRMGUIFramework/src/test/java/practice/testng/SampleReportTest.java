package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	public ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		//Spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		//add environment information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("CHROME","chrome");
	}
	@AfterSuite()
	public void configAS()
	{
		report.flush();
	}
@Test
public void createContactTest()
{
	WebDriver driver= new ChromeDriver();
	driver.get("http://localhost:8888/");
	TakesScreenshot eDriver=(TakesScreenshot)driver;
	String filepath=eDriver.getScreenshotAs(OutputType.BASE64);
	
	ExtentTest test=report.createTest("Create contact test");
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	
	
	if("HDFCee".equals("HDFC"))
	{
		test.log(Status.PASS,"contact is created Pass");
	}
	else
	{
		test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
	}	
	driver.close();
}
}
//@Test
//public void createOrgTest()
//{
//	
//	ExtentTest test=report.createTest("Create contact test");
//	
//	test.log(Status.INFO,"login to app");
//	test.log(Status.INFO,"navigate to contact page");
//	test.log(Status.INFO,"create contact");
//	
//	if("HDFC".equals("HDFC"))
//	{
//		test.log(Status.PASS,"contact is created Pass");
//	}
//	else
//	{
//		test.log(Status.FAIL,"contact is not created Pass");
//	}
//		
//}
//@Test
//public void createcotactwithPhoneTest()
//{
//	
//	ExtentTest test=report.createTest("Create contact test");
//	
//	test.log(Status.INFO,"login to app");
//	test.log(Status.INFO,"navigate to contact page");
//	test.log(Status.INFO,"create contact");
//	
//	if("HDFC".equals("HDFC"))
//	{
//		test.log(Status.PASS,"contact is created Pass");
//	}
//	else
//	{
//		test.log(Status.FAIL,"contact is not created Pass");
//	}
//		
//}
//}
