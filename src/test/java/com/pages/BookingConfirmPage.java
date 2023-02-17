package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Gugan
 * @see to get generated order id
 * @date 18-12-2022
 */
public class BookingConfirmPage extends BaseClass {
	/**
	 * @see constructor
	 */
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement txtOrderId;

	public WebElement getOrderId() {
		return txtOrderId;
	}

	/**
	 * @see to get generated order id
	 * @return String
	 */
	public String orederId() {
		String attribute = getAttribute(getOrderId());
		return attribute;

	}

}
