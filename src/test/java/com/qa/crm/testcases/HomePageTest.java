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

public class HomePageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	public HomePageTest()
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
		 
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitlTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO" , "Title does not match");
	}
	
	@Test(priority = 2)
	public void verifyUserLoggedInTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserLoggedIn());
	}
	
	
	@Test(priority = 3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
