package com.globant.qe.in.travelNEXT.mobile.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTAddFrequentFlyerNumbersPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	public TravelNEXTAddFrequentFlyerNumbersPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	/**
	 * This method will get Add Frequent Flyer Numbers page
	 * 
	 * @return TravelNEXTAddFrequentFlyerNumbersPage
	 */
	public TravelNEXTAddFrequentFlyerNumbersPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(addFrequentFlyerNumberHeader, "Add Frequent Flyer Numbers Header",
				pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Frequent Flyer Number']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='Add Frequent Flyer Number'")
	public MobileElement addFrequentFlyerNumberHeader;

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clear All']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' and name=='clearAllButton'")
	public MobileElement clearAllButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvAirline')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeTextField' and value=='Select Airline *'")
	public MobileElement selectAirlineField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etFrequentFlyerNumber')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeTextField' and value=='Frequent Flyer Number *'")
	public MobileElement frequentFlyerNumbersField;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnCancel')]")
	@iOSXCUITFindBy(accessibility = "leftButton")
	public MobileElement cancelBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnAddFrequentFlyer')]")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public MobileElement addFlyerNumberBtn;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvAirline')]")
	@iOSXCUITFindBy(accessibility = "searchResultTable")
	public MobileElement airlineDropdownIcon;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvAirline')]")
	@iOSXCUITFindBy(accessibility = "dropDownArrow")
	public MobileElement airlineDropdownList;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvAirline')]")
	@iOSXCUITFindBy(accessibility = "searchTextField")
	public MobileElement searchAirline;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etFrequentFlyerNumber')]")
	@iOSXCUITFindBy(accessibility = "numberTextField")
	public MobileElement typeFrequentFlyerNumber;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'textinput_counter')]")
	@iOSXCUITFindBy(accessibility = "numberCountLabel")
	public MobileElement helperTextCharacterCount;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='This is a required field.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value=='This is a required field.'")
	public MobileElement requiredFieldMsg;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Frequent Flyer Number already exists.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value=='Frequent Flyer Number already exists.'")
	public MobileElement duplicateFlyerNumberCardMsg;

	@iOSXCUITFindBy(accessibility = "searchResultListView")
	public List<MobileElement> specificAirlineSearchList;

	final String pageName = "Add Frequent Flyer Numbers Page";

	/**
	 * This method will select the airline
	 * 
	 * @param airline
	 * @return TravelNEXTAddFrequentFlyerNumbersPage
	 */
	public TravelNEXTAddFrequentFlyerNumbersPage selectAirline(String airline) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(searchAirline, airline, true, "Airline", pageName);
		airlineDropdownIcon.click();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter the frequent flyer number
	 * 
	 * @param frequentFlyerNumber
	 * @return TravelNEXTAddFrequentFlyerNumbersPage
	 */
	public TravelNEXTAddFrequentFlyerNumbersPage enterFrequentFlyerNumber(String frequentFlyerNumber) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(typeFrequentFlyerNumber, frequentFlyerNumber, true, "Frequent Flyer Number", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter the name of airline
	 * 
	 * @param airline
	 * @return TravelNEXTAddFrequentFlyerNumbersPage
	 */
	public TravelNEXTAddFrequentFlyerNumbersPage getSearchedAirlineList(String airline) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(selectAirlineField, "Select Airline field", pageName);
		enterText(searchAirline, airline, true, "Airline", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will check special char in frequent flyer number
	 * 
	 * @return boolean
	 */
	public boolean checkSpecialCharInFreqFlyer() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String checkSpecialChar;
		if (mobileDriver instanceof AndroidDriver)
			checkSpecialChar = typeFrequentFlyerNumber.getText();
		else
			checkSpecialChar = typeFrequentFlyerNumber.getAttribute("value");
		Pattern pattern = Pattern.compile("^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$");
		Matcher match = pattern.matcher(checkSpecialChar);
		boolean val = match.find();

		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return val;
	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersPage
	 */
	public TravelNEXTFrequentFlyerNumbersPage tapBackButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back button", pageName);
		TravelNEXTFrequentFlyerNumbersPage page = travelNEXTPageProvider.getTravelNEXTFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Add button
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersPage
	 */
	public TravelNEXTFrequentFlyerNumbersPage tapAddBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(addFlyerNumberBtn, "Add button", pageName);
		TravelNEXTFrequentFlyerNumbersPage page = travelNEXTPageProvider.getTravelNEXTFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Clear All button
	 * 
	 * @return TravelNEXTAddFrequentFlyerNumbersPage
	 */
	public TravelNEXTAddFrequentFlyerNumbersPage tapOnClearAll() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;

	}

}
