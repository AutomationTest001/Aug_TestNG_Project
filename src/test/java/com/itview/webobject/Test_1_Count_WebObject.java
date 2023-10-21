package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test_1_Count_WebObject {

	WebDriver w;

	@BeforeTest
	public void openBrowser() {

		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Count Element from webpage." )
	public void count() {
		
		w.get("https://demo.automationtesting.in/Register.html");
		
		List <WebElement> radioOption=w.findElements(By.name("radiooptions"));
		int count_radioOption=radioOption.size();
		System.out.println("Number of radio button on page : "+count_radioOption);
		
		List<WebElement> checkBox=w.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Number of checkBox on page : "+checkBox.size());
		
		
		List<WebElement> links=w.findElements(By.tagName("a"));
		System.out.println("Number of links on page : "+links.size());
		
		List<WebElement> drop_Down=w.findElements(By.tagName("select"));
		System.out.println("Number of drop_Down on page : "+drop_Down.size());
		
	}

	@AfterTest
	public void closeBrowser() throws Exception {

		Thread.sleep(2000);
		w.close();

	}

}
