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
public class TravelNEXTAddEmergencyContactsPage extends TravelNEXTBasePage {

	public TravelNEXTAddEmergencyContactsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "Profile- Add Contact Page";

	/**
	 * This method will take to Add Emergency contact Page
	 * 
	 * @return TravelNEXTAddEmergencyContactsPage
	 */
	public TravelNEXTAddEmergencyContactsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(addContactHeader, "Add Contact Header", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "back")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Contact']")
	@iOSXCUITFindBy(accessibility = "Add Contact")
	public MobileElement addContactHeader;

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

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnAdd')]")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public MobileElement addBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnCancel')]")
	@iOSXCUITFindBy(accessibility = "leftButton")
	public MobileElement cancelBtn;

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTEmergencyContactsPage
	 */
	public TravelNEXTEmergencyContactsPage tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
		TravelNEXTEmergencyContactsPage profileContactsPage = travelNEXTPageProvider
				.getTravelNEXTEmergencyContactsPage().getPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return profileContactsPage;
	}

	/**
	 * This method will enter your full name
	 * 
	 * @param fullName
	 * @return TravelNEXTAddEmergencyContactsPage
	 */
	public TravelNEXTAddEmergencyContactsPage enterFullName(String fullName) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		enterText(fullNameField, fullName, true, "Full Name field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter your enter your relationship in emergency contacts
	 * 
	 * @param relnship
	 * @return TravelNEXTAddEmergencyContactsPage
	 */
	public TravelNEXTAddEmergencyContactsPage enterRelationShip(String relnship) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		enterText(relationshipField, relnship, true, "Relationship field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter your Phone Number
	 * 
	 * @param phNo
	 * @return TravelNEXTAddEmergencyContactsPage
	 */
	public TravelNEXTAddEmergencyContactsPage enterPhoneNo(String phNo) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$1%s' method.", this.getClass().getSimpleName()));
		enterText(phoneNoField, phNo, true, "Phone Number field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will enter your Address
	 * 
	 * @param address
	 * @return TravelNEXTAddEmergencyContactsPage
	 */
	public TravelNEXTAddEmergencyContactsPage enterAddressField(String address) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(addressField, address, true, "Address field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Add button
	 * 
	 * @return TravelNEXTEmergencyContactsPage
	 */
	public TravelNEXTEmergencyContactsPage tapAddButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(addBtn, "Add button", pageName);
		TravelNEXTEmergencyContactsPage page = travelNEXTPageProvider.getTravelNEXTEmergencyContactsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

}
