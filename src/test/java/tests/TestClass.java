package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
	static XSSFWorkbook workbook;
	 static XSSFSheet  sheet;
	
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\HP\\eclipse-workspace\\myfirstmavenproject\\src\\test\\java\\tests\\Book1.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			 workbook = new XSSFWorkbook(fis);
			//XSSFSheet  sheet = workbook.getSheetAt(0);
			  sheet = workbook.getSheet("test");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(sheet.getLastRowNum());
		Row row = sheet.getRow(1);
		System.out.println(row.getLastCellNum());
		
	
		
		for(int i=0; i<=sheet.getLastRowNum();i++)
		{
			//row = sheet.getRow(i);
			
			for(int j=0; j<row.getLastCellNum();j++)
			{
				System.out.print(sheet.getRow(i).getCell(j));
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("Data for row 3");	
		List<String> list = getData(2);
		System.out.println(list);
		
		Object[][] arr = getData();
		
		for(int i=0; i<arr.length ;i++)
		{
			for(int j=0; j<arr[0].length;j++)
			{
				System.out.println(arr[i][j]);
			}
		}
		
		
	}
	
	//to return the data in a specific row
	
	public static List<String> getData(int rownum)
	{
		List<String> list = new ArrayList<String>();
		Row row = sheet.getRow(rownum);
		for(int j=0; j<row.getLastCellNum();j++)
		{
			list.add(sheet.getRow(rownum).getCell(j).toString());	
		}
		return list;
	}
	
	
	public static int getRowNum(){
		return sheet.getLastRowNum();
	}
	
	public static int getColNum()
	{
		return sheet.getRow(0).getLastCellNum();
	}
	
	public static Object[][] getData()
	{
		Object[][] arr = new Object[getRowNum()+1][getColNum()]; //3,4 
		
		for(int i=0; i<=getRowNum();i++)
		{
			for(int j=0; j<getColNum();j++)
			{
				
				arr[i][j]=sheet.getRow(i).getCell(j);
			}
			
		}
		
		return arr;
		
	}
	
	
}

	
	
	
	
