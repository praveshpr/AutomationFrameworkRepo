package com.qa.crm.util;

import com.qa.crm.base.TestBase;

public class TestUtil extends TestBase{
	
	public static int PAGE_LOAD_TIMEOUT = 60;
	public static int IMPLICIT_WAIT = 120;

	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
}
