package com.implement.project;

import com.selenium.project.GmailSendMail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendmailGmail {

	WebDriver driver;

	@BeforeMethod	
	public void intializeDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void mailSent_run() throws Exception
	{	
		GmailSendMail mail= new GmailSendMail(driver);
		mail.openUrl();
		mail.maximizeWindow();
		mail.printUrl();
		mail.enterEmail();
		mail.clickNext();
		mail.enterPassword();
		mail.signIn();
		mail.clickGoogleApps();
		mail.clickGmailIcon();
		mail.clickCompose(); 
		mail.mailTo();
		mail.mailSubject();
		mail.mailBody();
		mail.sendMail();
	}

	@AfterMethod
		public void CloseBrowser()
		{
			driver.quit();	
		}
	 
}
