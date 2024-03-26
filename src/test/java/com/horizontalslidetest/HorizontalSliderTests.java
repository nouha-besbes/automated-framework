package com.horizontalslidetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestUtilities;
import com.pages.HorizontalSliderPage;

public class HorizontalSliderTests extends TestUtilities {

	@Test
	public void sliderTest() throws InterruptedException {

		// Open HorizontalSliderPage
		HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(driver, log);
		horizontalSliderPage.openPage();

		String value = "3.5";

		// Set slider value
		Thread.sleep(2000);
		horizontalSliderPage.setSliderTo(value);
		Thread.sleep(2000);

		// Verify slider value
		String sliderValue = horizontalSliderPage.getSliderValue();
		Assert.assertTrue(sliderValue.equals(value), "Range is not correct. It is: " + sliderValue);
	}

}
