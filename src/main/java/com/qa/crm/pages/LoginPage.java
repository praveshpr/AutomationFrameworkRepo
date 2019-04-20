package com.qa.crm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class LoginPage extends TestBase {
	
	//OR
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//initalization of page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions 
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String userName, String password) throws InterruptedException
	{
		
		
		username.sendKeys(userName);
		pass.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", loginBtn);
		loginBtn.click();
		return new HomePage();
		
	}
	


}
