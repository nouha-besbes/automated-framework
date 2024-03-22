package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {

	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By dropdownLocator = By.id("dropdown");

	public void selectOption(int i) {
		log.info("Dropdown select option");
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		// select are three ways

		// dropdown.selectByIndex(i);

		// dropdown.selectByValue(""+1);

		dropdown.selectByVisibleText("Option " + i);
	}

	public String getSelectedOption() {
		log.info("Get selected option");
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);

		return dropdown.getFirstSelectedOption().getText();
	}

}
