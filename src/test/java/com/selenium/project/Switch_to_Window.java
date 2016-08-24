package com.selenium.project;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import junit.framework.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Switch_to_Window {

    @Test
	public void SwitchTo() throws InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//WebDriver driver= new FirefoxDriver();
		String IRCTC_Url = "https://www.irctc.co.in/eticketing/loginHome.jsf";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		
        driver.get(IRCTC_Url);
        driver.getCurrentUrl();
        System.out.println("The current url is:" + driver.getCurrentUrl());
        
        WebElement FlightTicket_btn=driver.findElement(By.xpath("//a[@href='http://air.irctc.co.in']")); 
        FlightTicket_btn.click();
        
        String ParentWdHandle=driver.getWindowHandle(); 
        Set<String> allhandle=driver.getWindowHandles();
        for(String winHandle :allhandle)
        {
         driver.switchTo().window(winHandle);
         if(driver.getTitle().equals("IRCTC Flight Ticket Booking"))
             break;
        }
       
        System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
        System.out.println("URL of the page after - switchingTo: " + driver.getCurrentUrl());
        
        WebElement Where=driver.findElement(By.xpath("//input[@id='origin']"));
        Where.click();
        Where.sendKeys("Delhi (New Delhi),DEL");
        
        Thread.sleep(5000);
        WebElement City=driver.findElement(By.id("ui-active-menuitem"));
        City.click();
        
        WebElement Destination=driver.findElement(By.xpath("//input[@id='destination']"));
        Destination.click();
        Destination.sendKeys("Jaipur,JAI");
        
        Thread.sleep(2000);
        WebElement DestinationValue=driver.findElement(By.id("ui-active-menuitem"));
        DestinationValue.click();
        
        WebElement Departure=driver.findElement(By.xpath("//div[@id='lastwhenId2']/following-sibling::div[1]/child::*[2]"));
        Departure.click();
        
        WebElement Next=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
        Next.	click();
        
        WebElement Departure_Date=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[4]/a"));
        Departure_Date.click();
        
        WebElement Adults=driver.findElement(By.id("noOfAdult"));
		Select dropdown=new Select(Adults);
	    dropdown.selectByValue("2");
	
        WebElement Search_btn=driver.findElement(By.xpath("//input[@value='SearchSubmit']/following::div[1]"));
        Search_btn.click();
	    
        List<WebElement> flights = driver.findElements(By.xpath("//table[@class='flightcont']"));
        System.out.println("Total number of flights:" + flights.size()); 
        
        Assert.assertTrue(flights.size()>0, "The flight count is less than zero"); 
        System.out.println("The flight size is greater than zero");    
	}
        
}	
