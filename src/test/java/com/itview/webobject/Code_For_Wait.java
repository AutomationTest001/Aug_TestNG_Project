package com.itview.webobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Code_For_Wait {

	public static void main(String[] args) throws Exception {
		
		WebDriver w = new ChromeDriver();
		
		//w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
			
			w.get("https://in.via.com/flight-tickets");

			w.findElement(By.id("wzrk-cancel")).click(); 

			// Select source location
			w.findElement(By.id("source")).sendKeys("Mumbai");
			
			Thread.sleep(2000);
			
			w.findElement(By.id("ui-id-1")).click();
			

			// Select target location

			w.findElement(By.id("destination")).sendKeys("Pune");
			
			Thread.sleep(2000);
			
			w.findElement(By.id("ui-id-2")).click();

		
			Thread.sleep(2000);

			w.findElement(By.xpath("//*[@id=\"depart-cal\"]/div[3]/div[2]/div[3]/div[1]")).click();

			Thread.sleep(2000);
			
			w.findElement(By.id("search-flight-btn")).click();

		//	Thread.sleep(8000);
			
		//	WebDriverWait wt=new WebDriverWait(w, Duration.ofSeconds(30)); //Time
	//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));
		
			
			Wait<WebDriver> fluentwt = new FluentWait<WebDriver>(w)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)) // poll every 5 sec
					.ignoring(NoSuchElementException.class); // this defines the
					
			fluentwt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));

			
			String lowestFlightPrice = w.findElement(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")).getText();

			System.out.println("Cheapest Flights is : " + lowestFlightPrice);

			
		w.close();

	}

}
