package com.itview.webobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Code_For_Tooltip {

	public static void main(String[] args) {

		WebDriver w = new ChromeDriver();

		w.get("https://www.google.com/");
		
		String tooltipValue=w.findElement(By.name("q")).getAttribute("title");
		
		System.out.println("ToolTip value is : "+tooltipValue);

       Assert.assertEquals(tooltipValue, "Search");
	}

}
