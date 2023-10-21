package com.itview.keyworddriven_test;

import org.testng.annotations.Test;

import com.itview.pageobject.FD_PageObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.AfterTest;

public class FD_DataProvider_keywordDriven {

	FD_PageObject fd = new FD_PageObject();

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "100000", "6.5", "4" }, new Object[] { "200000", "7", "10" },
				new Object[] { "300000", "4", "2" }, };
	}

	@BeforeTest
	public void beforeTest() throws Exception {

		fd.openBrowser(fd.readValueFromPropertiesFiles("browser"));
		fd.callPageFactoryObject();
		fd.openApplicationUrl(fd.readValueFromPropertiesFiles("fd_url"));

	}

	@Test(dataProvider = "dp")
	public void f(String principleValaue, String roiValue, String tenureValue) throws Exception {
		
		try {
			fd.handleClickEvent(fd.cancelBtn);

		} catch (Exception e) {
		}

		fd.handleInputEvent(fd.principalTextBox, principleValaue);
		fd.handleInputEvent(fd.interestTextBox, roiValue);
		fd.handleInputEvent(fd.tenureTextBox, tenureValue);

		fd.handleDropDownList(fd.tenurePeriodDropDown, "year(s)");
		fd.handleDropDownList(fd.frequencyDropDown, "Simple Interest");
		
		fd.handleClickEvent(fd.calculateBtn);
		
		fd.waitForSeconds(2);

		String maturityValue = fd.maturityValue.getText();

		System.out.println("Maturity Value : " + maturityValue);
	}

	@AfterTest
	public void afterTest() {

		fd.closeBrowser();
	}

}
