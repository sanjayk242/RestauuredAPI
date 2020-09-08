package data_driven_testing;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils1 
{
	public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFRow row;
    
	 public static int getRowCount(String xlFile,String xlSheet) throws IOException
	 {
	        fi = new FileInputStream(xlFile);
	        XSSFWorkbook   wb= new XSSFWorkbook(fi);
			XSSFSheet loginsheet = wb.getSheet(xlSheet);
	        int rowCount = loginsheet.getLastRowNum();
	        wb.close();
	        fi.close();
	        return rowCount;
	 }
	 
	 
	 public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException
	 {
	        fi = new FileInputStream(xlFile);
	        XSSFWorkbook   wb= new XSSFWorkbook(fi);
			XSSFSheet loginsheet = wb.getSheet(xlSheet);
		    row = loginsheet.getRow(rowNum);
		    int columnCount = row.getLastCellNum();
		    wb.close();
	        fi.close();
	        return columnCount;
	 }
	 
	 public static String getCellData(String xlFile, String xlSheet, int rowNum, int columnNum) throws IOException
	 {
		 fi = new FileInputStream(xlFile);
	        XSSFWorkbook   wb= new XSSFWorkbook(fi);
			XSSFSheet loginsheet = wb.getSheet(xlSheet);
		    row = loginsheet.getRow(rowNum);
		    XSSFCell cell = row.getCell(columnNum);
		    String data;
		    try
		    {
		    	 DataFormatter formatter = new DataFormatter();
		            data = formatter.formatCellValue(cell);
		        } catch (Exception e) {
		            data = "";
		        }
		        wb.close();
		        fi.close();
		        return data;
	 }
		 
	 public static void setCellData(String xlFile, String xlSheet, int rowNum, int columnNum, String data) throws IOException 
	 {
		 fi = new FileInputStream(xlFile);
	        XSSFWorkbook   wb= new XSSFWorkbook(fi);
			XSSFSheet loginsheet = wb.getSheet(xlSheet);
		    row = loginsheet.getRow(rowNum);
		    XSSFCell cell = row.getCell(columnNum);
	        cell.setCellValue(data);
	        fo = new FileOutputStream(xlFile);
	        wb.write(fo);
	        wb.close();
	        fo.close();
	        fi.close();
	    }
		    
		    
	 }

	 
	 

