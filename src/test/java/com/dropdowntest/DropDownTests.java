package com.dropdowntest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.DropdownPage;
import com.pages.WelcomePageObject;

public class DropDownTests extends TestUtilities {

	@Test
	public void selectingDropDownTest() {
		log.info("Starting selectingDropDownTest");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Checkboxes link
		DropdownPage checkboxesPage = welcomePage.clickDropDownLink();

		// Select option
		checkboxesPage.selectOption(2);

		// Verify all checkboxes are checked
		assertEquals(checkboxesPage.getSelectedOption(), "Option 2");
	}
}
