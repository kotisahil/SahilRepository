package com.selenium.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class DatadrivenDataprovider {

	private By Username=By.xpath("//input[@id='user_login']");
	private By Password=By.xpath("//input[@id='user_pass']");
	private By LoginButton=By.xpath("//input[@id='wp-submit']");

	WebDriver driver;
	public DatadrivenDataprovider(WebDriver driver){
		this.driver=driver;
	}

	public void openURL()
	{
		String WordPress_Url = "https://wordpress.com/wp-login.php?";
		driver.get(WordPress_Url);		
	}

	public void maximizeWindow()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	}

	public void printUrl()
	{
		driver.getCurrentUrl();
		System.out.println("The current url is:" + driver.getCurrentUrl());
	}

	public void enterUsername(String username)
	{
		driver.findElement(Username).sendKeys(username);	
	}

	public void enterPassword(String password)
	{
		driver.findElement(Password).sendKeys(password);
	}

	public void clickLoginButton()
	{
		WebElement login_btn=driver.findElement(LoginButton);
		login_btn.click();
	}

}

