package com.loginpagestest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.CsvDataProviders;
import com.base.TestUtilities;
import com.pages.LoginPage;
import com.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInTest(Map<String, String> testData) {
		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLogInTest #" + no + " for " + description);

		WelcomePage welcomePageObject = new WelcomePage(driver, log);
		welcomePageObject.openPage();

		LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
		loginPage.negaliveLogIn(username, password);

		loginPage.waitForErrorMessage();

		// Verification
		String actualErrorMessage = loginPage.getErroMessage();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}

}
