package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * @see contains the snippets to perform select hotel module
 * @author Gugan
 * @date 18-12-2022
 */
public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see to perform select hotel then click continue button
	 */
	@Then("user should perform select hotel then click continue button")
	public void userShouldPerformSelectHotelThenClickContinueButton() {
		pom.getSelectHotelPage().selectHotel();

	}

	/**
	 * @see to verify after select hotel the success message
	 * @param expSelectSuccessMessage
	 */
	@Then("user should verify after select hotel the success message {string}")
	public void userShouldVerifyAfterSelectHotelTheSuccessMessage(String expSelectSuccessMessage) {
		String actSelectSuccessMessage = pom.getBookHotelPage().getSelectSuccessMessage().getText();
		Assert.assertEquals("verify after select hotel the success message", expSelectSuccessMessage,
				actSelectSuccessMessage);
		HooksClass.sc.log("verify after select hotel the success message: " + "expectedSelectSuccessMessage: "
				+ expSelectSuccessMessage + " actualSelectSuccessMessage: " + actSelectSuccessMessage);

	}

	/**
	 * @see to lick continue button without selecting any hotel
	 */
	@Then("user should  click continue button without selecting any hotel")
	public void userShouldClickContinueButtonWithoutSelectingAnyHotel() {
		pom.getSelectHotelPage().clickContinue();
		implicitWait();
	}

	/**
	 * @see to verify after clicking continue Error message
	 * @param expSelectErrorMessage
	 */
	@Then("user should verify after clicking continue Error message {string}")
	public void userShouldVerifyAfterClickingContinueErrorMessage(String expSelectErrorMessage) {
		String actSelectErrorMessage = pom.getSelectHotelPage().getSelectErrorMessage().getText();
		Assert.assertEquals("verify after clicking continue Error message", expSelectErrorMessage,
				actSelectErrorMessage);
		HooksClass.sc.log("verify after clicking continue Error message: " + "expectedSelectErrorMessage: "
				+ expSelectErrorMessage + " actualSelectErrorMessage: " + actSelectErrorMessage);

	}

}
