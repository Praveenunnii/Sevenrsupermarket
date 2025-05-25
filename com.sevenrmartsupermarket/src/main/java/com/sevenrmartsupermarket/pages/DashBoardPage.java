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
	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-danger']"))
	WebElement newButton;
	@FindBy(xpath = ("//input[@id='username']"))
	WebElement userNamefield;
	@FindBy(xpath = ("//input[@id='password']"))
	WebElement passwordfield;
	@FindBy(xpath = ("//select[@id='user_type']"))
	WebElement userType;
	@FindBy(xpath = ("(//button[@class='btn btn-block-sm btn-danger'])[2]"))
	WebElement saveButton;
	@FindBy(xpath=("//div[@class='alert alert-success alert-dismissible']"))
	WebElement addSuccessAlertMessage;
	@FindBy(xpath=("(//i[@class='fas fa-trash-alt'])[1]"))
	WebElement deleteButton;
	@FindBy(xpath=("//div[@class='alert alert-success alert-dismissible']"))
	WebElement deleteSuccessAlertMessage;

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

	public void clickOnNewButton() {
		newButton.click();
	}

	public void enterNewUserName(String userName) {
		userNamefield.sendKeys(userName);
	}

	public void enterNewPassword(String password) {
		passwordfield.sendKeys(password);
	}

	public void selectUserType() {
		Select select = new Select(userType);
		select.selectByVisibleText("Admin");
	}

	public void addNewUser() {
		String userName = "NewUser123";
		String password = "password";
		enterNewUserName(userName);
		enterNewPassword(password);
		selectUserType();
		saveButton.click();
	}
	
	public String getAddSuccessAlertMessage()
	{
		return addSuccessAlertMessage.getText();
	}
	
	public void clickOnDeleteButton()
	{
		deleteButton.click();
	}
	
	public String getDeleteSuccessAlertMessage()
	{
		return deleteSuccessAlertMessage.getText();
	}

}
