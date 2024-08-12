 package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDPwithPhTest{
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName,long phoneNumber)//receive argument from data provider
	{
		System.out.println("FirstName:"+firstName + ",LastName:"+lastName +",PhoneNumber:"+phoneNumber) ;
	}
	
@DataProvider
public Object[][] getData()
{
	Object[][] objArr=new Object[3][3];
	objArr[0][0]="Deepak";
	objArr[0][1]="HR";
	objArr[0][2]=8970282123l;//long data
	
	objArr[1][0]="Sam";
	objArr[1][1]="SH";
	objArr[1][2]=9945318764l;
	
	objArr[2][0]="Jhon";
	objArr[2][1]="smith";
	objArr[2][2]=9164766667l;
	
	return objArr;
}
}

