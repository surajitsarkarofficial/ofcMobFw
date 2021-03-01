package com.globant.qe.in.travelNEXT.mobile.tests.createTrip;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTCostAllocationPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTCreateTripPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTPassengerPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTSideBarPage;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class PassengerTests extends TravelNEXTMobileBaseTestSuite {
	
	@Autowired
	TravelNEXTCreateTripPage travelNEXTCreateTripPage;
	
	@Autowired
	TravelNEXTCostAllocationPage travelNEXTCostAllocationPage;
	
	@Autowired
	CommonUtilities commonUtilities;

	@Autowired
	PersonalDeatils personalDeatils;
	
	@Autowired
	TravelNEXTSideBarPage sideBarPage;
	
	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;
	
	@Autowired
	TravelNEXTPassengerPage travelNEXTPassengerPage;

	public String pageName = "Passengers Page";
	static String projectName = "Discovery - Prisma";

	/**
	 * This method will verify passengers page details
	 */
//	@Test
//	Comment : Need to update locators for android.
	public void verifyPassengerPage() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			SoftAssert softAssert = new SoftAssert();

			String billabiltyType = "Bill to Globant";
			travelNEXTCreateTripPage.createTrip();
		
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					configMobileParams.getMaxWaitTime());

			travelNEXTCostAllocationPage.tapOnAddProjectPlusBtn();
			travelNEXTCostAllocationPage.selectProject(projectName);
			travelNEXTCostAllocationPage.tapOnAddProjectBtn();
			
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					configMobileParams.getMaxWaitTime());
			
			waitHandler.waitForElementToBeEnabled(travelNEXTCostAllocationPage.billablityDropdown, "Billability dropdown", pageName,
					configMobileParams.getMaxWaitTime());
			
			travelNEXTCostAllocationPage.SelectBillabilityType(billabiltyType);
			waitHandler.WaitForElementToDisappear(travelNEXTCostAllocationPage.billabilityTitle, "Billability Title", pageName,
					configMobileParams.getMaxWaitTime());

			travelNEXTCostAllocationPage.tapOnDoneBillabilityType();
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					configMobileParams.getMaxWaitTime());
			
			softAssert.assertTrue(travelNEXTCostAllocationPage.isElementEnabled(travelNEXTCostAllocationPage.editBillabilityBtn,
				"Edit billability button", pageName),"Edit billability button is not present.");
			
			travelNEXTCostAllocationPage.tapOnNextButton();
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					configMobileParams.getMaxWaitTime());
			
			softAssert.assertTrue(travelNEXTPassengerPage.isElementEnabled(travelNEXTPassengerPage.passengersCount,
					"Passengers count", pageName),"Defaulty passengers count is not present.");

			String defaultPassengersCount = TravelNEXTPassengerPage.passengersCount.getText();
			softAssert.assertEquals(defaultPassengersCount, "1");
			
			softAssert.assertEquals(TravelNEXTPassengerPage.defaultPassengerName.getText(),
					personalDeatils.getTravelAppGloberName());
			
			softAssert.assertTrue(travelNEXTPassengerPage.isElementEnabled(TravelNEXTPassengerPage.addPassengerBtn,
					"Add passenger Button", pageName),"Add Passenger button is not present.");
			
			softAssert.assertTrue(travelNEXTPassengerPage.isElementEnabled(TravelNEXTPassengerPage.addPassengerLabel,
					"Add passenger Label", pageName),"Add Passenger Label is not present.");
			
			softAssert.assertTrue(travelNEXTPassengerPage.isElementEnabled(TravelNEXTPassengerPage.maxPassengerLabel,
					"Passengers Count label", pageName),"Passengers Count Label is not present.");
			
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}

	}

}
