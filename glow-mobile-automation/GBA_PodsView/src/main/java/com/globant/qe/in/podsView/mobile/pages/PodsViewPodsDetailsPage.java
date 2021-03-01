package com.globant.qe.in.podsView.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


@Component
@Lazy
public class PodsViewPodsDetailsPage  extends PodsViewBasePage{


	public PodsViewPodsDetailsPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);

	}	

	final String pageName = "Pod Details Page";

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	ConfigMobileParams configParams;

	@Autowired
	PodsViewPageProvider podsviewPageProvider;

	@AndroidFindBy(id = "com.globant.globantview:id/tvTitle")
	@iOSXCUITFindBy(accessibility = "PODs")
	public MobileElement podTitle;

	@AndroidFindBy(id = "com.globant.globantview:id/tvSubTitle")
	@iOSXCUITFindBy(accessibility = "2K Games • Jonathan Tilden")
	public MobileElement contactTitle;

	@AndroidFindBy(id = "com.globant.globantview:id/tvNext")
	@iOSXCUITFindBy(accessibility = "navigation home icon")
	public MobileElement homeIcon;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ImageView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"navigation back arrow\"]")
	public MobileElement backButton;

	@AndroidFindBy(id = "com.globant.globantview:id/ivSearch")
	@iOSXCUITFindBy(accessibility = "navigation search icon")
	public MobileElement searchIcon;

	@AndroidFindBy(id = "com.globant.globantview:id/ivSearch")
	@iOSXCUITFindBy(accessibility = "//XCUIElementTypeButton[@name=\"i\"]")
	public MobileElement iIcon;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout")
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement pod;


	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"FEEDBACK HISTORY\"])[1]")
	public MobileElement feedbackHistory;



	/**
	 * This method will get PodsView PodsDetails Page
	 * 
	 * @return PodsViewPodsDetailsPage
	 */
	public PodsViewPodsDetailsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		waitHandler.WaitForElementToBeVissible(searchIcon, "Search Icon", pageName, timeOut);
		return this;

	}

	/**
	 * This method will tap on Search Icon 
	 * 
	 * @return PodsViewSearchPage
	 */
	public PodsViewSearch tapOnSearchIcon() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeVissible(searchIcon, "searchIcon", pageName, timeOut);
		tap(searchIcon, "searchIcon", pageName);
		PodsViewSearch PodsViewSearch = podsviewPageProvider.getPodsViewSearch();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewSearch;
	}

	/**
	 * This method will tap on Back Button
	 * 
	 * @return PodsViewContactsPage
	 */
	public PodsViewContactsPage tapOnBackButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backButton, "backToAccountPage", pageName);
		PodsViewContactsPage PodsViewContactsPage = podsviewPageProvider.getPodsViewContactPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewContactsPage;
	}	

	/**
	 * This method will tap on Home Button
	 * 
	 * @return PodsViewAccountsPage
	 */
	public PodsViewAccountsPage tapOnHome() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(homeIcon, "homeIcon", pageName);
		PodsViewAccountsPage PodsViewAccountsPage = podsviewPageProvider.getPodsViewAccountsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewAccountsPage;
	}	

	/**
	 * This method will tap on FeedBackHistory
	 * 
	 * @return PodsViewFeedbackHistoryPage
	 */
	public PodsViewFeedbackHistoryPage tapOnFeedBackHistory() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(feedbackHistory, "feedbackHistory", pageName);
		PodsViewFeedbackHistoryPage PodsViewFeedbackHistoryPage = podsviewPageProvider.getPodsViewFeedbackHistoryPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewFeedbackHistoryPage;
	}

}
