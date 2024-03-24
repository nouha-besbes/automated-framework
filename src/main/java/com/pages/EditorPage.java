package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePageObject {

	public EditorPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By textEditorLocator = By.id("tinymce");

	private By frameLocator = By.tagName("iframe");

	public String getEditorText() {
		switchToFrame(frameLocator);
		waitForVisibilityOf(textEditorLocator, Duration.ofSeconds(5));
		String text = find(textEditorLocator).getText();
		log.info("Text from TinyMCE WYSIWYG Editor: " + text);
		return text;
	}

}
