package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TravelNEXTTravelPolicyPage extends TravelNEXTBasePage {

	public TravelNEXTTravelPolicyPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "Travel Policy Page";

	/**
	 * This method will get to Travel Policy Page
	 * 
	 * @return TravelNEXTTravelPolicyPage
	 */
	public TravelNEXTTravelPolicyPage getPage() {
		waitHandler.WaitForElementToBeVissible(whatTravelNEXTHeader, "About Travel Next Page Header", pageName,
				timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "back")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']/following-sibling::android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "What's TravelNEXT?")
	public MobileElement whatTravelNEXTHeader;

	/**
	 * This method will tap on Back button
	 */
	public void tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
	}

}
