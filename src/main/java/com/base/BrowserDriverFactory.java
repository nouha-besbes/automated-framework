package main.java.com.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			this.driver.set(new ChromeDriver());
			break;

		case "firefox":
			this.driver.set(new FirefoxDriver());
			break;

		default:
			log.info("Do not know how to start: " + browser + ", starting chrome.");
			this.driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}
}
