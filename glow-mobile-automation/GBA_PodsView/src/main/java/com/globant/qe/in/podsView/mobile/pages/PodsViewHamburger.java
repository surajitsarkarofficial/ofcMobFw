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
	public class PodsViewHamburger  extends PodsViewBasePage{


		public PodsViewHamburger(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
			super(iAppLauncherInterface, configMobileParams);
		
		}
		

		final String pageName = "Hamburger Menu";
		
		@Autowired
		PodsViewPageProvider podsviewPageProvider;
		
		@Autowired
		WaitHandlers waitHandler;

		@Autowired
		ConfigMobileParams configParams;
		
		@AndroidFindBy(id = "com.globant.globantview:id/tvUseName")
		@iOSXCUITFindBy(accessibility = "Ritesh Menon")
		public MobileElement userNameText;
		
		@AndroidFindBy(id = "com.globant.globantview:id/tvLogout")
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"LOG OUT\"]")
		public MobileElement logOut;
		
		@AndroidFindBy(id = "com.globant.globantview:id/tvUseName")
		@iOSXCUITFindBy(accessibility = "Accounts")
		public MobileElement accounts;
		
		@AndroidFindBy(id = "com.globant.globantview:id/tvLogout")
		@iOSXCUITFindBy(accessibility = "PODs")
		public MobileElement pods;
		
		@AndroidFindBy(id = "com.globant.globantview:id/tvUseName")
		@iOSXCUITFindBy(accessibility = "Contacts")
		public MobileElement contacts;
		
		@AndroidFindBy(id = "com.globant.globantview:id/tvLogout")
		@iOSXCUITFindBy(accessibility = "Notifications")
		public MobileElement notificationLink;
		
		
		/**
		 * This method will get Hamburger page
		 * 
		 * @return hamburger page
		 */
		public PodsViewHamburger getPage() {
			waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
			return this;

		}
		
		
		/**
		 * This method will tap on LogOut Link
		 * 
		 * @return PodsViewLoginPage
		 */
		public PodsViewLoginPage tapLogOut() {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			tap(logOut, "Log Out", pageName);
			PodsViewLoginPage page = podsviewPageProvider.getPodsViewLoginPage();
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
			return page;
		}
		

}
