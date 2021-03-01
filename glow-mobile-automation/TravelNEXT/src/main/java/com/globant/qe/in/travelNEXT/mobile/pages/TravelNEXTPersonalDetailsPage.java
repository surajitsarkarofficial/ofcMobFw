package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
@PropertySource({ "classpath:application.properties" })
public class TravelNEXTPersonalDetailsPage extends TravelNEXTBasePage {

	public TravelNEXTPersonalDetailsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Value("${logged.in.user}")
	private String currentUser;

	@Value("${logged.in.user.mailId}")
	private String loggedInUserEmailId;

	@Autowired
	PersonalDeatils personalDeatils;

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "Profile - Personal Info Page";

	/**
	 * This method will get Personal Details Page
	 * 
	 * @return TravelNEXTPersonalDetailsPage
	 */
	public TravelNEXTPersonalDetailsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.waitForElementToBeEnabled(documentNoLabel, "Document No Label", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "back")
	public MobileElement profilePageBackBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandPersonalInfo')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Personal' ")
	public MobileElement menuOption_Personal;

	@AndroidFindBy(id = "tvLabel")
	@iOSXCUITFindBy(accessibility = "Document No.")
	public MobileElement documentNoLabel;

	@AndroidFindBy(id = "tvValue")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Document No.']/preceding-sibling::XCUIElementTypeStaticText")
	public MobileElement documentNo;

	@AndroidFindBy(xpath = "//*[@text='Gender']")
	@iOSXCUITFindBy(accessibility = "Gender")
	public MobileElement genderLabel;

	@AndroidFindBy(xpath = "//*[@text='Gender']/following-sibling::android.widget.TextView[contains(@resource-id,'tvValue')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Gender']/preceding-sibling::XCUIElementTypeStaticText")
	public MobileElement gender;

	@AndroidFindBy(xpath = "//*[@text='Birth Date']")
	@iOSXCUITFindBy(accessibility = "Birth Date")
	public MobileElement dobLabel;

	@AndroidFindBy(xpath = "//*[@text='Birth Date']/following-sibling::android.widget.TextView[contains(@resource-id,'tvValue')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Birth Date']/preceding-sibling::XCUIElementTypeStaticText")
	public MobileElement dob;

	@AndroidFindBy(xpath = "//*[@text='Nationality']")
	@iOSXCUITFindBy(accessibility = "Nationality")
	public MobileElement nationalityLabel;

	@AndroidFindBy(xpath = "//*[@text='Nationality']/following-sibling::android.widget.TextView[contains(@resource-id,'tvValue')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Nationality']/preceding-sibling::XCUIElementTypeStaticText")
	public MobileElement nationality;

	@AndroidFindBy(xpath = "//*[@text='Phone']")
	@iOSXCUITFindBy(accessibility = "Phone")
	public MobileElement phoneLabel;

	@AndroidFindBy(xpath = "//*[@text='Phone']/following-sibling::android.widget.TextView[contains(@resource-id,'tvValue')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Phone']/preceding-sibling::XCUIElementTypeStaticText")
	public MobileElement phoneNo;

	/**
	 * This method will hide Personal details
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage hidePersonalDetails() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_Personal, "Perosnal Menu option", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
}
