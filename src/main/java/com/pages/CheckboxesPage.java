package com.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePageObject {

	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By checkboxeLocator = By.xpath("//input[@type='checkbox']");

	public void selectAllCheckboxes() {
		log.info("Checking all unchecked checkboxes");
		List<WebElement> checkboxes = findAll(checkboxeLocator);
		for (WebElement checkboxe : checkboxes) {
			if (!checkboxe.isSelected()) {
				checkboxe.click();
			}
		}
	}

	public boolean areAllCheckboxesChecked() {
		log.info("Check if all checkboxes are selected");
		List<WebElement> checkboxes = findAll(checkboxeLocator);
		for (WebElement webElement : checkboxes) {
			if (!webElement.isSelected()) {
				return false;
			}
		}
		return true;
	}
}
