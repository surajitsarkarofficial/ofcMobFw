package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTPassengerPage extends TravelNEXTBasePage {

	public TravelNEXTPassengerPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	TravelNEXTCostAllocationPage travelNEXTCostAllocationPage;

	@Autowired
	TravelNEXTSideBarPage sideBarPage;

	@Autowired
	TravelNEXTBasePage travelNEXTBasePage;

	final String pageName = "Passenger Page";

	/**
	 * This method will take to Passenger Page
	 * 
	 * @return TravelNEXTPassengerPage
	 */
	public TravelNEXTPassengerPage getPage() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.waitForElementToBeEnabled(passengerPageTitle, "Passenger Page Title", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvAddPassengerText')]")
	@iOSXCUITFindBy(accessibility = "countTitleTextLabelsection0")
	public static MobileElement passengerPageTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvPassengersCount')]")
	@iOSXCUITFindBy(accessibility = "passengerCountLabelsection0")
	public static MobileElement passengersCount;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivAddPassenger')]")
	@iOSXCUITFindBy(accessibility = "addButtonsection0")
	public static MobileElement addPassengerBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvAddPassengerTitle')]")
	@iOSXCUITFindBy(accessibility = "passengerTextLabelsection0")
	public static MobileElement addPassengerLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvMaxPassengerTitle')]")
	@iOSXCUITFindBy(accessibility = "maxTextLabelsection0")
	public static MobileElement maxPassengerLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvPassengerName')]")
	@iOSXCUITFindBy(accessibility = "nameLabelsection0_row0")
	public static MobileElement defaultPassengerName;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvPassengerEmail')]")
	@iOSXCUITFindBy(accessibility = "emailLabelsection0_row0")
	public static MobileElement defaultPassengerEmail;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ivPassenger')]")
	@iOSXCUITFindBy(accessibility = "profileImageViewsection0_row0")
	public static MobileElement defaultPassengerProfilePic;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivDeletePassenger')]")
	@iOSXCUITFindBy(accessibility = "deleteButtonsection0_row0")
	public static MobileElement deletePassengerBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvPersonLabel')]")
	@iOSXCUITFindBy(accessibility = "personalInformationButtonsection0_row0")
	public static MobileElement personalInfoLabel;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivPersonal')]")
	@iOSXCUITFindBy(accessibility = "personalImageViewsection0_row0")
	public static MobileElement personalInfoIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandPersonalInfo')]")
	@iOSXCUITFindBy(accessibility = "personalInfoIndicatorButtonsection0_row0")
	public static MobileElement personalInfoExpandButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvContactLabel')]")
	@iOSXCUITFindBy(accessibility = "emergencyContactButtonsection0_row0")
	public static MobileElement emergencyContactsLabel;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivContact')]")
	@iOSXCUITFindBy(accessibility = "contactImageViewsection0_row0")
	public static MobileElement emergencyContactsIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandContactInfo')]")
	@iOSXCUITFindBy(accessibility = "emergencyInfoIndicatorButtonsection0_row0")
	public static MobileElement emergencyContactsExpandButton;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnNext')]")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public static MobileElement nextButton;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnBack')]")
	@iOSXCUITFindBy(accessibility = "leftButton")
	public static MobileElement backButton;

	/**
	 * This method will tap on back button return TravelNEXTPassengerPage
	 */
	public TravelNEXTPassengerPage tapOnBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '$%s' method.", this.getClass().getSimpleName()));
		tap(backButton, "Back Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

}
