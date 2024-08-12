package practice.homepagetest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SamlpeTest 
{
	@Test
	public void homeTest(Method mtd)
	{
		SoftAssert assertObj=new SoftAssert();
		
		Reporter.log(mtd.getName()+"Test starts");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		                                          //HardAssert
		Assert.assertEquals("Home", "Home");//mandatory verification home page itself fail no point of continue
		 
		//assertObj.assertEquals("Home", "Home");
		
		Reporter.log("step-3",true);
		
		//Assert.assertEquals("Home-CRM", "Home-CRM");
		
		assertObj.assertEquals("Home-CRM", "Home-CRM");//SoftAssert non mandatory information
		Reporter.log("step-4",true);
		assertObj.assertAll();
		Reporter.log(mtd.getName()+"Test ends");
	}

	@Test
	public void verificationHomeTest(Method mtd)
	{
		SoftAssert assertObj=new SoftAssert();
		
		Reporter.log(mtd.getName()+"Test starts");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
	
		//Assert.assertTrue(true);
		
		assertObj.assertTrue(true);
		
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		assertObj.assertAll();
		Reporter.log(mtd.getName()+"Test ends");
	}


}
