package com.itview.webobject;

import java.net.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Code_For_BrokenLinks {

	public static void main(String[] args) throws Exception {

		WebDriver w = new ChromeDriver();

		w.get("https://demo.automationtesting.in/Register.html");

		List<WebElement> links = w.findElements(By.tagName("a"));
		System.out.println("Number of links on page : " + links.size());

		try {

			for (int i = 0; i < links.size(); i++) {

				String href = links.get(i).getAttribute("href");

				HttpURLConnection huc = (HttpURLConnection) (new URL(href).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();

				if (huc.getResponseCode() >= 400) {

					System.out.println("Link is broken : " + href);
				}

			}
		} catch (Exception e) {

		}
		Thread.sleep(3000);
		//w.close();

	}

}
