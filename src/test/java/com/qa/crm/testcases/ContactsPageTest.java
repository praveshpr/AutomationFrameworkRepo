package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

public class ContactsPageTest extends TestBase{

	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initateBrowser();
		testUtil = new TestUtil();
		 loginPage = new LoginPage();
		 contactsPage = new ContactsPage();
		 homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		 testUtil.switchToFrame();
		 contactsPage = homePage.clickOnContactsLink();
		 
	}
	
	@Test(priority = 1)
	public void verifyContactsLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing on gthe page");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
}
