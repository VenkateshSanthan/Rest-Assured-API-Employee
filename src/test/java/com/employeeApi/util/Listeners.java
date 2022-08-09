package com.employeeApi.util;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext testContext) {

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/myReport.html"); //Specify location

		htmlReporter.config().setDocumentTitle("Automation Report"); // Title Of Report
		htmlReporter.config().setReportName("Rest Assured API");// name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("User Name", "Venkatesh");

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName()); //create new entry in the report

		test.log(Status.PASS, "Test Case PASSED Is" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());//create new entry in the Report

		test.log(Status.FAIL, "Test Case FAILED Is" + result.getName()); //to add name in extent report
		test.log(Status.FAIL, "Test Case FAILED Is" + result.getThrowable()); // to add error/exception in extent report

	}
	public void onTestSkipped(ITestResult result) {
	
	
		test = extent.createTest(result.getName());  //create new entry in the Report
		test.log(Status.SKIP, "Test Case Skipped Is"+result.getName());
		
		
		
	}
	
	public void onFinsh(ITestContext testContext) {
		extent.flush();
	}
	
	
	
	
}
