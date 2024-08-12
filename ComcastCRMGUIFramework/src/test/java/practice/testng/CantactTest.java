package practice.testng;

import org.testng.annotations.Test;

public class CantactTest {

	@Test
	public void createContactTest()
	{
		System.out.println("excute createContactTest with===>HDFC");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest()
	{
		//System.out.println(" excute query insert contact in DB==>ICICI");
		System.out.println("excute modifyContactTest-->HDFC--ICICI");
	}
	
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest()
	{
		//System.out.println("excute query insert contact in DB==>UPI");
		System.out.println("excute deleteContactTest ICICI" );
	}
}
