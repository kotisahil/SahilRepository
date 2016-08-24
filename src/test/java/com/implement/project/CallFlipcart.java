package com.implement.project;
import com.selenium.project.FlipcartRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.project.FlipcartRandom;
import com.selenium.project.Resman_FillExcel;

public class CallFlipcart {

	WebDriver driver;

	@BeforeMethod	
	public void intializeDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void callFlipcart_run() throws Exception
	{	
		FlipcartRandom call= new FlipcartRandom(driver);
		call.openUrl();
		call.maximizeWindow();
		call.printUrl();
		call.searchKeyword();
		call.search();
		call.click_random_product();
		call.select_random_size();
		call.add_to_cart();
		call.visit_cart();
		call.remove_product();
		call.print_message();

	}

	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();	
	}

}
