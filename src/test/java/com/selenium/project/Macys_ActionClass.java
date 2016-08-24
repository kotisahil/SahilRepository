package com.selenium.project;

import java.util.concurrent.TimeUnit;

//import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Macys_ActionClass {
	
	
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("Before suite will executed before all test cases");
	}
	
	@BeforeClass
	public void beforeclass()
	{
		
		System.out.println("Before class will executed before first @Test");
		
	}
	
	@AfterClass
	public void afterclass()
	{
		
		System.out.println("After class will executed after all @Test i.e before After Suite");
		
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before method will be executed before every@Test");
		
	}
	
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("The after method will be executed after every @ Test");
		
	}
	
	@AfterSuite
	public void aftersuite()
	{
	
		System.out.println("After Suite will be executed at last");
		
    }
	
	@Test
	public void Action() throws InterruptedException 
	{
	
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver= new FirefoxDriver();
		String Macys_URL = "http://www.macys.com/";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
        driver.get(Macys_URL);

		System.out.println("************************************************");

		
		WebElement Close_btn=driver.findElement(By.xpath("//div[@id='modal']/div/a"));
		
		if(Close_btn.isDisplayed())
		{
			Close_btn.click();	
		}
			
		else
		{
			System.out.println("Lets procced");
		}
		
		String title = driver.getTitle();
		System.out.println("Title is "+title);

		String url = driver.getCurrentUrl();
		System.out.println("URL is "+url);
		
			
//	    driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);

		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		WebElement MenMouseover = driver.findElement(By.xpath("//div[@id='globalMastheadCategoryMenu']/ul/li[@id='flexLabel_1']/a"));
		actions.moveToElement(MenMouseover).build().perform();;
		
		
		WebElement Jeans_Hyperlink=driver.findElement(By.linkText("Jeans"));
		Jeans_Hyperlink.click();
		
		System.out.println("Step 1 successful");
		 
		//WebElement Close_button=driver.findElement(By.xpath("//button[@id='closeBtn']"));
		
		//if(Close_button.isDisplayed())
		//{
			//Close_button.click();	
	//	}
		
		//else
		//{
		
		    System.out.println("This step is executed");
		    Thread.sleep(15000);
		
			WebElement Armani_Hyperlink=driver.findElement(By.xpath("//li[@id='Armani Jeans']/span[1]"));
			//JavascriptExecutor js = (JavascriptExecutor)driver;
	        //js.executeScript("arguments[0].click", Armani_Hyperlink);
			
            Actions action = new Actions(driver);
			action.doubleClick(Armani_Hyperlink).build().perform();
			
			//Armani_Hyperlink.click();
		
		    System.out.println("This step is executed also");
		    Thread.sleep(20000);
		    WebElement JeansItems=driver.findElement(By.xpath("//span[@id='productCount']"));
		    Thread.sleep(20000);
		    String Result=JeansItems.getText();
		    System.out.println("The total number of Armani Jeans items is"+":"+ Result);	    
	
		    driver.quit();
	}
	
	@Test
	public void run2()
	{
	  
	  System.out.println("@Test 2 annotation"); 	
	}
	
	@Test
	public void run3()
	{
	  
	  System.out.println("@Test 3 annotation"); 	
	}
	
	@Test
	public void run4()
	{
	  
	  System.out.println("@Test 4 annotation"); 	
	}
	
	
	@Test
	public void run5()
	{
	  
	  System.out.println("@Test 5 annotation"); 	
	}
	

	@Test
	public void run6()
	{
	  
	  System.out.println("@Test 6 annotation"); 	
	}
	
}







