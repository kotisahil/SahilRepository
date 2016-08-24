package com.selenium.project;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssertionPart2 {

	@Test
	public void Tab3() throws InterruptedException, IOException
	{	

		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//WebDriver driver= new FirefoxDriver();
		String Toolsqa_iframeURL = "http://toolsqa.com/iframe-practice-page/";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 

		driver.get(Toolsqa_iframeURL);
		System.out.println("The current url is:" + driver.getCurrentUrl());

		Thread.sleep(2000);
		WebElement frame1 = driver.findElement(By.id("IF2"));
		driver.switchTo().frame(frame1);
		System.out.println("Navigated to frame with name " + frame1);

		/*WebElement Tab = driver.findElement(By.xpath("//ul[@id='tab_ul']/li[3]"));
		((JavascriptExecutor) driver).executeScript(
               "arguments[0].scrollIntoView();", Tab);*/


		Thread.sleep(2000);
		//WebElement Tab3=driver.findElement(By.xpath("//ul[@id='tab_ul']/li[3]"));
		//Tab3.click();

		/*WebElement we = driver.findElement(By.xpath("//ul[@id='tab_ul']/li[3]/a"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click", we);*/
		//		driver.findElement(By.xpath("//a[@id='ui-id-3']")).click();
		//		System.out.println("tab 3 clicked");
		//Thread.sleep(5000);
		//Actions action = new Actions(driver);
		//action.doubleClick(we).build().perform();

		String Actual_Result = driver.findElement(By.xpath("//div[@id='tabs-3']/b")).getText();
		System.out.println("The Actual Result is:" + Actual_Result);

		Assert.assertEquals(Actual_Result, "Content 3 Title"); 
		System.out.println("Actual Result is equal to the Expected Result");

	}
}