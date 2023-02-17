package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * 
 * @author Gugan
 * @see contains the snippets to perform book hotel module
 * @date 18-12-2022
 */
public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see to perform booking hotel module
	 * @param txtFirstName
	 * @param txtLastName
	 * @param txtBillingAddress
	 * @param dataTable
	 */
	@Then("user should perform booking hotel using {string},{string} and {string}")
	public void userShouldPerformBookingHotelUsingAnd(String txtFirstName, String txtLastName, String txtBillingAddress,
			io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().bookHotel(txtFirstName, txtLastName, txtBillingAddress, dataTable);

	}

	/**
	 * @see to verify after booking hotel the success message
	 * @param expBookingSuccessMessage
	 */
	@Then("user should verify after booking hotel the success message {string} and save generated orderid")
	public void userShouldVerifyAfterBookingHotelTheSuccessMessageAndSaveGeneratedOrderid(
			String expBookingSuccessMessage) {
		String actBookingSuccessMessage = pom.getBookHotelPage().getBookingSuccessMessage().getText();
		Assert.assertEquals("verify after booking hotel the success message", expBookingSuccessMessage,
				actBookingSuccessMessage);
		HooksClass.sc.log("verify after booking hotel the success message: " + "expectedBookingSuccessMessage: "
				+ expBookingSuccessMessage + " actualBookingSuccessMessage: " + actBookingSuccessMessage);
	}

	/**
	 * @see to perform book hotel without entering any fields
	 */
	@Then("user should perform book hotel without entering any fields")
	public void userShouldPerformBookHotelWithoutEnteringAnyFields() {
		pom.getBookHotelPage().bookHotel();
	}

	/**
	 * @see to verify after clicking book now Error message
	 * @param expFirstNameErrorMessage
	 * @param expLastNameErrorMessage
	 * @param expAddressErrorMessage
	 * @param expCardNumberErrorMessage
	 * @param expCardTypeErrorMessage
	 * @param expCardMonthErrorMessage
	 * @param expCvvErrorMessage
	 */
	@Then("user should verify after clicking book now Error message {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAfterClickingBookNowErrorMessageAnd(String expFirstNameErrorMessage,
			String expLastNameErrorMessage, String expAddressErrorMessage, String expCardNumberErrorMessage,
			String expCardTypeErrorMessage, String expCardMonthErrorMessage, String expCvvErrorMessage) {
		String actFirstNameErrorMessage = pom.getBookHotelPage().getFirstNameErrorMessage().getText();
		Assert.assertEquals("verify after clicking book now firstName Error message ", expFirstNameErrorMessage,
				actFirstNameErrorMessage);
		HooksClass.sc.log("verify after clicking book now firstName Error message: " + "expectedFirstNameErrorMessage: "
				+ expFirstNameErrorMessage + " actualFirstNameErrorMessage: " + actFirstNameErrorMessage);

		String actLastNameErrorMessage = pom.getBookHotelPage().getLastNameErrorMessage().getText();
		Assert.assertEquals("verify after clicking book now lastName Error message ", expLastNameErrorMessage,
				actLastNameErrorMessage);
		HooksClass.sc.log("verify after clicking book now lastName Error message: " + "expectedLastNameErrorMessage: "
				+ expLastNameErrorMessage + " actualLastNameErrorMessage: " + actLastNameErrorMessage);

		String actAddressErrorMessage = pom.getBookHotelPage().getAddressErrorMessage().getText();
		Assert.assertEquals("verify after clicking book now address Error message ", expAddressErrorMessage,
				actAddressErrorMessage);
		HooksClass.sc.log("verify after clicking book now address Error message: " + "expectedAddressErrorMessage: "
				+ expAddressErrorMessage + " actualAddressErrorMessage: " + actAddressErrorMessage);

		String actCardNumberErrorMessage = pom.getBookHotelPage().getCardNumberErrorMessage().getText();
		Assert.assertEquals("verify after clicking book now cardNumber Error message ", expCardNumberErrorMessage,
				actCardNumberErrorMessage);
		HooksClass.sc
				.log("verify after clicking book now cardNumber Error message: " + "expectedCardNumberErrorMessage: "
						+ expCardNumberErrorMessage + " actualCardNumberErrorMessage: " + actCardNumberErrorMessage);

		String actCardTypeErrorMessage = pom.getBookHotelPage().getCardTypeErrorMessage().getText();
		Assert.assertEquals("verify after clicking book now cardType Error message ", expCardTypeErrorMessage,
				actCardTypeErrorMessage);
		HooksClass.sc.log("verify after clicking book now cardType Error message: " + "expectedCardTypeErrorMessage: "
				+ expCardTypeErrorMessage + " actualCardTypeErrorMessage: " + actCardTypeErrorMessage);

		String actCardMonthErrorMessage = pom.getBookHotelPage().getCardMonthErrorMessage().getText();
		Assert.assertEquals("verify after clicking book now cardMonth Error message ", expCardMonthErrorMessage,
				actCardMonthErrorMessage);
		HooksClass.sc.log("verify after clicking book now cardMonth Error message: " + "expectedCardMonthErrorMessage: "
				+ expCardMonthErrorMessage + " actualCardMonthErrorMessage: " + actCardMonthErrorMessage);

		String actCvvErrorMessage = pom.getBookHotelPage().getCvvErrorMessage().getText();
		Assert.assertEquals("verify after clicking book now cvv Error message ", expCvvErrorMessage,
				actCvvErrorMessage);
		HooksClass.sc.log("verify after clicking book now cvv Error message: " + "expectedCvvErrorMessage: "
				+ expCvvErrorMessage + " actualCvvErrorMessage: " + actCvvErrorMessage);

	}

}
