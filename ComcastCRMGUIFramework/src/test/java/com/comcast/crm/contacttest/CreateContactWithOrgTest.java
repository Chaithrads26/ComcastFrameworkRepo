package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
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
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


//Its an integration test case as data flow is happening from Organization module to Contacts module
//As when we get a new build in Testing environment, data is always empty, so here we should also try to automate the precondition.
//x-path getting created in runtime, is called dynamic x-path

public class CreateContactWithOrgTest extends BaseClass{

	@Test
	public void createContactWithOrgTest() throws Throwable, IOException {

		// read test script data from excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		// Step 2: Navigate to Organization page
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "Create Organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// Step 4: Create new Organization
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		// business logic
		cno.createOrg(orgName);

		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerMsg = oip.getHeaderMsg().getText();
		if (headerMsg.contains(orgName)) {
			System.out.println(orgName + " is created == PASS");
		} else {
			System.out.println(orgName + " is not created == FAIL");
		}

		// Step 6: Navigate to Contacts module
		hp.getContLink().click();

		// Step 8: Click on "Create Contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// Step 9: Create new Contact
		CreateNewContactPage cnc = new CreateNewContactPage(driver);

		// Business Logic
		cnc.createContact(driver, lastName);

		// Verify Header msg Expected Result
		ContactInfoPage cip = new ContactInfoPage(driver);
		headerMsg = cip.getHeaderMsg().getText();
		if (headerMsg.contains(lastName)) {
			System.out.println(lastName + " is created == PASS");
		} else {
			System.out.println(lastName + " is not created == FAIL");
		}

		// Verify lastName info Expected Result
		String actualLastName = cip.getListedLastName().getText();
		if (actualLastName.equals(lastName)) {
			System.out.println(lastName + " is created == PASS");
		} else {
			System.out.println(lastName + " is not created == FAIL");
		}

		// Verify orgName info Expected Result
		String actualOrgName = cip.getListedOrgName().getText();
		if (actualOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " is created == PASS");
		} else {
			System.out.println(orgName + " is not created == FAIL");
		}

	}

}