package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class DashBoardTest extends Base {
	
	LoginPage loginpage;
	DashBoardPage dashboardPage;
	AdminUsersPage adminuserpage;
	
	@Test(retryAnalyzer =RetryAnalyzer.class)
	public void verifyMoreInfoIsClickable()
	{
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		dashboardPage = loginpage.login();
		dashboardPage.clickOnMoreInfo();
		String actualText = adminuserpage.getAdminUserNameText();
		String expectedText = "Admin Userss";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test
	public void verifyIsAbleToLogout()
	{
		loginpage = new LoginPage(driver);
		dashboardPage = loginpage.login();
		dashboardPage.clickOnAdminIcon();
		dashboardPage.clickOnLogoutButton();
		String actualText = dashboardPage.loginPageHeading();
		String expectedText = "7rmart supermarket";
		Assert.assertEquals(actualText,expectedText);
	}
	
	@Test
	public void demoTest()
	{
		System.out.println(GeneralUtility.getRandomName());
	}
}
