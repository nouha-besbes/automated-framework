package main.java.com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/";

	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openPage() {
		// open main page
		openUrl(pageUrl);
		log.info("Main page is opened.");
	}
	
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on welcome Page");
		// Click on Form Authentication link
		click(By.linkText("Form Authentication"));
		return new LoginPage(driver, log);
	}
}
