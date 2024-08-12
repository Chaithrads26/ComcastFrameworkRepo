package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.camcast.crm.generic.wedriverutility.JavaUtility;
import com.camcast.crm.generic.wedriverutility.WebDriverUtility;
import com.cancast.crm.generic.fileutility.ExcelUtility;
import com.cancast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;


public class CreateContactWithSupportDateTest extends BaseClass{
	@Test
	public void CreateContactWithSupportDateTest() throws Throwable, IOException
	{

		// read test script data from excel file
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
	
		// Step 2: Navigate to Contacts module
		HomePage hp = new HomePage(driver);
		hp.getContLink().click();

		// Step 3: Click on "Create Contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// Step 4: Create new Contact
		CreateNewContactPage cnc = new CreateNewContactPage(driver);

		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYMMDD(30);
		
		//Business Logic
		cnc.createContactWithSupportDate(driver, lastName, startDate, endDate);

		// Verify start date
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actualStartDate = cip.getListedSuppStartDate().getText();
		if (actualStartDate.equals(startDate)) {
			System.out.println(startDate + " is created == PASS");
		} else {
			System.out.println(startDate + " is not created == FAIL");
		}

		// Verify end date
		String actualEndDate = cip.getListedSuppEndDate().getText();
		if (actualEndDate.equals(endDate)) {
			System.out.println(endDate + " is created == PASS");
		} else {
			System.out.println(endDate + " is not created == FAIL");
		}
	}
}