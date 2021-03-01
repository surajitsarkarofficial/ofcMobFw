package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTSideBarPage extends TravelNEXTBasePage {

	public TravelNEXTSideBarPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	@Value("${logged.in.user}")
	private String currentUser;

	@Value("${logged.in.user.mailId}")
	private String loggedInUserEmailId;

	final String pageName = "Side Bar Page";

	/**
	 * This method will get Sidebar page
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'ivGtLogo')]")
	@iOSXCUITFindBy(accessibility = "gtLogoImage")
	public MobileElement appLogo;

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' and name='back' ")
	public MobileElement backBtn;

	public MobileElement globerImage;

	public MobileElement globerName;

	public MobileElement globerEmailId;

	/**
	 * This method setting elements according to which driver you are calling
	 * android or iOS
	 */
	public void setElements() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		if (mobileDriver instanceof AndroidDriver) {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of Android Driver"));
			globerImage = mobileDriver.findElement(
					MobileBy.xpath("//*[contains(@resource-id,'civUserProfilePic')]"));
			globerName = mobileDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'tvUserName')]"));
			globerEmailId = mobileDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'tvUserEmail')]"));
		} else {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of iOS Driver"));
			globerImage = mobileDriver.findElement(MobileBy.AccessibilityId("userProfileImage"));
			globerName = mobileDriver.findElement(MobileBy.xpath("//XCUIElementTypeStaticText[@name='userNameLabel']"));
			globerEmailId = mobileDriver
					.findElement(MobileBy.xpath("//XCUIElementTypeStaticText[@name='emailIdLabel']"));
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandPersonalInfo')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Personal' ")
	public MobileElement menuOption_Personal;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandPassportInfo')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Passport/s' ")
	public MobileElement menuOption_Passport;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivPersonalMore')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Emergency Contacts' ")
	public MobileElement menuOption_EmergencyContacts;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandFlyerNumber')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Frequent Flyer Numbers' ")
	public MobileElement menuOption_FrequentFlyerNumbers;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandHotelLoyalty')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Hotel Loyalty Programs' ")
	public MobileElement menuOption_HotelLoyaltyPrograms;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'aboutSectionLayout')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='About TravelNEXT' ")
	public MobileElement menuOption_AboutTravelNEXT;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'feedbackSectionLayout')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Feedback' ")
	public MobileElement menuOption_Feedback;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id	,'tvSignOut')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='SIGN OUT' ")
	public MobileElement signOut;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id	,'tvToolbarTitle')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name=='userNameLabel' ")
	public MobileElement menuOption_globerName_bold;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivToolbarPic')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeImage' AND name=='userProfileImage' ")
	public MobileElement menuOption_globerImage_icon;

	/**
	 * This method will tap on SIGN OUT button
	 * 
	 * @return TravelNEXTWelcomePage
	 */
	public TravelNEXTWelcomePage tapSignOut() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		scroll("up");
		tap(signOut, "Sign Out", pageName);
		TravelNEXTWelcomePage page = travelNEXTPageProvider.getTravelNEXTWelcomePage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Personal dropdown button
	 * 
	 * @return TravelNEXTPersonalDetailsPage
	 */
	public TravelNEXTPersonalDetailsPage tapPersonal() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_Personal, "Personal Details option", pageName);
		TravelNEXTPersonalDetailsPage page = travelNEXTPageProvider.getTravelNEXTPersonalDetailsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Passport dropdown button
	 * 
	 * @return TravelNEXTPassportDetailsPage
	 */
	public TravelNEXTPassportDetailsPage tapPassport() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_Passport, "Passport Details option", pageName);
		TravelNEXTPassportDetailsPage page = travelNEXTPageProvider.getTravelNEXTPassportDetailsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Emergency Contacts
	 * 
	 * @return TravelNEXTEmergencyContactsPage
	 */
	public TravelNEXTEmergencyContactsPage tapEmergencyContacts() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_EmergencyContacts, "Emergency Contacts option", pageName);
		TravelNEXTEmergencyContactsPage page = travelNEXTPageProvider.getTravelNEXTEmergencyContactsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Feedback
	 * 
	 * @return TravelNEXTFeedbackPage
	 */
	public TravelNEXTFeedbackPage tapFeedback() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_Feedback, "Feedback", pageName);
		TravelNEXTFeedbackPage page = travelNEXTPageProvider.getTravelNEXTFeedbackPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on About TravelNEXT
	 * 
	 * @return TravelNEXTAboutAppPage
	 */
	public TravelNEXTAboutAppPage tapAboutTravelNEXT() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_AboutTravelNEXT, "About Travel Next", pageName);
		TravelNEXTAboutAppPage page = travelNEXTPageProvider.getTravelNEXTAboutAppPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Frequent Flyer Numbers
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersPage
	 */
	public TravelNEXTFrequentFlyerNumbersPage tapFrequentFlyerNumbers() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_FrequentFlyerNumbers, "Frequent Flyer Numbers", pageName);
		TravelNEXTFrequentFlyerNumbersPage page = travelNEXTPageProvider.getTravelNEXTFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Frequent Flyer Numbers
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsPage
	 */
	public TravelNEXTHotelLoyaltyProgramsPage tapHotelLoyaltyPrograms() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_HotelLoyaltyPrograms, "Hotel Loyalty Programs", pageName);
		TravelNEXTHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
}
