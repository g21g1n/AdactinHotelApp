package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;

import com.base.BaseClass;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

/**
 * 
 * @author Gugan
 * @see contains the before and after execution of every scenerio outline
 * @date 27-12-2022
 *
 */
public class HooksClass extends BaseClass {
	static Scenario sc;
	/**
	 * @see used to perform browser launch
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@io.cucumber.java.Before
	public void beforeScenario(Scenario scenario) throws FileNotFoundException, IOException {
		browserLaunch(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximize();
		implicitWait();
		sc=scenario;
	}

	/**
	 * @see user to perform take screenshot and browser quit
	 * @param scenario
	 */
	@io.cucumber.java.After
	public void afterScenario(Scenario scenario) {
		scenario.attach(screenshot(), "images/png", "Every Scenario");
		quit();
	}

}
