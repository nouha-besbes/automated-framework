package com.dropdowntest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.DropdownPage;
import com.pages.WelcomePageObject;

public class DropdownTests extends TestUtilities {

	@Test
	public void selectingDropDownTest() {
		log.info("Starting selectingDropDownTest");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Dropdown link
		DropdownPage dropdownPage = welcomePage.clickDropDownLink();

		// Select option
		dropdownPage.selectOption(2);

		// Verify all checkboxes are checked
		assertEquals(dropdownPage.getSelectedOption(), "Option 2");
	}
}
