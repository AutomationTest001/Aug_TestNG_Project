package com.itview.testcases.selenium_aug_batch;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class FirstTestCase {

	public static void main(String[] args) throws Exception {


		
		WebDriver w=new ChromeDriver();
		
		//Step 1 : Open application with url
		
		w.get("http://altoromutual.com:8080/login.jsp");
		
		//Step 2 : Enter username

		w.findElement(By.id("uid")).sendKeys("admin");
		
		//Step 3 : Enter Password

		w.findElement(By.id("passw")).sendKeys("admin");
		
		//Step 4: Click login
		
		w.findElement(By.name("btnSubmit")).click();
		
		
		Thread.sleep(2000);// pause execution for 2000 millisec = 2 sec
		
		
		//Selecting all links using linkText
		
		w.findElement(By.linkText("PERSONAL")).click();
		
		Thread.sleep(2000);
		
		w.findElement(By.linkText("MY ACCOUNT")).click();
		
		Thread.sleep(2000);
		
		
		w.findElement(By.linkText("View Account Summary")).click();
		
		Thread.sleep(2000);
		
		//Step 5: Click Logout
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		Thread.sleep(2000);

		//Step 6 : Close 
		
		w.close();
		
		System.out.println("Login Admin Successfully !!!");
		
		
		

	}

}
