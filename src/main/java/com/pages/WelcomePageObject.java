package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/";

	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By authenticationFormLocator = By.linkText("Form Authentication");

	private By checkboxesLinkLocator = By.cssSelector("a[href='/checkboxes']");

	private By dropdownLinkLocator = By.linkText("Dropdown");

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
}
