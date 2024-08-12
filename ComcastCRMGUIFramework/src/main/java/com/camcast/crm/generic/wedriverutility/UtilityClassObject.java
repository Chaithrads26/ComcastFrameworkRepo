package com.camcast.crm.generic.wedriverutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

// this class shares the multiple threads in case of parallel execution
public class UtilityClassObject {

public static ThreadLocal<ExtentTest> test= new ThreadLocal<ExtentTest>();
public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();

public static ExtentTest getTest()
{
	return test.get();
}
public static void setTest(ExtentTest actTest)
{
	test.set(actTest);
}

public static WebDriver getDriver()
{
	return driver.get();
}
public static void setdriver(WebDriver actdriver)
{
	driver.set(actdriver);
}
}
