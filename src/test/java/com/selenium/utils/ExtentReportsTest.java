package com.selenium.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentReports extentReports = new ExtentReports();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/result.html");
		
		extentReports.attachReporter(spark);
		
		ExtentTest testSuite = extentReports.createTest("Test Suite");
		
		ExtentTest testCase = testSuite.createNode("Test Case1");
		
		testCase.log(Status.PASS, "Teststep one is pass");
	
	//    testCase.log(Status.FAIL, "Teststep two is failed", MediaEntityBuilder.createScreenCaptureFromPath("../report/images/failed.png").build());

	    extentReports.flush();
		}
	

}
