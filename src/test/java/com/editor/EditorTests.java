package com.editor;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.EditorPage;
import com.pages.WelcomePageObject;

public class EditorTests extends TestUtilities {

	@Test
	public void editorTest() {
		log.info("Starting editor tests");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on editor link
		EditorPage editorPage = welcomePage.clickEditorLink();

		assertEquals(editorPage.getEditorText(), "Your content goes here.", "Editor default text is not expected.");

	}

}
