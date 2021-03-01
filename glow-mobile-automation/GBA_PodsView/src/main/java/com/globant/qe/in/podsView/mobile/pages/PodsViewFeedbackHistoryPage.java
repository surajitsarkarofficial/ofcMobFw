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
	public class PodsViewFeedbackHistoryPage  extends PodsViewBasePage{


		public PodsViewFeedbackHistoryPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
			super(iAppLauncherInterface, configMobileParams);
			
		}
		

		final String pageName = "Pod Details Page";
		
		@Autowired
		WaitHandlers waitHandler;

		@Autowired
		ConfigMobileParams configParams;
		
		@Autowired
		PodsViewPageProvider podsviewPageProvider;
		
		@AndroidFindBy(id = "com.globant.globantview:id/tv_feedbacks")
		@iOSXCUITFindBy(accessibility = "navigation search icon")
		public MobileElement feedbackText;

		public PodsViewFeedbackHistoryPage getPage() {
			waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
			return this;
			
		}
}
