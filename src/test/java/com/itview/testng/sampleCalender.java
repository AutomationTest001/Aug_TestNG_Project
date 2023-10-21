package com.itview.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sampleCalender {
	
	public static void selectDate(WebDriver w,String day,String Month,String Year) {		
		
		w.findElement(By.cssSelector("input#from")).click();
		
		Select sel=new Select(w.findElement(By.cssSelector("select.ui-datepicker-month")));
		sel.selectByVisibleText(Month);
		
		w.findElement(By.linkText(day)).click();
		
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		w.get("https://jqueryui.com/datepicker/#date-range");
		
		w.switchTo().frame(w.findElement(By.cssSelector("iframe.demo-frame")));
		
		Thread.sleep(2000);
		

		selectDate(w, "4", "Dec", "2023");

	}

}
