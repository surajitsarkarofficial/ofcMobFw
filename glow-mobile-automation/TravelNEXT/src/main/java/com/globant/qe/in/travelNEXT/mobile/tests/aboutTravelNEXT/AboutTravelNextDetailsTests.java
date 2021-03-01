package com.globant.qe.in.travelNEXT.mobile.tests.aboutTravelNEXT;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAboutAppPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTSideBarPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTWelcomePage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class AboutTravelNextDetailsTests extends TravelNEXTMobileBaseTestSuite {

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTAboutAppPage travelNEXTAboutPage;

	@Autowired
	TravelNEXTSideBarPage travelNEXTSideBarPage;
	
	@Autowired
	TravelNEXTWelcomePage travelNEXTWelcomePage;
	
	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;
	
	/**
	 * This method will verify details on TravelNEXT About page
	 */
	@Test
	public void verifyTravelNEXTAboutPage()
	{
		try {
			SoftAssert softAssert = new SoftAssert();
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			String pageName = "About Application Page";
			mobileServiceProvider.getTravelNEXTHomeService().tapHamburger().goToTravelNEXTAbout();
			
			softAssert.assertTrue(travelNEXTAboutPage.isElementDisplayed(travelNEXTAboutPage.travelPolicy,
					"Travel Policy", pageName), "Travel Policy link is not found");
			
			softAssert.assertTrue(travelNEXTAboutPage.isElementDisplayed(travelNEXTAboutPage.privacyPolicy,
					"Privacy Policy", pageName), "Privacy policy link is not found");
			
			softAssert.assertTrue(travelNEXTAboutPage.isElementDisplayed(travelNEXTAboutPage.appVersion,
					"App Version", pageName), "App version is not found");
			
			softAssert.assertAll();
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}
	
	/**
	 * This method will check the working of About TravelNEXT policies
	 */
	@Test(priority = 1)
	public void verifyPolicies() {
		try {

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "About Application Page";
			mobileServiceProvider.getTravelNEXTHomeService().tapHamburger().goToTravelNEXTAbout();
			mobileServiceProvider.getTravelNEXTAboutDetailsService().tapTravelPolicy();

			softAssert.assertTrue(travelNEXTAboutPage.isElementDisplayed(travelNEXTAboutPage.whatTravelNEXTHeader,
					"what's TravelNEXT Header", pageName), "what's TravelNEXT Header is not found");

			mobileServiceProvider.getTravelNEXTAboutDetailsService().tapBackBtn().tapPrivacyPolicy();

			softAssert.assertTrue(travelNEXTAboutPage.isElementDisplayed(travelNEXTAboutPage.whatTravelNEXTHeader,
					"what's TravelNEXT Header", pageName), "what's TravelNEXT Header is not found");
			
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}
	
	/**
	 * This method will verify user can signed out
	 */
	@Test
	public void verifyUserCanLogOut()
	{
		try {

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "About Application Page";
			mobileServiceProvider.getTravelNEXTHomeService().tapHamburger();
			
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);
			
			travelNEXTSideBarPage.scroll("up");
			softAssert.assertTrue(travelNEXTSideBarPage.isElementDisplayed(travelNEXTSideBarPage.signOut,
					"Signout button", pageName), "Signout button is not found");
			
			travelNEXTSideBarPage.tapSignOut();
			
			softAssert.assertTrue(travelNEXTWelcomePage.isElementDisplayed(travelNEXTWelcomePage.wellcomeMsg,
					"Welcome Title", pageName), "Welcome Title is not found");
			
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}
	
	/**
	 * This method will verify user can see GT Logo
	 */
	@Test
	public void verifyUserCanSeeGTLogo()
	{
		try {

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "About Application Page";
			mobileServiceProvider.getTravelNEXTHomeService().tapHamburger();
			
			//Visibility is false for locator so checked for enable property.
			softAssert.assertTrue(travelNEXTSideBarPage.isElementEnabled(travelNEXTSideBarPage.appLogo,
					"GT App Logo", pageName), "Globers Travel app logo is not found");
			
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

}
