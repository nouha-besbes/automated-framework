package com.draganddroptest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.DragAndDropPage;

public class DragAndDropTests extends TestUtilities {

	@Test
	public void dragColumAIntoColumBTest() {
		log.info("Starting drag and drop test");

		// open main page
		DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, log);
		dragAndDropPage.openPage();

		// Click operate drag and drop
		dragAndDropPage.dragAtoB();

		// Verify correct headers in correct boxes
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnBText.equals("A"), "Column A header should be B, but it is: " + columnBText);
	}
}
