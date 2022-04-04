package com.inetBankingV1.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.log4testng.Logger;

import com.inetBankingV1.testData.Credential;
import com.inetBankingV1.utilities.FileUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public String baseURL;// = "https://demo.guru99.com/v4/index.php";
	public String username;// = "mngr396721";
	public String password;// = "dYzujyn";
	public WebDriver driver;
	public static org.apache.logging.log4j.Logger logger;
	public static ExtentTest test;
	public static ExtentReports report;

	@BeforeClass
	public void setup() {
		Credential cred = FileUtility.getData();
		baseURL = cred.getUrl();
		username = cred.getUsername();
		password = cred.getPassword();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		// logger = LoggerFactory.getLogger(BaseClass.class);
		driver.manage().window().maximize();
		logger = LogManager.getLogger();
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}

	@AfterClass
	public void tearDown() {
		report.endTest(test);
		report.flush();
		// driver.close();
	}

	public static String capture(WebDriver driver) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("src/../Screenshots/" + System.currentTimeMillis() + ".png");
		String errflpath = destination.getAbsolutePath();
		FileUtils.copyFile(source, destination);
		return errflpath;
	}

}
