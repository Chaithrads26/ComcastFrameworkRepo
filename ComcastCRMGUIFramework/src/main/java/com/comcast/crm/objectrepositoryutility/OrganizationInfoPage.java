package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

                        
    public OrganizationInfoPage(WebDriver driver)
	{

	PageFactory.initElements(driver, this);
	}
    
@FindBy(className="dvHeaderText")
private WebElement headerMsg;

public WebElement getHeaderMsg() {
	return headerMsg;
}

@FindBy(id="dtlview_Phone")
private WebElement phoneHeader;

public WebElement getPhoneHeader() {
	return phoneHeader;
}

//how to do validation

}
