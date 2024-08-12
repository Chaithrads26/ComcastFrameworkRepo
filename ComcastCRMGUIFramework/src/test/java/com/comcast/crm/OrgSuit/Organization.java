package com.comcast.crm.OrgSuit;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.camcast.crm.generic.wedriverutility.UtilityClassObject;
import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class Organization extends BaseClass{
	
	@Test(groups="smokeTest")
	public void  CreateOrganizationTest() throws Throwable, IOException
	{
		UtilityClassObject.getTest().log(Status.INFO,"Read data from excel");
//read test script data from excel file for test case n generate random number
		String orgname=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();	
		
		
//navigate to organization page
		UtilityClassObject.getTest().log(Status.INFO,"navigate to Org page");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();//getter method provide single element action
		//op.navigateToCampianPage();//business method provide multiple element actions

//click on create organization button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org");
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

//enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO,"create new org");
		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgname);
		
//verify header msg
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
    String actOrgName =oip.getHeaderMsg().getText();

		if(actOrgName.contains(orgname))
	    {
		System.out.println(orgname +"name is verified===PASS");
	    }
		else
		{
			System.out.println(orgname +"name is not verified===FAIL");
		}			
	}

@Test(groups="regressionTest")
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

@Test(groups="regressionTest")
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
