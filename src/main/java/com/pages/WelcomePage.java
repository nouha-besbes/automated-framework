package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/";

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By authenticationFormLocator = By.linkText("Form Authentication");

	private By checkboxesLinkLocator = By.cssSelector("a[href='/checkboxes']");

	private By dropdownLinkLocator = By.linkText("Dropdown");

	private By alertesLinkLocator = By.linkText("JavaScript Alerts");

	private By multipeWindowLinkLocator = By.linkText("Multiple Windows");

	private By editorLinkLocator = By.linkText("WYSIWYG Editor");

	public void openPage() {
		// open main page
		openUrl(pageUrl);
		log.info("Main page is opened.");
	}

	public CheckboxesPage clickCheckboxesLink() {
		log.info("Clicking checkbexes link on welcome Page");
		// Click on Form Authentication link
		click(checkboxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}

	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on welcome Page");
		// Click on Form Authentication link
		click(authenticationFormLocator);
		return new LoginPage(driver, log);
	}

	public DropdownPage clickDropDownLink() {
		log.info("Clicking dropdown link on welcome Page");
		// Click on Form Authentication link
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}

	public AlertesPage clickAlertesLink() {
		log.info("Clicking dropdown link on welcome Page");
		// Click on Form Authentication link
		click(alertesLinkLocator);
		return new AlertesPage(driver, log);
	}

	public WindowPage clickWindowLink() {
		log.info("Clicking window link on welcome Page");
		// Click on window link
		click(multipeWindowLinkLocator);
		return new WindowPage(driver, log);
	}

	public EditorPage clickEditorLink() {
		log.info("Clicking window link on welcome Page");
		// Click on editor link
		click(editorLinkLocator);
		return new EditorPage(driver, log);
	}

}
