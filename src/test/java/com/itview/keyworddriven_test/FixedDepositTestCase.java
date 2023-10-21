package com.itview.keyworddriven_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositTestCase {

	public static void main(String[] args) throws Exception {


		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		
		w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		w.findElement(By.id("wzrk-cancel")).click();
		
		w.findElement(By.id("principal")).sendKeys("100000");
		w.findElement(By.id("interest")).sendKeys("6.5");
		w.findElement(By.id("tenure")).sendKeys("4");
		
		WebElement frequency=w.findElement(By.id("frequency"));
		
		Select sel=new Select(frequency);
		sel.selectByVisibleText("Simple Interest");
		
		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
		
		Thread.sleep(2000);
		
		String maturityValue=w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
		
		System.out.println("Maturity Value : "+maturityValue);
		
		w.close();

	}

}
