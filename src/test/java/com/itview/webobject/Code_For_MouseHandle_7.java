package com.itview.webobject;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_MouseHandle_7 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

			 
		 w=new ChromeDriver();
		w.manage().window().maximize();	
	}

	@Test
	public void Code_For_MouseHandle_Test() throws Exception {
		
		Actions a=new Actions(w);
		
		
	/*	  w.get("https://www.ebay.com/");	
		 
		
		w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a")).click();		
		
		Thread.sleep(2000);
		
		w.navigate().back();
		
		Thread.sleep(2000);

		WebElement ElectronicsLink=w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		a.moveToElement(ElectronicsLink).build().perform();
		
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")).click();

		//Double Click
		
		//a.doubleClick(ElectronicsLink).build().perform();
		
		
		//Right click

		WebElement Cell_Phones_Smartphones=w.findElement(By.linkText("Cell Phones, Smart Watches & Accessories"));
        a.contextClick(Cell_Phones_Smartphones).build().perform();
        
    */
		
		w.get("http://crossbrowsertesting.github.io/drag-and-drop.html");
		
		Thread.sleep(2000);
		
		WebElement draggable=w.findElement(By.id("draggable"));
		WebElement droppable=w.findElement(By.id("droppable"));

		Actions drag_drop=new Actions(w);
		drag_drop.dragAndDrop(draggable, droppable).build().perform();
		
	}

	@AfterTest
	public void afterTest() {
	}
}
