 package com.comcast.crm.orgtest;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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
	
	public class CreateOrganizationTest extends BaseClass
	{
		@Test
		public void  CreateOrganizationTest() throws Throwable, IOException
		{
	//read test script data from excel file for test case n generate random number
			String orgname=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();	
			
			
	//navigate to organization page
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();//getter method provide single element action
			//op.navigateToCampianPage();//business method provide multiple element actions
	
   //click on create organization button
			OrganizationsPage cnp=new OrganizationsPage(driver);
			cnp.getCreateNewOrgBtn().click();

   //enter all the details and create new organization
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
		
		}
			