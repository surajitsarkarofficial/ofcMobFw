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
public class TravelNEXTFeedbackSuccessPage extends TravelNEXTBasePage {

	public TravelNEXTFeedbackSuccessPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "Feedback Success Page";

	/**
	 * This method will take to feedback success page
	 * 
	 * @return TravelNEXTFeedbackSuccessPage
	 */
	public TravelNEXTFeedbackSuccessPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForElementToBeVissible(sentSuccessfully, "Feedback Sent Success Text", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//*[@text='Feedback']")
	@iOSXCUITFindBy(accessibility = "Feedback")
	public MobileElement feedbackPageHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_sent_successfully')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and value=='Sent Successfully!' ")
	public MobileElement sentSuccessfully;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_feedback_sent')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeImage' and name=='successImage'")
	public MobileElement successImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_feedback_thank_you')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and value=='Thank you!'")
	public MobileElement thankU;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_feedback_sent_note')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and name=='successInfoLabel")
	public MobileElement improveMsg;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_back_to_home')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' and label=='Done'")
	public MobileElement doneBtn;

	/**
	 * This method will tap on Done button
	 * 
	 * @return TravelNEXTHomePage
	 */
	public TravelNEXTHomePage tapOnDoneBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(doneBtn, "Done Button", pageName);
		TravelNEXTHomePage page = travelNEXTPageProvider.getTravelNEXTHomePage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;

	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

}
