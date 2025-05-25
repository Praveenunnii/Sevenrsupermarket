package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	
	WebDriver driver;
	Properties properties = new Properties();
	@FindBy(xpath=("//input[@placeholder='Username']"))
	WebElement userNameField;
	@FindBy(xpath=("//input[@placeholder='Password']"))
	WebElement passwordField;
	@FindBy(xpath=("//button[contains(text(),'Sign In')]"))
	WebElement singInButton;
	@FindBy(xpath=("//div[@class='alert alert-danger alert-dismissible']"))
	WebElement inValidLoginAlert;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickOnSignInButton()
	{
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.elementToBeClickable(singInButton, 30);
		singInButton.click();
	}
	
	public void login(String userName, String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}
	
	public void login()
	{
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}		
	
	public void inValidLogin()
	{
		 String userName = "admin";
		 String password = "123";
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}
	
	public String alertMessage()
			{
		       return inValidLoginAlert.getText();
			}
}
