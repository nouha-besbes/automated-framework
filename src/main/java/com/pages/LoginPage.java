package main.java.com.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

	
	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	private By userNameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By logInButtonLocator = By.className("radius");
	private By errorMessageLocator = By.id("flash");
	
	public SecureAreaPage logIn(String userName, String password) {
		loginData(userName, password);
		return new SecureAreaPage(driver, log);
	}
	
	public void negaliveLogIn(String userName, String password) {
		loginData(userName, password);
	}

	private void loginData(String userName, String password) {
		log.info("Executing LogIn with User " + userName + " and password " + password);
		
		// enter username and password
		type(userName, userNameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
	}
	
	public String getErroMessage() {
		return find(errorMessageLocator).getText();
	}
	
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, Duration.ofSeconds(10));
	}
}
