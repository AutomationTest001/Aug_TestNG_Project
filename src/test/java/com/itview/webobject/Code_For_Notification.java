package com.itview.webobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Code_For_Notification {

	public static void main(String[] args) throws Exception {

    ChromeOptions opt=new ChromeOptions();    
    opt.addArguments("--disable-notifications");
    
		WebDriver w = new ChromeDriver(opt);		
		w.get("https://www.justdial.com/");

	}

}
