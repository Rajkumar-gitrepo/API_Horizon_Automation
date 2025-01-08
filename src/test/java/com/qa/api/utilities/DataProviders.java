package com.qa.api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//Getting complete data from Excel sheet
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path = "./TestData/Userdata.xlsx";
		
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String apiData[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apiData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return apiData;
	}
	
	
	//Getting only Usernames from Excel file
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
        String path = "./TestData/Userdata.xlsx";
	
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		
		String apiData[] = new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
			apiData[i-1] = XLUtils.getCellData(path, "Sheet1", i, 1);
		}
		return apiData;
	}
}
