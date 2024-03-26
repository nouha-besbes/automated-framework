package com.loginpagestest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.LoginPage;
import com.pages.SecureAreaPage;
import com.pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {

		WelcomePage welcomePageObject = new WelcomePage(driver, log);
		welcomePageObject.openPage();

		LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), expectedUrl);

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccesufMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
}
