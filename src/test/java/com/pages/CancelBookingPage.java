package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Gugan
 * @date 18-12-2022
 * @see to perform cancel booking
 */
public class CancelBookingPage extends BaseClass {

	/**
	 * @see constructor
	 */
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement btnBookingItenary;

	@FindBy(id = "order_id_text")
	private WebElement txtSearcOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement btnCancel;

	@FindBy(id = "search_result_error")
	private WebElement bookingCancelSuccessMessage;

	public WebElement getBookingItenary() {
		return btnBookingItenary;
	}

	public WebElement getTxtSearcOrderId() {
		return txtSearcOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getBookingCancelSuccessMessage() {
		return bookingCancelSuccessMessage;
	}

	/**
	 * @see to perform cancel booking using created and existing orderid
	 * @param orderId
	 */
	public void cancelOrderId(String orderId) {
		click(getBookingItenary());
		sendKeys(getTxtSearcOrderId(), orderId);
		click(getBtnGo());
		click(getBtnCancel());
		alertHandlingAccept();

	}

}
