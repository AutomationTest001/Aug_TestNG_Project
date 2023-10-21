package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test_3_Frame_WebObject {

	WebDriver w;

	@BeforeTest
	public void openBrowser() {

		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Handle Frame" )
	public void count() throws Exception {
		
		w.get("https://demo.automationtesting.in/Frames.html");	
		
		w.switchTo().frame("singleframe");
		
		w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Selenium");
		
		
	}

	@AfterTest
	public void closeBrowser() throws Exception {

		Thread.sleep(6000);
		w.close();

	}

}
