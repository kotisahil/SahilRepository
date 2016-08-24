package com.selenium.project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	WebDriver driver;

	public void intializeDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void step2()
	{
		driver.get("https://www.google.com");	
		//driver.manage().window().maximize();	
		driver.getCurrentUrl();
		driver.getTitle();	
	}

	public void takescreenShot() throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/sample.png"));

		System.out.println("Screenshot is printed");
	}

	public static void main (String Args[]) throws Exception
	{
		ScreenShot sc=new ScreenShot();
		sc.intializeDriver();
		sc.step2();
		sc.takescreenShot();
	}	

}
