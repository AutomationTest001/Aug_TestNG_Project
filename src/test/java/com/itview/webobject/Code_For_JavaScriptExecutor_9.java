package com.itview.webobject;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Code_For_JavaScriptExecutor_9 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		 
		   w=new ChromeDriver();
		w.manage().window().maximize();
	}

	@Test
	public void Code_For_JavaScriptExecutor_Test() throws Exception {
		
		
		//  interfaceName js=(interfaceName) w;
		
		 JavascriptExecutor js=(JavascriptExecutor) w;

		w.get("http://demo.automationtesting.in/Register.html");               
		
				
		
		Thread.sleep(2000);

		//Page Down  (0- > width , 600 -> height )
		
      js.executeScript("window.scrollBy(0,600)");
	
		Thread.sleep(2000);
		
		    //Page Up  (0- > width , -600 -> height )
				js.executeScript("window.scrollBy(0,-600)");	
			
				Thread.sleep(2000);
				
				js.executeScript("window.scrollBy(0,600)");
				

		
		//Listbox
		w.findElement(By.id("msdd")).click();
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		
		WebElement thai=w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[37]/a"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", thai);

		Thread.sleep(2000);
		
		thai.click();
		
		//Select data from drop-sown list
		Thread.sleep(2000);
		WebElement skillsDropDown= w.findElement(By.id("Skills"));

		Select sel = new Select(skillsDropDown);
		sel.selectByVisibleText("Java"); // actual text from drop down
		
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,-600)");
		
		Thread.sleep(2000);
		js.executeScript("history.go(0)");

	}

	@AfterTest
	public void afterTest() {
	}

}
