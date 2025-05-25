package com.sevenrmartsupermarket.utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	//this class used to scroll and click
	
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	
	public PageUtility(WebDriver driver)
	{
		this.driver = driver;
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	
	public void selectByIndex(WebElement element, int index)
	
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	//scroll and click using js
	
	public void scrollAndClick(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();",element);
	}

}
