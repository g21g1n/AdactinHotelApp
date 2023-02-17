package com.runner		
;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;
import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * @author Gugan
 * @see to run the program and generate report
 *@date 18-12-2022
 */
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, tags = (""), plugin = { "pretty",
		"json:target\\output.json" }, dryRun = false, snippets = io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE, features = "src\\test\\resources\\Features", glue = "com.stepdefinition")
public class TestRunnerClass extends BaseClass {
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmReport(getProjectPath() + getPropertyFileValue("jsonpath"));

	}

}