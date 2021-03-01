package com.globant.qe.in.podsView.mobile.pages;


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

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
@PropertySource({ "classpath:applicationMobile.properties"})
@Primary
public class PodsViewLoginPage  extends PodsViewBasePage{


	public PodsViewLoginPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);

	}

	
	@Value("${spring.profiles.active}")
	private String currentEnv;

	@Value("${logged.in.user.id}")
	private String loggedInUserId;

	@Value("${logged.in.incorrect.user.id}")
	private String incorrectGloberMailId;

	final String pageName = "Login Page";
	
	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	ConfigMobileParams configParams;

	@AndroidFindBy(id = "com.globant.globantview:id/ivGlobantLogo")
	@iOSXCUITFindBy(accessibility = "ImageGlobantLogo")
	public MobileElement globantLogo;

	@AndroidFindBy(id = "com.globant.globantview:id/tvWelcome")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Welcome!\"]!")
	public MobileElement welcomeText;

	@AndroidFindBy(id = "com.globant.globantview:id/ivLoginGoogle")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"signIn with google\"]")
	public MobileElement loginWithGoogleButton;

	@AndroidFindBy(id = "com.globant.globantview:id/etUserName")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"Login\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther")
	public MobileElement enterUsernameTextbox;

	@AndroidFindBy(id = "com.globant.globantview:id/btnLogindialog")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
	public MobileElement loginButton;

	@AndroidFindBy(id = "com.globant.globantview:id/btnSignindialog")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"Login\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]")
	public MobileElement loginWindow; 
	
	
	@AndroidFindBy(id = "com.globant.globantview:id/btnSignindialog")
	@iOSXCUITFindBy(accessibility = "Google")
	public MobileElement loginWithGoogle;

	@AndroidFindBy(id = "com.globant.globantview:id/tvHomeTitle")
	@iOSXCUITFindBy(accessibility = "My accounts")
	public MobileElement myAccountsText;

	@AndroidFindBy(id = "com.globant.globantview:id/searchIcon")
	@iOSXCUITFindBy(accessibility = "navigation search icon")
	public MobileElement searchIcon;

	@AndroidFindBy(id = "com.globant.globantview:id/nvViewMenu")
	@iOSXCUITFindBy(accessibility = "menu icon")
	public MobileElement hamburgerIcon;


	
	/**
	 * This method will get Login page
	 * 
	 * @return PodsViewLoginPage
	 */
	public PodsViewLoginPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}


	/**
	 * This method will tap on Provide username Textbox
	 * 
	 * @return PodsViewLoginPage
	 */
	public PodsViewLoginPage provideUserId(String userId) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeVissible(enterUsernameTextbox, "Textbox", userId, timeOut);
		enterText(enterUsernameTextbox, userId, true, "userId TextBox", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will provide Incorrect Email
	 * 
	 * @return PodsViewLoginPage
	 */
	public PodsViewLoginPage provideIncorrectUserId(String incorrectUserId) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		enterText(enterUsernameTextbox, incorrectUserId, true, "EmailId TextBox", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Next Button
	 * 
	 * @return PodsViewAccountsPage
	 */
	public PodsViewAccountsPage tapLoginButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeVissible(loginButton, "nextButton", pageName, timeOut);
		tap(loginButton, "Login Button", pageName);
		PodsViewAccountsPage homePage = podsViewPageProvider.getPodsViewAccountsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return homePage;
	}

	/**
	 * This method will provide Sign In
	 * 
	 * @return PodsViewAccountsPage
	 */
	public PodsViewAccountsPage signIn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		isElementDisplayed(welcomeText, "Welcome Text", pageName);
		isElementDisplayed(loginWithGoogleButton, "loginWithGoogleButton", pageName);
		tap(loginWithGoogleButton, "login Button", pageName);
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName,timeOut);
		waitHandler.waitForElementToBeEnabled(enterUsernameTextbox, "enterUsernameTextbox", pageName, timeOut);
		provideUserId(loggedInUserId);
		tapLoginButton();
		PodsViewAccountsPage homePage = podsViewPageProvider.getPodsViewAccountsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return homePage;

	}
	
	
	
	
	
}
