package com.globant.qe.in.travelNEXT.mobile.pages;

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
public class TravelNEXTEditHotelLoyaltyProgramsPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	TravelNEXTHotelLoyaltyProgramsPage travelNEXTHotelLoyaltyProgramsPage;

	public TravelNEXTEditHotelLoyaltyProgramsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clear All']")
	@iOSXCUITFindBy(accessibility = "clearAllButton")
	public MobileElement clearAllBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	@iOSXCUITFindBy(accessibility = "leftButton")
	public MobileElement cancelBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Hotel Loyalty Program']")
	@iOSXCUITFindBy(accessibility = "Edit Hotel Loyalty Programs")
	public MobileElement editHotelLoyaltyHeader;

	@AndroidFindBy(accessibility = "Loyalty program dropdown icon")
	@iOSXCUITFindBy(accessibility = "dropDownArrow")
	public MobileElement dropdownIcon;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvLoyalty')]")
	@iOSXCUITFindBy(accessibility = "searchTextField")
	public MobileElement loyaltyProgramTextField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvLoyalty')]")
	@iOSXCUITFindBy(accessibility = "Select All")
	public MobileElement selectAllBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etHotelLoyaltyPoints')]")
	@iOSXCUITFindBy(accessibility = "numberTextField")
	public MobileElement loyaltyProgramNumbersTextField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvLoyalty')]//parent::android.widget.FrameLayout")
	@iOSXCUITFindBy(accessibility = "searchTextField")
	public MobileElement loyaltyProgramText;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etHotelLoyaltyPoints')]//parent::android.widget.FrameLayout")
	@iOSXCUITFindBy(accessibility = "numberTextField")
	public MobileElement loyaltyProgramNumbersText;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public MobileElement saveBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='This is a required field.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' AND value='This is a required field.'")
	public MobileElement mandatoryFieldMsgForLoyaltyProgram;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='This is a required field.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' AND value='This is a required field.'")
	public MobileElement mandatoryFieldMsgForProgramNumber;

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
	
	final String pageName = "Profile -  Edit HotelLoyaltyPrograms Page";

	/**
	 * This method will get Edit Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}
	
	/**
	 * This method will tap on loyalty program text field
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage tapOnLoyaltyProgramTextField()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(loyaltyProgramTextField, "Loyalty Program field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
		
	}
	
	/**
	 * This method will tap on loyalty program Number text field
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage tapOnLoyaltyProgramNumbersTextField()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(loyaltyProgramNumbersTextField, "Loyalty Program Number field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap on dropdown button
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage tapOnDropdownIcon()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(dropdownIcon, "Dropdown Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will check special char is not present in hotel loyalty program number
	 * 
	 * @return boolean
	 */
	public boolean checkSpecialCharNotPresentInHotelLoyalty() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String checkSpecialChar;
		if (mobileDriver instanceof AndroidDriver)
			checkSpecialChar = loyaltyProgramNumbersTextField.getText();
		else
			checkSpecialChar = loyaltyProgramNumbersTextField.getAttribute("value");
		Pattern pattern = Pattern.compile("^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$");
		Matcher match = pattern.matcher(checkSpecialChar);
		boolean val = match.find();
		
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return val;
	}

	/**
	 * This method will select loyalty program
	 * @param loyaltyProgram
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage selectLoyaltyProgram(String loyaltyProgram) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(loyaltyProgramTextField, loyaltyProgram, true, "Loyalty Program", pageName);
		dropdownIcon.click();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter loyalty program number
	 * @param loyaltyProgramNumber
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage enterLoyaltyProgramNumber(String loyaltyProgramNumber) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(loyaltyProgramNumbersTextField, loyaltyProgramNumber, true, "Loyalty Program Number", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Back icon button
	 * 
	 * @return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back button", pageName);
		TravelNEXTViewHotelLoyaltyProgramsPage page = travelNEXTPageProvider
				.getTravelNEXTViewHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Clear All button
	 * 
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage tapClearAllBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(clearAllBtn, "Clear All button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Save loyalty program button
	 * 
	 * @return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage tapSaveBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(saveBtn, "Save button", pageName);
		TravelNEXTViewHotelLoyaltyProgramsPage page = travelNEXTPageProvider
				.getTravelNEXTViewHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Cancel loyalty program button
	 * 
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage tapCancelBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(cancelBtn, "CANCEL button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Yes button
	 * 
	 * @return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage tapOnYesBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(yesBtn, "Yes button", pageName);
		TravelNEXTViewHotelLoyaltyProgramsPage page = travelNEXTPageProvider
				.getTravelNEXTViewHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on No button
	 * 
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage tapOnNoBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(noBtn, "No button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap on selectAll button
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage tapSelectAllBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(selectAllBtn, "Select All Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

}
