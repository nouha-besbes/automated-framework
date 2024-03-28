package com.stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.pages.LoginPage;
import com.pages.SecureAreaPage;
import com.pages.WelcomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition {

	private Logger log = LogManager.getLogger("LoginTest");
	private WebDriver driver = new FirefoxDriver();

	private LoginPage loginPage;
	private SecureAreaPage secureAreaPage;

	@Given("I landed in login page")
	public void goToLoginPage() {
		WelcomePage welcomePageObject = new WelcomePage(driver, log);
		welcomePageObject.openPage();

		loginPage = welcomePageObject.clickFormAuthenticationLink();
	}

	@When("^Logged in with correct username (.+) and password (.+)$")
	public void loginWithUserAndPassword(String user, String password) {
		// TODO Auto-generated method stub
		secureAreaPage = loginPage.logIn(user, password);
	}

	@Then("^page redirection and logout button is visible$")
	public void validateLogin() {
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), expectedUrl);

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccesufMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
		driver.quit();
	}

}
