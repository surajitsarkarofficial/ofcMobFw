package com.globant.qe.in.travelNEXT.mobile.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHomePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTBasePage;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTSideBarPage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;

@Component
@Lazy
public class TravelNEXTCreateTripPage extends TravelNEXTBasePage {

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTHomePage travelNEXTHomePage;

	@Autowired
	TravelNEXTCreateTripPage travelNEXTCreateTripPage;

	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;

	@Autowired
	CommonUtilities commonUtilities;

	@Autowired
	PersonalDeatils personalDeatils;

	@Autowired
	TravelNEXTSideBarPage sideBarPage;

	@Autowired
	TravelNEXTCostAllocationPage travelNEXTCostAllocationPage;

	@Autowired
	ConfigMobileParams configMobileParams;

	public TravelNEXTCreateTripPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	final String pageName = "Create trip Page";
	static String travelReason = "Sales";

	/**
	 * This method will take to Create trip Page
	 * 
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage getPage() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(createTripHeader, "Create Trip Header", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;

	}

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'toolbar_title')]")
	@iOSXCUITFindBy(accessibility = "navigationTitleLabel")
	public static MobileElement createTripHeader;

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public static MobileElement backButton;

	@AndroidFindBy(accessibility = "Create step")
	@iOSXCUITFindBy(accessibility = "stepperButtonsection0_row0")
	public static MobileElement createStepper;

	@AndroidFindBy(accessibility = "Cost step")
	@iOSXCUITFindBy(accessibility = "stepperButtonsection0_row1")
	public static MobileElement costStepper;

	@AndroidFindBy(accessibility = "Passenger step")
	@iOSXCUITFindBy(accessibility = "stepperButtonsection0_row2")
	public static MobileElement passangerStepper;

	@AndroidFindBy(accessibility = "Itinerary step")
	@iOSXCUITFindBy(accessibility = "stepperButtonsection0_row3")
	public static MobileElement itineraryStepper;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvStepOne')]")
	@iOSXCUITFindBy(accessibility = "titleLabelsection0_row0")
	public static MobileElement createStepperText;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvStepTwo')]")
	@iOSXCUITFindBy(accessibility = "titleLabelsection0_row1")
	public static MobileElement costStepperText;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvStepThree')]")
	@iOSXCUITFindBy(accessibility = "titleLabelsection0_row2")
	public static MobileElement passangerStepperText;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvStepFour')]")
	@iOSXCUITFindBy(accessibility = "titleLabelsection0_row3")
	public static MobileElement itineraryStepperText;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvCreateTripLabel')]")
	@iOSXCUITFindBy(accessibility = "Name & Purpose of your trip")
	public static MobileElement titleOfCreateTrip;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'etTripName')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='nameTextField']")
	public static MobileElement tripNameField;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'atvTravelReason')]")
	@iOSXCUITFindBy(accessibility = "travelReasonTextField")
	public static MobileElement travelReasonField;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'ivTravelReasonDropdown')]")
	@iOSXCUITFindBy(accessibility = "dropDownButton")
	public static MobileElement travelReasonDropdownBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'resultCell')]")
	public static List<MobileElement> travelReasonDropdownList;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'etTripGoalsPurpose')]")
	@iOSXCUITFindBy(accessibility = "goalTextField")
	public static MobileElement goalAndPurposeField;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'btnBack')]")
	@iOSXCUITFindBy(accessibility = "leftButton")
	public static MobileElement cancelbtn;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'btnNext')]")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public static MobileElement nextBtn;

	/**
	 * This method will create trip
	 */
	public void createTrip() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String triName = commonUtilities.gererateRandomString(6);
		String goalTrip = commonUtilities.gererateRandomString(10);
		mobileServiceProvider.getTravelNEXTHomeService().loadPage();

		travelNEXTHomePage.tapOnCreateTripBanner();
		travelNEXTCreateTripPage.enterTripName(triName);
		travelNEXTCreateTripPage.selectTravelReason(travelReason);
		travelNEXTCreateTripPage.enterGoalTrip(goalTrip);
		travelNEXTCreateTripPage.tapOnNextBtn();
		waitHandler.WaitForElementToDisappear(travelNEXTBasePage.loadingIcon, "Loading Icon", pageName,
				configMobileParams.getMaxWaitTime());
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
	}

	/**
	 * this method will tap on back button
	 * 
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		tapByElement(backButton, "Back button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Trip name field
	 * 
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage tapTripNameField() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		tapByElement(tripNameField, "Trip Name field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter Trip name field
	 * 
	 * @param tripName
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage enterTripName(String tripName) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		enterText(tripNameField, tripName, true, "Trip Name field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on travel reason field
	 * 
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage tapOnTravelReason() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		tapByElement(travelReasonDropdownBtn, "Travel reason Dropdown", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will select travel reason
	 * 
	 * @param travelReason
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage selectTravelReason(String travelReason) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));

		if (mobileDriver instanceof AndroidDriver) {
			tapOnDropdownBtn();
			enterText(travelReasonField, travelReason, true, "travel reason field", pageName);
			tap(travelReasonDropdownBtn, "Travel Reason dropdown Button", pageName);
		} else {
			travelReasonDropdownBtn.click();
			int size = TravelNEXTCreateTripPage.travelReasonDropdownList.size();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
			travelReasonDropdownList.get(randomNumber).click();
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter goal of trip
	 * 
	 * @param goalTrip
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage enterGoalTrip(String goalTrip) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(goalAndPurposeField, goalTrip, true, "Trip Name field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on next button
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnNextBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		tapByElement(nextBtn, "Next Button", pageName);
		TravelNEXTCostAllocationPage page = travelNEXTPageProvider.getTravelNEXTCostAllocationPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on dropdown button
	 * 
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage tapOnDropdownBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		tapByElement(travelReasonDropdownBtn, "Dropdown Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

}
