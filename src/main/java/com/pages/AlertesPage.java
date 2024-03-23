package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertesPage extends BasePageObject {

	public AlertesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By buttonJsAlertLocator = By.cssSelector("button[onclick='jsAlert()']");

	private By buttonJsConfirmLocator = By.cssSelector("button[onclick='jsConfirm()']");

	private By buttonJsPrompLocator = By.cssSelector("button[onclick='jsPrompt()']");

	private By resultLocator = By.id("result");

	public void openJsAlert() {
		log.info("button js alert");
		click(buttonJsAlertLocator);
	}

	public void openConfirmAlert() {
		log.info("button confirm");
		click(buttonJsConfirmLocator);
	}

	public void openPrompAlert() {
		log.info("button promp");
		click(buttonJsPrompLocator);
	}

	// Switch to alert and press ok
	public void acceptAlert() {
		log.info("Switching to alert and press ok");
		Alert alert = switchToAlerte();
		alert.accept();
	}

	// Switch to alert and press ok
	public void acceptAndPrompAlert(String text) {
		log.info("Switching to alert and press ok");
		Alert alert = switchToAlerte();
		alert.sendKeys(text);
		alert.accept();
	}

	// Switch to alert and press dismiss
	public void dismissAlert() {
		log.info("Switching to alert and press dismiss");
		Alert alert = switchToAlerte();
		alert.dismiss();
	}

	// Switch to alert and press ok
	public String getAlertText() {
		log.info("Switching to alert and read text");
		Alert alert = switchToAlerte();
		return alert.getText();
	}

	public String getResultText() {
		return find(resultLocator).getText();
	}

}
