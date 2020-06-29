package com.cucumber.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/reports/index.html","json:target/reports/testsReport.json"},
        monochrome = true,
        glue = "com.cucumber.demo",
        features = "src/test/resources/features")
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
