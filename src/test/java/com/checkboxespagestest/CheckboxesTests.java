package test.java.com.checkboxespagestest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import main.java.com.base.TestUtilities;
import main.java.com.pages.CheckboxesPage;
import main.java.com.pages.WelcomePageObject;

public class CheckboxesTests extends TestUtilities {

	@Test
	public void selectingTwoCheckboxesTest() {
		log.info("Starting selectingTwoCheckboxesTest");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Checkboxes link
		CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

		// Select All Checkboxes
		checkboxesPage.selectAllCheckboxes();

		// Verify all checkboxes are checked
		assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");

	}
}
