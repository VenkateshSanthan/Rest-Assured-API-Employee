package com.employeeApi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_Base {

	public static RequestSpecification httpRequest;
	public static Response response;
	public static String	responseBody;
	public String empId = "6";

	public Logger logger;

	@BeforeClass
	public void setUp() {

		
		logger = Logger.getLogger("RestAssuredAPITesting_Employee_Project");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);

	}

}
