package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

// to retrieve data
public class GeneralUtility {
	
	public String get_Attribute(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);
	}
	
	public String get_CSSValue(WebElement element,String cssProperty)
	{
		return element.getCssValue(cssProperty);
	}
	
	public List<String> getTextofElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();

		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}
	
	public boolean isDataPresent(WebElement element, String data)
	{
		return element.getText().contains(data); 
	}

}
