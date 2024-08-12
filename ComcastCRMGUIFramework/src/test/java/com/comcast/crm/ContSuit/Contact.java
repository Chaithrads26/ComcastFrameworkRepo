package com.comcast.crm.ContSuit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class Contact extends BaseClass{

	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable, IOException 
	{
		// read test script data from excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Step 2: Navigate to Contacts module
		HomePage hp = new HomePage(driver);
		hp.getContLink().click();

		// Step 3: Click on "Create Contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// Step 4: Create new Contact
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
        cnc.createContact(driver, lastName);
		
     //verify header msg
	CreateNewContactPage cncp=new CreateNewContactPage (driver);
    String actContactname =cncp.getLastNameEdit().getText();
    boolean status=actContactname.contains(lastName);
    Assert.assertEquals(status, true);

				
	}
	
	
@Test(groups="regressionTest")
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
	boolean status=headerMsg.contains(headerMsg);
	SoftAssert assertObj= new SoftAssert();
	assertObj.assertEquals(headerMsg, true);

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


@Test(groups="regressionTest")
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


