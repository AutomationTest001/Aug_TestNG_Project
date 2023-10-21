package com.itview.webobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Code_For_SSL {

	public static void main(String[] args) throws Exception {

    ChromeOptions opt=new ChromeOptions();    
      opt.setAcceptInsecureCerts(true);

		WebDriver w = new ChromeDriver(opt);		
		w.get("https://expired.badssl.com/");

	}

}
