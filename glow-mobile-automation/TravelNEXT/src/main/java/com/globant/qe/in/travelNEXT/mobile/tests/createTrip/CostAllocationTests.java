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
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTSideBarPage;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

public class CostAllocationTests extends TravelNEXTMobileBaseTestSuite {

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

	public String pageName = "Cost Allocation Page";
	static String projectName = "Discovery - Prisma";
	
	/**
	 * This method will verify cost allocation page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void verifyCostAllocationScreen() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
			String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			SoftAssert softAssert = new SoftAssert();

			travelNEXTCreateTripPage.createTrip();
			waitHandler.WaitForElementToBeVissible(travelNEXTCostAllocationPage.ownerName, "Owner Name", pageName,
					configMobileParams.getMaxWaitTime());
			softAssert.assertEquals(travelNEXTCostAllocationPage.ownerName.getText(),
					personalDeatils.getTravelAppGloberName());
			softAssert.assertTrue(travelNEXTCostAllocationPage.isElementDisplayed(
					travelNEXTCostAllocationPage.globerImage, "Glober Image", pageName), "Glober Image is not present");

			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify added project under cost allocation
	 */
	@Test(priority = 2)
	public void verifyProjectAddedUnderCostAllocation() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			SoftAssert softAssert = new SoftAssert();
			String projectName = "Discovery - Prisma";
			String projectAddedtoast = "Project added successfully";

			travelNEXTCreateTripPage.createTrip();
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					configMobileParams.getMaxWaitTime());

			travelNEXTCostAllocationPage.tapOnAddProjectPlusBtn();
			travelNEXTCostAllocationPage.selectProject(projectName);
			travelNEXTCostAllocationPage.tapOnAddProjectBtn();
			
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					configMobileParams.getMaxWaitTime());
		
			sideBarPage.scroll("up");

			waitHandler.WaitForElementToBeVissible(travelNEXTCostAllocationPage.projectName, "Project Name", pageName,
					configMobileParams.getMaxWaitTime());

			softAssert.assertEquals(travelNEXTCostAllocationPage.projectName.getText(), projectName);
			softAssert.assertTrue(travelNEXTCostAllocationPage.isElementDisplayed(
					travelNEXTCostAllocationPage.optionBtnforAddedProject, "Option button", pageName),
					"Option button for added project is not present.");

			travelNEXTCostAllocationPage.tapOnOptionButton();

			softAssert.assertTrue(travelNEXTCostAllocationPage.isElementDisplayed(travelNEXTCostAllocationPage.editOption,
					"Edit Option button", pageName),
					"Edit option button for added project is not present.");
			softAssert.assertTrue(travelNEXTCostAllocationPage.isElementDisplayed(travelNEXTCostAllocationPage.removeOption,
					"remove Option button", pageName),
					"Remove option button for added project is not present.");
			softAssert.assertTrue(travelNEXTCostAllocationPage.isElementDisplayed(travelNEXTCostAllocationPage.detailsOption,
					"Details Option button", pageName),
					"Details option button for added project is not present.");

			travelNEXTCostAllocationPage.tapOnDetailsOptionButton();
			travelNEXTCostAllocationPage.tapOnCloseButtonOfProjectDetails();

			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

}
