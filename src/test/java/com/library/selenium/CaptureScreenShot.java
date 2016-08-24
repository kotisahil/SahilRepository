package com.library.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot {

	/*public CaptureScreenShot(WebDriver driver) {
		this.driver = driver;
	}*/

	public static void takescreenShot( WebDriver driver)
	{
		try 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/screenshot.png"));
			//FileUtils.copyFile(source, new File("./Screenshots/screenshot1.png"));

				
			
			System.out.println("Screenshot is printed");
		} 
		catch (Exception e) {
			System.out.println("Exception is handled");
			e.getMessage();
		}
	}

}



