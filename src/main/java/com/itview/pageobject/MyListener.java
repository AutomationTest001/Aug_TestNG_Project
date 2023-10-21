package com.itview.pageobject;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyListener implements ITestListener {
	
	ExtentSparkReporter spark;
	ExtentReports extent_add;
	ExtentTest test_update;


	public void onTestSuccess(ITestResult result) {
		
		
		test_update=extent_add.createTest(result.getMethod().getDescription());
		test_update.log(Status.PASS,MarkupHelper.createLabel("Name of Passed test case : "+result.getMethod(),ExtentColor.GREEN));


		Reporter.log("Test Case Passed : " + result.getMethod().getDescription(),true);
	}

	public void onTestFailure(ITestResult result) {
		
		test_update=extent_add.createTest(result.getMethod().getDescription());
		test_update.log(Status.FAIL,MarkupHelper.createLabel("Name of Failed test case : "+result.getMethod(),ExtentColor.RED));


		Reporter.log("Test Case Failed : " + result.getMethod().getDescription());
	}

	public void onTestSkipped(ITestResult result) {
		
		test_update=extent_add.createTest(result.getMethod().getDescription());
		test_update.log(Status.SKIP,MarkupHelper.createLabel("Name of Skipped test case : "+result.getMethod(),ExtentColor.GREY));


		Reporter.log("Test Case Skipped : " + result.getMethod().getDescription());

	}
	
	
	    public void onStart(ITestContext context) {
	    	extent_add = new ExtentReports();
	    	spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");
	    	extent_add.attachReporter(spark);
	    	spark.config().setDocumentTitle("ExtentReport");
	    	
	    	extent_add.setSystemInfo("User","AutomationUser");
	    	extent_add.setSystemInfo("OS","Window 11");
	    	extent_add.setSystemInfo("Automation Tool","Selenium 4.12");


		}

		public void onFinish(ITestContext context) {

			extent_add.flush();

		}

}
