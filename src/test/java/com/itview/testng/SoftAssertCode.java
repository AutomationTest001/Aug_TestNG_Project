package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SoftAssertCode {
	
	WebDriver w;
	
	SoftAssert sft;

	@BeforeTest
	public void openBrowser() {
		
		w=new ChromeDriver();
	}

	@Test(priority = 0, description = "Verify Login Functionality")
	public void loginTest() {
		
		sft=new SoftAssert();
		
		w.get("http://altoromutual.com:8080/login.jsp");
		
	//	verify page title should be "Altoro Login"
		
		String loginPageTitle=w.getTitle();
		
        sft.assertEquals(loginPageTitle, "Altoro Mutual");

	//	verify page url should be -> http://altoromutual.com:8080/login.jsp
		
		String loginPageURL=w.getCurrentUrl();
		sft.assertEquals(loginPageURL, "http://altoromutual.com:8080/login.jsp");
		

	//	verify page label should contain "Login"
		
	String pageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
	sft.assertTrue(pageLabel.contains("Login"));
	
		
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		sft.assertAll();
		
	}
	
	@Test(priority = 1, description = "Verify Logout Functionality")
	public void logoutTest() throws Exception {
		
		sft=new SoftAssert();
		
		String homePageTitle=w.getTitle();
		sft.assertEquals(homePageTitle, "Altoro Mutual");
		
		String homePageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
		sft.assertTrue(homePageLabel.contains("Admin"));
		
		
		Thread.sleep(2000);
		w.findElement(By.linkText("Sign Off")).click();
		
		sft.assertAll();
	}


	@AfterTest
	public void closeBrowser() {
		w.close();
	}

}
