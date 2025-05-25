package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginTest extends Base {
	
	LoginPage loginpage;
	DashBoardPage dashboardPage;
	ExcelReader excelreader;
	
	@Test(groups="login")
	public void verifyValidLogin()
	{
		loginpage = new LoginPage(driver);
		dashboardPage = new DashBoardPage(driver);
		loginpage.login();
		String actualProfileName = dashboardPage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}
	
	@Test(groups="invalidlogin")
	public void verifyInvalidLogin()
	{
		loginpage = new LoginPage(driver);
		loginpage.inValidLogin();
		String actualAlertMessage = loginpage.alertMessage();
		//System.out.println(actualAlertMessage);
		String expectedAlertMessage ="×\r\n"
				+ "Alert!\r\n"
				+ "Invalid Username/Password";
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}
		
	
	
	
	/* @Test
	public void dummyTestCase()
	{
		excelreader.setExcelFile("AdminUserTestdata");
		String data = excelreader.getCellData(1, 1);
		System.out.println(data);
		Assert.assertTrue(false);
	}  */

}
