package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.camcast.crm.generic.wedriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage {
                       
    
	public CreatingNewOrganizationPage(WebDriver driver)
	{
	
	PageFactory.initElements(driver, this);
	}

@FindBy(name="accountname")
private WebElement orgNameEdit;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(id="phone")
private WebElement phoneEdit;

@FindBy(xpath="//option[@value='Energy']")
private WebElement indDD;

@FindBy(xpath="//option[@value='Press']")
private WebElement TypeDD;

public WebElement getIndDD() {
	return indDD;
}

public WebElement getTypeDD() {
	return TypeDD;
}

public WebElement getPhoneEdit() {
	return phoneEdit;
}

@FindBy(name="industry")
private WebElement industryEdit;

public WebElement getIndustryEdit() {
	return industryEdit;
}

public WebElement getOrgNameEdit() {
	return orgNameEdit;
}

@FindBy(name="accounttype")
private WebElement typeEdit;

public WebElement getTypeEdit() {
	return typeEdit;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
public void createOrg(String orgname) 
{
	orgNameEdit.sendKeys(orgname);// getting the data from test script (excel+random int)
	saveBtn.click();
}


public void createOrg( WebDriver driver,String orgname,String phoneNumber)
{
	orgNameEdit.sendKeys(orgname);
	phoneEdit.sendKeys(phoneNumber);
	saveBtn.click();
}
public void createOrg(WebDriver driver, String orgname,WebDriverUtility wLib,String industry, String type)
{
	orgNameEdit.sendKeys(orgname);
	wLib.Select(industryEdit, industry);
	wLib.Select(typeEdit,type);
	saveBtn.click();
	

}

}
