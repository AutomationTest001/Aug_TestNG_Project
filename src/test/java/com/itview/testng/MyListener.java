package com.itview.testng;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListener implements ITestListener {


	public void onTestSuccess(ITestResult result) {

		Reporter.log("Test Case Passed : " + result.getMethod().getDescription(),true);
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Failed : " + result.getMethod().getDescription());
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Case Skipped : " + result.getMethod().getDescription());

	}

}
