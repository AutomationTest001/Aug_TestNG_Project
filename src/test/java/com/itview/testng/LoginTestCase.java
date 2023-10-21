package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

//@Listeners(com.itview.testng.MyListener.class)

public class LoginTestCase {
	
	WebDriver w;

	@BeforeTest
	public void preCondition() {

		 w = new ChromeDriver();
	}

	@Test (priority = 0,description = "Test Case to verify Login functionality for Admin User",groups = "LoginTest")
	public void adminLoginTest() throws Exception {

		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
	//	Reporter.log("Admin Login Successfully..",true);
		
	//	Assert.fail();// forcefully fail any test case

	}
	
	@Test (priority = 1,description = "Test Case to verify Login functionality for test User",dependsOnMethods = "adminLoginTest",groups = "LoginTest",invocationCount = 1,enabled = true)
	public void testLoginTest() throws Exception {

		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
	//	Reporter.log("TestUser Login Successfully..",true);

	}
	
	
	@Test (priority = 2,description = "Test Case to verify Login functionality for JSmith User",dependsOnMethods = "adminLoginTest",groups = "LoginTest")
	public void jsmithLoginTest() throws Exception {

		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("jsmith");
		w.findElement(By.id("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
	//	Reporter.log("Jsmith Login Successfully..",true);

	}

	@AfterTest
	public void postCondition() {

	//	w.close();

	}

}
