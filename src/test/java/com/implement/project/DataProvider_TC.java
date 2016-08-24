package com.implement.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.project.DatadrivenDataprovider;

public class DataProvider_TC  {

	WebDriver driver;

	@BeforeMethod	
	public void intializeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider="dataPassed")
	public void loginToWordPress(String username, String password)
	{	
		DatadrivenDataprovider execute= new DatadrivenDataprovider(driver);
		execute.openURL();
		execute.maximizeWindow();
		execute.printUrl();
		execute.enterUsername(username);
		execute.enterPassword(password);
		execute.clickLoginButton();
	}

	@DataProvider(name="dataPassed")
	public Object[][] enterData()
	{

		Object [][] data=new Object[3][2];
		data[0][0]="testing3195";
		data[0][1]="P@ssw0rd";

		data[1][0]="testing3195";
		data[1][1]="P@ssw0rd";

		data[2][0]="engineer7095";
		data[2][1]="P@ssw0rd";

		return data;

	}

	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();	
	}

}
