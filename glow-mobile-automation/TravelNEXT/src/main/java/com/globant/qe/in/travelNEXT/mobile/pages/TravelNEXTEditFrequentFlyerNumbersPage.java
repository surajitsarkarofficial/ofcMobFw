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
public class TravelNEXTEditFrequentFlyerNumbersPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	TravelNEXTViewFrequentFlyerNumbersPage travelNEXTViewFrequentFlyerNumbersPage;
	
	public TravelNEXTEditFrequentFlyerNumbersPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	/**
	 * This method will get Edit Frequent Flyer Numbers page
	 * 
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(editFrequentFlyerNumberHeader, "Edit frequent flyer Header", pageName,
				timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Frequent Flyer Number']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='Edit Frequent Flyer Number'")
	public MobileElement editFrequentFlyerNumberHeader;

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement backBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clear All']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' and name=='clearAllButton'")
	public MobileElement clearAllButton;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'tilAirline')]")
	@iOSXCUITFindBy(accessibility = "searchTextField")
	public MobileElement selectAirlineLabel;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvAirline')]")
	@iOSXCUITFindBy(accessibility = "searchTextField")
	public MobileElement selectAirlineTextField;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivAirlineDropdown')]")
	@iOSXCUITFindBy(accessibility =  "dropDownArrow")
	public MobileElement airlineDropdownIcon;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'tilFrequentFlyerNumber')]")
	@iOSXCUITFindBy(accessibility = "numberTextField")
	public MobileElement frequentFlyerNumbersLabel;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etFrequentFlyerNumber')]")
	@iOSXCUITFindBy(accessibility = "numberTextField")
	public MobileElement frequentFlyerNumbersTextField;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnCancel')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' and label=='CANCEL'")
	public MobileElement cancelBtn;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'imageButton')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeOther' and name=='iconBackgroundView'")
	public MobileElement cancelIconImage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Discard changes?')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' and value=='Discard'")
	public MobileElement cancelFlyerNumbertitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Are you sure you want to discard all changes?')]")
	@iOSXCUITFindBy(accessibility = "descriptionLabel")
	public MobileElement cancelFlyerNumberDescription;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'NO')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' and label=='NO'")
	public MobileElement cancelChangesBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Yes')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeButton' and label=='Yes'")
	public MobileElement discardChnagesBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Save')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' and label=='Save'")
	public MobileElement saveBtn;
	
	@iOSXCUITFindBy(accessibility = "Select All")
	public MobileElement selectAllBtn;
	
	@iOSXCUITFindBy(accessibility = "Copy")
	public MobileElement copyBtn;
	
	@iOSXCUITFindBy(accessibility = "Paste")
	public MobileElement pasteBtn;
	
	final String pageName = "Edit Frequent Flyer Numbers Page";

	/**
	 * This method will select the airline
	 * 
	 * @param airline
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage selectAirline(String airline){
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(selectAirlineTextField, airline, true, "Airline", pageName);
		airlineDropdownIcon.click();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Airline field
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnAirlineField()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(selectAirlineTextField, "Airline Field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap on Frequent flyer numbers field
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnFrequentFlyerNumbersTextField()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(frequentFlyerNumbersTextField, "Frequent Flyer Number field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap on dropdown button
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnAirlineDropdownIcon()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(airlineDropdownIcon, "Airline dropdown", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap on copy button
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnCopyBtn()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(copyBtn, "Copy Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap on paste button
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnPasteBtn()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(pasteBtn, "Paste button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap on selectAll button
	 * 
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapSelectAllBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(selectAllBtn, "Select All Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	
	/**
	 * This method will enter the frequent flyer number
	 * 
	 * @param frequentFlyerNumber
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage enterFrequentFlyerNumber(String frequentFlyerNumber) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(frequentFlyerNumbersTextField, frequentFlyerNumber, true, "Frequent Flyer Number", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter the name of airline
	 * 
	 * @param airline
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage getSearchedAirlineList(String airline) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(selectAirlineLabel, airline, true, "Airline", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTViewFrequentFlyerNumbersPage
	 */
	public TravelNEXTViewFrequentFlyerNumbersPage tapBackButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back button", pageName);
		TravelNEXTViewFrequentFlyerNumbersPage page = travelNEXTPageProvider
				.getTravelNEXTViewFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Clear All button
	 * 
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnClearAll() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(clearAllButton, "Back button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;

	}
	
	/**
	 * This method will tap on Save button
	 * 
	 * @return TravelNEXTViewFrequentFlyerNumbersPage
	 */
	public TravelNEXTViewFrequentFlyerNumbersPage tapOnsaveBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(saveBtn, "Save button", pageName);
		TravelNEXTViewFrequentFlyerNumbersPage page = travelNEXTPageProvider
				.getTravelNEXTViewFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;

	}

	/**
	 * This method will tap on cancel button
	 * 
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnCancelBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(cancelBtn, "cancel button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;

	}
	
	/**
	 * This method will tap on cancel changes button
	 * 
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnCancelChangesBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(cancelChangesBtn, "CANCEL changes button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;

	}
	
	/**
	 * This method will tap on discard changes button
	 * 
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapOnDiscardChangesBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(discardChnagesBtn, "Discard changes button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
}
