package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import io.cucumber.datatable.DataTable;

/**
 * 
 * @author Gugan
 * @see to perfrom book hotel module
 * @date 18-12-2022
 *
 */
public class BookHotelPage extends BaseClass {

	/**
	 * @see constructor
	 */
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtBillingAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCreditCardNumber;

	@FindBy(id = "cc_type")
	private WebElement ddnCreditCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement ddnExpiryMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement ddnExpiryYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvvNumber;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement txtBookingSuccessMessage;

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement txtSelectSuccessMessage;

	@FindBy(id = "first_name_span")
	private WebElement txtFirstNameErrorMessage;

	@FindBy(id = "last_name_span")
	private WebElement txtLastNameErrorMessage;

	@FindBy(id = "address_span")
	private WebElement txtAddressErrorMessage;

	@FindBy(id = "cc_num_span")
	private WebElement txtCardNumberErrorMessage;

	@FindBy(id = "cc_type_span")
	private WebElement txtCardTypeErrorMessage;

	@FindBy(id = "cc_expiry_span")
	private WebElement txtCardMonthErrorMessage;

	@FindBy(id = "cc_cvv_span")
	private WebElement txtCvvErrorMessage;

	public WebElement getFirstName() {
		return txtFirstName;
	}

	public WebElement getLastName() {
		return txtLastName;
	}

	public WebElement getBillingAddress() {
		return txtBillingAddress;
	}

	public WebElement getCreditCardNo() {
		return txtCreditCardNumber;
	}

	public WebElement getCreditCardType() {
		return ddnCreditCardType;
	}

	public WebElement getExpiryMonth() {
		return ddnExpiryMonth;
	}

	public WebElement getExpiryYear() {
		return ddnExpiryYear;
	}

	public WebElement getCvvNo() {
		return txtCvvNumber;
	}

	public WebElement getBookNowBtn() {
		return btnBookNow;
	}

	public WebElement getBookingSuccessMessage() {
		return txtBookingSuccessMessage;
	}

	public WebElement getSelectSuccessMessage() {
		return txtSelectSuccessMessage;
	}

	public WebElement getFirstNameErrorMessage() {
		return txtFirstNameErrorMessage;
	}

	public WebElement getLastNameErrorMessage() {
		return txtLastNameErrorMessage;
	}

	public WebElement getAddressErrorMessage() {
		return txtAddressErrorMessage;
	}

	public WebElement getCardNumberErrorMessage() {
		return txtCardNumberErrorMessage;
	}

	public WebElement getCardTypeErrorMessage() {
		return txtCardTypeErrorMessage;
	}

	public WebElement getCardMonthErrorMessage() {
		return txtCardMonthErrorMessage;
	}

	public WebElement getCvvErrorMessage() {
		return txtCvvErrorMessage;
	}

	/**
	 * @see to perform all steps in book hotel module
	 * @param txtFirstName
	 * @param txtLastName
	 * @param txtBillingAddress
	 * @param dataTable
	 */
	public void bookHotel(String txtFirstName, String txtLastName, String txtBillingAddress, DataTable dataTable) {

		sendKeys(getFirstName(), txtFirstName);
		sendKeys(getLastName(), txtLastName);
		sendKeys(getBillingAddress(), txtBillingAddress);
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);

		String cardNo = map.get("creditCardNo");
		String cardType = map.get("creditCardType");
		String expMonth = map.get("expiryMonth");
		String expYear = map.get("expiryYear");
		String cvvNo = map.get("cvvNo");

		sendKeys(getCreditCardNo(), cardNo);
		sendKeys(getCreditCardType(), cardType);
		sendKeys(getExpiryMonth(), expMonth);
		sendKeys(getExpiryYear(), expYear);
		sendKeys(getCvvNo(), cvvNo);
		click(getBookNowBtn());
	}

	/**
	 * @see to click book button without selecting any fields
	 */
	public void bookHotel() {
		click(getBookNowBtn());

	}

}
