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
public class TravelNEXTEditEmergencyContactsPage extends TravelNEXTBasePage {

	public TravelNEXTEditEmergencyContactsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "Profile- Edit Contact Page";

	/**
	 * This method will take to Edit emergency contact Page
	 * 
	 * @return TravelNEXTEditEmergencyContactsPage
	 */
	public TravelNEXTEditEmergencyContactsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(editContactHeader, "Add Contact Header", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "back")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etFullName')]")
	@iOSXCUITFindBy(accessibility = "nameTextField")
	public MobileElement fullNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etRelationship')]")
	@iOSXCUITFindBy(accessibility = "relationshipTextField")
	public MobileElement relationshipField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etPhone')]")
	@iOSXCUITFindBy(accessibility = "phoneTextField")
	public MobileElement phoneNoField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etAddress')]")
	@iOSXCUITFindBy(accessibility = "addressTextField")
	public MobileElement addressField;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnCancel')]")
	@iOSXCUITFindBy(accessibility = "leftButton")
	public MobileElement cancelBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton'  and name=='rightButton'")
	public MobileElement saveBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Contact']")
	@iOSXCUITFindBy(accessibility = "Edit Contact")
	public MobileElement editContactHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clear All']")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeButton' and name=='clearAllButton'")
	public MobileElement clearAllButton;

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTViewEmergencyContactsPage
	 */
	public TravelNEXTViewEmergencyContactsPage tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
		TravelNEXTViewEmergencyContactsPage viewEmergencyContactsPage = travelNEXTPageProvider
				.getTravelNEXTViewEmergencyContactsPage().getPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return viewEmergencyContactsPage;
	}

	/**
	 * This method will tap on clearAll Button
	 */
	public TravelNEXTEditEmergencyContactsPage tapOnClearAllBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		tapByElement(clearAllButton, "Clear All Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	/**
	 * This method will enter your full name
	 * 
	 * @param fullName
	 * @return TravelNEXTEditEmergencyContactsPage
	 */
	public TravelNEXTEditEmergencyContactsPage enterFullName(String fullName) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		enterText(fullNameField, fullName, true, "Full Name field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter your enter you relationship in edit emergency contacts
	 * 
	 * @param relnship
	 * @return TravelNEXTEditEmergencyContactsPage
	 */
	public TravelNEXTEditEmergencyContactsPage enterRelationShip(String relnship) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		enterText(relationshipField, relnship, true, "Relationship field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter you Phone Number
	 * 
	 * @param phNo
	 * @return TravelNEXTEditEmergencyContactsPage
	 */
	public TravelNEXTEditEmergencyContactsPage enterPhoneNo(String phNo) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		enterText(phoneNoField, phNo, true, "Phone Number field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter your Address
	 * 
	 * @param address
	 * @return TravelNEXTEditEmergencyContactsPage
	 */
	public TravelNEXTEditEmergencyContactsPage enterAddressField(String address) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(addressField, address, true, "Address field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Save button
	 * 
	 * @return TravelNEXTViewEmergencyContactsPage
	 */
	public TravelNEXTViewEmergencyContactsPage tapSaveButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(saveBtn, "Save button", pageName);
		TravelNEXTViewEmergencyContactsPage page = travelNEXTPageProvider
				.getTravelNEXTViewEmergencyContactsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

}
