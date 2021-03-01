package com.globant.qe.in.travelNEXT.mobile.tests.frequentFlyerNumbers;

import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAddFrequentFlyerNumbersPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEditFrequentFlyerNumbersPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTFrequentFlyerNumbersPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTViewFrequentFlyerNumbersPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTWelcomePage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;
import io.appium.java_client.android.AndroidDriver;

public class FrequentFlyerNumberTests extends TravelNEXTMobileBaseTestSuite {

	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTFrequentFlyerNumbersPage frequentFlyerNumbersPage;

	@Autowired
	TravelNEXTAddFrequentFlyerNumbersPage addFrequentFlyerNumbersPage;

	@Autowired
	TravelNEXTWelcomePage travelNEXTWelcomePage;

	@Autowired
	CommonUtilities utilities;

	@Autowired
	AbstractMobileBasePage abstractMobileBasePage;

	@Autowired
	TravelNEXTEditFrequentFlyerNumbersPage editFrequentFlyerNumbersPage;

	@Autowired
	TravelNEXTViewFrequentFlyerNumbersPage viewFrequentFlyerNumbersPage;

	@Autowired
	CommonUtilities commonUtilities;

	String flyerNo, airlineName;

	/**
	 * This method will delete all the frequent flyer cards
	 */
	@Test(priority = 0)
	public void deleteAllFrequentFlyerCards() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Frequent Flyer Numbers";
			String toastMessage = "Frequent Flyer Number deleted successfully";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();

			while (frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.airlineList, "Airline list",
					pageName)) {
				frequentFlyerNumbersPage.tapOnAirlineList();
				viewFrequentFlyerNumbersPage.tapDeleteBtn().deleteFlyerNumberBtn.click();

				softAssert.assertTrue(frequentFlyerNumbersPage.isToastMessageDisplayed(toastMessage),
						"Toast frequent flyer number deleted successfully message is not displayed.");

				waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			}
			softAssert.assertTrue(
					frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.noFrequentFlyerNumbersMsg,
							"No Frequent Flyer Numbers added message", pageName),
					"No Frequent Flyer Numbers added message is absent");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify frequent flyer numbers page
	 */
	@Test(priority = 1)
	public void verifyFrequentFlyerNumbersPage() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Frequent Flyer Numbers";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();

			if (frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.noFrequentFlyerNumbersMsg,
					"No flyer number added message", pageName)) {

				softAssert.assertTrue(
						frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.noFrequentFlyerNumbersMsg,
								"No Frequent Flyer Numbers added message", pageName),
						"No Frequent Flyer Numbers added message is absent");

				softAssert
						.assertTrue(
								frequentFlyerNumbersPage.isElementDisplayed(
										frequentFlyerNumbersPage.frequentFlyerAddBtn, "ADD button", pageName),
								"ADD button is not displayled");
			} else {
				softAssert.assertTrue(frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.flyerList,
						"Flyer Numbers list", pageName), "Flyer number is not displayled");
			}
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify details of Add Frequent flyer numbers page
	 * on-clicking ADD button
	 */
	@Test(priority = 2)
	public void verifyAddFrequentFlyerNumbersPage() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Add Frequent Flyer Numbers Page";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapAddButton();

			softAssert
					.assertTrue(
							addFrequentFlyerNumbersPage.isElementDisplayed(
									addFrequentFlyerNumbersPage.selectAirlineField, "Select Airline field", pageName),
							"Select Airline is not displayled");

			softAssert.assertTrue(addFrequentFlyerNumbersPage.isElementDisplayed(
					addFrequentFlyerNumbersPage.frequentFlyerNumbersField, "Frequent Flyer Numbers field", pageName),
					"Frequent Flyer Numbers field is not displayled");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will add frequent flyer number
	 * 
	 */
	@Test(priority = 3, dependsOnMethods = { "deleteAllFrequentFlyerCards" })
	public void addFrequentFlyerNumbers() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			airlineName = "Adria Airways";
			String pageName = "Add Frequent Flyer Numbers", txt;
			flyerNo = commonUtilities.gererateRandomString(5);
			boolean isTextContainsFlyerNo = false;
			int sizeOfList;
			String toastMessage = "Frequent Flyer Number added successfully";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapAddButton();
			addFrequentFlyerNumbersPage.selectAirline(airlineName).enterFrequentFlyerNumber(flyerNo);

			softAssert.assertTrue(addFrequentFlyerNumbersPage
					.isElementEnabled(addFrequentFlyerNumbersPage.addFlyerNumberBtn, "Add button", pageName),
					"Add button is not displayled");

			addFrequentFlyerNumbersPage.addFlyerNumberBtn.click();

			softAssert.assertTrue(frequentFlyerNumbersPage.isToastMessageDisplayed(toastMessage),
					"Toast frequent flyer number added successfully message is not displayed.");

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			if (mobileDriver instanceof AndroidDriver) {
				frequentFlyerNumbersPage.scroll("up");
				sizeOfList = frequentFlyerNumbersPage.flyerNumbersList.size();
				txt = frequentFlyerNumbersPage.flyerNumbersList.get(sizeOfList - 1).getText();
				isTextContainsFlyerNo = txt.contains(flyerNo);
				softAssert.assertEquals(txt, flyerNo);

			} else {
				txt = frequentFlyerNumbersPage.getFrequentFlyerCardFromList(airlineName, flyerNo).getText();
				isTextContainsFlyerNo = txt.contains(flyerNo);
				softAssert.assertEquals(isTextContainsFlyerNo, true);
			}

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify helper text character count
	 */
	@Test(priority = 5, dependsOnMethods = { "addFrequentFlyerNumbers" })
	public void verifyHelperTextCharacterCount() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);
			viewFrequentFlyerNumbersPage.tapEditBtn();
			addFrequentFlyerNumbersPage.enterFrequentFlyerNumber(flyerNo);

			softAssert.assertNotEquals("15/15", addFrequentFlyerNumbersPage.helperTextCharacterCount.getText());
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify max helper text character length is 15
	 */
	@Test(priority = 6, dependsOnMethods = { "addFrequentFlyerNumbers" })
	public void verifyHelperTextCharacterLength() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);
			viewFrequentFlyerNumbersPage.tapEditBtn();
			addFrequentFlyerNumbersPage.enterFrequentFlyerNumber(flyerNo);
			int helperTextLength = addFrequentFlyerNumbersPage.typeFrequentFlyerNumber.getText().toUpperCase().length();

			softAssert.assertTrue(helperTextLength <= 15, "You can not add more than 15 characters.");
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify the Airline Dropdown
	 */
//	@Test(priority = 7) 
//	Commented this code because we need to see dropdown for android.
//	public void verifyAirlineDropdown() {
//		try {
//
//			logger.log(Status.INFO, "Test Case Execution Started");
//			SoftAssert softAssert = new SoftAssert();
//			String pageName = "Add Frequent Flyer Number Page";
//			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
//			frequentFlyerNumbersPage.tapAddButton();
//			addFrequentFlyerNumbersPage.getSearchedAirlineList("Airline");
//			softAssert
//					.assertTrue(
//							addFrequentFlyerNumbersPage.isElementDisplayed(
//									addFrequentFlyerNumbersPage.airlineDropdownList, "Airline dropdwonlist", pageName),
//							"Airline dropdwonlist is not present.");
//			logger.log(Status.INFO, "Test Case Execution completed.");
//			softAssert.assertAll();
//
//		} catch (Exception e) {
//			logger.log(Status.FAIL, e.getMessage());
//			throw e;
//		}
//	}

	/**
	 * This method will verify search feature of Airline, i.e.,It will verify list
	 * of the airlines which contains text your'e searching for.
	 */
//	@Test(priority = 8)
//	Commented this code because we need to see dropdown for android.
	/*
	 * public void verifySearchFeatureOfAirline() { try { logger.log(Status.INFO,
	 * "Test Case Execution Started"); SoftAssert softAssert = new SoftAssert();
	 * mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().
	 * goToFrequentFlyerNumbers(); frequentFlyerNumbersPage.tapAddButton();
	 * addFrequentFlyerNumbersPage.getSearchedAirlineList("Airline");
	 * List<MobileElement> list =
	 * addFrequentFlyerNumbersPage.specificAirlineSearchList;
	 * 
	 * for (int i = 0; i < list.size(); i++) { String airlineElement =
	 * addFrequentFlyerNumbersPage.specificAirlineSearchList.get(i)
	 * .getAttribute("value").toLowerCase();
	 * Assert.assertTrue(airlineElement.contains("air"),
	 * "The elements showing in dropdown doesn't contain air text."); }
	 * logger.log(Status.INFO, "Test Case Execution completed.");
	 * softAssert.assertAll();
	 * 
	 * } catch (Exception e) { logger.log(Status.FAIL, e.getMessage()); throw e; } }
	 */

	/**
	 * This method will verify message to be displayed for mandatory field
	 */
	@Test(priority = 9, dependsOnMethods = { "addFrequentFlyerNumbers" })
	public void verifyMandatoryFieldMsg() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Add Frequent Flyer Number Page";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);

			viewFrequentFlyerNumbersPage.tapEditBtn();
			abstractMobileBasePage.tap(editFrequentFlyerNumbersPage.selectAirlineTextField, "Select Airline", pageName);

			if (mobileDriver instanceof AndroidDriver) {
				editFrequentFlyerNumbersPage.selectAirlineTextField.clear();
			} else {
				abstractMobileBasePage.longPress(editFrequentFlyerNumbersPage.selectAirlineTextField, "Select Airline",
						pageName);
				editFrequentFlyerNumbersPage.tapSelectAllBtn();
				editFrequentFlyerNumbersPage.selectAirlineTextField.sendKeys(Keys.DELETE);
			}

			softAssert.assertTrue(
					addFrequentFlyerNumbersPage.isElementDisplayed(addFrequentFlyerNumbersPage.requiredFieldMsg,
							"Required Field Message", pageName),
					"Required Field message is not displayed.");

			addFrequentFlyerNumbersPage.enterFrequentFlyerNumber(flyerNo);

			if (mobileDriver instanceof AndroidDriver) {
				editFrequentFlyerNumbersPage.frequentFlyerNumbersTextField.clear();
			} else {
				abstractMobileBasePage.longPress(editFrequentFlyerNumbersPage.frequentFlyerNumbersTextField,
						"Frequent Flyer Number", pageName);
				editFrequentFlyerNumbersPage.tapSelectAllBtn();
				editFrequentFlyerNumbersPage.frequentFlyerNumbersTextField.sendKeys(Keys.DELETE);
			}

			softAssert.assertTrue(
					addFrequentFlyerNumbersPage.isElementDisplayed(addFrequentFlyerNumbersPage.requiredFieldMsg,
							"Required Field Message", pageName),
					"Required Field message is not displayed.");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify message to be displayed for duplicate flyer card
	 */
	@Test(priority = 10, dependsOnMethods = { "addFrequentFlyerNumbers" })
	public void verifyDuplicateFlyerCardMsg() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Edit flyer number page";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapAddButton();
			addFrequentFlyerNumbersPage.selectAirline(airlineName).enterFrequentFlyerNumber(flyerNo);
			addFrequentFlyerNumbersPage.tapAddBtn();

			softAssert.assertTrue(addFrequentFlyerNumbersPage.isElementDisplayed(
					addFrequentFlyerNumbersPage.duplicateFlyerNumberCardMsg, "Duplicate Flyer number Message",
					pageName), "Flyer number already exists.");
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify user can edit frequent flyer number
	 */
	@Test(priority = 11, dependsOnMethods = { "addFrequentFlyerNumbers" })
	public void verifyEditFrequentFlyerNumber() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Edit Frequent Flyer Number";
			String toastMessage = "Frequent Flyer information updated successfully";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);

			softAssert.assertTrue(viewFrequentFlyerNumbersPage.isElementDisplayed(viewFrequentFlyerNumbersPage.editBtn,
					"Edit button", pageName), "Edit button is not enabled");
			softAssert.assertTrue(viewFrequentFlyerNumbersPage.isElementDisplayed(
					viewFrequentFlyerNumbersPage.deleteBtn, "Delete button", pageName), "Delete button is not enabled");

			viewFrequentFlyerNumbersPage.tapEditBtn();

			softAssert.assertTrue(editFrequentFlyerNumbersPage.isElementDisplayed(
					editFrequentFlyerNumbersPage.editFrequentFlyerNumberHeader, "Edit Frequent Flyer Header", pageName),
					"Edit Frequent Flyer header is not displayed");
			softAssert.assertFalse(editFrequentFlyerNumbersPage.isElementEnabled(editFrequentFlyerNumbersPage.saveBtn,
					"Save button", pageName), "Save button is enabled");

			airlineName = "airberlin";
			flyerNo = commonUtilities.gererateRandomString(4);

			editFrequentFlyerNumbersPage.tapOnClearAll();
			editFrequentFlyerNumbersPage.selectAirline(airlineName).enterFrequentFlyerNumber(flyerNo);

			softAssert.assertTrue(editFrequentFlyerNumbersPage.isElementEnabled(editFrequentFlyerNumbersPage.saveBtn,
					"Save button", pageName), "Save button is not enabled");

			editFrequentFlyerNumbersPage.saveBtn.click();

			softAssert.assertTrue(viewFrequentFlyerNumbersPage.isToastMessageDisplayed(toastMessage),
					"Toast Frequent Flyer Information updated Msg is not displayed.");

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			softAssert.assertEquals(viewFrequentFlyerNumbersPage.flyerNumberFieldText.getText(), flyerNo);

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify user can cancel editing of frequent flyer number
	 */
	@Test(priority = 12, dependsOnMethods = { "verifyEditFrequentFlyerNumber" })
	public void verifyCancellingChangesOfFrequentFlyerNumber() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Edit Frequent Flyer Number";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);

			viewFrequentFlyerNumbersPage.tapEditBtn();
			editFrequentFlyerNumbersPage.tapOnClearAll();

			String airlineName = "Aeroflot";
			String flyerNo = commonUtilities.gererateRandomString(4);
			editFrequentFlyerNumbersPage.selectAirline(airlineName).enterFrequentFlyerNumber(flyerNo);

			softAssert.assertTrue(editFrequentFlyerNumbersPage.isElementEnabled(editFrequentFlyerNumbersPage.cancelBtn,
					"Cancel button", pageName), "Cancel button is not enabled");

			editFrequentFlyerNumbersPage.tapOnCancelBtn();

			softAssert.assertTrue(
					editFrequentFlyerNumbersPage.isElementDisplayed(
							editFrequentFlyerNumbersPage.cancelFlyerNumberDescription,
							"Are you sure you want to discard all changes? description", pageName),
					"Cancel changes button description is not displyed");

			editFrequentFlyerNumbersPage.tapOnCancelChangesBtn();

			boolean isFlyerNumberPresent = mobileDriver.getPageSource().contains(flyerNo);
			softAssert.assertEquals(isFlyerNumberPresent, true);

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify user can discard editing of frequent flyer number
	 */
	@Test(priority = 13, dependsOnMethods = { "verifyEditFrequentFlyerNumber" })
	public void verifyDiscardingChangesOfFrequentFlyerNumber() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "View Frequent Flyer Number";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();

			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);
			viewFrequentFlyerNumbersPage.tapEditBtn();
			editFrequentFlyerNumbersPage.tapOnClearAll();

			String airlineName = "Aeroflot";
			String flyerNo = commonUtilities.gererateRandomString(5);
			editFrequentFlyerNumbersPage.selectAirline(airlineName).enterFrequentFlyerNumber(flyerNo);

			softAssert.assertTrue(editFrequentFlyerNumbersPage.isElementEnabled(editFrequentFlyerNumbersPage.cancelBtn,
					"Cancel button", pageName), "Cancel button is not enabled");

			editFrequentFlyerNumbersPage.tapOnCancelBtn();

			softAssert.assertTrue(
					editFrequentFlyerNumbersPage.isElementDisplayed(
							editFrequentFlyerNumbersPage.cancelFlyerNumberDescription,
							"Are you sure you want to discard all changes? description", pageName),
					"Cancel changes button description is not displyed");

			editFrequentFlyerNumbersPage.tapOnDiscardChangesBtn();
			softAssert.assertNotEquals(viewFrequentFlyerNumbersPage.flyerNumberFieldText.getText(), flyerNo);

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify ClearAll feature
	 */
	@Test(priority = 14, dependsOnMethods = { "verifyEditFrequentFlyerNumber" })
	public void verifyClearAllFeature() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);
			viewFrequentFlyerNumbersPage.tapEditBtn();
			editFrequentFlyerNumbersPage.tapOnClearAll();
			
			softAssert.assertEquals(editFrequentFlyerNumbersPage.selectAirlineTextField.getText(), "Select Airline *");
			softAssert.assertEquals(editFrequentFlyerNumbersPage.frequentFlyerNumbersTextField.getText(),
					"Frequent Flyer Number *");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify user can delete frequent flyer number
	 */
	@Test(priority = 15, dependsOnMethods = { "verifyEditFrequentFlyerNumber" })
	public void verifyDeleteFrequentFlyerNumber() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Frequent Flyer Numbers Page";
			String toastMessage = "Frequent Flyer Number deleted successfully";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);
			viewFrequentFlyerNumbersPage.tapDeleteBtn().deleteFlyerNumberBtn.click();

			softAssert.assertTrue(
					frequentFlyerNumbersPage.isToastMessageDisplayed("Frequent Flyer Number deleted successfully"),
					"Toast frequent flyer number deleted successfully is not displayed.");

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			if (frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.flyerList, "Flyer numbers list",
					pageName)) {

				softAssert.assertNotEquals(frequentFlyerNumbersPage.flyerList.getText(), flyerNo);
			} else {
				softAssert.assertTrue(
						frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.noFrequentFlyerNumbersMsg,
								"No Frequent Flyer Numbers added message", pageName),
						"No Frequent Flyer Numbers added message is absent");
			}

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify user can cancel the deletion of frequent flyer number
	 */
	@Test(priority = 16)
	public void verifyCancellationOfDeleteFlyerNumber() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String toastMessage = "Frequent Flyer Number added successfully";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();
			frequentFlyerNumbersPage.tapAddButton();
			String airlineName = "Aeroflot (Rusia)";
			String flyerNo = commonUtilities.gererateRandomString(5);
			addFrequentFlyerNumbersPage.selectAirline(airlineName).enterFrequentFlyerNumber(flyerNo);
			addFrequentFlyerNumbersPage.tapAddBtn();

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			frequentFlyerNumbersPage.tapOnFrequentFlyerCardFromList(airlineName, flyerNo);
			viewFrequentFlyerNumbersPage.tapDeleteBtn().tapCancelFlyerNumberBtn();

			softAssert.assertNotNull(viewFrequentFlyerNumbersPage.flyerNumberFieldText.getText());
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify that max count of adding flyer cards is 10 This will
	 * fail for Android as all the attributes values are false for it
	 */
	@Test(priority = 17)
	public void verifyMaxCountOfFlyerNoAddition() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String airline = "Adria Airways";
			String pageName = "Frequent Flyer Numbers Page";
			String toastMsg = "You can save up to 10 Frequent Flyer Numbers only";
			String toastMsgForCardAdded = "Frequent Flyer Number added successfully";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToFrequentFlyerNumbers();

			if (frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.noFrequentFlyerNumbersMsg,
					"No Flyer Number added message", pageName)) {
				frequentFlyerNumbersPage.tapAddButton();

				waitHandler.waitForElementToBeEnabled(addFrequentFlyerNumbersPage.searchAirline, "Search Airline field",
						pageName, configMobileParams.getMaxWaitTime());

				addFrequentFlyerNumbersPage.selectAirline(airline)
						.enterFrequentFlyerNumber("123" + utilities.gererateRandomString(4));
				addFrequentFlyerNumbersPage.addFlyerNumberBtn.click();

				softAssert.assertTrue(frequentFlyerNumbersPage.isToastMessageDisplayed(toastMsgForCardAdded),
						"Toast frequent flyer number added successfully message is not displayed.");
			}

			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					travelNEXTBasePage.timeOut);

			frequentFlyerNumbersPage.scroll("up");
			int cardsCount = frequentFlyerNumbersPage.listOfFlyerCards.size();
			frequentFlyerNumbersPage.scroll("down");
			waitHandler.waitForTimeToLapse(1000);

			while (cardsCount < 10) {
				frequentFlyerNumbersPage.tapAddButton();

				waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
						travelNEXTBasePage.timeOut);

				addFrequentFlyerNumbersPage.selectAirline("Adria Airways")
						.enterFrequentFlyerNumber("123" + utilities.gererateRandomString(7));
				addFrequentFlyerNumbersPage.addFlyerNumberBtn.click();

				softAssert.assertTrue(frequentFlyerNumbersPage.isToastMessageDisplayed(toastMsgForCardAdded),
						"Toast frequent flyer number added successfully message is not displayed.");

				cardsCount++;
			}

			if (cardsCount == 10) {

				waitHandler.waitForElementToBeEnabled(frequentFlyerNumbersPage.frequentFlyerAddBtn, "ADD button",
						pageName, configMobileParams.getMaxWaitTime());

				frequentFlyerNumbersPage.frequentFlyerAddBtn.click();
				softAssert.assertTrue(abstractMobileBasePage.isToastMessageDisplayed(toastMsg));
			}

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		} finally {
			String pageName = "Frequent Flyer Numbers Page";
			String toastMessage = "Frequent Flyer Number deleted successfully";

			while (frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.airlineList, "Airline list",
					pageName)) {
				frequentFlyerNumbersPage.tapOnAirlineList();
				viewFrequentFlyerNumbersPage.tapDeleteBtn().deleteFlyerNumberBtn.click();

				softAssert.assertTrue(frequentFlyerNumbersPage.isToastMessageDisplayed(toastMessage),
						"Toast frequent flyer number deleted successfully message is not displayed.");

			}

			softAssert.assertTrue(
					frequentFlyerNumbersPage.isElementDisplayed(frequentFlyerNumbersPage.noFrequentFlyerNumbersMsg,
							"No Frequent Flyer Numbers added message", pageName),
					"No Frequent Flyer Numbers added message is absent");
		}
	}

}