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
public class TravelNEXTItineraryPage extends TravelNEXTBasePage {

	public TravelNEXTItineraryPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "Itinerary Page";

	/**
	 * This method will go to Itinerary Page
	 * 
	 * @return TravelNEXTItineraryPage
	 */
	public TravelNEXTItineraryPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "Back")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'toolbar_title')]")
	@iOSXCUITFindBy(accessibility = "navigationTitleLabel")
	public MobileElement itineraryHeader;
	
	@AndroidFindBy(xpath = "(//android.widget.HorizontalScrollView[contains(@resource-id,'tab')]//android.widget.LinearLayout//androidx.appcompat.app.ActionBar.Tab)[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"itineraryTabBarController\"]/XCUIElementTypeTabBar/XCUIElementTypeButton)[1]")
	public MobileElement itineraryTabBtn;
	
	@AndroidFindBy(xpath = "(//android.widget.HorizontalScrollView[contains(@resource-id,'tab')]//android.widget.LinearLayout//androidx.appcompat.app.ActionBar.Tab)[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"itineraryTabBarController\"]/XCUIElementTypeTabBar/XCUIElementTypeButton)[2]")
	public MobileElement commentsTabBtn;
	
	@AndroidFindBy(xpath = "(//android.widget.HorizontalScrollView[contains(@resource-id,'tab')]//android.widget.LinearLayout//androidx.appcompat.app.ActionBar.Tab)[3]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"itineraryTabBarController\"]/XCUIElementTypeTabBar/XCUIElementTypeButton)[3]")
	public MobileElement moreInfoTabBtn;
	
	/**
	 * This method will tap on back button.
	 * @return TravelNEXTHomePage
	 */
	public TravelNEXTHomePage tapBackBtn()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
		TravelNEXTHomePage page = travelNEXTPageProvider.getTravelNEXTHomePage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
	
	/**
	 * This method will tap on comments tab.
	 * @return TravelNEXTCommentsPage
	 */
	public TravelNEXTCommentsPage tapCommentsTab()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(commentsTabBtn, "Comments Tab Button", pageName);
		TravelNEXTCommentsPage page = travelNEXTPageProvider.getTravelNEXTCommentsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
	
	/**
	 * This method will tap on itinerary tab.
	 * @return TravelNEXTItineraryPage
	 */
	public TravelNEXTItineraryPage tapItineraryTab()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(itineraryTabBtn, "Itinerary Tab Button", pageName);
		TravelNEXTItineraryPage page = travelNEXTPageProvider.getTravelNEXTItineraryPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
	
	/**
	 * This method will tap on More info tab.
	 * @return TravelNEXTMoreInfoPage
	 */
	public TravelNEXTMoreInfoPage tapMoreInfoTab()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(moreInfoTabBtn, "More Info Tab Button", pageName);
		TravelNEXTMoreInfoPage page = travelNEXTPageProvider.getTravelNEXTMoreInfoPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
}
