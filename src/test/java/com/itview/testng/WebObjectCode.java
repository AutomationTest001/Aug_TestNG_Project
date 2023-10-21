package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class WebObjectCode {

	WebDriver w;

	@BeforeTest
	public void openBrowser() {

		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Handle TextBox")
	public void handleTextBox() throws Exception {

		w.get("https://demo.automationtesting.in/Register.html");

		w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Steve");

		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Jones");

		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("123/B-1 Smple Test Address");

	}

	@Test(priority = 1, description = "verify Value From TextBox Field")
	public void verifyValueFromTextBox() throws Exception {

		String register = w.findElement(By.xpath("//*[@id=\"section\"]/div/h2")).getText();
		System.out.println("Label Value : " + register);

		String firstname = w.findElement(By.cssSelector("input[ng-model='FirstName']")).getAttribute("value");
		System.out.println("Firstname is : " + firstname);
		Assert.assertEquals(firstname, "Steve");

	}

	@Test(priority = 2, description = "Handle RadioButton and CheckBox")
	public void handleRadioButton_Checkbox() throws Exception {

		w.findElement(By.cssSelector("input[value='FeMale']")).click();

		w.findElement(By.id("checkbox1")).click();

		w.findElement(By.id("checkbox3")).click();

	}

	@Test(priority = 3, description = "Handle DropDown List")
	public void handleDropDownList() throws Exception {

		WebElement skillsDropDown = w.findElement(By.id("Skills"));

		Select sel = new Select(skillsDropDown);

		// sel.selectByIndex(9);

		// sel.selectByValue("AutoCAD");

		sel.selectByVisibleText("HTML");

	}

	@Test(priority = 4, description = "Print value from DropDown List")
	public void printValueDropDownList() throws Exception {

		WebElement monthDropDown = w.findElement(By.cssSelector("select[ng-model='monthbox']"));

		Select sel = new Select(monthDropDown);

		List<WebElement> valueFromDropDown = sel.getOptions();

		int dataCount = valueFromDropDown.size();

		for (int i = 1; i < dataCount; i++) {

			System.out.println(valueFromDropDown.get(i).getText());
		}

	}

	@Test(priority = 5, description = "Verify value from DropDown List")
	public void verifyValueDropDownList() throws Exception {

		WebElement skillsDropDown = w.findElement(By.id("Skills"));
		Select sel = new Select(skillsDropDown);
		sel.selectByVisibleText("Java");
		
		WebElement firstSelectedOption=sel.getFirstSelectedOption();

		String skillsSelectedValue = firstSelectedOption.getText();
		System.out.println("Selected Value from Drop Down is : "+skillsSelectedValue);
		
		Assert.assertEquals(skillsSelectedValue, "Java");

	}

	@AfterTest
	public void closeBrowser() throws Exception {

		Thread.sleep(6000);
		w.close();

	}

}
