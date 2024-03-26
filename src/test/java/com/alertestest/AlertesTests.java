package com.alertestest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.TestUtilities;
import com.pages.AlertesPage;
import com.pages.WelcomePage;

public class AlertesTests extends TestUtilities {

	@Test
	public void jsAlertesTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
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

		SoftAssert softAssert = new SoftAssert();

		// verification
		softAssert.assertTrue(alertMessage.equals("I am a JS Alert"), "Alert message is not expected");

		softAssert.assertTrue(result.equals("You successfully clicked an alert"), "Result is not expected");

		softAssert.assertAll();
	}

	@Test
	public void jsDismissTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
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
		Assert.assertTrue(alertMessage.equals("I am a JS Confirm"), "Alert message is not expected");

		Assert.assertTrue(result.equals("You clicked: Cancel"), "Result is not expected");
	}

	@Test
	public void jsPrompTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
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
		Assert.assertTrue(alertMessage.equals("I am a JS prompt"), "Alert message is not expected");

		Assert.assertTrue(result.equals("You entered: test"), "Result is not expected");
	}
}
