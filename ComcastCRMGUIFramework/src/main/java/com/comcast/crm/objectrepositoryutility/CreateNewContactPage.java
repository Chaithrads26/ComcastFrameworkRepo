package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.camcast.crm.generic.wedriverutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	public CreateNewContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdit;

	@FindBy(name = "support_start_date")
	private WebElement suppStartDateEle;
	
	@FindBy(name = "support_end_date")
	private WebElement suppEndDateEle;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement plusIcon;
	
	@FindBy(id="search_txt")
	WebElement searchTF;
	
	@FindBy(name="search")
	WebElement searchBtn;
	
	@FindBy(name = "button")
	private WebElement buttonEle;
	
	
	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}
	
	public WebElement getSuppStartDateEle() {
		return suppStartDateEle;
	}

	public WebElement getSuppEndDateEle() {
		return suppEndDateEle;
	}
	
	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getButtonEle() {
		return buttonEle;
	}
	
	//Business Logic
	
	public void createContact(WebDriver driver, String lastName) {
		lastNameEdit.sendKeys(lastName);// getting the data from test script (excel+random int)
		buttonEle.click();
	}
	
	public void createContactWithSupportDate(WebDriver driver,String  lastName, String startDate, String endDate) {
		lastNameEdit.sendKeys(lastName);// getting the data from test script (excel+random int)
		suppStartDateEle.clear();
		suppStartDateEle.sendKeys(startDate);
		suppEndDateEle.clear();
		suppEndDateEle.sendKeys(endDate);
		buttonEle.click();
	}
	
	public void createContactWithOrg(WebDriver driver,String lastName, String startDate, String orgName) {
		lastNameEdit.sendKeys(lastName);
		plusIcon.click();
		
		// switch to child window
		switchToTabOnURL(driver,"partialURL");

		searchTF.sendKeys(orgName);

		searchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		
		// switch to parent window
		switchToTabOnURL(driver, "Contacts&action");
		buttonEle.click();
	}
	
}
