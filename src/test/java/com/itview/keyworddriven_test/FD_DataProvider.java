package com.itview.keyworddriven_test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class FD_DataProvider {
  

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "100000", "6.5","4" },
      new Object[] { "200000", "7","10" },
      new Object[] { "300000", "4","2" },
    };
  }
  
  
  WebDriver w;
  
  @BeforeTest
  public void beforeTest() {
	  
	  w=new ChromeDriver();
  }
  
  @Test(dataProvider = "dp")
  public void f(String principleValaue, String roiValue,String tenureValue) throws Exception{
	  
	  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
	  try {
		w.findElement(By.id("wzrk-cancel")).click();
	  }catch(Exception e) {}
		
		w.findElement(By.id("principal")).sendKeys(principleValaue);
		w.findElement(By.id("interest")).sendKeys(roiValue);
		w.findElement(By.id("tenure")).sendKeys(tenureValue);
		
		WebElement frequency=w.findElement(By.id("frequency"));
		
		Select sel=new Select(frequency);
		sel.selectByVisibleText("Simple Interest");
		
		WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));

		Select sel_1 = new Select(tenurePeriod);
		sel_1.selectByVisibleText("year(s)");
		
		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
		
		Thread.sleep(2000);
		
		String maturityValue=w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
		
		System.out.println("Maturity Value : "+maturityValue);
  }

  @AfterTest
  public void afterTest() {
	  
	  w.close();
  }

}
