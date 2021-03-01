package com.globant.qe.in.travelNEXT.mobile.tests.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTHomeService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTSideBarService;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHomePage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class LoginTests extends TravelNEXTMobileBaseTestSuite {

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTHomePage homePage;

	@Autowired
	TravelNEXTHomeService homeService;

	/**
	 * This method will verify that valid login has been done
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void verifyValidLogin() throws InterruptedException {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");

			String pageName = "Home Page";
			homeService = mobileServiceProvider.getTravelNEXTHomeService().loadPage();
			softAssert.assertEquals(homePage.getElementText(homePage.onGoingTrips, "ONGOING", pageName), "ONGOING",
					"Text mismatched");
			softAssert.assertTrue(homePage.isElementDisplayed(homePage.hamburger, "Hamburger", pageName),
					"Hamburger button is not present");
			softAssert.assertTrue(homePage.isElementDisplayed(homePage.bellIcon, "Bell Icon", pageName),
					"Bell icon is not present");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}
}
