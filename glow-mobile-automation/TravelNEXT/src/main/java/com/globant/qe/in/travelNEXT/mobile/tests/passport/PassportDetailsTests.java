package com.globant.qe.in.travelNEXT.mobile.tests.passport;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTPassportDetailsService;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTPassportDetailsPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class PassportDetailsTests extends TravelNEXTMobileBaseTestSuite {

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTPassportDetailsPage passportPage;

	@Autowired
	TravelNEXTPassportDetailsService passportDetailsService;

	@Autowired
	PersonalDeatils personalDeatils;

	/**
	 * This method will verify passport section's functionality
	 * 
	 * @throws Exception
	 */
	@Test
	public void verifyGloberPassportDetails() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger();
			mobileServiceProvider.getTravelNEXTSideBarService().goToPassportDetails();
			verifyPassportDetailsLabels();
			verifyGloberPassportInfo();
			mobileServiceProvider.getTravelNEXTPassportDetailsServices().hidePassportDetails();
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify Labels of passport section
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void verifyPassportDetailsLabels() throws IOException, InterruptedException {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String pageName = "Passport Details Page";
		if (passportPage.isElementDisplayed(passportPage.noPassportAddedMsg, "No passport details added Message",
				pageName)) {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Glober has no passport information."));
			softAssert.assertTrue(passportPage.getElementText(passportPage.noPassportAddedMsg,"No passport details added Message", pageName)
									.contains("Glober has no passport information."),"Glober has no passport information.");
		} else {
			waitHandler.WaitForElementToBeVissible(passportPage.passportNoLbl, "Passport Number Label", pageName,
					configMobileParams.getMaxWaitTime());
			softAssert.assertEquals(
					passportPage.getElementText(passportPage.passportNoLbl, "Passport Number Label", pageName),
					"Passport No.", "Passport No. label text mismatched");
			softAssert.assertEquals(
					passportPage.getElementText(passportPage.passportExpDateLbl, "Expiration Date Label", pageName),
					"Expiration Date", "EXPIRATION DATE label text mismatched");
			softAssert.assertEquals(
					passportPage.getElementText(passportPage.passportCountryLbl, "PASSPORT COUNTRY Label", pageName),
					"Passport Country", "PASSPORT COUNTRY label text mismatched");
		}
		String fileName = this.getClass().getSimpleName() + "_" + CommonUtilities.getCurrentDateAndTime("ddMMyyhhmmss");
		AbstractMobileBasePage.getLogger().pass("Successfully verified Passport details.",
				MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreenshot(fileName)).build());
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
	}

	/**
	 * This method will verify passport information of glober
	 * 
	 * @throws IOException
	 */
	public void verifyGloberPassportInfo() throws IOException {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String pageName = "Passport Details Page";
		if (passportPage.isElementDisplayed(passportPage.noPassportAddedMsg, "No passport details added Message",
				pageName)) {
			softAssert.assertTrue(passportPage.getElementText(passportPage.noPassportAddedMsg,"No passport details added Message", pageName)
									.contains("Glober has no passport information."),"Glober has no passport information added.");
		} else {
			waitHandler.WaitForElementToBeVissible(passportPage.passportNoLbl, "Passport Number Label", pageName,
					configMobileParams.getMaxWaitTime());
			softAssert.assertEquals(passportPage.getElementText(passportPage.passportNo, "Passport Number", pageName),
					personalDeatils.getPassportNo(), "Passport Number did not match");
			softAssert.assertEquals(
					passportPage.getElementText(passportPage.passportExpDate, "Expiration Date", pageName),
					personalDeatils.getPassportExpDate(), "Expiration Date did not match");
			softAssert.assertEquals(
					passportPage.getElementText(passportPage.passportCountry, "Passport Country", pageName),
					personalDeatils.getPassportCountry(), "Passport Country did not match");
		}
		String fileName = this.getClass().getSimpleName() + "_" + CommonUtilities.getCurrentDateAndTime("ddMMyyhhmmss");
		AbstractMobileBasePage.getLogger().pass("Successfully verified Passport details.",
				MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreenshot(fileName)).build());
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
	}

}
