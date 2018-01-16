package com.zohocrm.generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	
	//To get the data
	public String getData(String path,String sheetName,int m,int cn)
	{
		try
		{
			FileInputStream fis=new FileInputStream(new File(path));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			String data=sh.getRow(m).getCell(cn).toString();
			return data;
			
		}
		catch(Exception e)
		{
			return"";
		}
	}
	
	//To count the rows
	public int getRow(String path,String sheetName)
	{
		try
		{
			FileInputStream fis=new FileInputStream(new File(path));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			int rc=sh.getLastRowNum();
			return rc;
			
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	   //To count the cells
		public int getCell(String path,String sheetName,int rc)
		{
			try
			{
				FileInputStream fis=new FileInputStream(new File(path));
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh=wb.getSheet(sheetName);
				int cc=sh.getRow(rc).getLastCellNum();
				return cc;
			}
			catch(Exception e)
			{
				return 0;
			}
		}

}
