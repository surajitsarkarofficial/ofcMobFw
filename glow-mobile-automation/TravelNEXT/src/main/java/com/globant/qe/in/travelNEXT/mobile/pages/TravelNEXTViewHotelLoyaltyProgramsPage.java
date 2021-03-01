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
public class TravelNEXTViewHotelLoyaltyProgramsPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	TravelNEXTHotelLoyaltyProgramsPage travelNEXTHotelLoyaltyProgramsPage;

	public TravelNEXTViewHotelLoyaltyProgramsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clear All']")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement clearAllBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hotel Loyalty Program']")
	@iOSXCUITFindBy(accessibility = "Hotel Loyalty Programs")
	public MobileElement viewHotelLoyaltyHeader;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvLabelName')]")
	@iOSXCUITFindBy(accessibility = "nameTitleLabel")
	public MobileElement loyaltyProgramLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'Loyalty Program Number')]")
	@iOSXCUITFindBy(accessibility = "numberTitleLabel")
	public MobileElement loyaltyProgramNumbersLabel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvHotelName')]")
	@iOSXCUITFindBy(accessibility = "airlineLabel")
	public MobileElement loyaltyProgramTextField;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvHotelLoyaltyNumber')]")
	@iOSXCUITFindBy(accessibility = "numberLabel")
	public MobileElement loyaltyProgramNumbersTextField;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'item_edit')]")
	@iOSXCUITFindBy(accessibility = "editButton")
	public MobileElement editIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'item_delete')]")
	@iOSXCUITFindBy(accessibility = "deleteButton")
	public MobileElement deleteIcon;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnPositive')]")
	@iOSXCUITFindBy(accessibility = "rightSideButton")
	public MobileElement yesBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnNegative')]")
	@iOSXCUITFindBy(accessibility = "leftSideButton")
	public MobileElement noBtn;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'imageButton')]")
	@iOSXCUITFindBy(accessibility = "iconBackgroundView")
	public MobileElement deleteImage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTitle')]")
	@iOSXCUITFindBy(accessibility = "titleLabel")
	public MobileElement deleteTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvMessage')]")
	@iOSXCUITFindBy(accessibility = "descriptionLabel")
	public MobileElement deleteDescription;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[contains(@text,'Hotel Loyalty information updated successfully')]")
	@iOSXCUITFindBy(accessibility = "Hotel Loyalty information updated successfully")
	public MobileElement toastForHotelLoyaltyUpdated;
	
	final String pageName = "Profile -  View HotelLoyaltyPrograms Page";

	/**
	 * This method will get View Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	/**
	 * This method will tap on Back icon button button
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
	 * This method will tap on Edit loyalty program icon
	 * 
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage tapEditIcon() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(editIcon, "Edit button", pageName);
		TravelNEXTEditHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTEditHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
	
	
	/**
	 * This method will tap on delete loyalty program icon
	 * 
	 * @return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage tapDeleteIcon() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(deleteIcon, "Delete button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Yes button to delete loyalty program button
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsPage
	 */
	public TravelNEXTHotelLoyaltyProgramsPage tapOnYesBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(yesBtn, "Delete Loyalty Program button", pageName);
		TravelNEXTHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
	
	/**
	 * This method will tap on No button to cancel deletion of loyalty program
	 * 
	 * @return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage tapOnNoBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(noBtn, "No button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}
}
