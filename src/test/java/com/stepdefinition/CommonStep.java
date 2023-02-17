package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * 
 * @author Gugan
 * @see contains the common steps of adactin project
 * @date 18-12-2022
 */
public class CommonStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see verify login success message
	 * @param expLoginSuccessMessage
	 */
	@Then("user should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginSuccessMessage) {

		WebElement loginSuccess = pom.getSearchHotelPage().getLoginSuccessMessage();
		String actLoginSuccessMessage = getAttribute(loginSuccess);
		Assert.assertEquals("verify after login success message", expLoginSuccessMessage, actLoginSuccessMessage);
		HooksClass.sc.log("verify after login success message: " + "expectedLoginSuccessMessage: "
				+ expLoginSuccessMessage + " actualLoginSuccess: " + actLoginSuccessMessage);
		
		
		
	}
}
