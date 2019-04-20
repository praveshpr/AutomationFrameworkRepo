package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath= "//td[contains(text(),'User: pravesh kumar prajapati')]")
	WebElement userNameLabel;
	
	@FindBy(xpath= "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath= "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath= "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath= "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
		
	}
	
	
	public  boolean verifyUserLoggedIn()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}

	
	public TaskPage clickOnTaskLink()
	{
		dealsLink.click();
		return new TaskPage();
	}
}
