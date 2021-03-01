package com.globant.qe.in.travelNEXT.mobile.tests.itinerary;

import org.springframework.beans.factory.annotation.Autowired;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTCommentsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHistoryPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHomePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTItineraryPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTMoreInfoPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class ItineraryTests extends TravelNEXTMobileBaseTestSuite {

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

	@Autowired
	TravelNEXTItineraryPage travelNEXTItineraryPage;

	/**
	 * This method will verify itinerary section from ongoing trip
	 */
	@Test(priority = 0)
	public void verifyItineraryFromOngoingTripCard() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Trip Card Home Page";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().goToOngoingTrips();
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);
			if (travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.cardView, "Trip Cards List", pageName)) {

				verifyItineraryDetails();

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
	 * This method will verify itinerary section from older trip
	 */
	@Test(priority = 1)
	public void verifyItineraryFromOlderTripCard() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Trip Card Home Page";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().goToOlderTrips();
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);
			if (travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.cardView, "Trip Cards List", pageName)) {

				verifyItineraryDetails();

			} else {
				softAssert.assertTrue(
						travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.errorMsgForOlderTrip,
								"Error message for older trip", pageName),
						"Error message for Older Trip is not present");

			}
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify itinerary details
	 */
	public void verifyItineraryDetails() {

		String pageName = "Itinerary Page";
		travelNEXTHomePage.tapOnCardView();
		softAssert.assertTrue(travelNEXTItineraryPage.isElementDisplayed(travelNEXTItineraryPage.itineraryHeader,
				"Itinerary Header", pageName), "Itinerary Header is not present");

		softAssert.assertTrue(travelNEXTItineraryPage.isElementDisplayed(travelNEXTItineraryPage.itineraryTabBtn,
				"Itinerary Tab Button", pageName), "Itinerary tab button is not present");

		softAssert.assertTrue(travelNEXTItineraryPage.isElementDisplayed(travelNEXTItineraryPage.commentsTabBtn,
				"Comments Tab Button", pageName), "Comments tab button is not present");

		softAssert.assertTrue(travelNEXTItineraryPage.isElementDisplayed(travelNEXTItineraryPage.moreInfoTabBtn,
				"More Info Tab Button", pageName), "More Info tab button is not present");

		travelNEXTItineraryPage.tapCommentsTab();
		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
				travelNEXTBasePage.timeOut);
		softAssert.assertTrue(travelNEXTCommentsPage.isElementDisplayed(travelNEXTCommentsPage.headerComments,
				"Comments Header", pageName), "Comments header is not present");

		travelNEXTItineraryPage.tapMoreInfoTab();
		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
				travelNEXTBasePage.timeOut);
		softAssert.assertTrue(travelNEXTMoreInfoPage.isElementDisplayed(travelNEXTMoreInfoPage.headerMoreinfo,
				"More Info Header", pageName), "More Info header is not present");

		travelNEXTCommentsPage.tapBackBtn();
		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
				travelNEXTBasePage.timeOut);
		softAssert.assertTrue(
				travelNEXTHomePage.isElementDisplayed(travelNEXTHomePage.myTripsHeader, "My trips Header", pageName),
				"My trips header is not present");

	}

}
