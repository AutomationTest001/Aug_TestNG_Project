package com.itview.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarEMI_PageObject extends TestBase {

	@FindBy(id = "carhome_loan")
	public WebElement loanAmt;

	@FindBy(id = "loan_period")
	public WebElement loanDurationInYear;

	@FindBy(id = "upfront_charges")
	public WebElement upfrontCharges;

	@FindBy(css = "input#interest_rate")
	public WebElement interestRate;

	@FindBy(xpath = "/html/body/div[13]/section[1]/div/div/div[1]/div[1]/div/div[2]/div/div[5]/a[1]")
	public WebElement submitBtn;

	@FindBy(id = "emi")
	public WebElement emiValue;
	
	
	@FindBy(id = "wzrk-cancel")
	public WebElement cancelBtn;

	public void callPageFactoryObject() {

		PageFactory.initElements(w, this);
	}

}
