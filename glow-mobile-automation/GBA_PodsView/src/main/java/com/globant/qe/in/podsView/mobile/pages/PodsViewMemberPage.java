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
public class PodsViewMemberPage  extends PodsViewBasePage{


	public PodsViewMemberPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);

	}


	final String pageName = "Pod Member Page";

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	ConfigMobileParams configParams;

	@Autowired
	PodsViewPageProvider podsviewPageProvider;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ImageView")
	@iOSXCUITFindBy(accessibility = "navigation back arrow")
	public MobileElement backButton;

	@AndroidFindBy(id = "com.globant.globantview:id/tvSubTitle")
	@iOSXCUITFindBy(accessibility = "2K DAM")
	public MobileElement podName;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")
	public MobileElement podMemberList;

	@AndroidFindBy(id = "com.globant.globantview:id/tvNext")
	@iOSXCUITFindBy(accessibility = "navigation home icon")
	public MobileElement homeButton;

	@AndroidFindBy(xpath = "Christian Moreno Lopez")
	@iOSXCUITFindBy(accessibility = "Pod Members")
	public MobileElement podMemberName;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Friend\"])[1]")
	public MobileElement podMemberRole;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeImage")
	public MobileElement podMemberPic;

	/**
	 * This method will get PodsView MemberPage
	 * 
	 * @return PodsViewMemberPage
	 */
	public PodsViewMemberPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;

	}

	/**
	 * This method will tap on Back Button
	 * 
	 * @return PodsViewAccountsPage
	 */
	public PodsViewAccountsPage tapOnBackButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backButton, "backToAccountPage", pageName);
		PodsViewAccountsPage PodsViewAccountsPage = podsviewPageProvider.getPodsViewAccountsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewAccountsPage;
	}	


}
