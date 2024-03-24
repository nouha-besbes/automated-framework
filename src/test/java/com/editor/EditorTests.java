package com.editor;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.EditorPage;
import com.pages.WelcomePage;

public class EditorTests extends TestUtilities {

	@Test
	public void editorTest() {
		log.info("Starting editor tests");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);

		welcomePage.openPage();

		// Scroll to the bottom
		welcomePage.scrollToBottom();

		// click on editor link
		EditorPage editorPage = welcomePage.clickEditorLink();

		sleep(5000);

		String result = editorPage.getEditorText();

		assertEquals(result, "Your content goes here.", "Editor default text is not expected.");

	}

}
