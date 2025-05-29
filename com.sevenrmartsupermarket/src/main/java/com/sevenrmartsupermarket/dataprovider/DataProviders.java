package com.sevenrmartsupermarket.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Manage News")
	public Object[][]productsSearch()
	{
		return new Object [][] {{"National News"},{"International News"},{"Local News"}};
	}

}
