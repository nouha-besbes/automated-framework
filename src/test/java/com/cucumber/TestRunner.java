package com.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/cucumber/feature", glue = "com.stepdefinition", monochrome = true, plugin = "html:target/cucumber.html")
public class TestRunner extends AbstractTestNGCucumberTests {

}
