package com.globant.qe.in.travelNEXT.mobile.tests.feedback;

import org.springframework.beans.factory.annotation.Autowired;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAboutAppPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTFeedbackPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class FeedbackTests extends TravelNEXTMobileBaseTestSuite {

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTAboutAppPage travelNEXTAboutPage;

	@Autowired
	TravelNEXTFeedbackPage feedback;

	/**
	 * This method will verify positive scenario of feedback
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void verifyPositiveScenarioForGloberFeedback() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger();
			mobileServiceProvider.getTravelNEXTSideBarService().goToTravelNEXTFeedback();
			mobileServiceProvider.getTravelNEXTFeedbackService().provideFeedback();
			mobileServiceProvider.getTravelNEXTFeedbackSuccessService();

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify negative scenario of feedback
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void verifyNegativeScenarioForGloberFeedback() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			String pageName = "Feedback Page";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger();
			mobileServiceProvider.getTravelNEXTSideBarService().goToTravelNEXTFeedback();
			feedback.provideFeedbackComment("String comment");
			feedback.feedbackPageHeader.click();
			feedback.getMobileDriver().hideKeyboard();

			softAssert.assertFalse(feedback.isElementEnabled(feedback.sendFeedbackBtn, "feedback button", pageName),
					"Send Feedback button is enabled");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}
}
