package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserTest {

	WebDriver w;

	@Test(priority = 0, description = "Verify application opening on chrome")
	public void chromeBrowser() throws Exception {

		w = new ChromeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.close();
	}

	@Test(priority = 1, description = "Verify application opening on firefox")
	public void firefoxBrowser() throws Exception {

		w = new FirefoxDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.close();
	}

	@Test(priority = 2, description = "Verify application opening on edge")
	public void edgeBrowser() throws Exception {

		w = new EdgeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.close();
	}

}
