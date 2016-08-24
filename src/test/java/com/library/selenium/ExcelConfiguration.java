package com.library.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfiguration {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	File src = null;

	public ExcelConfiguration(String excelpath)

	{
		try {
			src=new File(excelpath); 

			FileInputStream file=new FileInputStream(src);
			wb=new XSSFWorkbook(file);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}


	public String getdata(int sheetnumber, int row, int column)
	{
		//String data = null;

		//sheet1 = wb.getSheetAt(sheetnumber);

		//Cell cell = null;	
		//System.out.println(".........:"+cell.getCellType());
		//System.out.println(".........:"+Cell.CELL_TYPE_STRING);

		sheet1 = wb.getSheetAt(sheetnumber);
		Cell cellValue = sheet1.getRow(row).getCell(column);
		DataFormatter formatter = new DataFormatter();
		String df2 = formatter.formatCellValue(cellValue);
		//System.out.println(".........:"+df2);
		/*
		Cell cell = null;		
		if(cell.getCellType() == Cell.CELL_TYPE_STRING) 

		{

		if(column==3){
			String data=sheet1.getRow(row).getCell(column).getStringCellValue();
			System.out.println("mobiledata:"+data);

		}
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		System.out.println("data.........:"+data);
		}

		else

		{
			int data=(int) sheet1.getRow(row).getCell(column).getNumericCellValue(); 
		}
		 */
		/*Cell cell = sheet1.getRow(row).getCell(column);


		if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) 
		{
			int i = (int)cell.getNumericCellValue();
			int i = (int)cell.getNumericCellValue();
			data = Integer.toString(i);
		}
		else if(cell.getCellType() == cell.CELL_TYPE_STRING){
			data = cell.getStringCellValue();
		}
		 */
		return df2;
	}

	public void setcelldata(int sheetnumber, int row, int column, String str)
	{	
		sheet1 = wb.getSheetAt(sheetnumber);
		sheet1.getRow(row).createCell(column).setCellValue(str);
		FileOutputStream fout=null;
		try {
			fout = new FileOutputStream(src);
		} catch (Exception e) {

			System.out.println("Exception is handled in Catch block");
		}
		try {
			wb.write(fout);
		} catch (Exception e) {

			System.out.println("Excpetion is handled again in catch block");
		}
	}

	public int getRowCount(int sheetindex)
	{
		int rowcount=wb.getSheetAt(sheetindex).getLastRowNum();
		rowcount=rowcount+1;
		return rowcount;
	}	

}




