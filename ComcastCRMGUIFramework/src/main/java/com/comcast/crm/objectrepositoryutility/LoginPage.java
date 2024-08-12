package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.camcast.crm.generic.wedriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	                      //Rule-1:Create a separate java class
	                                          //Rule-2:Object Creation
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);//Login=this refer to current object 
	}                                          //advantage is no need of initialization calling
	                                           //constractor will take care of initialization
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	//Rule-3:Object initialization in test script
	//Rule-4:Object Encapsulation
		
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
   
	//Rule-5:Provide Action business library utilization particular to the application
	public void loginToApp(WebDriver driver, String url,String username, String password)
	{
		waitPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}

}
