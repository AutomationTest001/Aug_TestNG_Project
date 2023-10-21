package com.itview.keyworddriven_test;

import org.testng.annotations.Test;

import com.itview.pageobject.CarEMI_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;

@Listeners(com.itview.pageobject.MyListener.class)

public class CarEMI_Test {

	CarEMI_PageObject car_emi = new CarEMI_PageObject();

	@BeforeTest
	public void preCondition() throws Exception {

		car_emi.openBrowser(car_emi.readValueFromPropertiesFiles("browser"));
		car_emi.callPageFactoryObject();
	}

	@Test(priority = 0, description = "Verify Loan Amount of 1 lac")
	public void loanAmt_1_lakh() throws Exception {
		
		String baseUrl=car_emi.readValueFromPropertiesFiles("baseUrl");
		String caremiUrl=car_emi.readValueFromPropertiesFiles("car_emi_url");

		car_emi.openApplicationUrl(baseUrl+caremiUrl);
		
		car_emi.handleClickEvent(car_emi.cancelBtn);
		
		car_emi.waitForSeconds(2);

		car_emi.handleInputEvent(car_emi.loanAmt, "100000");

		car_emi.handleInputEvent(car_emi.loanDurationInYear, "5");

		car_emi.handleInputEvent(car_emi.upfrontCharges, "1000");

		car_emi.handleInputEvent(car_emi.interestRate, "7");

		car_emi.handleClickEvent(car_emi.submitBtn);

		car_emi.waitForSeconds(2);

		String emiValue = car_emi.emiValue.getText();

		System.out.println("Emi Value is : " + emiValue);

		car_emi.waitForSeconds(2);

	}
	
	@Test(priority = 1, description = "Verify Loan Amount of 2 lac")
	public void loanAmt_2_lakh() throws Exception {
		
		String baseUrl=car_emi.readValueFromPropertiesFiles("baseUrl");
		String caremiUrl=car_emi.readValueFromPropertiesFiles("car_emi_url");

		car_emi.openApplicationUrl(baseUrl+caremiUrl);
		
	//	car_emi.handleClickEvent(car_emi.cancelBtn);
		
		car_emi.waitForSeconds(2);

		car_emi.handleInputEvent(car_emi.loanAmt, "200000");

		car_emi.handleInputEvent(car_emi.loanDurationInYear, "6");

		car_emi.handleInputEvent(car_emi.upfrontCharges, "8000");

		car_emi.handleInputEvent(car_emi.interestRate, "7");

		car_emi.handleClickEvent(car_emi.submitBtn);

		car_emi.waitForSeconds(2);

		String emiValue = car_emi.emiValue.getText();

		System.out.println("Emi Value is : " + emiValue);

		car_emi.waitForSeconds(2);

	}
	
	@Test(priority = 2, description = "Verify Loan Amount of 3 lac")
	public void loanAmt_3_lakh() throws Exception {
		
		String baseUrl=car_emi.readValueFromPropertiesFiles("baseUrl");
		String caremiUrl=car_emi.readValueFromPropertiesFiles("car_emi_url");

		car_emi.openApplicationUrl(baseUrl+caremiUrl);
		
		//car_emi.handleClickEvent(car_emi.cancelBtn);
		
		car_emi.waitForSeconds(2);

		car_emi.handleInputEvent(car_emi.loanAmt, "300000");

		car_emi.handleInputEvent(car_emi.loanDurationInYear, "5");

		car_emi.handleInputEvent(car_emi.upfrontCharges, "2000");

		car_emi.handleInputEvent(car_emi.interestRate, "4");

		car_emi.handleClickEvent(car_emi.submitBtn);

		car_emi.waitForSeconds(2);

		String emiValue = car_emi.emiValue.getText();

		System.out.println("Emi Value is : " + emiValue);

		car_emi.waitForSeconds(2);

	}

	@AfterTest
	public void postCondition() {

		car_emi.closeBrowser();
	}

}
