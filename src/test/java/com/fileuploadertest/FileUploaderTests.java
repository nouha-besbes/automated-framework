package com.fileuploadertest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.FileUploaderPage;

public class FileUploaderTests extends TestUtilities {

	@Test
	public void FileUploaderTest() {

		log.info("Starting FileUploaderTest tests");

		// click on editor link
		FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);

		fileUploaderPage.openPage();

		fileUploaderPage.selectFile("test.txt");

		fileUploaderPage.pushUploadButton();

		String result = fileUploaderPage.getUploadedFileName();

		// Verify Result text is expected
		Assert.assertTrue(result.equals("test.txt"),
				"result is not expected. \nShould be 'You selected: test.txt', but it is '" + result + "'");
	}

}
