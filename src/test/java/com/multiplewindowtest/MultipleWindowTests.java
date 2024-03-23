package com.multiplewindowtest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.NewWindowPage;
import com.pages.WelcomePageObject;
import com.pages.WindowPage;

public class MultipleWindowTests extends TestUtilities {

	@Test
	public void openTabTest() {
		log.info("Starting open tab tests");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on Window link
		WindowPage windowPage = welcomePage.clickWindowLink();

		// open new window
		windowPage.openNewWindow();

		NewWindowPage newWindowPage = windowPage.switchToNewWindowPage();

		// get page source
		String newWindowUrl = newWindowPage.getCurrentPageSource();

		// verification
		assertTrue(newWindowUrl.contains("New Window"), "New Window is expected, result not expected");
	}

}
