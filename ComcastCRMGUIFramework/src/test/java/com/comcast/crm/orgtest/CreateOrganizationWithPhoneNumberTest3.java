package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;
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
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


//This test case is a regression test case
//You have to take care of end result validation	
public class CreateOrganizationWithPhoneNumberTest3 extends BaseClass {

	@Test
	public void CreateOrganizationWithPhoneNumberTest3() throws Throwable, IOException {

		// read test script data from excel file

		String orgname = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);

		// Step 2: Navigate to Organization page
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "Create Organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// Step 4: Enter all the details and Create new Organization
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createOrg(driver, orgname, phoneNumber);
		// cno.createOrg(orgname, phoneNumber);

       //Verify the phone no info expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualPhoneNo = oip.getHeaderMsg().getText();
		if (actualPhoneNo.equals(phoneNumber)) {
			System.out.println(phoneNumber + " information is verified == PASS");
		} else {
			System.out.println(phoneNumber + " information is not verified == FAIL");
		}

	}
}