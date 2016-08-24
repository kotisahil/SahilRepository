package com.selenium.project;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class CreateAccount {

	@Test
	public void CreateTest()

	{
		//WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String Gmail_URL = "https://accounts.google.com/AccountChooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail&scc=1";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		//	        driver.manage().deleteAllCookies();

		driver.get(Gmail_URL);

		System.out.println("************************************************");

		driver.manage().window().maximize();

		//	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		String title = driver.getTitle();
		System.out.println("Title is "+title);

		//	        driver.getPageSource();

		String url = driver.getCurrentUrl();
		System.out.println("URL is "+url);

		//WebElement AddAcc_hyperlink= driver.findElement(By.xpath("//a[@id='account-chooser-add-account']"));
		//AddAcc_hyperlink.click();

		WebElement CreateAcc_hyperlink= driver.findElement(By.xpath("//span[@id='link-signup']/a"));
		CreateAcc_hyperlink.click();

		WebElement FirstName_txt_box= driver.findElement(By.xpath("//input[@id='FirstName']"));
		FirstName_txt_box.click();
		FirstName_txt_box.sendKeys("Sahil");

		WebElement LastName_txt_box= driver.findElement(By.xpath("//input[@id='LastName']"));
		LastName_txt_box.click();
		LastName_txt_box.sendKeys("Kumar");

		WebElement GmailAddress_txt_box= driver.findElement(By.xpath("//input[@id='GmailAddress']"));
		GmailAddress_txt_box.click();
		GmailAddress_txt_box.sendKeys("kumarasahiiiii");

		WebElement Password_txt_box= driver.findElement(By.xpath("//input[@id='Passwd']"));
		Password_txt_box.click();
		Password_txt_box.sendKeys("jaimatadi111000");

		WebElement ConfirmPassword_txt_box= driver.findElement(By.xpath("//input[@id='PasswdAgain']"));
		ConfirmPassword_txt_box.click();
		ConfirmPassword_txt_box.sendKeys("jaimatadi111000");

		//Select dropdown=new Select(driver.findElement(By.xpath("//span[@id='BirthMonth']/div[1]")));
		//dropdown.selectByVisibleText("October");

		WebElement Month_dropdown=driver.findElement(By.xpath("//span[@id='BirthMonth']/div[1]"));
		Month_dropdown.click();
		WebElement Month_Value=driver.findElement(By.xpath("//div[@id=':7']/div"));
		Month_Value.click();

		WebElement day_txtbox= driver.findElement(By.xpath("//input[@id='BirthDay']"));

		if(day_txtbox.isDisplayed())
		{
			System.out.println("working fine");
			//day_txtbox.click();
			day_txtbox.sendKeys("14");
		}
		//day_txtbox.click();

		WebElement Year_txt_box= driver.findElement(By.xpath("//input[@id='BirthYear']"));
		Year_txt_box.click();
		Year_txt_box.sendKeys("1987");

		WebElement gender=driver.findElement(By.xpath("//div[@id='Gender']/div"));
		gender.click();
		WebElement gender_value=driver.findElement(By.xpath("//div[@id='Gender']//div[text()= 'Male']"));
		gender_value.click();

		WebElement Mobile_txt_box= driver.findElement(By.xpath("//input[@id='RecoveryPhoneNumber']"));
		//Mobile_txt_box.click();
		Mobile_txt_box.sendKeys("9811909091");

		WebElement EmailAddress_txt_box= driver.findElement(By.xpath("//input[@id='RecoveryEmailAddress']"));
		//EmailAddress_txt_box.click();
		EmailAddress_txt_box.sendKeys();

		WebElement SkipVerification_checkbox= driver.findElement(By.xpath("//input[@id='SkipCaptcha']"));
		SkipVerification_checkbox.click();

		//Select gender= new Select(driver.findElement(By.xpath("//div[@id='Gender']/div[1]")));
		//gender.selectByVisibleText("Male");

		WebElement IAgree_checkbox= driver.findElement(By.xpath("//input[@id='TermsOfService']"));
		IAgree_checkbox.click();

		WebElement NextStep_btn= driver.findElement(By.xpath("//input[@id='submitbutton']"));
		NextStep_btn.click();

		driver.close();
		driver.quit();

	}	

}


