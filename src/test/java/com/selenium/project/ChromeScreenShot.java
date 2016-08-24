package com.selenium.project;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeScreenShot {

	WebDriver driver;


	public void intializeDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	public void step1()
	{
		driver.get("https://www.macys.com");	
		//driver.manage().window().maximize();	
		driver.getCurrentUrl();
		driver.getTitle();	
	}


	/*public void takescreenShot() throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/screenshot.png"));
		//System.out.println("ScreenShot is taken");
	}*/


	public void step2() throws Exception
	{
		JavascriptExecutor exe =(JavascriptExecutor)driver;
		exe.executeScript("window.scrollTo(0,0)");
		Boolean condition =(Boolean)exe.executeScript("return document.documentElement.scrollHeight > document.documentElement.clientHeight");
		Long ScrollH =(Long)exe.executeScript("return document.documentElement.scrollHeight");
		Long ClientH =(Long)exe.executeScript("return document.documentElement.clientHeight");
		int index = 1;
		if (condition.booleanValue()){
			while(ScrollH.intValue() > 0)
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshots/screenshot"+ index +".png"));
				exe.executeScript("window.scrollTo(0,"+ ClientH * index + ")");
				ScrollH = ScrollH - ClientH;
				Thread.sleep(3000);	
				index++;
			}
		}	
		else		
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/screenshot0.png"));
		}

	}

	@Test
	public void call() throws Exception
	{
		intializeDriver();
		step1();
		step2();
	}

}
