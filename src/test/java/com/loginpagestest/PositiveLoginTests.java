package test.java.com.loginpagestest;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.com.base.TestUtilities;
import main.java.com.pages.LoginPage;
import main.java.com.pages.SecureAreaPage;
import main.java.com.pages.WelcomePageObject;

public class PositiveLoginTests extends TestUtilities {
	
	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		
		LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
		
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
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
