package com.selenium.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailSendMail 
{

	private WebDriver driver;
	private  By EMAIL_BTN=By.xpath("//input[@id='Email']");
	private  By NEXT_BTN=By.xpath("//input[@id='next']");
	private  By PASSWRD_TXTBOX=By.xpath("//input[@id='Passwd']");		 
	private  By SIGNIN_BTN=By.xpath("//input[@id='signIn']");
	private  By GOOGLEAPPS_BTN=By.xpath("//a[@title='Google apps']");
	private  By GMAIL_ICON=By.xpath("//a[@id='gb23']/span[1]");
	private  By COMPOSE_BTN=By.xpath("//div[@class='z0']/div[1]"); 
	private  By TO_TXTFIELD=By.xpath("//textarea[@id=':92']");
	private  By SUBJECT_TXTFIELD=By.xpath("//input[@id=':8m']");
	private  By MAILBODY_TXTFIELD=By.xpath("//div[@id=':9r']");
	private  By SEND_BTN=By.xpath("//div[@id=':8c']");
	
	//ExcelConfiguration excel=new ExcelConfiguration("C:\\Selenium\\Excelsheet\\Excelsheet0.xlsx");

	public GmailSendMail(WebDriver driver)
	{
		this.driver=driver;
	}

	public void openUrl()
	{	
		String gmail_URL = "https://accounts.google.com/";
		driver.get(gmail_URL);
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

	public void enterEmail() throws Exception
	{
		WebElement email_txt=driver.findElement(EMAIL_BTN);
		email_txt.clear();
		Thread.sleep(2000);
		email_txt.sendKeys("sahilk.gspann");
	}

	public void clickNext() throws Exception
	{
		WebElement next_btn=driver.findElement(NEXT_BTN);
		next_btn.click();
		Thread.sleep(10000);
	}

	public void enterPassword() throws Exception
	{
		
		WebElement password_txt=driver.findElement(PASSWRD_TXTBOX);
		password_txt.sendKeys("seleniumtest");
	}

	public void signIn() throws Exception
	{
		WebElement signIn_btn=driver.findElement(SIGNIN_BTN);
		signIn_btn.click();
		Thread.sleep(20000);
	}
	
	public void clickGoogleApps()
	{
		WebElement googleapps=driver.findElement(GOOGLEAPPS_BTN);
		googleapps.click();
	}
	
	public void clickGmailIcon() throws Exception
	{
		WebElement gmailIcon=driver.findElement(GMAIL_ICON);
		gmailIcon.click();
		Thread.sleep(10000);
	}

	public void clickCompose() throws Exception
	{
		WebElement compose_btn=driver.findElement(COMPOSE_BTN);
		compose_btn.click();
		Thread.sleep(10000);
	}
	
	public void mailTo() throws Exception
	{
		WebElement mail_to=driver.findElement(TO_TXTFIELD);
		mail_to.sendKeys("shubham.mathur@gspann.com");
		Thread.sleep(10000);
	}

	public void mailSubject() throws Exception
	{
		WebElement subject=driver.findElement(SUBJECT_TXTFIELD);
		subject.sendKeys("Automated-Gmail Mail Send");
		Thread.sleep(10000);
	}
	
	public void mailBody() throws Exception
	{
		WebElement mail_content=driver.findElement(MAILBODY_TXTFIELD);
		mail_content.sendKeys("Hi Shubham," + "\n" + "Thanks very much for teaching Selenium");
		Thread.sleep(10000);
	}
	
	public void sendMail()
	{
		WebElement send=driver.findElement(SEND_BTN);
		send.click();
	}
		
}

