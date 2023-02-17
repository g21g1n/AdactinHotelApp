package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Gugan
 * @see used to perform search hotel module
 * @date 18-12-2022
 */
public class SearchHotelPage extends BaseClass {

	/**
	 * @see constructor
	 */
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement ddnLocation;

	@FindBy(id = "hotels")
	private WebElement ddnHotels;

	@FindBy(id = "room_type")
	private WebElement ddnRoomType;

	@FindBy(id = "room_nos")
	private WebElement ddnRoomNumber;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckIn;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOut;

	@FindBy(id = "adult_room")
	private WebElement ddnAdultsPerRoom;

	@FindBy(id = "child_room")
	private WebElement ddnChildPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	@FindBy(id = "username_show")
	private WebElement txtLoginSuccessMessage;

	@FindBy(id = "location_span")
	private WebElement txtSearchErrorMessage;

	@FindBy(id = "checkin_span")
	private WebElement txtCheckInErrorMessage;

	@FindBy(id = "checkout_span")
	private WebElement txtCheckOutErrorMessage;

	public WebElement getLocation() {
		return ddnLocation;
	}

	public WebElement getHotels() {
		return ddnHotels;
	}

	public WebElement getRoomType() {
		return ddnRoomType;
	}

	public WebElement getRoomNos() {
		return ddnRoomNumber;
	}

	public WebElement getCheckIn() {
		return txtCheckIn;
	}

	public WebElement getCheckOut() {
		return txtCheckOut;
	}

	public WebElement getAdultsPerRoom() {
		return ddnAdultsPerRoom;
	}

	public WebElement getChildPerRoom() {
		return ddnChildPerRoom;
	}

	public WebElement getSearchBtn() {
		return btnSearch;
	}

	public WebElement getLoginSuccessMessage() {
		return txtLoginSuccessMessage;
	}

	public WebElement getSearchErrorMessage() {
		return txtSearchErrorMessage;
	}

	public WebElement getCheckInErrorMessage() {
		return txtCheckInErrorMessage;
	}

	public WebElement getCheckOutErrorMessage() {
		return txtCheckOutErrorMessage;
	}

	/**
	 * @see contains the common steps for this program
	 * @param ddnLocation
	 * @param ddnRoomNumber
	 * @param txtCheckIn
	 * @param txtCheckOut
	 * @param ddnAdultsPerRoom
	 */
	public void searchHotelCommonStep(String ddnLocation, String ddnRoomNumber, String txtCheckIn, String txtCheckOut,
			String ddnAdultsPerRoom) {
		selectVisibleText(getLocation(), ddnLocation);
		selectVisibleText(getRoomNos(), ddnRoomNumber);
		clear(getCheckIn());
		sendKeys(getCheckIn(), txtCheckIn);
		clear(getCheckOut());
		sendKeys(getCheckOut(), txtCheckOut);
		selectVisibleText(getAdultsPerRoom(), ddnAdultsPerRoom);
	}

	/**
	 * @see to perform search hotel using mandatory fields
	 * @param ddnLocation
	 * @param ddnRoomNumber
	 * @param txtCheckIn
	 * @param txtCheckOut
	 * @param ddnAdultsPerRoom
	 */
	public void searchHotelByMandatoryFields(String ddnLocation, String ddnRoomNumber, String txtCheckIn,
			String txtCheckOut, String ddnAdultsPerRoom) {
		searchHotelCommonStep(ddnLocation, ddnRoomNumber, txtCheckIn, txtCheckOut, ddnAdultsPerRoom);
		searchBtnClick();
	}

	/**
	 * @see to perform all steps in search hotel module
	 * @param ddnLocation
	 * @param ddnHotels
	 * @param ddnRoomType
	 * @param ddnRoomNumber
	 * @param txtCheckIn
	 * @param txtCheckOut
	 * @param ddnAdultsPerRoom
	 * @param ddnChildPerRoom
	 */
	public void searchHotel(String ddnLocation, String ddnHotels, String ddnRoomType, String ddnRoomNumber,
			String txtCheckIn, String txtCheckOut, String ddnAdultsPerRoom, String ddnChildPerRoom) {

		searchHotelCommonStep(ddnLocation, ddnRoomNumber, txtCheckIn, txtCheckOut, ddnAdultsPerRoom);
		selectVisibleText(getHotels(), ddnHotels);
		selectVisibleText(getRoomType(), ddnRoomType);
		selectVisibleText(getChildPerRoom(), ddnChildPerRoom);
		searchBtnClick();

	}

	/**
	 * @see used to click search button
	 */
	public void searchBtnClick() {
		click(getSearchBtn());

	}

}
