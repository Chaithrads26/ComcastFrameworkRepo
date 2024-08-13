package PracticeDDT;

import org.testng.annotations.Test;

public class SimpleSeleniumProgram {

@Test
public void runtimeparameterTest()
{
	String url=System.getProperty("url");
	String browser=System.getProperty("browser");
	String username=System.getProperty("username");
	String password=System.getProperty("passw0rd");
	{
	System.out.println("env data==> url====>"+url);
	System.out.println("Browser data==> url====>"+browser);
	System.out.println("username==> url====>"+username);
	System.out.println("password==> url====>"+password);
	

	}

}
}
