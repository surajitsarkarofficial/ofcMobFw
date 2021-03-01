package com.globant.qe.in.travelNEXT.mobile.pages;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTHomePage extends TravelNEXTBasePage {

	public TravelNEXTHomePage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	final String pageName = "Home Page";

	/**
	 * This method will take to Home Page
	 * 
	 * @return TravelNEXTHomePage
	 */
	public TravelNEXTHomePage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));

		/**
		 * The below code can be used once the create trip banner is displayed form
		 * Release 5.0
		 */
		try {
			waitHandler.WaitForElementToBeVissible(hamburger, "Hamburger Icon", pageName, timeOut);
		} catch (Exception e) {
			if (isElementDisplayed(createTripBanner, "Create Trip Banner", pageName)) {
				tapCreateTripBanner();
			}
			waitHandler.WaitForElementToBeVissible(hamburger, "Hamburger Icon", pageName, timeOut);
		}
		return this;

	}

	/**
	 * This element will be used once the create trip banner is displayed form
	 * Release 5.0
	 */

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'fab')]")
	@iOSXCUITFindBy(accessibility = "ic add services")
	public static MobileElement createTripBanner;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Trips']/preceding-sibling::android.widget.ImageButton")
	@iOSXCUITFindBy(accessibility = "hamburger")
	public MobileElement hamburger;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Trips']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name=='My Trips' ")
	public MobileElement myTripsHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ONGOING']")
	@iOSXCUITFindBy(accessibility = "ONGOING")
	public MobileElement onGoingTrips;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='UPCOMING']")
	@iOSXCUITFindBy(accessibility = "UPCOMING")
	public MobileElement upComingTrips;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OLDER']")
	@iOSXCUITFindBy(accessibility = "OLDER")
	public MobileElement olderTrips;

	@AndroidFindBy(xpath = "(//android.widget.ImageView)[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[contains(@name,'TripListView')]/XCUIElementTypeButton[@name='hamburger']/following-sibling::XCUIElementTypeButton[1]")
	public MobileElement bellIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Looks like you don’t have any Ongoing trip')]")
	@iOSXCUITFindBy(accessibility = "fullPageInfoDescriptionLabel")
	public MobileElement errorMsgForOngoingTrip;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Looks like you don’t have any Upcoming trip')]")
	@iOSXCUITFindBy(accessibility = "fullPageInfoDescriptionLabel")
	public MobileElement errorMsgForUpcomingTrip;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Looks like you don’t have any Older trip')]")
	@iOSXCUITFindBy(accessibility = "fullPageInfoDescriptionLabel")
	public MobileElement errorMsgForOlderTrip;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'card_view')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'tableViewCellsection0_row')]")
	public MobileElement cardView;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'card_view')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'tableViewCellsection0_row')]")
	public List<MobileElement> cardListView;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_trip_title')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'tripNameLabelsection0_row')]")
	public MobileElement tripCardTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_id_title')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'tripIdLabelsection0_row')]")
	public MobileElement tripCardId;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_start_date')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'dateLabelsection0_row')]")
	public MobileElement tripCardDates;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'iv_more_trip_option')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'moreButtonsection0_row')]")
	public MobileElement tripOptionBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'iv_more_trip_option')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'moreButtonsection0_row')]")
	public List<MobileElement> tripOptionsBtnList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'History')]")
	@iOSXCUITFindBy(accessibility = "optionCell0")
	public MobileElement historyOption;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Comments')]")
	@iOSXCUITFindBy(accessibility = "optionCell1")
	public MobileElement commentsOption;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'More Info')]")
	@iOSXCUITFindBy(accessibility = "optionCell2")
	public MobileElement moreInfoOption;
	
	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "Back")
	public MobileElement backBtn;
	
	/**
	 * This method will tap on Hamburger button
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage tapHamburger() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(hamburger, "Hamburger Menu", pageName);
		TravelNEXTSideBarPage TravelNEXTSideBarPage = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return TravelNEXTSideBarPage;
	}

	
	/**
	 * This method will tap on cardView
	 * return TravelNEXTItineraryPage
	 */
	public TravelNEXTItineraryPage tapOnCardView()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(cardView, "Trip card", pageName);
		TravelNEXTItineraryPage page = travelNEXTPageProvider.getTravelNEXTItineraryPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
	
	/**
	 * This method will tap on Ongoing button
	 * 
	 * @return TravelNEXTHomePage
	 */
	public TravelNEXTHomePage tapOngoingTrip() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(onGoingTrips, "Ongoing Trips tab", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Upcoming button
	 * 
	 * @return TravelNEXTHomePage
	 */
	public TravelNEXTHomePage tapUpcomingTrips() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(upComingTrips, "Upcoming Trips tab", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Older button
	 * 
	 * @return TravelNEXTHomePage
	 */
	public TravelNEXTHomePage tapOlderTrips() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(olderTrips, "Older Trips tab", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This element will be used once the create trip banner is displayed form
	 * Release 5.0
	 */

	/**
	 * This method will tap on Create Trip button
	 */
	public void tapCreateTripBanner() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(createTripBanner, "Create Trip Banner", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
	}
	
	/**
	 * This method will tap on trip option button
	 */
	public void tapOnTripOptionBtn()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(tripOptionBtn, "Trip Options Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
	}

	/**
	 * This method will tap on create trip button
	 */
	public void tapOnCreateTripBanner()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(createTripBanner, "Create Trip Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
	}
}
