package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Gugan
 * @see used to send username and password values
 * @date 18-12-2022
 */
public class LoginPage extends BaseClass {
	/**
	 * @see constructor
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(xpath = "//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement txtLoginErrorMessage;

	public WebElement getUserName() {
		return txtUserName;
	}

	public WebElement getPassword() {
		return txtPassword;
	}

	public WebElement getLogin() {
		return btnLogin;
	}

	public WebElement getErrorMessage() {
		return txtLoginErrorMessage;
	}

	/**
	 * @see contains the common steps for this program
	 * @param txtUserName
	 * @param txtPassword
	 */
	public void loginCommonSteps(String txtUserName, String txtPassword) {
		sendKeys(getUserName(), txtUserName);
		sendKeys(getPassword(), txtPassword);

	}

	/**
	 * @see to login using credentials
	 * @param txtUserName
	 * @param txtPassword
	 */
	public void login(String txtUserName, String txtPassword) {
		loginCommonSteps(txtUserName, txtPassword);
		click(getLogin());
	}

	/**
	 * @see to login using enter key
	 * @param txtUserName
	 * @param txtPassword
	 * @throws AWTException
	 */
	public void loginWithEnterKey(String txtUserName, String txtPassword) throws AWTException {
		loginCommonSteps(txtUserName, txtPassword);
		robotTab();
		robotTab();
		robotEnter();

	}

}
