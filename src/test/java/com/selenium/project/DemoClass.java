package com.selenium.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoClass {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");*/
		
	public static void main(String[] args){
		
			WebDriver driver=new FirefoxDriver();
			driver.get("https://www.google.co.in/");
			driver.manage().window().maximize();
			System.out.println("Testing the change made test..");
		}
	}

//}