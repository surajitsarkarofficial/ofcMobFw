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
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTEmergencyContactDetailsPage extends TravelNEXTBasePage {

	public TravelNEXTEmergencyContactDetailsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	EmergencyContactDetails emergencyContactDetails;

	final String pageName = "Emergency Contact Details Page";

	/**
	 * This method will get Emergency contacts page
	 * 
	 * @return TravelNEXTEmergencyContactDetailsPage
	 */
	public TravelNEXTEmergencyContactDetailsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(contactHeader, "Contact Header", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//*[@text='Contact']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='Contact'")
	public MobileElement contactHeader;

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "back")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'item_edit')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name='whiteEdit'")
	public MobileElement editEmergencyContact;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'item_delete')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name='whiteDelete'")
	public MobileElement deleteEmergenctContact;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvLabelName')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='Full Name *'")
	public MobileElement fullNameLbl;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvFullName')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Full Name *']/following-sibling::XCUIElementTypeStaticText[1]")
	public MobileElement fullNameValue;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvLabelRelationship')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='Relationship *'")
	public MobileElement relationshipLbl;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvRelationship')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Relationship *']/following-sibling:: XCUIElementTypeStaticText[1]")
	public MobileElement relationshipValue;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvLabelPhone')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='Phone *'")
	public MobileElement phoneLbl;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvPhone')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Phone *']/following-sibling:: XCUIElementTypeStaticText[1]")
	public MobileElement phoneNoValue;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvLabelAddress')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='Address' AND visible=true")
	public MobileElement addressLbl;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvAddress')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Address'][@visible='true']/following-sibling:: XCUIElementTypeStaticText[1]")
	public MobileElement addressValue;

	/**
	 * This method will return Emergency contact full name
	 * 
	 * @return string
	 */
	public String getEmergencyContactFullName() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String value = getElementText(fullNameValue, "Full Name Value", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return value;
	}

	/**
	 * This method will return Emergency contact Relationship
	 * 
	 * @return String
	 */
	public String getEmergencyContactRelationship() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String value = getElementText(relationshipValue, "Relationship Value", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return value;
	}

	/**
	 * This method will return Emergency contact PhoneNumber
	 * 
	 * @return string
	 */
	public String getEmergencyContactPhoneNumber() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String value = getElementText(phoneNoValue, "Phone Number Value", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return value;
	}

	/**
	 * This method will return Emergency contact Address
	 * 
	 * @return string
	 */
	public String getEmergencyContactAddress() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		String value = getElementText(addressValue, "Address Value", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return value;
	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTEmergencyContactsPage
	 */
	public TravelNEXTEmergencyContactsPage tapBackButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back button", pageName);
		TravelNEXTEmergencyContactsPage page = travelNEXTPageProvider.getTravelNEXTEmergencyContactsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;

	}

}
