package com.fileuploadertest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.FileUploaderPage;

public class FileUploaderTests extends TestUtilities {

	@Test(dataProvider = "files")
	public void fileUploaderTest(int number, String fileName) {

		log.info("Starting fileUploadTest #" + number + " for " + fileName);

		// click on editor link
		FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);

		fileUploaderPage.openPage();

		fileUploaderPage.selectFile(fileName);

		fileUploaderPage.pushUploadButton();

		String result = fileUploaderPage.getUploadedFileName();

		// Verify Result text is expected
		Assert.assertTrue(result.equals(fileName),
				"result is not expected. \nShould be 'You selected: test.txt', but it is '" + result + "'");
	}

}
