package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * 
 * @author Gugan
 * @see contains the snippets to perform search login module
 * @date 18-12-2022
 */
public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to perform browser launch
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("user is on adactinhotelapp page")
	public void userIsOnAdactinhotelappPage() throws FileNotFoundException, IOException {

	}

	/**
	 * @see used to perform login
	 * @param txtUserName
	 * @param txtPassword
	 */
	@When("user should perform login using {string},{string}")
	public void userShouldPerformLoginUsing(String txtUserName, String txtPassword) {
		pom.getLoginPage().login(txtUserName, txtPassword);
	}

	/**
	 * @see used to perform login using enter key
	 * @param txtUserName
	 * @param txtPassword
	 * @throws AWTException
	 */
	@When("user should perform login using {string},{string} by pressing EnterKey")
	public void userShouldPerformLoginUsingByPressingEnterKey(String txtUserName, String txtPassword)
			throws AWTException {
		pom.getLoginPage().loginWithEnterKey(txtUserName, txtPassword);
	}

	/**
	 * @see used to perform login using invalid credentials
	 * @param expLoginErrorMessage
	 */
	@Then("user should verify after login Error message {string}")
	public void userShouldVerifyAfterLoginErrorMessage(String expLoginErrorMessage) {
		WebElement errorMessage = pom.getLoginPage().getErrorMessage();
		String actLoginErrorMessage = getText(errorMessage);
		boolean contains = actLoginErrorMessage.contains(expLoginErrorMessage);
		Assert.assertTrue("verify after login Error message", contains);
		HooksClass.sc.log("verify after login Error message: " + "expectedLoginErrorMessage: " + expLoginErrorMessage
				+ " actualLoginErrorMessage: " + actLoginErrorMessage);
	}

}
