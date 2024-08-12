package com.camcast.crm.generic.wedriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cancast.crm.generic.fileutility.FileUtility;

import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility
{
   public void maximizeWindow(WebDriver driver)
   {
	   driver.manage().window().maximize();
	   
   }
	public void waitPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new 
				WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver,String partialURL)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowid=it.next();
			driver.switchTo().window(windowid);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("partialURL"))
			{
				break;
			}
		}
	}
	public void switchToTabOnTitle(WebDriver driver,String partialTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowid=it.next();
			driver.switchTo().window(windowid);
			String acturl = driver.getTitle();
			if(acturl.contains("partialTitle"))
			{
				break;
			}
		}
	}
	//Switch to Frames
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	//Switch to Alert
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	//Select class
	public void Select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void Select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void Select1(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	//Mouse movement
	
	public void mousemoveOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).perform();	
	}
	public void contextClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();	
	}
	public void click(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.click(element).perform();
	}
	
	//javaScriptExecuter
	public void scrollUntillElePosition(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("windows.scrollBy(0,"+y+")");
	
	}
	public void scrollUntillEleToBeVisible(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	public void scrollUntillEleToBeVisibleAndClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click()",element);
	}
	public void takeScreenShot(WebDriver driver,String fileName) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File tempFile = ts.getScreenshotAs(OutputType.FILE);
	File permFile = new File("./Screenshots"+fileName+".png");
	//fileutils.copyFile(tempFile,permFile); 
	FileHandler.copy(tempFile, permFile);
	}
}


 