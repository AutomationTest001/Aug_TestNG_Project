package com.itview.testcases.selenium_aug_batch;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class XpathTestCase {

	public static void main(String[] args) throws Exception {


		
		WebDriver w=new ChromeDriver();
		
	
		
		w.get("http://altoromutual.com:8080/login.jsp");
		
		w.findElement(By.xpath("//input[@id='uid']")).sendKeys("admin");
		
		w.findElement(By.xpath("//input[@name='passw']")).sendKeys("admin");
		
		w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/form/table/tbody/tr[3]/td[2]/input")).click();
		
		Thread.sleep(2000);
		
		w.close();
		
		System.out.println("xpath test cases executed Successfully !!!");
		
		
		

	}

}
