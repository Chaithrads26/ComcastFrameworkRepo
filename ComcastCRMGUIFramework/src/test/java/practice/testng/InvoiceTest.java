package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClassUtility.BaseClass;
@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class InvoiceTest  extends BaseClass
{

//@Test
//public void createInvoiceTest()
//{
//	System.out.println("excute createInvoiceTest");
//	String actTitle=driver.getTitle();
//	Assert.assertEquals(actTitle, "Login");//failure
//	System.out.println("step-1");
//	System.out.println("step-2");
//	System.out.println("step-3");
//	System.out.println("step-4");
//}
//@Test
//public void createInvoicewithcontactTest()
//{
//	System.out.println("excute createInvoicewithcontactTest");
//	System.out.println("step-1");
//	System.out.println("step-2");
//	System.out.println("step-3");
//	System.out.println("step-4");
//	
//}
	
	@Test(retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim()
	{
		System.out.println("excute createInvoiceTest");
	String actTitle=driver.getTitle();
		Assert.assertEquals("", "Login");//failure
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
