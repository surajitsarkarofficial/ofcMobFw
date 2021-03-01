package com.globant.qe.in.travelNEXT.mobile.tests.hotelLoyaltyPrograms;

import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTSideBarService;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAddHotelLoyaltyProgramsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEditHotelLoyaltyProgramsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHomePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHotelLoyaltyProgramsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTSideBarPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTViewHotelLoyaltyProgramsPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;
import io.appium.java_client.android.AndroidDriver;

public class HotelLoyaltyProgramsTests extends TravelNEXTMobileBaseTestSuite {

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
	TravelNEXTHotelLoyaltyProgramsPage hotelLoyaltyProgramsPage;

	@Autowired
	TravelNEXTViewHotelLoyaltyProgramsPage viewHotelLoyaltyProgramsPage;

	@Autowired
	TravelNEXTEditHotelLoyaltyProgramsPage editHotelLoyaltyProgramsPage;

	@Autowired
	TravelNEXTAddHotelLoyaltyProgramsPage addHotelLoyaltyProgramsPage;

	@Autowired
	AbstractMobileBasePage abstractMobileBasePage;

	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;
	
	public String loyaltyProgram, loyaltyProgramNumber;

	/**
	 * This method will delete all the hotel loyalty programs
	 */
	@Test(priority = 0)
	public void deleteAllHotelLoyaltyPrograms() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Hotel loyalty Programs Page";
			String toastMessage = "Hotel Loyalty Program deleted successfully";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();

			while (hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.loyaltyPrograms,
					"Loyalty programs list", pageName)) {
				hotelLoyaltyProgramsPage.tapOnLoyaltyProgram();
				viewHotelLoyaltyProgramsPage.tapDeleteIcon().yesBtn.click();

				softAssert.assertTrue(hotelLoyaltyProgramsPage.isToastMessageDisplayed(toastMessage),
						"Toast hotel loyalty program deleted successfully message is not displayed.");

				waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			}
			softAssert.assertTrue(
					hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.noHotelLoyaltyProgramAddedMsg,
							"No hotel loyalty program added message", pageName),
					"Message for No hotel loyalty program is absent");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify text for No Hotel Loyalty Program Added
	 */
	@Test(priority = 1)
	public void verifyNoHotelLoyaltyProgramAddedMsg() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Hotel loyalty Programs Page";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();

			softAssert.assertTrue(hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.addBtn,
					"ADD button", pageName), "ADD button is not present");

			softAssert.assertTrue(
					hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.noHotelLoyaltyProgramAddedMsg,
							"No hotel loyalty program added message", pageName),
					"Text Message for No hotel loyalty program is absent");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify detailed section of Hotel Loyalty programs page
	 */
	@Test(priority = 2)
	public void verifyAddHotelLoyaltyProgramPageDetails() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Hotel loyalty Programs Page";
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();

			hotelLoyaltyProgramsPage.tapOnAddBtn();

			softAssert.assertTrue(
					addHotelLoyaltyProgramsPage.isElementDisplayed(addHotelLoyaltyProgramsPage.loyaltyProgramField,
							"Select Loyalty Program field", pageName),
					"Select Loyalty Program field is not present");

			softAssert.assertTrue(
					addHotelLoyaltyProgramsPage.isElementDisplayed(
							addHotelLoyaltyProgramsPage.loyaltyProgramNumberField,
							"Select Loyalty Program Numbers field", pageName),
					"Select Loyalty Program Numbers field is not present");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will add hotel loyalty program
	 */
	@Test(priority = 3, dependsOnMethods = { "deleteAllHotelLoyaltyPrograms" })
	public void addHotelLoyaltyProgram() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			loyaltyProgram = "Hilton Honors";
			String toastMessage = "Hotel Loyalty Program added successfully";

			loyaltyProgramNumber = CommonUtilities.generateRandomNumber(5);

			String txt;
			int sizeOfList;
			boolean isTextContainsProgramNumber;

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnAddBtn();
			addHotelLoyaltyProgramsPage.selectLoyaltyProgram(loyaltyProgram)
					.enterLoyaltyProgramNumber(loyaltyProgramNumber);
			addHotelLoyaltyProgramsPage.addBtn.click();

			softAssert.assertTrue(hotelLoyaltyProgramsPage.isToastMessageDisplayed(toastMessage),
					"Toast hotel loyalty program added successfully message is not displayed.");

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 2);

			if (mobileDriver instanceof AndroidDriver) {
				hotelLoyaltyProgramsPage.scroll("up");
				sizeOfList = hotelLoyaltyProgramsPage.loyaltyProgramNumbersList.size();
				txt = hotelLoyaltyProgramsPage.loyaltyProgramNumbersList.get(sizeOfList - 1).getText();
				isTextContainsProgramNumber = txt.contains(loyaltyProgramNumber);
				softAssert.assertEquals(txt, loyaltyProgramNumber);

			} else {
				txt = hotelLoyaltyProgramsPage.getLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber)
						.getText();
				isTextContainsProgramNumber = txt.contains(loyaltyProgramNumber);
				softAssert.assertEquals(isTextContainsProgramNumber, true);
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
	@Test(priority = 5, dependsOnMethods = { "addHotelLoyaltyProgram" })
	public void verifyHelperTextCharacterCount() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();

			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);

			viewHotelLoyaltyProgramsPage.tapEditIcon();
			editHotelLoyaltyProgramsPage.enterLoyaltyProgramNumber(loyaltyProgramNumber);

			softAssert.assertNotEquals("15/15", addHotelLoyaltyProgramsPage.helperTextCharacterCount.getText());

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify maximum helper text character length is 15
	 */
	@Test(priority = 6, dependsOnMethods = { "addHotelLoyaltyProgram" })
	public void verifyHelperTextCharacterLength() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);
			viewHotelLoyaltyProgramsPage.tapEditIcon();
			String loyaltyProgramNumber = CommonUtilities.generateRandomNumber(17);

			editHotelLoyaltyProgramsPage.enterLoyaltyProgramNumber(loyaltyProgramNumber);

			int helperTextLength = editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.getText().toUpperCase()
					.length();

			softAssert.assertTrue(helperTextLength <= 15, "You can not add more than 15 characters.");
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify message to be displayed for mandatory field
	 */
	@Test(priority = 7, dependsOnMethods = { "addHotelLoyaltyProgram" })
	public void verifyMandatoryFieldMsg() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Edit Hotel Loyalty Program Page";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);
			viewHotelLoyaltyProgramsPage.tapEditIcon();
			editHotelLoyaltyProgramsPage.tapClearAllBtn();
			editHotelLoyaltyProgramsPage.selectLoyaltyProgram(loyaltyProgram);

			if (mobileDriver instanceof AndroidDriver) {
				editHotelLoyaltyProgramsPage.loyaltyProgramTextField.clear();
			} else {
				abstractMobileBasePage.longPress(editHotelLoyaltyProgramsPage.loyaltyProgramTextField,
						"Loyalty Program Number", pageName);
				editHotelLoyaltyProgramsPage.tapSelectAllBtn();
				editHotelLoyaltyProgramsPage.loyaltyProgramTextField.sendKeys(Keys.DELETE);
			}
			softAssert.assertTrue(editHotelLoyaltyProgramsPage.isElementDisplayed(
					editHotelLoyaltyProgramsPage.mandatoryFieldMsgForLoyaltyProgram, "Required Field Message",
					pageName), "Required Field message is not displayed.");

			editHotelLoyaltyProgramsPage.enterLoyaltyProgramNumber(loyaltyProgramNumber);
			if (mobileDriver instanceof AndroidDriver) {
				editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.clear();
			} else {
				abstractMobileBasePage.longPress(editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField,
						"Loyalty Program Number", pageName);
				editHotelLoyaltyProgramsPage.tapSelectAllBtn();
				editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.sendKeys(Keys.DELETE);
			}

			softAssert.assertTrue(
					editHotelLoyaltyProgramsPage.isElementDisplayed(
							editHotelLoyaltyProgramsPage.mandatoryFieldMsgForProgramNumber,
							"Required Field Message for program number", pageName),
					"Required Field message for program number is not displayed.");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify message to be displayed for duplicate Loyalty Program
	 * Number
	 */
	@Test(priority = 8, dependsOnMethods = { "addHotelLoyaltyProgram" })
	public void verifyDuplicateLoyaltyProgramNumberMsg() {

		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Add Hotel Loyalty Program Page";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnAddBtn();
			addHotelLoyaltyProgramsPage.selectLoyaltyProgram(loyaltyProgram)
					.enterLoyaltyProgramNumber(loyaltyProgramNumber);
			addHotelLoyaltyProgramsPage.addBtn.click();
			
			waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
					configMobileParams.getMaxWaitTime());
					
			softAssert.assertTrue(
					addHotelLoyaltyProgramsPage.isElementEnabled(
							addHotelLoyaltyProgramsPage.duplicateProgramNumberCardMsg,
							"Duplicate Hotel loyalty number Message", pageName),
					"Hotel Loyalty number already exists.");

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		}
	}

	/**
	 * This method will verify cancel deletion feature of loyalty program
	 */
	@Test(priority = 9, dependsOnMethods = { "addHotelLoyaltyProgram" })
	public void verifyCancellationOfDeleteHotelLoyaltyProgram() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);
			viewHotelLoyaltyProgramsPage.tapDeleteIcon().noBtn.click();

			softAssert.assertEquals(viewHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.getText(),
					loyaltyProgramNumber);

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		}
	}

	/**
	 * This method will verify user can edit hotel loyalty program. Android : toast
	 * is unable to locate
	 */
	@Test(priority = 10, dependsOnMethods = { "addHotelLoyaltyProgram" })
	public void verifyEditHotelLoyaltyProgram() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Edit Hotel Loyalty Program Page";
			String toastMessage = "Hotel Loyalty information updated successfully";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);
			viewHotelLoyaltyProgramsPage.tapEditIcon();
			loyaltyProgramNumber = CommonUtilities.generateRandomNumber(5);

			softAssert.assertTrue(editHotelLoyaltyProgramsPage.isElementDisplayed(
					editHotelLoyaltyProgramsPage.editHotelLoyaltyHeader, "Edit Hotel Loyalty program header", pageName),
					"Edit Hotel loyalty Program header is not present");
			
			abstractMobileBasePage.tap(editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField,
					"Loyalty Program Number", pageName);
			abstractMobileBasePage.longPress(editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField,
					"Loyalty Program Number", pageName);
			editHotelLoyaltyProgramsPage.tapSelectAllBtn();
			editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.sendKeys(Keys.DELETE);

			editHotelLoyaltyProgramsPage.enterLoyaltyProgramNumber(loyaltyProgramNumber);
			editHotelLoyaltyProgramsPage.saveBtn.click();

			softAssert.assertTrue(hotelLoyaltyProgramsPage.isToastMessageDisplayed(toastMessage),
					"Toast Hotel Loyalty information updated successfully message is not displayed.");

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			softAssert.assertEquals(viewHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.getText(),
					loyaltyProgramNumber);

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		}
	}

	/**
	 * This method will verify user can cancel changes in hotel loyalty program.
	 */
	@Test(priority = 11, dependsOnMethods = { "verifyEditHotelLoyaltyProgram" })
	public void verifyCancellingChangesOfHotelLoyaltyProgram() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Edit Hotel Loyalty Program Pgae";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);
			viewHotelLoyaltyProgramsPage.tapEditIcon();
			String loyaltyProgramNumber = CommonUtilities.generateRandomNumber(5);

			abstractMobileBasePage.tap(editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField,
					"Loyalty Program Number", pageName);
			abstractMobileBasePage.longPress(editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField,
					"Loyalty Program Number", pageName);
			editHotelLoyaltyProgramsPage.tapSelectAllBtn();
			editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.sendKeys(Keys.DELETE);

			editHotelLoyaltyProgramsPage.enterLoyaltyProgramNumber(loyaltyProgramNumber);
			editHotelLoyaltyProgramsPage.tapCancelBtn();

			softAssert.assertTrue(editHotelLoyaltyProgramsPage.isElementDisplayed(
						editHotelLoyaltyProgramsPage.discardDiscription, "Discard discription", pageName),
						"Discard discription is not present");

			editHotelLoyaltyProgramsPage.tapOnNoBtn();

			boolean isLoyaltyProgramNumberPresent = mobileDriver.getPageSource().contains(loyaltyProgramNumber);
			softAssert.assertEquals(isLoyaltyProgramNumberPresent, true);

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		}
	}

	/**
	 * This method will verify user can discard changes in hotel loyalty program.
	 */
	@Test(priority = 12, dependsOnMethods = { "verifyEditHotelLoyaltyProgram" })
	public void verifyDiscardingChangesOfHotelLoyaltyProgram() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "Edit Hotel Loyalty Program Pgae";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);
			viewHotelLoyaltyProgramsPage.tapEditIcon();

			String loyaltyProgramNumber = CommonUtilities.generateRandomNumber(5);

			abstractMobileBasePage.tap(editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField,
					"Loyalty Program Number", pageName);
			abstractMobileBasePage.longPress(editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField,
					"Loyalty Program Number", pageName);
			editHotelLoyaltyProgramsPage.tapSelectAllBtn();
			editHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.sendKeys(Keys.DELETE);

			editHotelLoyaltyProgramsPage.enterLoyaltyProgramNumber(loyaltyProgramNumber);
			editHotelLoyaltyProgramsPage.tapCancelBtn();

			softAssert.assertTrue(editHotelLoyaltyProgramsPage.isElementDisplayed(editHotelLoyaltyProgramsPage.discardDiscription,
					"Discard discription", pageName),"Discard discription is not present");

			editHotelLoyaltyProgramsPage.tapOnYesBtn();

			softAssert.assertNotEquals(viewHotelLoyaltyProgramsPage.loyaltyProgramNumbersTextField.getText(),
					loyaltyProgramNumber);

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		}
	}

	@Test(priority = 13, dependsOnMethods = { "verifyEditHotelLoyaltyProgram" })
	public void verifyClearAllButtonFeature() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);
			viewHotelLoyaltyProgramsPage.tapEditIcon();

			editHotelLoyaltyProgramsPage.tapClearAllBtn();

			softAssert.assertEquals(mobileDriver.getPageSource().contains("Select Loyalty Program *"), true);

			softAssert.assertEquals(mobileDriver.getPageSource().contains("Loyalty Program Number *"), true);

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify delete feature of loyalty program
	 */
	@Test(priority = 14, dependsOnMethods = { "verifyEditHotelLoyaltyProgram" })
	public void verifyDeleteHotelLoyaltyProgram() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			SoftAssert softAssert = new SoftAssert();
			String pageName = "View Loyalty Program Page";
			String toastMessage = "Hotel Loyalty Program deleted successfully";

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();
			hotelLoyaltyProgramsPage.tapOnLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber);
			viewHotelLoyaltyProgramsPage.tapDeleteIcon().yesBtn.click();

			softAssert.assertTrue(
					hotelLoyaltyProgramsPage.isToastMessageDisplayed("Hotel Loyalty Program deleted successfully"),
					"Toast Hotel Loyalty program deleted successfully message is not displayed.");

			waitHandler.WaitForToastMessageToDisappear(toastMessage, 1);

			if (hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.programsList,
					"Loyalty Programs list", pageName)) {

				softAssert.assertNotEquals(hotelLoyaltyProgramsPage.programsList.getText(), loyaltyProgramNumber);
			} else {
				softAssert.assertTrue(hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.noHotelLoyaltyProgramAddedMsg,
						"No Hotel Loyalty program added message", pageName),
						"No added Hotel Loyalty programs message is absent");
			}

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution completed.");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		}
	}

	/**
	 * This method will verify maximum count of loyalty program addition is 10.
	 */
	@Test(priority = 15)
	public void verifyMaxCountOfLoyaltyProgramAddition() {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			SoftAssert softAssert = new SoftAssert();
			String loyaltyProgram = "Hilton Honors";
			String pageName = "Hotel Loyalty Program Page";
			String toastMsg = "You can save up to 10 Hotel Loyalty Programs only";
			String toastMsgForLoyaltyProgramAdded = "Hotel Loyalty Program added successfully";

			loyaltyProgramNumber = CommonUtilities.generateRandomNumber(4);

			mobileServiceProvider.getTravelNEXTHomeService().loadPage().tapHamburger().goToHotelLoyaltyPrograms();

			if (hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.noHotelLoyaltyProgramAddedMsg,
					"No Loyalty Program added message", pageName)) {
				hotelLoyaltyProgramsPage.tapOnAddBtn();

				waitHandler.waitForElementToBeEnabled(addHotelLoyaltyProgramsPage.loyaltyProgramField,
						"Loyalty Program field", pageName, configMobileParams.getMaxWaitTime());

				addHotelLoyaltyProgramsPage.selectLoyaltyProgram(loyaltyProgram)
						.enterLoyaltyProgramNumber(loyaltyProgramNumber);

				addHotelLoyaltyProgramsPage.addBtn.click();

				softAssert.assertTrue(hotelLoyaltyProgramsPage.isToastMessageDisplayed(toastMsgForLoyaltyProgramAdded),
						"Toast Loyalty Program added successfully message is not displayed.");
			}
			waitHandler.WaitForToastMessageToDisappear(toastMsgForLoyaltyProgramAdded, 2);

			hotelLoyaltyProgramsPage.scroll("up");
			int loyaltyProgramCount = hotelLoyaltyProgramsPage.loyaltyProgramNumbersList.size();
			hotelLoyaltyProgramsPage.scroll("down");

			while (loyaltyProgramCount < 10) {
				hotelLoyaltyProgramsPage.tapOnAddBtn();

				loyaltyProgramNumber = CommonUtilities.generateRandomNumber(4);

				waitHandler.waitForElementToBeEnabled(addHotelLoyaltyProgramsPage.loyaltyProgramField,
						"Loyalty Program field", pageName, configMobileParams.getMaxWaitTime());

				addHotelLoyaltyProgramsPage.selectLoyaltyProgram(loyaltyProgram)
						.enterLoyaltyProgramNumber(loyaltyProgramNumber);

				addHotelLoyaltyProgramsPage.addBtn.click();

				softAssert.assertTrue(hotelLoyaltyProgramsPage.isToastMessageDisplayed(toastMsgForLoyaltyProgramAdded),
						"Toast Loyalty Program added successfully message is not displayed.");

				waitHandler.WaitForToastMessageToDisappear(toastMsgForLoyaltyProgramAdded, 1);

				loyaltyProgramCount++;
			}

			if (loyaltyProgramCount == 10) {

				waitHandler.waitForElementToBeEnabled(hotelLoyaltyProgramsPage.addBtn, "ADD button", pageName,
						configMobileParams.getMaxWaitTime());

				hotelLoyaltyProgramsPage.addBtn.click();
				softAssert.assertTrue(abstractMobileBasePage.isToastMessageDisplayed(toastMsg));
			}

			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
			softAssert.assertAll();

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;

		} 
		finally {
			String pageName = "Hotel Loyalty Programs Page";
			String toastMessage = "Hotel Loyalty Program deleted successfully";

			while (hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.programsList,
					"Loyalty Programs list", pageName)) {
				hotelLoyaltyProgramsPage.programsList.click();
				viewHotelLoyaltyProgramsPage.tapDeleteIcon().yesBtn.click();

				softAssert.assertTrue(hotelLoyaltyProgramsPage.isToastMessageDisplayed(toastMessage),
						"Toast frequent flyer number deleted successfully message is not displayed.");

			}

			softAssert.assertTrue(
					hotelLoyaltyProgramsPage.isElementDisplayed(hotelLoyaltyProgramsPage.noHotelLoyaltyProgramAddedMsg,
							"No Hotel Loyalty Programs added message", pageName),
					"No Hotel Loyalty Programs added message is absent");
		}
	}

}
