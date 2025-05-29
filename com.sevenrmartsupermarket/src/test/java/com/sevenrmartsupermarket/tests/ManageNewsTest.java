package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.dataprovider.DataProviders;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;

public class ManageNewsTest extends Base {
	
	LoginPage loginpage;
	DashBoardPage dashboardPage;
	ManageNewsPage managenewspage;
	
	@Test 
	public void verifyManageNewsPageIsLoading()
	{
		loginpage = new LoginPage(driver);
		managenewspage = new ManageNewsPage(driver);
		dashboardPage = loginpage.login();
		dashboardPage.clickOnManageNewsMenuOption();
		String actualHeading = managenewspage.getManageNewsHeading();
		String expectedHeading ="Manage News";
		Assert.assertEquals(actualHeading, expectedHeading);
	}
	
	@Test (dataProvider ="Manage News",dataProviderClass=DataProviders.class)
	public void verifyAbleToAddNew(String data)
	{
		loginpage = new LoginPage(driver);
		managenewspage = new ManageNewsPage(driver);
		dashboardPage = loginpage.login();
		dashboardPage.clickOnManageNewsMenuOption();
		managenewspage.clickOnNewButton().createNews(data).clickOnSaveButton();
		Assert.assertTrue(managenewspage.getAddNewsAlertMessage());
		
	}

}
