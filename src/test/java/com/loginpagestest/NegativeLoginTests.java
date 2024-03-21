package test.java.com.loginpagestest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.com.base.TestUtilities;
import main.java.com.pages.LoginPage;
import main.java.com.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities{


	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
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
