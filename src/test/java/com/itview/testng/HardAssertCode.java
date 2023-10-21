package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertCode {
	
	WebDriver w;

	@BeforeTest
	public void openBrowser() {
		
		w=new ChromeDriver();
		w.manage().window().maximize();
		w.manage().timeouts();
	}

	@Test(priority = 0, description = "Verify Login Functionality")
	public void loginTest() {
		
		w.get("http://altoromutual.com:8080/login.jsp");
		
	//	verify page title should be "Altoro Login"
		
		String loginPageTitle=w.getTitle();
		Assert.assertEquals(loginPageTitle, "Altoro Mutual");

	//	verify page url should be -> http://altoromutual.com:8080/login.jsp
		
		String loginPageURL=w.getCurrentUrl();
		Assert.assertEquals(loginPageURL, "http://altoromutual.com:8080/login.jsp");
		

	//	verify page label should contain "Login"
		
	String pageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
	Assert.assertTrue(pageLabel.contains("Login"));
	
		
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
	}
	
	@Test(priority = 1, description = "Verify Logout Functionality")
	public void logoutTest() throws Exception {
		
		String homePageTitle=w.getTitle();
		Assert.assertEquals(homePageTitle, "Altoro Mutual");
		
		String homePageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
		Assert.assertTrue(homePageLabel.contains("Admin"));
		
		
		Thread.sleep(10000);
		w.findElement(By.linkText("Sign Off")).click();
	}


	@AfterTest
	public void closeBrowser() {
		w.close();
	}

}
