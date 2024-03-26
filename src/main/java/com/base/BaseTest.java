package com.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected Logger log;
	protected WebDriver driver;

	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, @Optional("chrome") String browser, ITestContext context) {
		String testName = context.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);

		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);

		driver = factory.createDriver();

		this.driver.manage().window().maximize();

		this.testMethodName = method.getName();
		this.testSuiteName = context.getSuite().getName();
		this.testName = testName;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
//		if (testResult.getStatus() == ITestResult.FAILURE) {
//			TestUtilities test = new TestUtilities();
//			test.takeScreenshot(testSuiteName);
//		}
		log.info("Close driver");
		// Close browser
		driver.quit();
	}

}
