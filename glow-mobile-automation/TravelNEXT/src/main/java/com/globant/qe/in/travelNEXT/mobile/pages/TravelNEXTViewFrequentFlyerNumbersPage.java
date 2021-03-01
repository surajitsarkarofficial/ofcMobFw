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
public class TravelNEXTViewFrequentFlyerNumbersPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	public TravelNEXTViewFrequentFlyerNumbersPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	/**
	 * This method will get View Frequent Flyer Numbers page
	 * 
	 * @return TravelNEXTViewFrequentFlyerNumbersPage
	 */
	public TravelNEXTViewFrequentFlyerNumbersPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(frequentFlyerNumberHeader, "Frequent Flyer Number Header", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']//following-sibling::android.widget.TextView[@text='Frequent Flyer Number']")
	@iOSXCUITFindBy(accessibility = "Frequent Flyer Number")
	public MobileElement frequentFlyerNumberHeader;

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'item_edit')]")
	@iOSXCUITFindBy(accessibility = "editButton")
	public MobileElement editBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'item_delete')]")
	@iOSXCUITFindBy(accessibility = "deleteButton")
	public MobileElement deleteBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@name,'Airline')]")
	@iOSXCUITFindBy(accessibility = "nameTitleLabel")
	public MobileElement airlineLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'vAirline')]//parent::android.widget.FrameLayout")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='nameTitleLabel']//parent::XCUIElementTypeOther")
	public MobileElement airlineField;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvAirlineName')]")
	@iOSXCUITFindBy(accessibility = "airlineLabel")
	public MobileElement airlineFieldText;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'AirlineDropdown')]")
	@iOSXCUITFindBy(accessibility = "dropDownArrow")
	public MobileElement airlineDropdownIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvLabelFrequentFlyerNumber')]")
	@iOSXCUITFindBy(accessibility = "numberTitleLabel")
	public MobileElement flyerNumberLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'FrequentFlyerNumber')]//parent::android.widget.FrameLayout")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='numberTitleLabel']//parent::XCUIElementTypeOther")
	public MobileElement flyerNumberField;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvFrequentFlyerNumber')]")
	@iOSXCUITFindBy(accessibility = "numberLabel")
	public MobileElement flyerNumberFieldText;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'imageButton')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeOther' and name=='iconBackgroundView'")
	public MobileElement deleteIconImage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTitle')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' and name=='titleLabel'")
	public MobileElement deleteFlyerNumbertitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvMessage')]")
	@iOSXCUITFindBy(accessibility = "type='XCUIElementTypeStaticText' and name=='descriptionLabel'")
	public MobileElement deleteFlyerNumberDescription;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnNegative')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeButton' and label=='NO'")
	public MobileElement cancelFlyerNumberBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnPositive')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeButton' and label=='Yes'")
	public MobileElement deleteFlyerNumberBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[contains(@text,'Frequent flyer information updated successfully')]")
	@iOSXCUITFindBy(accessibility = "Frequent Flyer information updated successfully")
	public MobileElement toastFlyerNumberUpdated;
	

	final String pageName = "View Frequent Flyer Numbers Page";

	/**
	 * This method will tap on edit button
	 *
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage tapEditBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(editBtn, "Edit button", pageName);
		TravelNEXTEditFrequentFlyerNumbersPage page = travelNEXTPageProvider.getTravelNEXTEditFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on delete button
	 *
	 * @return TravelNEXTViewFrequentFlyerNumbersPage
	 */
	public TravelNEXTViewFrequentFlyerNumbersPage tapDeleteBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(deleteBtn, "Delete button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap on cancel flyer number button
	 *
	 * @return TravelNEXTViewFrequentFlyerNumbersPage
	 */
	public TravelNEXTViewFrequentFlyerNumbersPage tapCancelFlyerNumberBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(cancelFlyerNumberBtn, "CANCEL flyer number button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
	
	/**
	 * This method will tap Delete Flyer Number button
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersPage
	 */
	public TravelNEXTFrequentFlyerNumbersPage tapDeleteFlyerNumberBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(deleteFlyerNumberBtn, "DELETE flyer number button", pageName);
		TravelNEXTFrequentFlyerNumbersPage page = travelNEXTPageProvider.getTravelNEXTFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
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

}
