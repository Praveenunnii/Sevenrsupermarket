package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	
	LoginPage loginpage;
	DashBoardPage dashboardPage;
	ExcelReader excelreader;
	
	@Test(groups="login")
	public void verifyValidLogin()
	{
		loginpage = new LoginPage(driver);
		dashboardPage = loginpage.login();
		String actualProfileName = dashboardPage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
	}
	
	@Test//(groups="invalidlogin")
	public void verifyInvalidLogin()
	{
		loginpage = new LoginPage(driver);
		loginpage.inValidLogin();
		Assert.assertTrue(loginpage.inValidAlertMessage());
	}

}
