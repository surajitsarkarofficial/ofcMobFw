package com.globant.qe.in.travelNEXT.mobile.tests.hamburger;

import org.springframework.beans.factory.annotation.Autowired;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTSideBarService;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHomePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTSideBarPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class HamburgerTests extends TravelNEXTMobileBaseTestSuite {

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTHomePage homePage;

	@Autowired
	TravelNEXTSideBarPage sideBarPage;

	@Autowired
	TravelNEXTSideBarService sideBarService;

	@Autowired
	PersonalDeatils personalDeatils;
	
	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;

	/**
	 * This method will verify display of Hamburger menu Items
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void verifyHamburgerMenuItems() throws InterruptedException {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");

			String pageName = "Hamburger Menu";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger();
			sideBarPage.setElements();

			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);
			
			// Checking for enabled because visibility is false
			softAssert.assertTrue(sideBarPage.isElementEnabled(sideBarPage.globerImage, "Glober Image", pageName),
					"Glober Image not present");

			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.globerName, "Glober Name", pageName),
					"Glober name is not present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.globerEmailId, "Glober EmailId", pageName),
					"Glober EmailId not present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.menuOption_Personal, "Personal", pageName),
					"Personal menu is not present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.menuOption_Passport, "Passport", pageName),
					"Passport menu not is present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.menuOption_EmergencyContacts,
					"Emergency contact", pageName), "Emergency Contact is menu not present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.menuOption_FrequentFlyerNumbers,
					"Frequent Flyer Numbers", pageName), "Frequent Flyer Numbers menu is not present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.menuOption_HotelLoyaltyPrograms,
					"Hotel Loyalty Programs", pageName), "Hotel Loyalty Programs menu is not present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.menuOption_AboutTravelNEXT,
					"About TravelNEXT", pageName), "About TravelNEXT menu is not present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.menuOption_Feedback, "Feedback", pageName),
					"Feedback menu is not present");
			softAssert.assertTrue(sideBarPage.isElementDisplayed(sideBarPage.signOut, "signOut", pageName),
					"Sign Out menu is not present");

			// Checking for enabled because visibility is false
			softAssert.assertTrue(sideBarPage.isElementEnabled(sideBarPage.appLogo, "GTappLogo", pageName),
					"GT appLogo is menu not present");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify dropdown items and Hamburger Menu is scrollable up,
	 * down.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void verifyScrollableHamburgerMenu() throws InterruptedException {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			String pageName = "Hamburger Menu";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger();
			mobileDriver = sideBarPage.getMobileDriver();

			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);
			
			sideBarPage.scroll("up");

			// Checking for enabled because visibility is false
			softAssert.assertTrue(
					sideBarPage.isElementEnabled(sideBarPage.menuOption_globerName_bold, "Glober Name", pageName),
					"Glober Name not present");

			// Checking for enabled because visibility is false
			softAssert.assertTrue(
					sideBarPage.isElementDisplayed(sideBarPage.menuOption_globerImage_icon, "Glober Image", pageName),
					"Glober Image not present");

			sideBarPage.scroll("down");
			mobileServiceProvider.getTravelNEXTSideBarService().goToPersonalDetails().hidePersonalDetails()
					.goToPassportDetails().hidePassportDetails().goToEmergencyContacts().hideEmergencyContacts()
					.goToFrequentFlyerNumbers().hideFrequentFlyerNumbers().goToHotelLoyaltyPrograms()
					.hideHotelLoyaltyPrograms();

			sideBarPage.scroll("down");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		}
	}
}
