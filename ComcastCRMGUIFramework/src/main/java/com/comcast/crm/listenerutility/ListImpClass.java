package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.camcast.crm.generic.wedriverutility.UtilityClassObject;
import com.comcast.crm.BaseClassUtility.BaseClass;

public class ListImpClass  implements ITestListener,ISuiteListener
{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite)
	{
		System.out.println("Report configuration");
		String time = new Date().toString().replace(' ', '_').replace(':', '_');
		
	

	//Spark report config
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
	spark.config().setDocumentTitle("CRM Test Suite Result");
	spark.config().setReportName("CRM report");
	spark.config().setTheme(Theme.DARK);
	
	//add environment information & create test
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS","Windows-10");
	report.setSystemInfo("CHROME","chrome");
	}

	public void onFinish(ISuite suite)
	{
		System.out.println("Report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result)
	{
		System.out.println("====>"+result.getMethod().getMethodName()+"<====");
		 test=report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"===>Started<=====");
	}
	public void onTestSuccess(ITestResult result )
	{
		System.out.println("====>"+result.getMethod().getMethodName()+"<====END=======");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===>Completed<=====");
	}

	public void onTestFailure(ITestResult result)
	{
		String testName= result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(' ', '_').replace(':', '_');
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED <==");
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName()+"===>Failed<=====");
		
	}
	//test.addScreenCaptureFromBase64String(filepath,"ErrorFile");

	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, result.getMethod().getMethodName()+"===>Skipped<====="); 
	}
}
