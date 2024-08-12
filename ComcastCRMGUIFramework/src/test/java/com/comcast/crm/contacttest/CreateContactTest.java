package com.comcast.crm.contacttest;

import java.io.IOException;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClassUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
public class CreateContactTest extends BaseClass{
	
	@Test
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

		if(actContactname.contains(lastName))
	    {
		System.out.println(actContactname +"Contact is verified===PASS");
	    }
		else
		{
			System.out.println(actContactname +"Contact is not verified===FAIL");
		}			
	}
	
	}
		
