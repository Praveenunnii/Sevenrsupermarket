package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver;
	@FindBy(xpath=("//h1[contains(text(),'Manage News')]"))
	WebElement manageNewsHeading;
	@FindBy(xpath=("//a[@class='btn btn-rounded btn-danger']"))
	WebElement newButton;
	@FindBy(xpath=("//textarea[@id='news']"))
	WebElement textField;
	@FindBy(xpath=("//button[@class='btn btn-danger']"))
	WebElement saveButton;
	@FindBy(xpath=("//div[@class='alert alert-success alert-dismissible']"))
	WebElement alertMessage;
	
	
	public ManageNewsPage(WebDriver driver)
	{
	   this.driver = driver;
	   PageFactory.initElements(driver,this);
	}
	
	public String getManageNewsHeading()
	{
		return manageNewsHeading.getText();
	}
	
	public ManageNewsPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	
	public ManageNewsPage createNews(String news)
	{
		textField.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	
	public boolean getAddNewsAlertMessage()
	{
		 boolean message = alertMessage.getText().contains("News Created Successfully");
		 return message;
	}
}
