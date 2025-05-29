package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DashBoardPage {

	WebDriver driver;
	@FindBy(xpath = ("//a[@class='d-block']"))
	WebElement profileName;
	@FindBy(xpath = ("(//p[text()='Admin Users']//following::a[@class='small-box-footer'])[1]"))
	WebElement moreInfo;
	@FindBy(xpath=("(//p[contains(text(),'Manage News')])[1]"))
	WebElement manageNewsOption;
	@FindBy(xpath=("(//a[@class='nav-link'])[2]"))
	WebElement adminIcon;
	@FindBy(xpath=("(//a[@class='dropdown-item'])[2]"))
	WebElement logoutButton;
	@FindBy(xpath=("//b[contains(text(),'7rmart supermarket')]"))
	WebElement loginPageHeader;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public void clickOnMoreInfo() {
		moreInfo.click();
	}
	
	public void clickOnManageNewsMenuOption()
	{
		manageNewsOption.click();
	}
	
	public void clickOnAdminIcon()
	{
		adminIcon.click();
	}
	
	public void clickOnLogoutButton()
	{
		logoutButton.click();
	}
	
	public String loginPageHeading()
	{
		return loginPageHeader.getText();
	}

}
