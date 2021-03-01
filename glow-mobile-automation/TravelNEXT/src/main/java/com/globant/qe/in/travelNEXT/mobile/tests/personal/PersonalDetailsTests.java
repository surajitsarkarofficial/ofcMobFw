package com.globant.qe.in.travelNEXT.mobile.tests.personal;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTPersonalDetailsService;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTPersonalDetailsPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class PersonalDetailsTests extends TravelNEXTMobileBaseTestSuite {

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTPersonalDetailsPage profilePage;

	@Autowired
	TravelNEXTPersonalDetailsService personalDetailsService;

	@Autowired
	PersonalDeatils personalDeatils;

	/**
	 * This method will verify personal section's functionality
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void verifyGloberPersonalDetails() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger();
			mobileServiceProvider.getTravelNEXTSideBarService().goToPersonalDetails();
			verifyPersonalDetailsLabels();
			verifyGloberPersonalInfo();
			mobileServiceProvider.getTravelNEXTPersonalDetailsService().hidePersonalDetails().logout();
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify Labels of personal section
	 * 
	 * @throws IOException
	 */
	public void verifyPersonalDetailsLabels() throws IOException {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String pageName = "Personal Details Page";
		waitHandler.waitForElementToBeEnabled(profilePage.documentNoLabel, "Document Number Label", pageName,
				configMobileParams.getMaxWaitTime());

		softAssert.assertEquals(
				profilePage.getElementText(profilePage.documentNoLabel, "Document Number Label", pageName),
				"Document No.", "Document Number label text mismatched");
		softAssert.assertEquals(profilePage.getElementText(profilePage.genderLabel, "Gender Label", pageName), "Gender",
				"Gender Label text mismatched.");
		softAssert.assertEquals(profilePage.getElementText(profilePage.dobLabel, "BIRTH DATE Label", pageName),
				"Birth Date", "BIRTH DATE Label text mismatched.");
		softAssert.assertEquals(profilePage.getElementText(profilePage.nationalityLabel, "NATIONALITY Label", pageName),
				"Nationality", "NATIONALITY Label text mismatched.");
		softAssert.assertEquals(profilePage.getElementText(profilePage.phoneLabel, "PHONE Label", pageName), "Phone",
				"PHONE Label text mismatched.");
		String fileName = this.getClass().getSimpleName() + "_" + CommonUtilities.getCurrentDateAndTime("ddMMyyhhmmss");
		AbstractMobileBasePage.getLogger().pass("Successfully verified Personal Details Labels",
				MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreenshot(fileName)).build());
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));

	}

	/**
	 * This method will verify Personal information of glober
	 * 
	 * @throws IOException
	 */
	public void verifyGloberPersonalInfo() throws IOException {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String pageName = "Personal Details Page";
		softAssert.assertEquals(profilePage.getElementText(profilePage.documentNo, "Document Number", pageName),
				personalDeatils.getDocumentNo(), "Document Number did not match");
		softAssert.assertEquals(profilePage.getElementText(profilePage.gender, "Gender", pageName),
				personalDeatils.getGender(), "Gender did not match");
		softAssert.assertEquals(profilePage.getElementText(profilePage.dob, "Birth Date", pageName),
				personalDeatils.getDOB(), "Birth Date did not match");
		softAssert.assertEquals(profilePage.getElementText(profilePage.nationality, "Nationality", pageName),
				personalDeatils.getNationality(), "Nationality did not match");
		softAssert.assertEquals(profilePage.getElementText(profilePage.phoneNo, "Phone Number", pageName),
				personalDeatils.getPhoneNo(), "Phone Number did not match");
		String fileName = this.getClass().getSimpleName() + "_" + CommonUtilities.getCurrentDateAndTime("ddMMyyhhmmss");
		AbstractMobileBasePage.getLogger().pass("Successfully verified Personal Information",
				MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreenshot(fileName)).build());
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		softAssert.assertAll();
	}

}
