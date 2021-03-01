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
public class TravelNEXTHistoryPage extends TravelNEXTBasePage {

	public TravelNEXTHistoryPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "History Page";

	/**
	 * This method will go to History Page
	 * 
	 * @return TravelNEXTHistoryPage
	 */
	public TravelNEXTHistoryPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "Back")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Trip History')]")
	@iOSXCUITFindBy(accessibility = "navigationTitleLabel")
	public MobileElement headerTripHistory;
	
	/**
	 * This method will tap on back button.
	 * @return TravelNEXTHomePage
	 */
	public TravelNEXTHomePage tapBackBtn()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
		TravelNEXTHomePage page = travelNEXTPageProvider.getTravelNEXTHomePage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return page;
	}

}
