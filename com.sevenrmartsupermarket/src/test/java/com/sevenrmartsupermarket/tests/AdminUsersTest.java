package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class AdminUsersTest extends Base {

	LoginPage loginpage;
	DashBoardPage dashboardPage;
	AdminUsersPage adminuserpage;
	ExcelReader excelreader = new ExcelReader();

	@Test
	public void verifyAbletoAddNewUser() {
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		dashboardPage = loginpage.login();
		dashboardPage.clickOnMoreInfo();
		adminuserpage.clickOnNewButton();
		adminuserpage.addNewUser("NewUser12345", "password");
		Assert.assertTrue(adminuserpage.getAddSuccessAlertMessage());
	}
	
	@Test
	public void verifyAbleToAddNewUserFromExcel()
	{
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		dashboardPage = loginpage.login();
		dashboardPage.clickOnMoreInfo();
		adminuserpage.clickOnNewButton();
		excelreader.setExcelFile("AdminUserTestData");
		String userName = excelreader.getCellData(1, 0);
		String password = excelreader.getCellData(1, 1);
		adminuserpage.addNewUser(userName, password);
		Assert.assertTrue(adminuserpage.getAddSuccessAlertMessage());
		
	}

}
