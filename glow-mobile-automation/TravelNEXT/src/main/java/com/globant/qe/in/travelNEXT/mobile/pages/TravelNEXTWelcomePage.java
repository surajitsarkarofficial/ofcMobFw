package com.globant.qe.in.travelNEXT.mobile.pages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
@PropertySource({ "classpath:application.properties" })
@Primary
public class TravelNEXTWelcomePage extends TravelNEXTBasePage {

	public TravelNEXTWelcomePage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Value("${spring.profiles.active}")
	private String currentEnv;

	@Value("${logged.in.user}")
	private String currentUser;

	@Value("${logged.in.user.mailId}")
	private String loggedInUserMailId;

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	ConfigMobileParams configParams;

	final String pageName = "Welcome Page";

	/**
	 * This method will take to Welcome Page
	 * 
	 * @return TravelNEXTWelcomePage
	 */
	public TravelNEXTWelcomePage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.waitForElementToBeEnabled(wellcomeMsg, "Welcome Message", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_splash_logo')]")
	@iOSXCUITFindBy(accessibility = "login_applogo")
	public MobileElement appLogo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome to']")
	@iOSXCUITFindBy(accessibility = "Welcome to")
	public MobileElement wellcomeMsg;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='TravelNEXT']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and name=='TravelNEXT'")
	public MobileElement travelNEXT;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Make travel easier']")
	@iOSXCUITFindBy(accessibility = "Make travel easier")
	public MobileElement travelNEXTTagline;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btn_login')]")
	@iOSXCUITFindBy(accessibility = "signInGoogle")
	public MobileElement signInToGoogleBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Powered by']")
	@iOSXCUITFindBy(accessibility = "Powered by")
	public MobileElement powerBy;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_gt_logo')]")
	@iOSXCUITFindBy(accessibility = "gtLogo_Menu")
	public MobileElement globantLogo;

	@AndroidFindBy(id = "com.google.android.gms:id/main_title")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and name=='Choose an account'")
	public MobileElement chooseAnotherAcc;

	public MobileElement userName;

	@AndroidFindBy(id = "com.google.android.gms:id/add_account_chip_title")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and name=='Use another account'")
	public MobileElement useAnotherAcc;

	/**
	 * This method will sign in into Google
	 * 
	 * @return TravelNEXTHomePage
	 * @throws InterruptedException
	 */

	public TravelNEXTHomePage signinWithGoogle() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeVissible(signInToGoogleBtn, "SignIn Google button", pageName, timeOut);
		tap(signInToGoogleBtn, "Sign-in to Google", pageName);
		boolean isUserFound = false;
		switch (currentEnv.toUpperCase()) {
		case "IOS":
			handleAlertWithText("google.com", "Google Signin", true, timeOut);
			waitHandler.WaitForElementToBeVissible(chooseAnotherAcc, "Choose Another Account", "Google SignIn",
					timeOut);
			userName = mobileDriver
					.findElement(MobileBy.AccessibilityId(String.format("%s %s", currentUser, loggedInUserMailId)));
			tap(userName, "User Name", pageName);
			break;
		case "ANDROID":
			waitHandler.WaitForElementToBeVissible(chooseAnotherAcc, "Choose Another Account", "Google SignIn",
					timeOut);
			String locator = "//android.widget.TextView[contains(@resource-id,'account_name')]";
			List<MobileElement> usernameList = mobileDriver.findElements(MobileBy.xpath(locator));

			for (MobileElement mob : usernameList) {
				if (mob.getText().equalsIgnoreCase(loggedInUserMailId)) {
					userName = mob;
					isUserFound = true;
					tap(userName, "User Account", "Google SignIn Page");
					break;
				}

			}

			if (!isUserFound) {
				AbstractMobileBasePage.getLogger().fail(String.format("'%s' user not found.", loggedInUserMailId));
			}
			break;
		default:
			break;
		}
		handleAlertWithText("Would Like to Send You Notifications", "Home Page", true, timeOut);
		TravelNEXTHomePage page = travelNEXTPageProvider.getTravelNEXTHomePage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;

	}

}
