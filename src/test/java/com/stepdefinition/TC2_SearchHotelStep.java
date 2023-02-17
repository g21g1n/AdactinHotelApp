package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * @see contains the snippets to perform search hotel module
 * @author Gugan
 * @date 18-12-2022
 */
public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to perform search hotel module
	 * @param ddnLocation
	 * @param ddnHotels
	 * @param ddnRoomType
	 * @param ddnRoomNumber
	 * @param txtCheckIn
	 * @param txtCheckOut
	 * @param ddnAdultsPerRoom
	 * @param ddnChildPerRoom
	 */
	@Then("user should search hotel using {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelUsingAnd(String ddnLocation, String ddnHotels, String ddnRoomType,
			String ddnRoomNumber, String txtCheckIn, String txtCheckOut, String ddnAdultsPerRoom,
			String ddnChildPerRoom) {
		pom.getSearchHotelPage().searchHotel(ddnLocation, ddnHotels, ddnRoomType, ddnRoomNumber, txtCheckIn,
				txtCheckOut, ddnAdultsPerRoom, ddnChildPerRoom);

	}

	/**
	 * @see used to verify search hotel success message
	 * @param expSearchSuccessMessage
	 */
	@Then("user should verify after search hotel the success message {string}")
	public void userShouldVerifyAfterSearchHotelTheSuccessMessage(String expSearchSuccessMessage) {
		String actSearchSuccessMessage = pom.getSelectHotelPage().getSearchSuccessMessage().getText();
		Assert.assertEquals("verify after search hotel the success message", expSearchSuccessMessage,
				actSearchSuccessMessage);
		HooksClass.sc.log("verify after search hotel the success message: " + "expectedSearchSuccessMessage: "
				+ expSearchSuccessMessage + " actualSearchSuccessMessage: " + actSearchSuccessMessage);
	}

	/**
	 * @see to perform search hotel module using mandatory fields
	 * @param ddnLocation
	 * @param ddnRoomNumber
	 * @param txtCheckIn
	 * @param txtCheckOut
	 * @param ddnAdultsPerRoom
	 */
	@Then("user should perform search hotel by entering mandatory fields only using {string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchHotelByEnteringMandatoryFieldsOnlyUsingAnd(String ddnLocation,
			String ddnRoomNumber, String txtCheckIn, String txtCheckOut, String ddnAdultsPerRoom) {
		pom.getSearchHotelPage().searchHotelByMandatoryFields(ddnLocation, ddnRoomNumber, txtCheckIn, txtCheckOut,
				ddnAdultsPerRoom);

	}

	/**
	 * @see to get error message using invalid dates
	 * @param expCheckInErrorMessage
	 * @param expCheckOutErrorMessage
	 */
	@Then("user should verify after entering invalid date the Error message {string},{string}")
	public void userShouldVerifyAfterEnteringInvalidDateTheErrorMessage(String expCheckInErrorMessage,
			String expCheckOutErrorMessage) {
		String actCheckInErrorMessage = pom.getSearchHotelPage().getCheckInErrorMessage().getText();
		Assert.assertEquals("verify after entering invalid checkin", expCheckInErrorMessage, actCheckInErrorMessage);
		HooksClass.sc.log("verify after entering invalid checkin: " + "expectedCheckInErrorMessage: "
				+ expCheckInErrorMessage + " actualCheckInErrorMessage: " + actCheckInErrorMessage);
		String actCheckOutErrorMessage = pom.getSearchHotelPage().getCheckOutErrorMessage().getText();
		Assert.assertEquals("verify after entering invalid checkout", expCheckOutErrorMessage, actCheckOutErrorMessage);
		HooksClass.sc.log("verify after entering invalid checkout: " + "expectedCheckOutErrorMessage: "
				+ expCheckOutErrorMessage + " actualCheckOutErrorMessage: " + actCheckOutErrorMessage);
	}

	/**
	 * @see used to click search button only
	 */
	@Then("user should select search button")
	public void userShouldSelectSearchButton() {
		pom.getSearchHotelPage().searchBtnClick();
	}

	/**
	 * @see to get search hotel error message
	 * @param expSearchErrorMessage
	 */
	@Then("user should verify after search hotel the Error message {string}")
	public void userShouldVerifyAfterSearchHotelTheErrorMessage(String expSearchErrorMessage) {
		String actSearchErrorMessage = pom.getSearchHotelPage().getSearchErrorMessage().getText();
		Assert.assertEquals("verify after search hotel the Error message", expSearchErrorMessage,
				actSearchErrorMessage);
	}

}
