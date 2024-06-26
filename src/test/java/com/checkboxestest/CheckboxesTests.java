package com.checkboxestest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.CheckboxesPage;
import com.pages.WelcomePage;

public class CheckboxesTests extends TestUtilities {

	@Test
	public void selectingTwoCheckboxesTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Checkboxes link
		CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

		// Select All Checkboxes
		checkboxesPage.selectAllCheckboxes();

		// Verify all checkboxes are checked
		assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");

	}
}
