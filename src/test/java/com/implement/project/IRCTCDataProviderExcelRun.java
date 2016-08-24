package com.implement.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.project.IrctcDataProvider;

public class IRCTCDataProviderExcelRun {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;

	String s;
	String a;
	String b;
	String c;
	String d;
	String l;
	
	WebDriver driver;

	@BeforeMethod	
	public void intializeDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	@Test(dataProvider="myDP")
	public void test1(String s, String a, String b, String c, String d, String l)
	{

		System.out.println("Value is"+ s + a + b + c + d + l);
		IrctcDataProvider irctc= new IrctcDataProvider(driver);
		irctc.openUrl();
		
	}

	@DataProvider
	public Object[][] myDP() {
		Object [][] obj= null;
		try {			
			fis= new FileInputStream("E:/AutomateIRCTC.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			wb= new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet= wb.getSheet("Sheet1");
		int totalRows=sheet.getLastRowNum();  //this return index and not the actual value
		int totalCols=sheet.getRow(1).getLastCellNum(); //this is not returning index. It return actual number
		obj= new Object[totalRows][totalCols];
		int startRow=1;
		int startcol=0;
		int ci, cj;  //denotes 2 D array indexes
		ci=0;

		for (int i = startRow;i<=totalRows;i++, ci++)
		{
			cj=0;
			for(int j=startcol; j<totalCols; j++, cj++)
			{
				obj [ci][cj]= getData(i,j);
			};

		}
		return obj;
	}

	public Object getData(int r, int c)
	{
		cell= sheet.getRow(r).getCell(c);	
		int type = cell.getCellType();
		if(type==0)  //for integers, type is 0
		{
			return cell.getRawValue();
		}
		else if (type==1) {//for strings, type is 1
			return cell.getStringCellValue();
		}
		else return null;
	}	
}

