package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Primary
public class TravelNEXTBasePage extends AbstractMobileBasePage {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	public TravelNEXTBasePage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}
	@AndroidFindBy(xpath = "//*[contains(text(),'Loading, please wait')]")
	@iOSXCUITFindBy(iOSNsPredicate =  "type=='XCUIElementTypeActivityIndicator' AND name=='In progress' ")
	public MobileElement loadingIcon;

}
