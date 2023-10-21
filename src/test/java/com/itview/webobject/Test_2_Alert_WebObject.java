package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test_2_Alert_WebObject {

	WebDriver w;

	@BeforeTest
	public void openBrowser() {

		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Handle Alert" )
	public void count() throws Exception {
		
		w.get("http://altoromutual.com:8080/login.jsp");		
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		
		try {
		w.switchTo().alert().accept();
		}
		catch(Exception e) {  System.out.println("No Alert !!!"); }
		
		Thread.sleep(2000);
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
	}

	@AfterTest
	public void closeBrowser() throws Exception {

		Thread.sleep(2000);
		w.close();

	}

}
