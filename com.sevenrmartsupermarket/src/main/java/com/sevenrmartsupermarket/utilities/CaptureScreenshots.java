package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class CaptureScreenshots {
	
	TakesScreenshot takesscreenshot; // interface used to capture screenshots
	
	public void takeScreenShot(WebDriver driver, String imageName)
	{
		try {
			takesscreenshot = (TakesScreenshot) driver;
			File screenShot = takesscreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); // capture SS
			String path = Constants.SCREENSHOTS_FILE_PATH + imageName + "-"+ timeStamp + ".png"; // saves in this
			File destination = new File(path);
			FileHandler.copy(screenShot, destination); // to move the file and store
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
