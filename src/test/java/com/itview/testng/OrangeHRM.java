package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class OrangeHRM {

	WebDriver w;

	@BeforeTest
	public void openBrowser() {

		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Verify Login Functionalty")
	public void loginOrangeHRM() throws Exception {

		w.get("https://demo.openmrs.org/openmrs/login.htm");
		w.findElement(By.cssSelector("input#username")).sendKeys("Admin");
		w.findElement(By.cssSelector("input[name='password']")).sendKeys("Admin123");
		w.findElement(By.cssSelector("li[value='6']")).click();
		w.findElement(By.cssSelector("input#loginButton")).click();
		Thread.sleep(2000);
		w.findElement(By.linkText("Logout")).click();
		
		Reporter.log("loginOrangeHRM Executed");
	}

	@AfterTest
	public void closeBrowser() {

		w.close();
	}

}
