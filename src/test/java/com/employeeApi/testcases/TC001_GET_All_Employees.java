package com.employeeApi.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.Test_Base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC001_GET_All_Employees {

	public class getAllEmplyees extends Test_Base {

		@BeforeClass
		void getAllEmployees() throws InterruptedException {
			logger.info("**** Started TC001_GET_ALL_Employees****");

			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
			httpRequest = RestAssured.given();
			response = httpRequest.request(Method.GET, "/employees");

			Thread.sleep(3000);

		}

		@Test
		void checkResponseBody() {
			logger.info("****Checking Response Body****");
			responseBody = response.getBody().asString();
			logger.info("Response Body is===>" + responseBody);
			Assert.assertTrue(responseBody != null);

		}

		@Test
		void checkStatusCode() {
			logger.info("****Checking Status Code****");
			int statusCode = response.getStatusCode();
			logger.info("Status Code is===>" + statusCode);
//			Assert.assertEquals(statusCode, 200);

		}

		@Test
		void checkContentType() {
			logger.info("****Checking Content Type****");
			String contentType = response.header("Content-Type");
			logger.info("Content Type is===>" + contentType);
//			Assert.assertEquals(contentType, "application/json");
		}

		@Test
		void checkHeaders() {

			logger.info("****Checking Headers****");
			Headers headers = response.getHeaders();
			logger.info("Check Headers are===>" + headers);
			Assert.assertTrue(headers != null);

		}

		@Test
		void checkServerType() {
			logger.info("****Checking Server Type****");
			String serverType = response.header("Server");
			logger.info("Check Server Type===>" + serverType);
			Assert.assertEquals(serverType, "nginx");

		}

		@Test
		void checkResponseTime() {
			logger.info("****Checking Response Time****");
			long responseTime = response.getTime();
			logger.info("Cookies Are==>" + responseTime);

			
			}
		

		@AfterClass
		void tearDown() {

		logger.info("****Completed TC001_GET_All_Employees****");	
		}

	}

}
