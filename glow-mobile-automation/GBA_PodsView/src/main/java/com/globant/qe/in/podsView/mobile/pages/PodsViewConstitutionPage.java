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
public class PodsViewConstitutionPage  extends PodsViewBasePage{


	public PodsViewConstitutionPage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);

	}


	final String pageName = "Constitution Page";

	@Autowired
	PodsViewPageProvider podsviewPageProvider;

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	ConfigMobileParams configParams;

	@AndroidFindBy(id = "com.globant.globantview:id/txtPurpose")
	@iOSXCUITFindBy(accessibility = "Purpose")
	public MobileElement purposeTitle;

	@AndroidFindBy(id = "com.globant.globantview:id/txtPrinciple")
	@iOSXCUITFindBy(accessibility = "Principles")
	public MobileElement principleTitle;

	@AndroidFindBy(id = "com.globant.globantview:id/tvName")
	@iOSXCUITFindBy(accessibility = "Franco Nicolas Biagioli")
	public MobileElement entrepreneurMemberName;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "Entrepreneur")
	public MobileElement entrepreneurTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "Closer")
	public MobileElement  closerTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.wid")
	@iOSXCUITFindBy(accessibility = "Accountant")
	public MobileElement accountantTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "Polisher")
	public MobileElement polisherTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "Storyteller")
	public MobileElement  storytellerTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "Professor")
	public MobileElement professorTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "Handler")
	public MobileElement handlerTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	@iOSXCUITFindBy(accessibility = "Friend")
	public MobileElement friendTitle;

	@AndroidFindBy(id = "com.globant.companionapp:id/ivAvator")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"PODsVIEW\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther[1] ")	
	public MobileElement entrepreneurProfilePic;

	
	/**
	 * This method will get PodsView ConstitutionPage
	 * 
	 * @return PodsViewConstitutionPage
	 */
	public PodsViewConstitutionPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;

	}

	/**
	 * This method will verify SliderView
	 * 
	 * @return PodsViewConstitutionPage
	 */
	public PodsViewConstitutionPage sliderView()
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		slide();
		PodsViewConstitutionPage PodsViewConstitutionPage = podsviewPageProvider.getPodsViewConstitutionPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return PodsViewConstitutionPage;
	}


}
