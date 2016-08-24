package com.selenium.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;



//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;



public class ReadExcelFile {

	public static void main (String args[]) throws Exception

	{

		File src=new File("G:\\Test_Excel\\SheetExcel.xlsx"); 
		FileInputStream file=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		String datavalue_1=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("The value of the first row and column in excel sheet is"+":"+ datavalue_1);
		
		String datavalue_2=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("The value of the first row and column in excel sheet is"+":"+ datavalue_2);
		
		String datavalue_3=sheet1.getRow(1).getCell(1).getStringCellValue();
		System.out.println("The value of the first row and column in excel sheet is"+":"+ datavalue_3);
		
		int i;
		int rowcount=sheet1.getLastRowNum();
		System.out.println("Total number rows in sheet includes"+":"+ rowcount);
		
		for (i=0;i<rowcount;i++)
		{
			String excel_value1=sheet1.getRow(i).getCell(0).getStringCellValue();
			String excel_value2=sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("The data value of excel sheet is"+":"+ excel_value1 +" " + "and" + " "+ excel_value2);
		}
		
		wb.close();

	}

}
