package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * 
 * @author Gugan
 * @see contains the snippets to perform cancel hotel
 * @date 18-12-2022
 */
public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see to cancel generated orderid
	 */
	@Then("user should cancel generated orderid")
	public void userShouldCancelGeneratedOrderid() {
		WebElement orderId = pom.getBookingConfirmPage().getOrderId();
		pom.getCancelBookingPage().cancelOrderId(getAttribute(orderId));
	}

	/**
	 * @see to verify after cancel orderid the success message
	 * @param expCancelSuccessMessage
	 */
	@Then("user should verify after cancel orderid the success message {string}")
	public void userShouldVerifyAfterCancelOrderidTheSuccessMessage(String expCancelSuccessMessage) {
		String actCancelSuccessMessage = pom.getCancelBookingPage().getBookingCancelSuccessMessage().getText();
		Assert.assertEquals("verify after cancel orderid the success message", expCancelSuccessMessage,
				actCancelSuccessMessage);
		HooksClass.sc.log("verify after cancel orderid the success message: " + "expectedCancelSuccessMessage: "
				+ expCancelSuccessMessage + " actualCancelSuccessMessage: " + actCancelSuccessMessage);

	}

	/**
	 * @see to cancel exixting order id
	 * @param orderId
	 */
	@Then("user should cancel exixting order id using {string}")
	public void userShouldCancelExixtingOrderIdUsing(String orderId) {
		pom.getCancelBookingPage().cancelOrderId(orderId);
	}

}
