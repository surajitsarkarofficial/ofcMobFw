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
public class TravelNEXTViewEmergencyContactsPage extends TravelNEXTBasePage {

	public TravelNEXTViewEmergencyContactsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	TravelNEXTEmergencyContactsPage emergencyContactPage;
	
	final String pageName = "Profile- View Contact Page";

	/**
	 * This method will take to View emergency contact Page
	 * 
	 * @return TravelNEXTViewEmergencyContactsPage
	 */
	public TravelNEXTViewEmergencyContactsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(contactHeader, "Contact Header", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etFullName')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[contains(@name,'.AddContactView')]//following::XCUIElementTypeTextField[1]")
	public MobileElement fullNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etRelationship')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[contains(@name,'.AddContactView')]//following::XCUIElementTypeTextField[2]")
	public MobileElement relationshipField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etPhone')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[contains(@name,'.AddContactView')]//following::XCUIElementTypeTextField[3]")
	public MobileElement phoneNoField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etAddress')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' AND value='Address'")
	public MobileElement addressField;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvFullName')]") 
	@iOSXCUITFindBy(accessibility = "nameLabel")
	public MobileElement fullNameText;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvRelationship')]") 
	@iOSXCUITFindBy(accessibility = "relationshipLabel")
	public MobileElement relationshipText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvPhone')]") 
	@iOSXCUITFindBy(accessibility = "phoneLabel")
	public MobileElement phoneText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvAddress')]") 
	@iOSXCUITFindBy(accessibility = "addressLabel")
	public MobileElement addressText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'item_edit')]")
	@iOSXCUITFindBy(accessibility = "editButton")
	public MobileElement whiteEditBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'item_delete')]")
	@iOSXCUITFindBy(accessibility = "deleteButton")
	public MobileElement whiteDeleteBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnPositive')]")
	@iOSXCUITFindBy(accessibility = "rightSideButton")
	public MobileElement deleteEmergencyContactBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnNegative')]")
	@iOSXCUITFindBy(accessibility = "leftSideButton")
	public MobileElement cancelEmergencyContactBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[@text='Contact updated successfully']")
	@iOSXCUITFindBy(accessibility = "Contact updated successfully")
	public MobileElement toastContactUpdated;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Contact')]")
	@iOSXCUITFindBy(accessibility = "Contact")
	public MobileElement contactHeader;

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTEmergencyContactsPage
	 */
	public TravelNEXTEmergencyContactsPage tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
		TravelNEXTEmergencyContactsPage emergencyContactsPage = travelNEXTPageProvider
				.getTravelNEXTEmergencyContactsPage().getPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return emergencyContactsPage;
	}

	/**
	 * This method will tap on edit button
	 * 
	 * @return TravelNEXTEditEmergencyContactsPage
	 */
	public TravelNEXTEditEmergencyContactsPage tapEditBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(whiteEditBtn, "Back Button", pageName);
		TravelNEXTEditEmergencyContactsPage editEmergencyContactsPage = travelNEXTPageProvider
				.getTravelNEXTEditEmergencyContactsPage().getPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return editEmergencyContactsPage;
	}

	/**
	 * This method will tap on delete button
	 * 
	 * @return TravelNEXTViewEmergencyContactsPage
	 */
	public TravelNEXTViewEmergencyContactsPage tapDeleteBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(whiteDeleteBtn, "Back Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on delete emergency contact button
	 * @return TravelNEXTEmergencyContactsPage
	 */
	public TravelNEXTEmergencyContactsPage tapOnDeleteEmergencyContactBtn()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(deleteEmergencyContactBtn, "Delete emergency contact Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return emergencyContactPage;
	}
	
	/**
	 * This method will tao on cancel emergency contact button
	 * @return TravelNEXTViewEmergencyContactsPage
	 */
	public TravelNEXTViewEmergencyContactsPage tapOnCancelEmergencyContactBtn()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(cancelEmergencyContactBtn, "Cancel emergency contact Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
}
