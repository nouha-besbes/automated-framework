package com.keypressestest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.KeyPressesPage;

public class KeyPressesTests extends TestUtilities {

	@Test
	public void keyPressesTests() {

		log.info("Starting keyPresses tests");

		// click on editor link
		KeyPressesPage keyPressesPage = new KeyPressesPage(driver, log);

		keyPressesPage.presseskeyWithBody(Keys.ENTER);

		String result = keyPressesPage.getMessageResult();

		// Verify Result text is expected
		Assert.assertTrue(result.equals("You entered: ENTER"),
				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
	}

	@Test
	public void keyPressesCase2Tests() {

		log.info("Starting keyPresses tests");

		// click on editor link
		KeyPressesPage keyPressesPage = new KeyPressesPage(driver, log);

		keyPressesPage.presseskeyWithoutBody(Keys.ADD);

		String result = keyPressesPage.getMessageResult();

		// Verify Result text is expected
		Assert.assertTrue(result.equals("You entered: ADD"),
				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
	}

}
