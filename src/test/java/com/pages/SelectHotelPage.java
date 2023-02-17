package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Gugan
 * @see used to perform select hotel module
 * @date 18-12-2022
 */
public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement rdoSelect;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	@FindBy(xpath = "//label[text()='Please Select a Hotel']")
	private WebElement txtSelectErrorMessage;

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement txtSearchSuccessMessage;

	public WebElement getRdButtonSelect() {
		return rdoSelect;
	}

	public WebElement getButtonContinue() {
		return btnContinue;
	}

	public WebElement getSelectErrorMessage() {
		return txtSelectErrorMessage;
	}

	public WebElement getSearchSuccessMessage() {
		return txtSearchSuccessMessage;
	}

	/**
	 * @see used to perform select hotel module
	 */
	public void selectHotel() {
		click(rdoSelect);
		click(btnContinue);

	}

	/**
	 * @see used to click continue button
	 */
	public void clickContinue() {
		click(btnContinue);

	}

}
