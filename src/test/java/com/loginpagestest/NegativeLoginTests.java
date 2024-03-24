package com.loginpagestest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.LoginPage;
import com.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

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
