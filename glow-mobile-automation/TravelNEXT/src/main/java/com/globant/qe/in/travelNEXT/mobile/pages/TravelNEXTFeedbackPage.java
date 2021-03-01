package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
public class TravelNEXTFeedbackPage extends TravelNEXTBasePage {

	public TravelNEXTFeedbackPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "Feedback Page";

	/**
	 * This method will get Feedback page
	 * 
	 * @return TravelNEXTFeedbackPage
	 */
	public TravelNEXTFeedbackPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		waitHandler.WaitForEitherElementToBeVissible(feedbackPageHeader, discardTitle, "Feedback Page Header",
				"Discard Popup", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@Autowired
	public PersonalDeatils personalDeatils;

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "back")
	public MobileElement backBtn;

	@AndroidFindBy(xpath = "//*[@text='Feedback']")
	@iOSXCUITFindBy(accessibility = "Feedback")
	public MobileElement feedbackPageHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_user_name')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and name=='userNameLabel'")
	public MobileElement globerName;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_tell_us_more')]")
	@iOSXCUITFindBy(accessibility = "Tell us more about your experience")
	public MobileElement tellUsYourExp;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_rate_your_experience')]")
	@iOSXCUITFindBy(accessibility = "RATE YOUR EXPERIENCE *")
	public MobileElement rateYourExp;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_terrible')]")
	@iOSXCUITFindBy(accessibility = "icTerribleSmiley")
	public MobileElement terribleExpEmoji;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_bad')]")
	@iOSXCUITFindBy(accessibility = "icBadSmiley")
	public MobileElement badExpEmoji;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_average')]")
	@iOSXCUITFindBy(accessibility = "icAverageSmiley")
	public MobileElement avgExpEmoji;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_good')]")
	@iOSXCUITFindBy(accessibility = "icGoodSmiley")
	public MobileElement goodExpEmoji;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_excellent')]")
	@iOSXCUITFindBy(accessibility = "icExcellentSmiley")
	public MobileElement excellentExpEmoji;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_describe_your_experience')]")
	@iOSXCUITFindBy(accessibility = "COMMENTS")
	public MobileElement commentsHeader;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'edt_feedback')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeTextView'  and visible==true")
	public MobileElement commentTextBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_feedback_note')]")
	@iOSXCUITFindBy(accessibility = "Your valuable feedback allows the TravelNext team to improve the experience of this travel application.")
	public MobileElement feedbackNote;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_send_feedback')]")
	@iOSXCUITFindBy(accessibility = "Send Feedback")
	public MobileElement sendFeedbackBtn;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'imageButton')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeImage'  and name=='icAlert'")
	public MobileElement discardImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTitle')]")
	@iOSXCUITFindBy(accessibility = "Discard changes?")
	public MobileElement discardTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvMessage')]")
	@iOSXCUITFindBy(accessibility = "Are you sure you want to discard all changes?")
	public MobileElement discardMsg;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnNegative')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton'  and name=='CANCEL'")
	public MobileElement cancelButton;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnPositive')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton'  and name=='DISCARD'")
	public MobileElement discardButton;

	/**
	 * This method will tap on Back button
	 */
	public void tapBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backBtn, "Back Button", pageName);
	}

	/**
	 * This method will send the ratings according to input given
	 * 
	 * @param ratings
	 * @return TravelNEXTFeedbackPage
	 */
	public TravelNEXTFeedbackPage sendRatings(String ratings) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeVissible(rateYourExp, "Rate your experience", "Feedback Page", timeOut);
		switch (ratings.toUpperCase()) {
		case "TERRIBLE":
			tap(terribleExpEmoji, "Terrible Experience Emoji", pageName);
			break;
		case "BAD":
			tap(badExpEmoji, "Bad Experience Emoji", pageName);
			break;
		case "AVERAGE":
			tap(avgExpEmoji, "Average Experience Emoji", pageName);
			break;
		case "GOOD":
			tap(goodExpEmoji, "Good Experience Emoji", pageName);
			break;
		case "EXCELLENT":
			tap(excellentExpEmoji, "Excellent Experience Emoji", pageName);
			break;
		default:
			break;
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will provide pass comment in feedback comment section
	 * 
	 * @param comment
	 * @return TravelNEXTFeedbackPage
	 */
	public TravelNEXTFeedbackPage provideFeedbackComment(String comment) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeVissible(commentsHeader, "Comments Header", pageName, timeOut);
		enterText(commentTextBox, comment, true, "Comment Textbox", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will submit your feedback
	 * 
	 * @return TravelNEXTFeedbackSuccessPage
	 */
	public TravelNEXTFeedbackSuccessPage submitFeedback() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		sendRatings(personalDeatils.getGloberRatings());
		provideFeedbackComment(personalDeatils.getGloberComment());
		tapByCoordinates(171, 73);
		tapSendFeedbackButton();
		TravelNEXTFeedbackSuccessPage successPage = travelNEXTPageProvider.getTravelNEXTFeedbackSuccessPage().getPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return successPage;
	}

	/**
	 * This method will tap on Send Feedback button
	 * 
	 * @return TravelNEXTFeedbackSuccessPage
	 */
	public TravelNEXTFeedbackSuccessPage tapSendFeedbackButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		mobileDriver.hideKeyboard();
		tap(sendFeedbackBtn, "Send Feedback Button", pageName);
		TravelNEXTFeedbackSuccessPage successPage = travelNEXTPageProvider.getTravelNEXTFeedbackSuccessPage().getPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return successPage;
	}

	/**
	 * This method will tap on Discard feedback button
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage discardFeedback() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(discardButton, "Discard Button", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will provide false/wrong feedback
	 * 
	 * @return TravelNEXTFeedbackPage
	 */
	public TravelNEXTFeedbackPage provideFlasefeedback() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeVissible(commentsHeader, "Comments Header", pageName, timeOut);
		sendRatings(personalDeatils.getGloberRatings());
		provideFeedbackComment(personalDeatils.getGloberComment());
		tapByCoordinates(171, 73);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on cancel feedback button
	 * 
	 * @return TravelNEXTFeedbackPage
	 */
	public TravelNEXTFeedbackPage clickCancelFeedback() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(cancelButton, "Cancel Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

}
