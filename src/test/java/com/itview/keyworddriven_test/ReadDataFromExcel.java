package com.itview.keyworddriven_test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		
		DataFormatter df=new DataFormatter();

     FileInputStream fi=new FileInputStream(".\\TestData\\FDCal.xlsx");
     
     XSSFWorkbook wb=new XSSFWorkbook(fi);
     
     XSSFSheet sht=wb.getSheetAt(0);
     
     XSSFRow row=sht.getRow(3);
     
     XSSFCell cell=row.getCell(2);
     
    // System.out.println(df.formatCellValue(cell));
     
     int rowCount=sht.getLastRowNum();
     
     System.out.println(rowCount);
     

	}

}
