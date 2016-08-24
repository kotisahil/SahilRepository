package com.implement.project;
/**
 * 
 */
/**
 *  * @author Admin
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.project.PageObjectModel;

public class POMTestCase {

	private static WebDriver driver = null;

	@BeforeMethod
	public void OpenDriver()
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test     
	public void ExcuteScript() throws Exception {
		PageObjectModel p = new PageObjectModel(driver);
		PageObjectModel.openUrl();
		PageObjectModel.maximizeWindow();
		PageObjectModel.printUrl();
		PageObjectModel.clickFlightTicket();
		PageObjectModel.handleWindow(); 
		PageObjectModel.fromCity();
		PageObjectModel.toCity();
		PageObjectModel.Close_btn();
		PageObjectModel.departureDate();
		PageObjectModel.totalMembers();
		PageObjectModel.clickSearchButton();
		PageObjectModel.totalFlightCount();

		driver.close();
		driver.quit();

		//driver.quit();

	}

}



