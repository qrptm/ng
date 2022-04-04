package com.inetBankingV1.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class LoginTest_001 extends BaseClass {

	// @Test
	public void testHelloWorld() {
		logger.debug("Sample DEBUG message");
		logger.error("Sample ERROR message");
		logger.info("Sample INFO message");
		logger.warn("Sample WARN message");
		test.log(LogStatus.PASS, "Test_001 is passed");
	}

	@Test
	public void loginTest() {
		driver.get(baseURL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		logger.info("Hello world!");

		if (driver.getTitle().equals(" Guru99 Bank Home Page ")) {
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "Test_001 is passed");
		} else {
			Assert.assertTrue(true);
			test.log(LogStatus.FAIL, "Test_001 is failed");
			try {
				test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Test Failed");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
