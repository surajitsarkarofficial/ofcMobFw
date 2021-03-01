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
public class PodsViewContactsPage extends PodsViewBasePage{


	public PodsViewContactsPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);

	}

	@Autowired
	PodsViewPageProvider podsviewPageProvider;

	final String pageName = "Contact's Page";

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	ConfigMobileParams configParams;

	@AndroidFindBy(id = "com.globant.globantview:id/tvTitle")
	@iOSXCUITFindBy(accessibility = "2K Games")
	public MobileElement accountName;

	@AndroidFindBy(id ="com.globant.globantview:id/tvSubTitle")
	@iOSXCUITFindBy(accessibility = "4 Contacts")
	public MobileElement contactCount;

	@AndroidFindBy(id = "com.globant.globantview:id/tvNext")
	@iOSXCUITFindBy(accessibility = "navigation home icon")
	public MobileElement homeIcon;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ImageView")
	@iOSXCUITFindBy(accessibility = "navigation back arrow")
	public MobileElement backButton;

	@AndroidFindBy(id = "com.globant.globantview:id/ivSearch")
	@iOSXCUITFindBy(accessibility = "navigation search icon")
	public MobileElement searchIcon;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement contact;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	public MobileElement secondContact;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	public MobileElement contactName;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
	@iOSXCUITFindBy(accessibility = "Producer")
	public MobileElement contactRole;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"2 PODs\"])[1]")
	public MobileElement podCount;

	@AndroidFindBy(id = "com.globant.globantview:id/tvSubTitle")
	@iOSXCUITFindBy(accessibility = "2K Games • Jason Smith")
	public MobileElement podName;

	@AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement pod;



	/**
	 * This method will get PodsView ContactsPage
	 * 
	 * @return PodsViewContactsPage
	 */
	public PodsViewContactsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	/**
	 * This method will tap on Search Icon 
	 * 
	 * @return PodsViewSearchPage
	 */
	public PodsViewSearch tapOnSearchIcon() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(searchIcon, "searchIcon", pageName);
		PodsViewSearch PodsViewSearch = podsviewPageProvider.getPodsViewSearch();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewSearch;
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
	 * This method will tap on Contact
	 * 
	 * @return PodsViewPodsDetailsPage
	 */
	public PodsViewPodsDetailsPage tapOnContact() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(contact, "contact", pageName);
		PodsViewPodsDetailsPage PodsViewPodsDetailsPage = podsviewPageProvider.getPodsViewPodsDetailsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewPodsDetailsPage;
	}
}
