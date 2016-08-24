package com.selenium.project;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.library.selenium.ExcelConfiguration;

public class FlipcartRandom {

	private WebDriver driver;

	private static By SEARCHBUTTON= By.xpath("//input[@class='LM6RPg']");
	private static By SEARCH_CLICK=By.xpath("//button[@class='vh79eN']");
	private static By ADDTOCART=By.xpath("//input[@value='Add to Cart']");
	/*
	private static By SIZE30=By.xpath("//div[@class='selector-boxes']/span[contains(text(),'30')]");
	private static By SIZE32=By.xpath("//div[@class='selector-boxes']/span[contains(text(),'32')]");
	private static By SIZE34=By.xpath("//div[@class='selector-boxes']/span[contains(text(),'34')]");
	private static By SIZE36=By.xpath("//div[@class='selector-boxes']/span[contains(text(),'36')]");
	private static By SIZE38=By.xpath("//div[@class='selector-boxes']/span[contains(text(),'38')]");
	private static By ALLSIZE=By.xpath("//div[@class='selector-boxes']");*/
	
	private static By CARTBUTTON=By.xpath("//a[@class='btn btn-blue btn-cart']");
	private static By REMOVE_LINK=By.xpath("//a[@title='Remove Item']");
    private static By PRINTMESSAGE=By.xpath("//div[@id='cartpage-cart-tab-content']/div[1]");
	
	//ExcelConfiguration excel=new ExcelConfiguration("C:\\Selenium\\Excelsheet\\Excelsheet0.xlsx");

	public FlipcartRandom(WebDriver driver){
		this.driver=driver;
	}

	public void openUrl()
	{	
		String Flipcart_URL = "https://www.flipkart.com/#";
		driver.get(Flipcart_URL);
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

	public void searchKeyword() throws Exception
	{
		WebElement search_button=driver.findElement(SEARCHBUTTON);	
		search_button.sendKeys("Jeans");
	}

	public void search()
	{
		WebElement search=driver.findElement(SEARCH_CLICK);
		search.click();
	}

	public void click_random_product()
	{
		List <WebElement> jeans_links = driver.findElements(By.xpath("//div[@class='unit size1of3']"));
		int list_size = jeans_links.size();
		Random randomno = new Random(); 
		WebElement RandomJeans=jeans_links.get(randomno.nextInt(list_size));
		System.out.println("Next jeans value:" + randomno.nextInt(list_size));

		if (RandomJeans.isDisplayed()) {
			System.out.println("Clicking on any jeans dislayed on page");
			RandomJeans.click();
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", RandomShoe);

		} else {
			System.out.println("Unable to click on element");
		}
	}

	public void select_random_size()
	{
		List <WebElement> size_links = driver.findElements(By.xpath("//div[@class='selector-boxes']"));
		int list_size = size_links.size();
		Random randomno = new Random(); 
		WebElement RandomSize=size_links.get(randomno.nextInt(list_size));
		System.out.println("Next size value:" + randomno.nextInt(list_size));

		if (RandomSize.isDisplayed()) {
			System.out.println("Clicking on any jeans size dislayed on page");
			RandomSize.click();
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", RandomShoe);

		} else {
			System.out.println("Unable to click on element");
		}
	}

	public void add_to_cart() throws Exception
	{
		WebElement addtocart=driver.findElement(ADDTOCART);
		addtocart.click();
		Thread.sleep(10000);
	}

	public void visit_cart()
	{
		WebElement cart_button=driver.findElement(CARTBUTTON);
		cart_button.click();
	}

	public void remove_product() throws Exception
	{
		WebElement remove_link=driver.findElement(REMOVE_LINK);
		remove_link.click();
		Thread.sleep(10000);
	}

    public void print_message()
    {
    	
    WebElement message=driver.findElement(PRINTMESSAGE);
    String success_message=message.getText();
    System.out.println(success_message);
    }

}
