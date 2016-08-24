package com.selenium.project;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.library.selenium.ExcelConfiguration;
import com.library.selenium.CaptureScreenShot;

public class Resman_FillExcel{

	private WebDriver driver;

	private  By FRESHER_BUTTON=By.xpath("//div[@id='alert']/following::div[3]/button");
	private  By NAME_TXTBOX=By.xpath("//input[@id='fname']");
	private  By EMAIL_TXTBOX=By.xpath("//input[@id='email']");		 
	private  By PASSWORD_TXTBOX=By.xpath("//span[@id='password_err']//preceding::input[1]");
	private  By MOBILE_TXTBOX=By.xpath("//input[@id='mobile']/preceding::input[1]");
	private  By SHOW_BUTTON=By.xpath("//span[@id='password_err']/preceding::a[1]");
	private  By CITY_DROPDOWN=By.xpath("//form[@id='basicDetailForm']/resman-location/div/div/div[1]/div/div[1]/ul/li/div/label/input");
	private  String CITY_VALUE="//span[text()='%s']";
	private  By UPLOAD_CV_BTN=By.xpath("//span[@class='uploadCV']");
	private  By REGISTER_BTN=By.xpath("//span[@id='term_err']/following::div[1]/button");
	private  By PERSONAL_TXT=By.xpath("//div[@id='banner']/child::*[2]/li[1]/div");

	ExcelConfiguration excel=new ExcelConfiguration("C:\\Selenium\\Excelsheet\\Excelsheet0.xlsx");

		public Resman_FillExcel(WebDriver driver){
			this.driver=driver;
	}

	public void openUrl()
	{	
		String Naukri_URL = "http://my.naukri.com/account/createaccount";
		driver.get(Naukri_URL);
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

	public void clickbuttonFresher() throws Exception
	{
		WebElement Fresher_btn=driver.findElement(FRESHER_BUTTON);	
		Fresher_btn.click();
		Thread.sleep(5000);
	}

	public void enterName()	
	{
		WebElement name_txt=driver.findElement(NAME_TXTBOX);
		String name=excel.getdata(0, 1, 0);
		name_txt.sendKeys(name);
		//CaptureScreenShot.takescreenShot(driver);
	}

	public void enterEmailId()
	{
		WebElement emailId_txt=driver.findElement(EMAIL_TXTBOX);
		String email=excel.getdata(0, 1, 1);
		emailId_txt.sendKeys(email);
		//CaptureScreenShot.takescreenShot(driver);
	}

	public void enterPassword() throws Exception
	{
		WebElement password_txt=driver.findElement(PASSWORD_TXTBOX);
		String password=excel.getdata(0, 1, 2);
		password_txt.sendKeys(password);
		Thread.sleep(5000);
		//CaptureScreenShot.takescreenShot(driver);
	}

	public void clickShowbutton()
	{
		WebElement show_button=driver.findElement(SHOW_BUTTON);
		show_button.click();
	}

	public void enterMobile()
	{
		WebElement mobile_txt=driver.findElement(MOBILE_TXTBOX);
		String mobile=excel.getdata(0, 1, 3);
		mobile_txt.sendKeys(mobile);
		//CaptureScreenShot.takescreenShot(driver);
	}		

	public void clickCity()
	{
		WebElement city_dropdwn=driver.findElement(CITY_DROPDOWN);
		city_dropdwn.click();
	}

	public void enterCityvalue() throws Exception
	{
		String city_value=excel.getdata(0, 1, 4);
		List<WebElement> city_dropdwn_value=driver.findElements(By.xpath(String.format(CITY_VALUE, city_value)));
		city_dropdwn_value.get(1).click();
		Thread.sleep(10000);
		//CaptureScreenShot.takescreenShot(driver);
	}

	public void uploadCV() throws Exception
	{
		WebElement upload_cv_button=driver.findElement(UPLOAD_CV_BTN);
		upload_cv_button.click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\AutoITScript\\NewScript\\ScriptUpload.exe");	
		//CaptureScreenShot.takescreenShot(driver);
	}

	public void registerNow() throws Exception
	{
		WebElement registerNow=driver.findElement(REGISTER_BTN);
		registerNow.click();
		Thread.sleep(20000);
		CaptureScreenShot.takescreenShot(driver);
	}

	public void printresult()
	{
		WebElement personal_txt=driver.findElement(PERSONAL_TXT);
		if (personal_txt.isDisplayed())
		{
			excel.setcelldata(0, 1, 6, "Pass");
		}
		else
		{
			excel.setcelldata(0, 1, 6, "Fail"); 

		}
	}
}

