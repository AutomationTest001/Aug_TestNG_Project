package com.itview.webobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Code_For_WindowAuth {

	public static void main(String[] args) throws Exception {


		WebDriver w = new ChromeDriver();

		//https://username:password@URL
		
		w.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}
