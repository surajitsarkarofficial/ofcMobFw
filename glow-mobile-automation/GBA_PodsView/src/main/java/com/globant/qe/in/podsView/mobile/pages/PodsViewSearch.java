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
	public class PodsViewSearch  extends PodsViewBasePage{


		public PodsViewSearch(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
			super(iAppLauncherInterface, configMobileParams);
		
		}
		

		final String pageName = " Search Page";
		
		@Autowired
		WaitHandlers waitHandler;

		@Autowired
		ConfigMobileParams configParams;
		
		@Autowired
		PodsViewPageProvider podsviewPageProvider;
		
		
		@AndroidFindBy(id = "com.globant.globantview:id/ivSearchBackIcon")
		@iOSXCUITFindBy(accessibility = "navigation back arrow")
		public MobileElement backButton;
		
		@AndroidFindBy(id = "com.globant.globantview:id/tvRecentSearch")
		@iOSXCUITFindBy(accessibility = "navigation back arrow")
		public MobileElement recentSearchText;
		
		@AndroidFindBy(id = "com.globant.globantview:id/search_src_text")
		@iOSXCUITFindBy(accessibility = "navigation back arrow")
		public MobileElement searchBar;
		
		
		/**
		 * This method will get PodsViewSearch
		 * 
		 * @return PodsViewSearch
		 */
		public PodsViewSearch getPage() {
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
		
		/**
		 * This method will tap on Back Button to contacts page
		 * 
		 * @return PodsViewAccountsPage
		 */
		public PodsViewAccountsPage tapOnBackToContactsPage() {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
			tap(backButton, "backToAccountPage", pageName);
			PodsViewAccountsPage PodsViewAccountsPage = podsviewPageProvider.getPodsViewAccountsPage();
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
			return PodsViewAccountsPage;
		}
}
