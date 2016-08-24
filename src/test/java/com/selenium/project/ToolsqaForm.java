package com.selenium.project;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


	public class ToolsqaForm {

	   
		@Test
		public void FillForm() throws InterruptedException, IOException
		{	
		
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			//WebDriver driver= new FirefoxDriver();
			String Toolsqa_Url = "http://toolsqa.com/automation-practice-form/";
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
			
	        driver.get(Toolsqa_Url);
	        System.out.println("The current url is:" + driver.getCurrentUrl());
	           
	        WebElement FirstName=driver.findElement(By.name("firstname"));
	        FirstName.click();
	        FirstName.sendKeys("Sahil");
	        
	        WebElement LastName=driver.findElement(By.name("lastname"));
	        LastName.click();
	        LastName.sendKeys("Koti");
	        
	        WebElement Sex=driver.findElement(By.xpath("//input[@id='sex-0']"));
	        Sex.click();
	        
	        WebElement Experience=driver.findElement(By.xpath("//input[@id='exp-5']"));
	        Experience.click();
	        
	        WebElement Date=driver.findElement(By.xpath("//input[@id='datepicker']"));
	        Date.click();
	        
	        WebElement Next_lnk=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/child::div[1]/child::*[2]/span"));
	        Next_lnk.click();
	        
	        WebElement Date_value=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a"));
	        Date_value.click();
	        
	        WebElement Profession=driver.findElement(By.xpath("//input[@id='profession-1']"));
	        Profession.click();
	        
	        WebElement Browse_btn=driver.findElement(By.xpath("//input[@id='photo']"));
	        Browse_btn.click();
	        
	        Thread.sleep(5000);
	        
	        //Browse_btn.sendKeys("G:/Upload/Selenium.testing.tools.cookbook.nov.2012.pdf");
	        
	        Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\AutoITScript\\ScriptUpload.exe");
	        
	        //WinWaitActive("Open");
	        //Send("G:/Upload/Selenium.testing.tools.cookbook.nov.2012.pdf");
	        //Send("{ENTER}");
	        
	        WebElement AutomationTool=driver.findElement(By.xpath("//input[@id='tool-2']"));
	        AutomationTool.click();	
	        
	        Thread.sleep(2000);
	        WebElement Continents=driver.findElement(By.xpath("//select[@id='continents']"));
			Select dropdown=new Select(Continents);
		    dropdown.selectByVisibleText("Europe");
	        
		    WebElement Selenium_Commands=driver.findElement(By.id("selenium_commands"));
		    
		    Select se=new Select(Selenium_Commands);
		    se.selectByVisibleText("Navigation Commands");
		    se.selectByVisibleText("Wait Commands");
		    se.selectByVisibleText("WebElement Commands");
		    
		   //Print the options chosen in Multi Select drop down
		    
		    List<WebElement> allSelectedOptions = se.getAllSelectedOptions();
		    for (WebElement webElement : allSelectedOptions)
		    {
		    System.out.println("You have selected ::"+ webElement.getText());
		    }
	        
		    Thread.sleep(10000);
		 	WebElement Close_Sares=driver.findElement(By.xpath("//input[@id='focus_retriever']/following::div[1]/child::*[3]/span"));
		 	//Close_Shares.click();
		    
		    Actions actions = new Actions(driver);
		 	Thread.sleep(5000);
		 	WebElement MenMouseover = driver.findElement(By.xpath("//input[@id='focus_retriever']/following::div[3]/child::*[2]"));
		 	actions.moveToElement(MenMouseover).click(Close_Sares).build().perform();
		 			
		    WebElement Submit_btn=driver.findElement(By.xpath("//button[@id='submit']"));
		    Submit_btn.click();
		    
		    driver.close();
		    driver.quit();
	      
}

}	