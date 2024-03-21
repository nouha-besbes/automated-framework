package main.java.com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class SecureAreaPage extends BasePageObject {
	
	private String pageUrl="https://the-internet.herokuapp.com/secure";
	
	private By logOutButoon = By.className("//a[@class='button secondary radius']");
	
	private By message = By.id("flash");
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getPageUrl() {
		return pageUrl;
	}

	public boolean isLogOutButtonVisible() {
		return find(logOutButoon).isDisplayed();
	}
	
	public String getSuccesufMessage() {
		return find(message).getText();
	}

}
