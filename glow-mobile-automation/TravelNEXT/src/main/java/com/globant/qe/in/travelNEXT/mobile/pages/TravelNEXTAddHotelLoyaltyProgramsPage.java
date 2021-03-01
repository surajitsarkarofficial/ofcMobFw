package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTAddHotelLoyaltyProgramsPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	TravelNEXTHotelLoyaltyProgramsPage travelNEXTHotelLoyaltyProgramsPage;

	public TravelNEXTAddHotelLoyaltyProgramsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Hotel Loyalty Program']")
	@iOSXCUITFindBy(accessibility = "Add Hotel Loyalty Programs")
	public MobileElement addHotelLoyaltyHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clear All']")
	@iOSXCUITFindBy(accessibility = "clearAllButton")
	public MobileElement clearAllBtn;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Select Loyalty Program *']")
	@iOSXCUITFindBy(accessibility = "searchTextField")
	public MobileElement loyaltyProgramField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Loyalty Program Number *']")
	@iOSXCUITFindBy(accessibility = "numberTextField")
	public MobileElement loyaltyProgramNumberField;

	@AndroidFindBy(accessibility = "Loyalty program dropdown icon")
	@iOSXCUITFindBy(accessibility = "dropDownArrow")
	public MobileElement dropdownIcon;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvLoyalty')]")
	@iOSXCUITFindBy(accessibility = "searchTextField")
	public MobileElement loyaltyProgramTextField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etHotelLoyaltyPoints')]")
	@iOSXCUITFindBy(accessibility = "numberTextField")
	public MobileElement loyaltyProgramNumbersTextField;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	@iOSXCUITFindBy(accessibility = "leftButton")
	public MobileElement cancelBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add']")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public MobileElement addBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='NO']")
	@iOSXCUITFindBy(accessibility = "leftSideButton")
	public MobileElement noBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Yes']")
	@iOSXCUITFindBy(accessibility = "rightSideButton")
	public MobileElement yesBtn;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'imageButton')]")
	@iOSXCUITFindBy(accessibility = "iconBackgroundView")
	public MobileElement discardImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Discard']")
	@iOSXCUITFindBy(accessibility = "titleLabel")
	public MobileElement discardTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Are you sure you want to discard all changes?']")
	@iOSXCUITFindBy(accessibility = "descriptionLabel")
	public MobileElement discardDiscription;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'textinput_counter')]")
	@iOSXCUITFindBy(accessibility = "numberCountLabel")
	public MobileElement helperTextCharacterCount;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='This is a required field.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' AND value='This is a required field.'")
	public MobileElement mandatoryFieldMsgForLoyaltyProgram;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='This is a required field.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' AND value='This is a required field.'")
	public MobileElement mandatoryFieldMsgForProgramNumber;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Loyalty Program Number already exists.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' AND value='Loyalty Program Number already exists.'") 
	public MobileElement duplicateProgramNumberCardMsg;
	
	final String pageName = "Profile -  Add HotelLoyaltyPrograms Page";

	/**
	 * This method will get Add Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTAddHotelLoyaltyProgramsPage
	 */
	public TravelNEXTAddHotelLoyaltyProgramsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	/**
	 * This method will select loyalty program
	 * @param loyaltyProgram 
	 * @return TravelNEXTAddHotelLoyaltyProgramsPage
	 */
	public TravelNEXTAddHotelLoyaltyProgramsPage selectLoyaltyProgram(String loyaltyProgram) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(loyaltyProgramField, loyaltyProgram, true, "Loyalty Program", pageName);
		dropdownIcon.click();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter loyalty program number
	 * @param loyaltyProgramNumber 
	 * @return TravelNEXTAddHotelLoyaltyProgramsPage
	 */
	public TravelNEXTAddHotelLoyaltyProgramsPage enterLoyaltyProgramNumber(String loyaltyProgramNumber) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(loyaltyProgramNumberField, loyaltyProgramNumber, true, "Loyalty Program Number", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Back icon button
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsPage
	 */
	public TravelNEXTHotelLoyaltyProgramsPage tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back button", pageName);
		TravelNEXTHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Clear All button
	 * 
	 * @return TravelNEXTAddHotelLoyaltyProgramsPage
	 */
	public TravelNEXTAddHotelLoyaltyProgramsPage tapClearAllBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(clearAllBtn, "Clear All button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on ADD loyalty program button
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsPage
	 */
	public TravelNEXTHotelLoyaltyProgramsPage tapAddBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(addBtn, "Add button", pageName);
		TravelNEXTHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Cancel loyalty program button
	 * 
	 * @return TravelNEXTAddHotelLoyaltyProgramsPage
	 */
	public TravelNEXTAddHotelLoyaltyProgramsPage tapCancelBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(cancelBtn, "CANCEL button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Yes button
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsPage
	 */
	public TravelNEXTHotelLoyaltyProgramsPage tapOnYesBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(yesBtn, "Yes button", pageName);
		TravelNEXTHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on No button
	 * 
	 * @return TravelNEXTAddHotelLoyaltyProgramsPage
	 */
	public TravelNEXTAddHotelLoyaltyProgramsPage tapOnNoBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(noBtn, "No button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

}
