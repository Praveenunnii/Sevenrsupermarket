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
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getAdminUserNameText()
	{
		return adminUser.getText();
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

	public void addNewUser(String userName, String password) {
		enterNewUserName(userName);
		enterNewPassword(password);
		selectUserType();
		saveButton.click();
	}
	
	public boolean getAddSuccessAlertMessage()
	{
		 boolean message = addSuccessAlertMessage.getText().contains("User Created Successfully");
		 return message;
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
