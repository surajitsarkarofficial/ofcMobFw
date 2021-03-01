package com.globant.qe.in.travelNEXT.mobile.tests.emergencyContacts;

import java.io.IOException; 
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.EmergencyContactDetails;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTEmergencyContactsService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTSideBarService;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAddEmergencyContactsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEditEmergencyContactsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEmergencyContactsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHomePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTSideBarPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTViewEmergencyContactsPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;

import io.appium.java_client.android.AndroidDriver;

public class EmergencyContactsTests extends TravelNEXTMobileBaseTestSuite {

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
	TravelNEXTEmergencyContactsPage emergencyContactsPage;

	@Autowired
	EmergencyContactDetails emergencyContactDetails;

	@Autowired
	TravelNEXTAddEmergencyContactsPage addEmergencyContactsPage;

	@Autowired
	TravelNEXTEditEmergencyContactsPage editEmergencyContactsPage;

	@Autowired
	TravelNEXTViewEmergencyContactsPage viewEmergencyContactsPage;

	@Autowired
	TravelNEXTEmergencyContactsService emergencyContactService;

	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;
	
	@Autowired
	AbstractMobileBasePage abstractMobileBasePage;
	
	SoftAssert softAssert;

	public static String eContactName, phoneNumber;

	/**
	 * This method will delete all the emergency contacts
	 * @throws Exception 
	 */
	@Test(priority = 0)
	public void deleteAllEmergencyContacts() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Emergency Contacts Page";
			String toastMessage = "Contact deleted successfully";
			
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToEmergencyContacts();

			while (emergencyContactsPage.isElementDisplayed(emergencyContactsPage.fullNameList, "FullName list",
					pageName)) {
				emergencyContactsPage.fullNameList.click();
				viewEmergencyContactsPage.tapDeleteBtn().deleteEmergencyContactBtn.click();
				
				softAssert.assertTrue(emergencyContactsPage.isToastMessageDisplayed("Contact deleted successfully"),
						"Toast emergency contact deleted successfully message is not displayed.");
			
				waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);
				
				softAssert.assertTrue(
						emergencyContactsPage.isElementDisplayed(emergencyContactsPage.addContactBtn,
								"ADD button", pageName),
						"Add button is not present");
			}
			softAssert.assertTrue(
					emergencyContactsPage.isElementDisplayed(emergencyContactsPage.noEmergencyContactMsg,
							"No emergency contact added message", pageName),
					"Message for No emergency contact added is not present");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify Emergency Contacts Details
	 * 
	 * @throws Exception
	 * 
	 */
	@Test(priority = 1)
	public void verifyEmergencyContactsPageDetails() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToEmergencyContacts();
			verifyEmergencyContactsPage();
			emergencyContactService.tapAddContactBtn();
			verifyAddEmergencyContactPage();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		}
	}

	/**
	 * This method will add emergency contacts with all fields and verify mandatrory
	 * fields.
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2, dependsOnMethods = {"deleteAllEmergencyContacts"})
	public void addEmergencyContacts() throws Exception {
		try {
			softAssert = new SoftAssert();
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			String pageName = "Add Emergency Contact Page";
			String toastMessage ="Contact added successfully";
			
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToEmergencyContacts()
					.tapAddContactBtn();
			eContactName = "Auto UI" + CommonUtilities.getCurrentDateAndTime("MMddyyhhmmss");
			phoneNumber = CommonUtilities.generateRandomPhoneNumber();
			String relationship = "Colleague";
			String address = "Globant,Pune,India";

			addEmergencyContactsPage.enterFullName(eContactName);
			addEmergencyContactsPage.enterRelationShip(relationship);
			softAssert.assertFalse(
					addEmergencyContactsPage.isElementEnabled(addEmergencyContactsPage.addBtn, "Add button", pageName),
					"Add button is enabled even when all mandarory fields are not entered");

			addEmergencyContactsPage.enterPhoneNo(phoneNumber);
			
			softAssert.assertTrue(
					addEmergencyContactsPage.isElementEnabled(addEmergencyContactsPage.addBtn, "Add button", pageName),
					"Add button is not enabled even after entering all mandatory fields");

			addEmergencyContactsPage.enterAddressField(address);

			// Added call to this directly because for iOS it takes time to load the page
			// and toast disappears
			// by the time control comes back
			addEmergencyContactsPage.addBtn.click();

			
			softAssert.assertTrue(emergencyContactsPage.isToastMessageDisplayed("Contact added successfully"),
					"Toast message 'Contact added successfully' is not displayed");
					
			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			softAssert.assertTrue(
					emergencyContactsPage.isElementDisplayed(emergencyContactsPage.getFullnameFromList(eContactName),
					"Username from Contact list is not displayed.", pageName),
					"Username Contact list is not displayled");
					
			softAssert.assertTrue(
					emergencyContactsPage.isElementDisplayed(emergencyContactsPage.getPhoneNoFromList(phoneNumber),
					"Phone no from Contact list is not displayed.", pageName),
					"Phone no Contact list is not displayled");
			
			softAssert.assertAll();

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will edit emergency contacts
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4, dependsOnMethods = "addEmergencyContacts")
	public void clearEmergencyContactAndReenterIt() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			softAssert = new SoftAssert();
			String pageName = "Edit Emergency Contact Page";
			
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToEmergencyContacts();
			emergencyContactsPage.tapOnFullnameFromList(eContactName);
			
			softAssert.assertTrue(viewEmergencyContactsPage.isElementDisplayed(viewEmergencyContactsPage.whiteEditBtn,
					"whiteEdit button", pageName), "whiteEdit button is not enabled");
			softAssert.assertTrue(viewEmergencyContactsPage.isElementEnabled(viewEmergencyContactsPage.whiteDeleteBtn,
					"whiteDelete button", pageName), "whiteDelete button is not enabled");

			viewEmergencyContactsPage.tapEditBtn();
			addEmergencyContactsPage.enterAddressField("INDIA");

			editEmergencyContactsPage.saveBtn.click();
			
			softAssert.assertTrue(emergencyContactsPage.isToastMessageDisplayed("Contact updated successfully"),
					"Toast message 'Contact updated successfully' is not displayed");
			
			addEmergencyContactsPage.tapBackBtn();
			
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);

			softAssert.assertTrue(
					emergencyContactsPage.isElementDisplayed(emergencyContactsPage.getFullnameFromList(eContactName),
							"Username from Contact list is not displayed.", pageName),
					"Username Contact list is not displayled");
			softAssert.assertAll();

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will clear already added Fields, reenter in emergency contact and
	 * save it page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5, dependsOnMethods = "clearEmergencyContactAndReenterIt")
	public void clearAndReenterDataInEmergencyContactsAndSave() throws Exception {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			softAssert = new SoftAssert();
			String toastMessage = "Contact updated successfully";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToEmergencyContacts();
			String pageName = "Edit Emergency Contact Page";
			emergencyContactsPage.tapOnFullnameFromList(eContactName);
			viewEmergencyContactsPage.tapEditBtn();

			editEmergencyContactsPage.tapOnClearAllBtn();

			eContactName = "Auto UI" + CommonUtilities.getCurrentDateAndTime("MMddyyhhmmss");
			phoneNumber = CommonUtilities.generateRandomPhoneNumber();
			emergencyContactDetails.setFullName(eContactName);
			emergencyContactDetails.setPhoneNumber(phoneNumber);
			mobileServiceProvider.getTravelNEXTEditEmergencyContactsService()
					.fillEmergencyContactForm(emergencyContactDetails);

			editEmergencyContactsPage.saveBtn.click();
			
			softAssert.assertTrue(emergencyContactsPage.isToastMessageDisplayed("Contact updated successfully"),
					"Toast message 'Contact updated successfully' is not displayed");

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			viewEmergencyContactsPage.tapBackBtn();
			
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);

			softAssert.assertTrue(
					emergencyContactsPage.isElementDisplayed(emergencyContactsPage.getFullnameFromList(eContactName),
							"Username from Contact list is not displayed.", pageName),
					"Username Contact list is not displayled");
			softAssert.assertAll();

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	@Test(priority = 6, dependsOnMethods = { "clearAndReenterDataInEmergencyContactsAndSave" })
	public void cancelAndDeleteEmergencyContact() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			softAssert = new SoftAssert();
			String toastMessage = "Contact deleted successfully";
			//String pageName = "View Emergency contact";
			
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToEmergencyContacts();
			emergencyContactsPage.tapOnFullnameFromList(eContactName);

			viewEmergencyContactsPage.tapDeleteBtn().tapOnCancelEmergencyContactBtn();

			if (mobileDriver instanceof AndroidDriver)
				softAssert.assertEquals(viewEmergencyContactsPage.fullNameText.getText(), eContactName);
			else
				softAssert.assertEquals(viewEmergencyContactsPage.fullNameText.getAttribute("value"), eContactName);

			viewEmergencyContactsPage.tapDeleteBtn().deleteEmergencyContactBtn.click();
			
			softAssert.assertTrue(emergencyContactsPage.isToastMessageDisplayed(toastMessage),
					"Toast emergency contact deleted successfully message is not displayed.");

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);
			
			softAssert.assertAll();

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify emergency contact page details
	 * 
	 * @throws IOException
	 */
	public void verifyEmergencyContactsPage() throws IOException {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String pageName = "Emergency Contacts Page";
		softAssert = new SoftAssert();
		if (emergencyContactsPage.isElementDisplayed(emergencyContactsPage.noEmergencyContactMsg,
				"No Emergency Contact Message", pageName)) {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("No Emergency Contact Found."));
			softAssert.assertTrue(emergencyContactsPage
					.getElementText(emergencyContactsPage.noEmergencyContactMsg,
					"No Emergency Contact Message", pageName).contains("Glober has no Emergency Contact information"),
							"No Emergency contact msg text mismatched");
		} else {
			softAssert.assertTrue(emergencyContactsPage.isElementDisplayed(emergencyContactsPage.fullNameList,
					"Emergency Contact card was not displayed", pageName));
		}
		softAssert.assertTrue(emergencyContactsPage.isElementDisplayed(emergencyContactsPage.addContactBtn,
				"Add Contact Button", pageName), "Add contact button was not displayed.");
		softAssert.assertAll();

		String fileName = this.getClass().getSimpleName() + "_" + CommonUtilities.getCurrentDateAndTime("ddMMyyhhmmss");
		AbstractMobileBasePage.getLogger().log(Status.PASS, "Successfully verified Emergency Contacts Page.",
				MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreenshot(fileName)).build());
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));

	}

	/**
	 * This method will verify add emergency contacts page section
	 * 
	 * @throws IOException
	 */
	public void verifyAddEmergencyContactPage() throws IOException {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		softAssert = new SoftAssert();
		String pageName = "Add Emergency Contact Page";
		waitHandler.WaitForElementToBeVissible(addEmergencyContactsPage.addContactHeader, "Add Contact Header",
				pageName, configMobileParams.getMaxWaitTime());
		softAssert.assertTrue(
				addEmergencyContactsPage.isElementDisplayed(addEmergencyContactsPage.backBtn, "Back Button", pageName),
				"Back button not displayed");
		softAssert.assertEquals(addEmergencyContactsPage.getElementText(addEmergencyContactsPage.addContactHeader,
				"Add Contact Header", pageName), "Add Contact", "add contact page header not found");
		softAssert.assertTrue(addEmergencyContactsPage.isElementEnabled(addEmergencyContactsPage.fullNameField,
				"Full Name Field", pageName), "Full Name field is not editable");
		softAssert.assertTrue(addEmergencyContactsPage.isElementEnabled(addEmergencyContactsPage.relationshipField,
				"Relationship Field", pageName), "Relationship field is not editable");
		softAssert.assertTrue(addEmergencyContactsPage.isElementEnabled(addEmergencyContactsPage.phoneNoField,
				"Phone Number Field", pageName), "Phone Number field is not editable");
		softAssert.assertTrue(addEmergencyContactsPage.isElementEnabled(addEmergencyContactsPage.addressField,
				"Address Field", pageName), "Address field is not editable");
		softAssert.assertFalse(
				addEmergencyContactsPage.isElementEnabled(addEmergencyContactsPage.addBtn, "Add Button", pageName),
				"Add button is Enabled");
		softAssert.assertAll();
		String fileName = this.getClass().getSimpleName() + "_" + CommonUtilities.getCurrentDateAndTime("ddMMyyhhmmss");
		AbstractMobileBasePage.getLogger().log(Status.PASS, "Successfully verified Profiles - Add contact Page.",
				MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreenshot(fileName)).build());
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
	}

}
