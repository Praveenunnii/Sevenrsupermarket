package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	
	WebDriver driver;
	@FindBy(xpath=("//h1[text()='Admin Users']"))
	WebElement adminUser;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getAdminUserNameText()
	{
		return adminUser.getText();
	}
	
	
	
		

}
