package com.selenium.project;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class KohlsTesting {
	
@Test
public void Assertion2() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	//WebDriver driver= new FirefoxDriver();
	String Macys_URL = "http://www.kohls.com";
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	
    driver.get(Macys_URL);

    System.out.println("************************************************");
    
    Thread.sleep(5000);	

    String title = driver.getTitle();
	System.out.println("Title is "+title);

	String url = driver.getCurrentUrl();
	System.out.println("URL is "+url);
	
    //WebElement Kohls_Logo=driver.findElement(By.xpath("//div[@id='kohls_logo']/a/img"));
	
    /*Thread.sleep(5000);
	Actions actions = new Actions(driver);	
	WebElement MenMouseover = driver.findElement(By.xpath("//a[@href='/sale-event/mens-clothing.jsp?cc=men-TN1.0-S-men']"));
	MenMouseover.click();
	Thread.sleep(10000);
	actions.moveToElement(MenMouseover).build().perform();
	*/	
	
	Thread.sleep(3000);
	
	Actions actions = new Actions(driver);
	WebElement MenMouseover = driver.findElement(By.xpath("//a[@href='/sale-event/mens-clothing.jsp?cc=men-TN1.0-S-men']"));	
	
	WebDriverWait wait = new WebDriverWait(driver, 15); 
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/sale-event/mens-clothing.jsp?cc=men-TN1.0-S-men']")));
	
	actions.moveToElement(MenMouseover);
	actions.build().perform();
	
	WebElement Shoes_link=driver.findElement(By.xpath("//a[@href='/sale-event/mens-shoes.jsp?cc=mens-TN3.0-S-shoes']"));
	WebDriverWait wait2 = new WebDriverWait(driver,60); 
    
	wait2.until(ExpectedConditions.visibilityOf(Shoes_link));
	
	Shoes_link.click();
    
	Thread.sleep(10000);
	
    WebElement Image=driver.findElement(By.xpath("//a[@href='/catalog/mens-casual-athletic-shoes-sneakers-shoes.jsp?CN=4294723349+4294737443+4294711897+4294719777&icid=msa|a2']/child::*[1]"));
    
    //WebDriverWait pageload1 = new WebDriverWait(driver,100); 
	//pageload1.until(ExpectedConditions.visibilityOf(Image));
	
    Image.click();
    
    Thread.sleep(10000);
	
    WebElement Online_chkbox=driver.findElement(By.xpath("//ul[@id='StoreAvailability']/child::*[1]/a/span[1]"));
    
    //WebDriverWait pageload2 = new WebDriverWait(driver,80); 
	//pageload2.until(ExpectedConditions.visibilityOf(Online_chkbox));
	
    Online_chkbox.click();
    
    Thread.sleep(10000);
    
    WebElement Pickup_chkbox=driver.findElement(By.xpath("//ul[@id='StoreAvailability']/child::*[2]/a/span[1]"));
    
    //WebDriverWait pageload3 = new WebDriverWait(driver,100); 
	//pageload3.until(ExpectedConditions.visibilityOf(Pickup_chkbox));
	
    Pickup_chkbox.click();
 
    Thread.sleep(10000);
    WebElement Brand=driver.findElement(By.xpath("//ul[@id='Brand']/preceding::span[1]"));
    String str2=null;
    str2=Brand.getAttribute("aria-expanded");
   
    System.out.println("attribute value:" + str2);
    
    if (str2.equalsIgnoreCase("true"))
    {
    	Thread.sleep(10000);
    	WebElement Brand_plus=driver.findElement(By.xpath("//ul[@id='Brand']/preceding::div[1]/span[2]"));
    	//((JavascriptExecutor) driver).executeScript(
        //       "arguments[0].scrollIntoView();", Brand_plus);
    	Brand_plus.click();	
    	
    	Thread.sleep(10000);
    	WebElement Nike_chkbox=driver.findElement(By.xpath("//span[@class='facet_name' and contains(text(),'Nike')]"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Nike_chkbox);
    	
       	WebElement Nike_link=driver.findElement(By.xpath("//a[@title='Nike']"));
    	if (Nike_link.isDisplayed()) {
			System.out.println("Clicking on element with using java script click");

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Nike_link);
		} else {
			System.out.println("Unable to click on element");
		}

    }
    else  
    {
    	Thread.sleep(10000);
    	WebElement Nike_chkbox=driver.findElement(By.xpath("//span[contains(text(),'NoSoX')]/../../preceding::span[3]"));
    	((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", Nike_chkbox);
    	Nike_chkbox.click();
    }
    

    List<WebElement> shoes_links = driver.findElements(By.xpath("//div[@class='prod_img_block']/a"));
    int list_size = shoes_links.size();
    System.out.println("total shoes:" +list_size);
     	   Random randomno = new Random(); 
    	   WebElement RandomShoe=shoes_links.get(randomno.nextInt(list_size));
           System.out.println("Next shoe value:" + randomno.nextInt(list_size));

           if (RandomShoe.isDisplayed()) {
   			System.out.println("Clicking on any shoe dislayed on page");
   			RandomShoe.click();
   			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", RandomShoe);
   		
           } else {
   			System.out.println("Unable to click on element");
   		}
	     
           
           //WebDriverWait wait = new WebDriverWait(driver, 10);
           //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")))
           
           //WebDriverWait(driver,30);
           
           //	        FluentWait<WebDriver> wait = null;
   		//		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
           //          driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
            	//}

   	// private void WebDriverWait(WebDriver driver, int i) {
   		// TODO Auto-generated method stub
           
}
}

