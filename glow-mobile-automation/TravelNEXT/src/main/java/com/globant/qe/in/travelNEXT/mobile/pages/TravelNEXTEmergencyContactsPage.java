package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.EmergencyContactDetails;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTEmergencyContactsPage extends TravelNEXTBasePage {

	public TravelNEXTEmergencyContactsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	EmergencyContactDetails emergencyContactDetails;

	final String pageName = "Emergency Contacts Page";

	/**
	 * This method will get to Emergency Contact Page
	 * 
	 * @return TravelNEXTEmergencyContactsPage
	 */
	public TravelNEXTEmergencyContactsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(addContactBtn, "Add Contact Button", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'btnAddEmergencyContact')]")
	@iOSXCUITFindBy(accessibility = "ADD")
	public MobileElement addContactBtn;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvNoContactMsg')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value=='Glober has no Emergency Contact information.'")
	public MobileElement noEmergencyContactMsg;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTitle')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'expandedDataTVCellsection2_row')]")
	public MobileElement fullNameList;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvDetails')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'expandedDataTVCellsection2_row')]")
	public MobileElement phoneNumberList;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivPersonalMore')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Emergency Contacts' ")
	public MobileElement menuOption_EmergencyContacts;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text='Contact added successfully']")
	@iOSXCUITFindBy(accessibility = "Contact added successfully")
	public MobileElement toastContactAdded;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text='Contact added successfully']")
	@iOSXCUITFindBy(accessibility = "Contact deleted successfully")
	public MobileElement toastContactDeleted;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'constraintLayout')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name=='descLabel'")
	public MobileElement contactList;

	private MobileElement emergencyContactCard;
	MobileElement fullNameFromList;
	MobileElement phoneNoFromList;

	/**
	 * This method will set your Emergency contact card element locator according to
	 * the driver you are calling
	 * 
	 * @param name
	 */
	public void setEmergencyContactCardElement(String name) {
		if (mobileDriver instanceof AndroidDriver) {
			emergencyContactCard = mobileDriver.findElement(MobileBy.xpath(String
					.format("//android.widget.TextView[contains(@resource-id,'tvContactName')][@text='%s']", name)));
		} else {
			emergencyContactCard = mobileDriver.findElement(MobileBy.iOSNsPredicateString(String.format(
					"type=='XCUIElementTypeStaticText' AND value=='%s'", emergencyContactDetails.getFullName())));

		}
	}

	/**
	 * This method will tap on fullname list
	 * 
	 * return TravelNEXTViewEmergencyContactsPage
	 */
	public TravelNEXTViewEmergencyContactsPage tapOnFullNameList() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(fullNameList, "FullName list", pageName);
		TravelNEXTViewEmergencyContactsPage page = travelNEXTPageProvider.getTravelNEXTViewEmergencyContactsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will check if Emergency Contact Card is displayed
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isEmergencyContactCardDisplayed(String name) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		setEmergencyContactCardElement(name);
		boolean isDisplayed = isElementDisplayed(emergencyContactCard, "Emergency Contact card", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return isDisplayed;
	}

	/**
	 * This method will tap on Add button
	 * 
	 * @return TravelNEXTAddEmergencyContactsPage
	 */
	public TravelNEXTAddEmergencyContactsPage tapAddButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(addContactBtn, "Add Contact Button", pageName);
		TravelNEXTAddEmergencyContactsPage page = travelNEXTPageProvider.getTravelNEXTAddEmergencyContactsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will hide Emergency Contact details
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage hideEmergencyContactDetails() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_EmergencyContacts, "Emergency Contacts option", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Emergency Contact card
	 * 
	 * @param name
	 * @return TravelNEXTEmergencyContactDetailsPage
	 */
	public TravelNEXTEmergencyContactDetailsPage tapEmergencyContactCard(String name) {
		setEmergencyContactCardElement(name);
		tap(emergencyContactCard, "Emergency Contact Card", pageName);
		TravelNEXTEmergencyContactDetailsPage page = travelNEXTPageProvider.getTravelNEXTEmergencyContactDetailsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method getting full name from emergency contact list
	 * 
	 * @param userName
	 * @return MobileElement
	 */
	public MobileElement getFullnameFromList(String fullName) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		if (mobileDriver instanceof AndroidDriver) {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of Android Driver"));
			fullNameFromList = mobileDriver
					.findElement(MobileBy.xpath(String.format("//*[contains(@text,'%s')]", fullName)));

		} else {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of iOS Driver"));
			fullNameFromList = mobileDriver.findElement(
					MobileBy.xpath(String.format("//XCUIElementTypeStaticText[contains(@value,'%s')]", fullName)));
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return fullNameFromList;
	}

	/**
	 * This method will tap on fullname from emergency contact list
	 * 
	 * @param fullName
	 * return TravelNEXTViewEmergencyContactsPage
	 */
	public TravelNEXTViewEmergencyContactsPage tapOnFullnameFromList(String fullName) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(getFullnameFromList(fullName), "Fullname List", pageName);
		TravelNEXTViewEmergencyContactsPage page = travelNEXTPageProvider.getTravelNEXTViewEmergencyContactsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method getting phone number from emergency contact list
	 * 
	 * @param phoneNo
	 * @return MobileElement
	 */
	public MobileElement getPhoneNoFromList(String phoneNo) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		if (mobileDriver instanceof AndroidDriver) {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of Android Driver"));
			phoneNoFromList = mobileDriver
					.findElement(MobileBy.xpath(String.format("//*[contains(@text,'%s')]", phoneNo)));

		} else {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of iOS Driver"));
			phoneNoFromList = mobileDriver.findElement(
					MobileBy.xpath(String.format("//XCUIElementTypeStaticText[contains(@value,'%s')]", phoneNo)));
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return phoneNoFromList;
	}

}
