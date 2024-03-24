package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {

	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private String pageUrl = "http://the-internet.herokuapp.com/key_presses";

	private By body = By.xpath("//body");

	private By resultTextLocator = By.id("result");

	public void presseskeyWithBody(Keys key) {
		log.info("press key operation");
		openUrl(pageUrl);
		presseskey(body, key);
	}

	public void presseskeyWithoutBody(Keys key) {
		log.info("press key operation");
		openUrl(pageUrl);
		presseskey(key);
	}

	public String getMessageResult() {
		return find(resultTextLocator).getText();
	}

}
