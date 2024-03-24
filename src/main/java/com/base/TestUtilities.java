package com.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@DataProvider(name = "files")
	protected Object[][] files() {
		return new Object[][] { { 1, "Test.txt" }, { 2, "NewFile.xml" }, { 3, "File.json" } };
	}
}
