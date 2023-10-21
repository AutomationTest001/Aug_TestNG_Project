package com.itview.keyworddriven_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class FD_Excel {

	WebDriver w;
	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell principleCell,roiCell,tenureCell,frequencyCell;

	@BeforeTest
	public void beforeTest() throws Exception {

		w = new ChromeDriver();
		df = new DataFormatter();
		fi = new FileInputStream(".\\TestData\\FDCal.xlsx");
		wb = new XSSFWorkbook(fi);
		sht = wb.getSheetAt(0);
	}

	@Test(priority = 0, description = "Test case to verify fixed deposit page")
	public void fd() throws Exception {

		w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		w.findElement(By.id("wzrk-cancel")).click();
		
		int rowCount=sht.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++) {
			
			row=sht.getRow(i);
			
			principleCell=row.getCell(0);
			roiCell=row.getCell(1);
			tenureCell=row.getCell(2);
			frequencyCell=row.getCell(3);

		w.findElement(By.id("principal")).clear();
		w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principleCell));
		
		w.findElement(By.id("interest")).clear();
		w.findElement(By.id("interest")).sendKeys(df.formatCellValue(roiCell));
		
		w.findElement(By.id("tenure")).clear();
		w.findElement(By.id("tenure")).sendKeys(df.formatCellValue(tenureCell));

		WebElement frequency = w.findElement(By.id("frequency"));

		Select sel = new Select(frequency);
		sel.selectByVisibleText(df.formatCellValue(frequencyCell));
		
		WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));

		Select sel_1 = new Select(tenurePeriod);
		sel_1.selectByVisibleText("year(s)");
		
		

		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();

		Thread.sleep(2000);

		String maturityValue = w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();

		System.out.println("Maturity Value : " + maturityValue);
		
		
		}
		

	}

	@AfterTest
	public void afterTest() {
		
		w.close();
	}
	

}
