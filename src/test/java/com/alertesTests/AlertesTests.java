package com.alertesTests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.AlertesPage;
import com.pages.WelcomePageObject;

public class AlertesTests extends TestUtilities {

	@Test
	public void jsAlertesTest() {
		log.info("Starting jsAlerte tests");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on Checkboxes link
		AlertesPage alertesPage = welcomePage.clickAlertesLink();

		// clic for js alert
		alertesPage.openJsAlert();

		// get alert text
		String alertMessage = alertesPage.getAlertText();

		alertesPage.acceptAlert();

		// get results text
		String result = alertesPage.getResultText();

		// verification
		assertTrue(alertMessage.equals("I am a JS Alert"), "Alert message is not expected");

		assertTrue(result.equals("You successfully clicked an alert"), "Result is not expected");
	}

	@Test
	public void jsDismissTest() {
		log.info("Starting js dismiss test");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on Checkboxes link
		AlertesPage alertesPage = welcomePage.clickAlertesLink();

		// clic for js alert
		alertesPage.openConfirmAlert();

		// get alert text
		String alertMessage = alertesPage.getAlertText();

		alertesPage.dismissAlert();

		// get results text
		String result = alertesPage.getResultText();

		// verification
		assertTrue(alertMessage.equals("I am a JS Confirm"), "Alert message is not expected");

		assertTrue(result.equals("You clicked: Cancel"), "Result is not expected");
	}

	@Test
	public void jsPrompTest() {
		log.info("Starting js promp test");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on Checkboxes link
		AlertesPage alertesPage = welcomePage.clickAlertesLink();

		// clic for js alert
		alertesPage.openPrompAlert();

		// get alert text
		String alertMessage = alertesPage.getAlertText();

		alertesPage.acceptAndPrompAlert("test");

		// get results text
		String result = alertesPage.getResultText();

		// verification
		assertTrue(alertMessage.equals("I am a JS prompt"), "Alert message is not expected");

		assertTrue(result.equals("You entered: test"), "Result is not expected");
	}
}
