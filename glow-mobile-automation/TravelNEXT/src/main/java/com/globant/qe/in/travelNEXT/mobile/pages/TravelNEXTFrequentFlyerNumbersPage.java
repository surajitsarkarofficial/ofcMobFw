package com.globant.qe.in.travelNEXT.mobile.pages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTFrequentFlyerNumbersPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandFlyerNumber')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Frequent Flyer Numbers' ")
	public MobileElement menuOption_FrequentFlyerNumbers;

	public TravelNEXTFrequentFlyerNumbersPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	final String pageName = "Profile -  FrequentFlyerNumbers Page";

	/**
	 * This method will take to Frequent Flyer Numbers Page
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersPage
	 */
	public TravelNEXTFrequentFlyerNumbersPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'ADD')]")
	@iOSXCUITFindBy(accessibility =  "addButtonsection4_row0")
	public MobileElement frequentFlyerAddBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvFrequentFlyerWarning')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND label=='Glober has no Frequent Flyer Number added.'")
	public MobileElement noFrequentFlyerNumbersMsg; 

	@AndroidFindBy(xpath = "//android.widget.Toast[@text='Frequent flyer number added successfully']")
	@iOSXCUITFindBy(accessibility = "Frequent Flyer Number added successfully")
	public MobileElement toastFrequentFlyerNumberAdded;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnCancel')]")
	@iOSXCUITFindBy(accessibility =  "Frequent Flyer Number deleted successfully")
	public MobileElement toastForDeletedFlyerNumber;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[contains(@text,'You can save up to 10 Frequent Flyer Numbers only.')]")
	@iOSXCUITFindBy(accessibility =  "You can save up to 10 frequent flyer numbers only")
	public MobileElement toastForMaxAdditionCountOfFlyerNumber;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTitle')]")
	@iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[contains(@name,'descLabelsection4_row')]")
	public MobileElement airlineList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvDetails')]")
	@iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[contains(@name,'descLabelsection4_row')]")
	public MobileElement flyerList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvDetails')]")
	@iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[contains(@name,'descLabelsection4_row')]")
	public List<MobileElement> flyerNumbersList;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'constraintLayout')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'descLabelsection4_row')]")
	public List<MobileElement> listOfFlyerCards;
	
	String android_flyerCard = "//android.view.ViewGroup/*[contains(@resource-id,'id/tvTitle')][@text='%s']/../*[contains(@resource-id,'tvDetails')][@text='%s']";

	String iOS_flyerCard="//XCUIElementTypeStaticText[contains(@value,'%s')]";
	
	
	public MobileElement userNameFromList;
	/**
	 * This method will tap on Add button
	 * 
	 * @return TravelNEXTAddFrequentFlyerNumbersPage
	 */
	public TravelNEXTAddFrequentFlyerNumbersPage tapAddButton(){
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(frequentFlyerAddBtn, "Add Frequent Flyer Number Button", pageName);
		TravelNEXTAddFrequentFlyerNumbersPage page = travelNEXTPageProvider
				.getTravelNEXTAddFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Airline list
	 * return TravelNEXTViewFrequentFlyerNumbersPage
	 */
	public TravelNEXTViewFrequentFlyerNumbersPage tapOnAirlineList()
	{	
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(airlineList, "Airline list", pageName);
		TravelNEXTViewFrequentFlyerNumbersPage page = travelNEXTPageProvider.getTravelNEXTViewFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
	/**
	 * This method getting frequent flyer card from frequent flyer numbers list
	 * @param airline
	 * @param flyerNumber
	 * @return MobileElement
	 */
	public MobileElement getFrequentFlyerCardFromList(String airline,String flyerNumber ) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		MobileElement frequentFlyerCardFromList = null;
		if (mobileDriver instanceof AndroidDriver) {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of Android Driver"));
			String locator = String.format(android_flyerCard, airline, flyerNumber);
			try {
			frequentFlyerCardFromList = mobileDriver.findElement(MobileBy.xpath(locator));}
			catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of iOS Driver"));
			frequentFlyerCardFromList = mobileDriver.findElement(
					MobileBy.xpath(String.format(iOS_flyerCard, airline + " " + flyerNumber)));
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return frequentFlyerCardFromList;
	}
	
	/**
	 * This method will tap on flyer card from list
	 * @param airline
	 * @param flyerNumber
	 * return TravelNEXTViewFrequentFlyerNumbersPage
	 */
	public TravelNEXTViewFrequentFlyerNumbersPage tapOnFrequentFlyerCardFromList(String airline,String flyerNumber)
	{
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(getFrequentFlyerCardFromList(airline, flyerNumber), "Frequent Flyer Card", pageName);
		TravelNEXTViewFrequentFlyerNumbersPage page = travelNEXTPageProvider.getTravelNEXTViewFrequentFlyerNumbersPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}
	
	/**
	 * This method will tap on hide Frequent Flyer Numbers
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage hideFrequentFlyerNumbers() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_FrequentFlyerNumbers, "Frequent Flyer Numbers", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

}
