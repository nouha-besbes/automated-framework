package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends BasePageObject {

	public WindowPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By linkLocator = By.linkText("Click Here");

	public void openNewWindow() {
		log.info("open new window");
		click(linkLocator);
	}

	// Switch to new window page
	public NewWindowPage switchToNewWindowPage() {
		log.info("Switching to new window page");
		switchToWindowWithTitle("New Window");
		return new NewWindowPage(driver, log);
	}

}
