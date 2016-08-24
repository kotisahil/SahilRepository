package com.implement.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.project.Resman_FillExcel;
import com.selenium.project.WordpressReadExcel;
import com.library.selenium.ExcelConfiguration;
import com.library.selenium.CaptureScreenShot;

public class Execute_Resman {

	WebDriver driver;

	@BeforeMethod	
	public void intializeDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void registerResman() throws Exception
	{	
		Resman_FillExcel run= new Resman_FillExcel(driver);
		run.openUrl();
		run.maximizeWindow();
		run.printUrl();
		run.clickbuttonFresher();
		run.enterName();
		run.enterEmailId();
		run.enterPassword();
		run.clickShowbutton();
		run.enterMobile();
		run.clickCity();
		run.enterCityvalue();
		run.uploadCV();
		run.registerNow();
		run.printresult();
	}

	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();	
	}

}
