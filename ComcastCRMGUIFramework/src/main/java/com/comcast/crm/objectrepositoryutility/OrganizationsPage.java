package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;                        
    
	public OrganizationsPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement CreateNewOrgBtn;

public WebElement getCreateNewOrgBtn() {
	return CreateNewOrgBtn;
}
@FindBy(name="search_text")
private WebElement searchEdt;
@FindBy(name="search_field")
private WebElement searchDD;
@FindBy(name="submit")
private WebElement searchBtn;
@FindBy(id="dtlview_Industry")
private WebElement indDD;
@FindBy(id="dtlview_Type")
private WebElement typeDD;




public WebElement getIndDD() {
	return indDD;
}
public WebElement getTypeDD() {
	return typeDD;
}
public WebElement getSearchBtn() {
	return searchBtn;
}
public WebElement getSearchEdt() {
	return searchEdt;
}
public WebElement getSearchDD() {
	return searchDD;
}


}
