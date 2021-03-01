package com.globant.qe.in.travelNEXT.mobile.tests.tripCard;

import org.springframework.beans.factory.annotation.Autowired; 
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTCommentsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHistoryPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHomePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTMoreInfoPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class TripCardTests extends TravelNEXTMobileBaseTestSuite {

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTHomePage travelNEXTHomePage;

	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;

	@Autowired
	TravelNEXTHistoryPage travelNEXTHistoryPage;

	@Autowired
	TravelNEXTCommentsPage travelNEXTCommentsPage;

	@Autowired
	TravelNEXTMoreInfoPage travelNEXTMoreInfoPage;

	/**
	 * This method will verify history, comments and more section from ongoing tip
	 * 
	 * @throws Exception
	 */
	@Test(priority = 0)
	public void verifyCardOnOngoingTrip() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Trip Card  Home Page";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().goToOngoingTrips();

			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);
			if (travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.cardView, "Trip Cards List", pageName)) {

				checkForCardDetails();
				travelNEXTHomePage.tapOnTripOptionBtn();
				tripCardOptions();
				validateHistory();
				travelNEXTHomePage.tapOnTripOptionBtn();
				validateComments();
				travelNEXTHomePage.tapOnTripOptionBtn();
				validateMoreInfo();

			} else {
				softAssert.assertTrue(
						travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.errorMsgForOngoingTrip,
								"Error message for ongoing trip", pageName),
						"Error message for Ongoing Trip is not present");
			}

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify history, comments and more section from upcoming tip
	 * 
	 * @throws Exception
	 */
//	@Test(priority = 1)
//	development is under process for upcoming section
//	public void verifyCardOnUpcomingTrip() throws Exception {
//		try {
//			logger.log(Status.INFO, "Test Case Execution Started");
//			SoftAssert softAssert = new SoftAssert();
//			String pageName = "Trip Card  Home Page";
//
//			mobileServiceProvider.getTravelNEXTHomeService().loadPage().goToUpcomingTrips();
//
//
//			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
//					travelNEXTBasePage.timeOut);
//			if (travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.cardView, "Trip Cards List", pageName)) {
//				checkForCardDetails();
//
//				for (MobileElement tripOptionBtn : travelNEXTHomePage.tripOptionsBtnList) {
//
//					if (travelNEXTHomePage.isElementEnabled(tripOptionBtn, "Trip Card from List", pageName)) {
//
//						tripOptionBtn.click();
//						tripCardOptions();
//						validateHistory();
//						
//						for (MobileElement tripOptionButton : travelNEXTHomePage.tripOptionsBtnList) {
//
//							if (travelNEXTHomePage.isElementEnabled(tripOptionButton, "Trip Card from List", pageName)) {
//								
//								tripOptionButton.click();
//								validateComments();
//								break;
//							}
//						}
//						for (MobileElement optionBtn : travelNEXTHomePage.tripOptionsBtnList) {
//
//							if (travelNEXTHomePage.isElementEnabled(optionBtn, "Trip Card from List", pageName)) {
//								optionBtn.click();
//								validateMoreInfo();
//								break;
//							}
//						}
//						break;
//					}
//				}
//			} else {
//				softAssert.assertTrue(
//						travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.errorMsgForUpcomingTrip,
//								"Error message for upcoming trip", pageName),
//						"Error message for Upcoming Trip is not present");
//			}
//		} catch (Exception e) {
//			logger.log(Status.FAIL, e.getMessage());
//			throw e;
//		}
//	}

	/**
	 * This method will verify history, comments and more section from older tip
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void verifyCardOnOlderTrip() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Trip Card  Home Page";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().goToOlderTrips();

			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);
			
			if (travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.cardView, "Trip Cards List", pageName)) {

				checkForCardDetails();
				travelNEXTHomePage.tapOnTripOptionBtn();
				tripCardOptions();
				validateHistory();
				travelNEXTHomePage.tapOnTripOptionBtn();
				validateComments();
				travelNEXTHomePage.tapOnTripOptionBtn();
				validateMoreInfo();

			} else {
				softAssert.assertTrue(
						travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.errorMsgForOlderTrip,
								"Error message for older trip", pageName),
						"Error message for Older Trip is not present");
			}

			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify view card details
	 */
	public void checkForCardDetails() {
		String pageName = "Home Page";

		softAssert.assertTrue(
				travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.tripCardTitle, "Trip card title", pageName),
				"Trip Card Title is not present");

		softAssert.assertTrue(
				travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.tripOptionBtn, "Trip Option button", pageName),
				"Trip option button is not present");

		softAssert.assertTrue(
				travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.tripCardId, "Trip card ID", pageName),
				"Trip Card Id is not present");

		// There is a common locator for start and end date.
		softAssert.assertTrue(travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.tripCardDates,
				"Trip card start date", pageName), "Trip card start date is not present");

	}

	/**
	 * This method will verify details of trip card options
	 */
	public void tripCardOptions() {
		String pageName = "Home Page";

		waitHandler.WaitForElementToBeVissible(travelNEXTHomePage.historyOption, "History Option button", pageName,
				configMobileParams.getMaxWaitTime());
		softAssert.assertTrue(travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.historyOption,
				"History Option button", pageName), "History option button is not present");
		softAssert.assertTrue(travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.commentsOption,
				"Comments Option button", pageName), "Comments option button is not present");
		softAssert.assertTrue(travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.moreInfoOption,
				"More Info Option button", pageName), "More Info option button is not present");

	}

	/**
	 * This method will verify details of history section
	 */
	public void validateHistory() {
		String pageName = "History Page";

		waitHandler.WaitForElementToBeVissible(travelNEXTHomePage.historyOption, "History Option button", pageName,
				configMobileParams.getMaxWaitTime());
		softAssert.assertTrue(travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.historyOption,
				"History Option button", pageName), "History option button is not present");

		travelNEXTHomePage.historyOption.click();

		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
				travelNEXTBasePage.timeOut);
		softAssert.assertTrue(travelNEXTHistoryPage.isElementDisplayed(travelNEXTHistoryPage.headerTripHistory,
				"History Header", pageName), "History header is not present");
		travelNEXTHistoryPage.backBtn.click();
		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
				travelNEXTBasePage.timeOut);

	}

	/**
	 * This method will verify details of comments section
	 */
	public void validateComments() {
		String pageName = "Comments Page";

		waitHandler.WaitForElementToBeVissible(travelNEXTHomePage.commentsOption, "Comments Option button", pageName,
				configMobileParams.getMaxWaitTime());
		softAssert.assertTrue(travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.commentsOption,
				"Comments Option button", pageName), "Comments option button is not present");

		travelNEXTHomePage.commentsOption.click();
//		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
//				travelNEXTBasePage.timeOut);
		waitHandler.waitForTimeToLapse(20000);

		softAssert.assertTrue(travelNEXTCommentsPage.isElementDisplayed(travelNEXTCommentsPage.headerComments,
				"Comments Header", pageName), "Comments header is not present");
		travelNEXTCommentsPage.backBtn.click();
		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
				travelNEXTBasePage.timeOut);

	}

	/**
	 * this method will verify details of more info option
	 */
	public void validateMoreInfo() {
		String pageName = "More Info Page";

		waitHandler.WaitForElementToBeVissible(travelNEXTHomePage.moreInfoOption, "More Info Option button", pageName,
				configMobileParams.getMaxWaitTime());
		softAssert.assertTrue(travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.moreInfoOption,
				"More Info Option button", pageName), "More Info option button is not present");

		travelNEXTHomePage.moreInfoOption.click();

//		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
//				travelNEXTBasePage.timeOut);
		waitHandler.waitForTimeToLapse(20000);

		softAssert.assertTrue(travelNEXTMoreInfoPage.isElementDisplayed(travelNEXTMoreInfoPage.headerMoreinfo,
				"More Info Header", pageName), "More Info header is not present");
		travelNEXTMoreInfoPage.backBtn.click();
		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
				travelNEXTBasePage.timeOut);
	}
}
