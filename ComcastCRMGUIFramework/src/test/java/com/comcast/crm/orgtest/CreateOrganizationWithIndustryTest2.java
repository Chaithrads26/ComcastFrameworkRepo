package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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

//every test case you have to verify the expected result.
//This test case is a regression test case
//You have to take care of end result validation

public class CreateOrganizationWithIndustryTest2 extends BaseClass{
	
	@Test
	public void CreateOrganizationWithIndustryTest2() throws Throwable, IOException
	{
		// read test script data from excel file
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

        // Step 2: Navigate to Organization page
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "Create Organization" button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// Step 4: Create new Organization
		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		
		//Business logic
		cno.createOrg(driver, orgName, wLib, industry, type);
		
		//Verify the industries info
		String actualIndustry = op.getIndDD().getText();
		if(actualIndustry.equals(industry)) {
			System.out.println(industry+" information is verified == PASS");
		} else {
			System.out.println(industry+" information is not verified == FAIL");
		}
		
		//Verify the type info
		String actualType = op.getTypeDD().getText();
		if(actualType.equals(type)) {
			System.out.println(type+" information is verified == PASS");
		} else {
			System.out.println(type+" information is not verified == FAIL");
		}
	}
}