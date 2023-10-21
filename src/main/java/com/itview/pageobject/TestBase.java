package com.itview.pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {

	WebDriver w;

	public void openBrowser(String br) {

		if (br.equalsIgnoreCase("Chrome")) {
			w = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			w = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("Edge")) {
			w = new EdgeDriver();
		}

		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void closeBrowser() {

		w.quit();
	}

	public void openApplicationUrl(String baseUrlwithPage) {

		w.get(baseUrlwithPage);
	}
	
	
	public void waitForSeconds(int sec) throws Exception {

		Thread.sleep(sec * 1000);
	}

	public void handleInputEvent(WebElement we, String value) {

		we.clear();
		we.sendKeys(value);

	}

	
	public void handleClickEvent(WebElement we) {

		we.click();
	}
	
	

	public void handleDropDownList(WebElement we, String value) {

		Select sel = new Select(we);
		sel.selectByVisibleText(value);
	}

	public void handleAlert() {

		try {
			w.switchTo().alert().accept();
		} catch (Exception e) {

		}
	}

	public String readValueFromPropertiesFiles(String Key) throws Exception {

		FileInputStream fi = new FileInputStream(".\\config.properties");

		Properties p = new Properties();
		p.load(fi);
		
		String value  = p.getProperty(Key);		

		fi.close();
		
		return value;

	}

}
