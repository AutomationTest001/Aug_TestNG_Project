package com.itview.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FD_PageObject extends TestBase {

	@FindBy(id = "principal")
	public WebElement principalTextBox;

	@FindBy(id = "interest")
	public WebElement interestTextBox;

	@FindBy(id = "tenure")
	public WebElement tenureTextBox;

	@FindBy(id = "frequency")
	public WebElement frequencyDropDown;

	@FindBy(id = "tenurePeriod")
	public WebElement tenurePeriodDropDown;

	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement calculateBtn;
	
	@FindBy(xpath="//*[@id=\"resp_matval\"]/strong")
	public WebElement maturityValue;
	
	@FindBy(id = "wzrk-cancel")
	public WebElement cancelBtn;

	public void callPageFactoryObject() {

		PageFactory.initElements(w, this);
	}

}
