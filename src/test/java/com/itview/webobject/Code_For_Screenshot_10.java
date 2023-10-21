package com.itview.webobject;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_Screenshot_10 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

			 
		   w=new ChromeDriver();
		w.manage().window().maximize();
		
	}

	@Test
	public void Code_For_Screenshot() throws Exception {
			
		w.get("https://www.selenium.dev/downloads/");
		
	   Thread.sleep(2000);
	   
//	   D:\\selenium-aug-batch -> .\\ (Return project path)
	   
	   TakesScreenshot ts=(TakesScreenshot) w;
	   File f=ts.getScreenshotAs(OutputType.FILE);	   
	   FileUtils.copyFile(f, new File(".\\Screenshot\\SeleniumPage.png"));
	   
	   
	   
	///     TakesScreenshot ts=(TakesScreenshot)w;
	 //    File f=ts.getScreenshotAs(OutputType.FILE);
//	     FileUtils.copyFile(f, new File(".\\Screenshot\\GoogleSearchPage.png"));
	     
		
        
		/*
		  
		 * For FileUtils add dependencies in pom.xml.
		 
		  <dependency>
		  
		   <groupId>commons-io</groupId>
		 <artifactId>commons-io</artifactId> 
		 <version>2.6</version>
		 
		    </dependency>
		 
		 
		 * 
		 */

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
