package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.camcast.crm.generic.wedriverutility.WebDriverUtility;

public class HomePage 
{
	                        
    
public HomePage(WebDriver driver)
{

PageFactory.initElements(driver, this);
}

	//Object Creation
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contLink;
	@FindBy(linkText = "Products")
	private WebElement productlink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singOutLink;

	@FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	public WebElement getOrgLink() { 
		return orgLink;
	}

	public WebElement getContLink() {
		return contLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getCampaignLink() {
		return campaignLink;
	}

public WebElement getSingOutLink() {
	return singOutLink;
}

public WebElement getAdminImage() {
	return adminImage;
}
	
public void navigateToCampianPage(WebDriver driver) {
	Actions act=new Actions(driver);
	act.moveToElement(moreLink).perform();
	campaignLink.click();	
}


public void logout(WebDriver driver, WebDriverUtility wLib) {
	wLib.mousemoveOnElement(driver, adminImage);
	//adminImage.click();
	wLib.mousemoveOnElement(driver, singOutLink);
	singOutLink.click();
}
}
	


