package com.selenium.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	@Test
	public void testGoogle(){
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=jBSrV-LkFq_98weZjLKwBA&gws_rd=ssl");
		System.out.println("URL entered");
		driver.quit();
	}

}


