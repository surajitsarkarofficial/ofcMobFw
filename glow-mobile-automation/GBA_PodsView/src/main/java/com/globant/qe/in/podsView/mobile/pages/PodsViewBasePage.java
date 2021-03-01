package com.globant.qe.in.podsView.mobile.pages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


@Primary
public class PodsViewBasePage extends AbstractMobileBasePage{
	
	@Autowired
	PodsViewPageProvider podsViewPageProvider;

	public PodsViewBasePage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface,configMobileParams);
	}

	@AndroidFindBy(id = "com.globant.globantview:id/progressBarView")
	@iOSXCUITFindBy(accessibility =  "In progress")
	public MobileElement loadingIcon;
	
	
	@AndroidFindBy(id = "com.globant.globantview:id/paginationProgressBar")
	@iOSXCUITFindBy(accessibility =  "In progress")
	public MobileElement paginationLoadingIcon;
}
