package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {

	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private String pageUrl = "http://the-internet.herokuapp.com/upload";

	private By choseFileFieldLocator = By.id("file-upload");

	private By uploadButtonLocator = By.id("file-submit");

	private By uploadedFilesLocator = By.id("uploaded-files");

	public void openPage() {
		openUrl(pageUrl);
	}

	public void selectFile(String fileName) {
		log.info("Selecting '" + fileName + "' file from Files folder");
		// Selecting file
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, choseFileFieldLocator);
		log.info("File selected");
	}

	public void pushUploadButton() {
		log.info("push upload file");
		click(uploadButtonLocator);
	}

	public String getUploadedFileName() {
		String fileName = find(uploadedFilesLocator).getText();
		log.info("uploaded file name: " + fileName);
		return fileName;
	}

}
