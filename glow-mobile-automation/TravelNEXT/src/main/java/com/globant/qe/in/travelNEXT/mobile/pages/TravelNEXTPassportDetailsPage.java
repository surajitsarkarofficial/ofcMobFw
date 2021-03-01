package com.globant.qe.in.travelNEXT.mobile.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.beans.PersonalDeatils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTPassportDetailsPage extends TravelNEXTBasePage {

	public TravelNEXTPassportDetailsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@Autowired
	PersonalDeatils personalDeatils;

	@Autowired
	WaitHandlers waitHandler;

	final String pageName = "Profile - Passport Page";

	/**
	 * This method will get Passport details page
	 * 
	 * @return TravelNEXTPassportDetailsPage
	 */
	public TravelNEXTPassportDetailsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		if (this.isElementDisplayed(noPassportAddedMsg, "No passport details added Message", pageName)) {
			waitHandler.WaitForElementToBeVissible(noPassportAddedMsg, "No Passport Details Added Msg", pageName, timeOut);
		} else {
			waitHandler.WaitForElementToBeVissible(passportNoLbl, "Passport No. Label", pageName, timeOut);
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvPassportLabel')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and value='Passport No.'")
	public MobileElement passportNoLbl;

	@AndroidFindBy(xpath = "(//*[contains(@resource-id,'tvPassportNumber')])[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Passport No.']/following-sibling::XCUIElementTypeStaticText[1]")
	public MobileElement passportNo;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvExpirationLabel')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and value='Expiration Date'")
	public MobileElement passportExpDateLbl;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvExpirationDate')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Expiration Date']/following-sibling::XCUIElementTypeStaticText[1]")
	public MobileElement passportExpDate;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvPassportCountryLabel')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' and value='Passport Country'")
	public MobileElement passportCountryLbl;

	@AndroidFindBy(xpath = "(//*[contains(@resource-id,'tvPassportCountry')])[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Passport Country']/following-sibling::XCUIElementTypeStaticText[1]")
	public MobileElement passportCountry;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandPassportInfo')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Passport/s' ")
	public MobileElement menuOption_Passport;

	@AndroidFindBy(xpath = "//android.view.ViewGroup//android.widget.TextView[@text='Glober has no passport information.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Passport/s' ")
	public MobileElement noPassportAddedMsg;

	/**
	 * This button will tap on hide Passport details
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage hidePassportDetails() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_Passport, "Passport/s Menu option", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'$1%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

}
