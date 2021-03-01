package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

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
public class TravelNEXTAboutAppPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	TravelNEXTAboutAppPage travelNEXTAboutPage;
	
	final String pageName = "About Application Page";

	public TravelNEXTAboutAppPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	/**
	 * This method will get About TravelNEXT Page
	 * @return TravelNEXTAboutAppPage
	 */
	@Test
	public TravelNEXTAboutAppPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(whatTravelNEXTHeader, "About Travel Next Page Header", pageName,
				timeOut);
		waitHandler.WaitForElementToBeVissible(travelPolicy, "About Travel Next Travel Policy", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(privacyPolicy, "About Travel Next Privacy Policy", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "back")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']/following-sibling::android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "What's TravelNEXT?")
	public MobileElement whatTravelNEXTHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTravelPolicy')]")
	@iOSXCUITFindBy(accessibility = "Travel Policy")
	public MobileElement travelPolicy;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvPrivacyPolicy')]")
	@iOSXCUITFindBy(accessibility = "Privacy Policy")
	public MobileElement privacyPolicy;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'imageView8')]")
	@iOSXCUITFindBy(accessibility = "icAppLogo")
	public MobileElement travelNEXTLogo;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvVersionName')]")
	@iOSXCUITFindBy(accessibility = "versionLabel")
	public MobileElement appVersion;

	/**
	 * This method will tap on the Back button
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage tapBackButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Travel Policy 
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage tapTravelPolicy() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$%s' method.", this.getClass().getSimpleName()));
		tap(travelPolicy, "Travel Policy Button", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Privacy Policy
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage tapPrivacyPolicy() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '$%s' method.", this.getClass().getSimpleName()));
		tap(privacyPolicy, "Privacy Policy Button", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

}
