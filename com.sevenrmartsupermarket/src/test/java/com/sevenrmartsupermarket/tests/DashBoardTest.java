package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashBoardTest extends Base {
	
	LoginPage loginpage;
	DashBoardPage dashboardPage;
	AdminUsersPage adminuserpage;
	
	@Test(groups="adminpage")
	public void verifyMoreInfoIsClickable()
	{
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		dashboardPage = new DashBoardPage(driver);
		loginpage.login();
		dashboardPage.clickOnMoreInfo();
		String actualText = adminuserpage.getAdminUserNameText();
		String expectedText = "Admin Users";
		Assert.assertEquals(actualText, expectedText);
		
	}
	@Test
	public void verifyAbletoAddNewUser()
	{
		loginpage = new LoginPage(driver);
		dashboardPage = new DashBoardPage(driver);
		loginpage.login();
		dashboardPage.clickOnMoreInfo();
		dashboardPage.clickOnNewButton();
		dashboardPage.addNewUser();
		String actualAddSuccessAlertMessage = dashboardPage.getAddSuccessAlertMessage();
		System.out.println(actualAddSuccessAlertMessage);
		String expectedAddSuccessAlertMessage = "×\r\n"
				+ "Alert!\r\n"
				+ "User Created Successfully";
		Assert.assertEquals(actualAddSuccessAlertMessage, expectedAddSuccessAlertMessage);
	}
	
	@Test
	public void verifyAbleToDeleteUser()
	{
		loginpage = new LoginPage(driver);
		dashboardPage = new DashBoardPage(driver);
		loginpage.login();
		dashboardPage.clickOnMoreInfo();
		dashboardPage.clickOnDeleteButton();
		String actualDeleteSuccessAlertMessage = dashboardPage.getDeleteSuccessAlertMessage();
		System.out.println(actualDeleteSuccessAlertMessage);
	}

}
