package com.implement.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.project.WordpressReadExcel;
import com.library.selenium.ExcelConfiguration;

public class ReadExcel_TC {

	WebDriver driver;

	@BeforeMethod	
	public void intializeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider="dataPassed")
	public void logintoWordPress(String username, String password)
	{	
		WordpressReadExcel execute= new WordpressReadExcel(driver);
		execute.openURL();
		execute.maximizeWindow();
		execute.printUrl();
		execute.enterUsername(username);
		execute.enterPassword(password);
		execute.clickLoginButton();
	}

	@DataProvider(name="dataPassed")
	public Object[][] passdata()
	{

		ExcelConfiguration excel=new ExcelConfiguration("C:\\Selenium\\Excelsheet\\Excelsheet.xlsx");
		int rows=excel.getRowCount(0);
		
		Object [][] data=new Object[rows][2];
		for (int i = 0; i<rows; i++)
		{
			data[i][0]=excel.getdata(0, i, 0);
			data[i][1]=excel.getdata(0, i, 1);

		}

		return data;
	}

	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();	
	}


}
