package com.selenium.project;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
 

     public class Assertion_Url
       {
		
		@Test
		public void Assertion() throws InterruptedException
		{
		
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			//WebDriver driver= new FirefoxDriver();
			String Macys_URL = "http://www.macys.com/";
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
			
	        driver.get(Macys_URL);

	        System.out.println("************************************************");
	        Thread.sleep(5000);
			WebElement Close_btn=driver.findElement(By.xpath("//div[@id='modal']/div/a"));
			
			if(Close_btn.isDisplayed())
			{
				Close_btn.click();	
			}
				
			else
			{
				System.out.println("Lets procced");
			}
			
			WebElement Search_txt=driver.findElement(By.xpath("//input[@id='globalSearchInputField']"));
			Search_txt.sendKeys("Jeans");
			Thread.sleep(3000);
			WebElement we = driver.findElement(By.xpath("//input[@id='subnavSearchSubmit']"));
//	        JavascriptExecutor js = (JavascriptExecutor)driver;
//	        js.executeScript("arguments[0].click", we);
			
			Actions action = new Actions(driver);
			action.doubleClick(we).build().perform();
			
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ clicked");
			//WebElement Search_btn = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='subnavSearchSubmit']")));
			
			Thread.sleep(15000);
			assertTrue("Jeans is persent in the URL", driver.getCurrentUrl().contains("jeans"));
			System.out.println("Jeans is present in the Current URL");
			
			WebElement pagination_btn=driver.findElement(By.xpath("//div[@id='paginateTop']/a[7]"));
			pagination_btn.click();
			
			System.out.println("This step is executed");
		    Thread.sleep(10000);
		    
			driver.navigate().back();
			System.out.println("The user is navigated to the back page");
				
			Thread.sleep(10000);
			WebElement result=driver.findElement(By.xpath("//h3[@id='weFoundMsg']/span[1]"));
			String finalresult=result.getText();
			System.out.println("The number of Jeans Items are: "+ finalresult);
			
}
}