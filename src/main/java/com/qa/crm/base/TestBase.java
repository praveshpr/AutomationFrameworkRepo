package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.crm.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	String currentDir =  System.getProperty("user.dir");
	String inputFile = currentDir + "/" +"src/main/java/com/qa/crm/config/config.properties";
	
	public TestBase() 
	{
		prop = new Properties();
		FileInputStream input;
		try {
			input = new FileInputStream(inputFile);
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void initateBrowser()
	{
		String browserName = prop.getProperty("browser");
		//String chromeDriver = prop.getProperty("chromeDriver");
		String ghecoDriver = prop.getProperty("gheckDriver");
		String appUrl = prop.getProperty("url");
		String chromeDriver = "J:\\chromedriver\\chromedriver.exe";
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gheco.drive",ghecoDriver);
			driver = new FirefoxDriver();
		}
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.drive", "J:/chromedriver/chromedriver.exe" );
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, 	TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(appUrl);

}
	

}
