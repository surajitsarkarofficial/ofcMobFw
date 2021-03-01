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
public class PodsViewAccountsPage extends PodsViewBasePage{


	public PodsViewAccountsPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
		
	}
	

	final String pageName = "AccountsPage";
	
	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	ConfigMobileParams configParams;
	
	@Autowired
	PodsViewPageProvider podsviewPageProvider;

	@AndroidFindBy(id = "com.globant.globantview:id/tvHomeTitle")
	@iOSXCUITFindBy(accessibility = "My accounts")
	public MobileElement myAccountsText;
	
	@AndroidFindBy(id = "com.globant.globantview:id/searchIcon")
	@iOSXCUITFindBy(accessibility = "navigation search icon")
	public MobileElement searchIcon;
	
	@AndroidFindBy(id = "com.globant.globantview:id/nvViewMenu")
	@iOSXCUITFindBy(accessibility = "menu icon")
	public MobileElement hamburgerIcon;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]")
	@iOSXCUITFindBy(accessibility = "4 Contacts")
	public MobileElement contactCount;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	@iOSXCUITFindBy(accessibility = "2K Games")
	public MobileElement accountName;

	@AndroidFindBy(id = "com.globant.globantview:id/tvHomeSubTitle")
	@iOSXCUITFindBy(accessibility = "750 accounts")
	public MobileElement myAccountsCount;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement accountItem;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	public MobileElement newAccountItem;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ImageView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement accountDetailsArrow;
	
	@AndroidFindBy(id = "com.globant.globantview:id/tvHomeTitle")
	@iOSXCUITFindBy(accessibility = "navigation back arrow")
	public MobileElement backButton;
	
	@AndroidFindBy(id = "com.globant.globantview:id/ivSearchBackIcon")
	@iOSXCUITFindBy(accessibility = "navigation back arrow")
	public MobileElement backToAccountPage;
	
	//add
	@AndroidFindBy(id = "com.globant.globantview:id/tvHomeTitle")
	@iOSXCUITFindBy(accessibility = "Oops! Something went wrong")
	public MobileElement somethingWentWrongError;
	
	//add
	@AndroidFindBy(id = "com.globant.globantview:id/tvHomeTitle")
	@iOSXCUITFindBy(accessibility = "Oops! Something went wrong")
	public MobileElement noAccountErrorMsg;
	
	@AndroidFindBy(id = "com.globant.globantview:id/search_src_text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
	public MobileElement searchBar;


	
	/**
	 * This method will get Home page
	 * 
	 * @return PodsViewAccountsPage
	 */
	public PodsViewAccountsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;

	}

	/**
	 * This method will tap on Hamburger
	 * 
	 * @return PodsViewHamburger
	 */
	public PodsViewHamburger tapOnHamburger() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeClickable(hamburgerIcon, "hamburgerIcon", pageName, timeOut);
		tap(hamburgerIcon, "hamburgerIcon", pageName);
		PodsViewHamburger PodsViewHamburger = podsviewPageProvider.getPodsViewHamburger();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewHamburger;
	}

	/**
	 * This method will tap on Search Icon 
	 * 
	 * @return PodsViewSearchPage
	 */
	public PodsViewSearch tapOnSearchIcon() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		waitHandler.WaitForElementToBeClickable(searchIcon, "searchIcon", pageName, timeOut);
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
	 * This method will tap on Back Button
	 * 
	 * @return PodsViewAccountsPage
	 */
	public PodsViewAccountsPage tapBackToHome() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(backToAccountPage, "backToAccountPage", pageName);
		PodsViewAccountsPage PodsViewAccountsPage = podsviewPageProvider.getPodsViewAccountsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewAccountsPage;
	}	

	/**
	 * This method will tap on Account
	 * 
	 * @return PodsViewContactsPage
	 */
	public PodsViewContactsPage tapOnAccount() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(accountItem, "Account", pageName);
		PodsViewContactsPage PodsViewContactsPage = podsviewPageProvider.getPodsViewContactPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewContactsPage;
	}	
	
}
