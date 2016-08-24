package com.selenium.project;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//import org.apache.log4j.Logger;
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


public class PageObjectModel {


	private  static WebDriver driver;

	private static By FLIGHTTICKETBUTTON= By.xpath("//a[@href='http://air.irctc.co.in']");
	private static By WHERE=By.xpath("//input[@id='origin']");
	private static By FROMCITYVALUE=By.id("ui-active-menuitem");		 
	private static By DESTINATION=By.xpath("//input[@id='destination']");
	private static By DESTINATIONVALUE=By.id("ui-active-menuitem");
	private static By CLOSE_BTN=By.xpath("//div[@id='tigertrailbanner']/img");
	private static By DEPARTURE=By.xpath("//div[@id='lastwhenId2']/following-sibling::div[1]/child::*[2]");
	private static By NEXT=By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
	private static By DEPARTUREDATE=By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[4]/a");
	private static By ADULTS=By.id("noOfAdult");
	private static By SEARCHBUTTON=By.xpath("//input[@value='SearchSubmit']/following::div[1]");
	private static By FLIGHTCOUNT=By.xpath("//table[@class='flightcont']");

	public PageObjectModel(WebDriver driver){
		this.driver=driver;
	}


	public static void openUrl()
	{
		String IRCTC_Url = "https://www.irctc.co.in/eticketing/loginHome.jsf";
		driver.get(IRCTC_Url);

	}

	public static void maximizeWindow()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	}

	public static void printUrl()
	{
		driver.getCurrentUrl();
		System.out.println("The current url is:" + driver.getCurrentUrl());

	}

	public static void clickFlightTicket()

	{  
		WebElement FlightTicket_btn=driver.findElement(FLIGHTTICKETBUTTON); 
		FlightTicket_btn.click();

	}

	public static void handleWindow()
	{
		String ParentWdHandle=driver.getWindowHandle(); 
		Set<String> allhandle=driver.getWindowHandles();
		for(String winHandle :allhandle)
		{
			driver.switchTo().window(winHandle);
			if(driver.getTitle().equals("IRCTC Flight Ticket Booking"))
				break;
			System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
			System.out.println("URL of the page after - switchingTo: " + driver.getCurrentUrl());

		}
	}

	public static void fromCity() throws InterruptedException
	{
		WebElement Where=driver.findElement(WHERE);
		Where.click();
		Where.sendKeys("Delhi (New Delhi),DEL");

		Thread.sleep(5000);
		WebElement City=driver.findElement(FROMCITYVALUE);
		City.click();

	}

	public static void toCity() throws InterruptedException
	{
		WebElement Destination=driver.findElement(DESTINATION);
		Destination.click();
		Destination.sendKeys("Jaipur,JAI");
		Thread.sleep(2000);
		WebElement DestinationValue=driver.findElement(DESTINATIONVALUE);
		DestinationValue.click();

	}

	public static void Close_btn() throws Exception
	{
		try{
			Thread.sleep(10000);
			System.out.println("IN TRY BLOCK");
			WebElement Close_btn1=driver.findElement(CLOSE_BTN);
			Close_btn1.click();
			
		}catch (Exception e) {
			System.out.println("IN CATCH BLOCK");
			//Logger.getLogger("Register element is not found.");

			throw(e);
}
	}

	public static void departureDate() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement Departure=driver.findElement(DEPARTURE);
		Departure.click(); 	
		WebElement Next=driver.findElement(NEXT);
		Next.click();
		WebElement Departure_Date=driver.findElement(DEPARTUREDATE);
		Departure_Date.click();

	}

	public static void totalMembers()	
	{
		WebElement Adults=driver.findElement(ADULTS);
		Select dropdown=new Select(Adults);
		dropdown.selectByValue("2");  

	}

	public static void clickSearchButton() throws InterruptedException
	{
		WebElement Search_btn=driver.findElement(SEARCHBUTTON);
		Search_btn.click();
		Thread.sleep(10000);
	}

	public static void totalFlightCount()
	{
		List<WebElement> flights = driver.findElements(FLIGHTCOUNT);
		System.out.println("Total number of flights:" + flights.size()); 

	}

}




























