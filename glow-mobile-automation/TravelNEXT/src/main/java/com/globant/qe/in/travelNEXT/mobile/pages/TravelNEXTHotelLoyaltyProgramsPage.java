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
public class TravelNEXTHotelLoyaltyProgramsPage extends TravelNEXTBasePage {

	@Autowired
	WaitHandlers waitHandler;

	@Autowired
	TravelNEXTAddHotelLoyaltyProgramsPage travelNEXTAddHotelLoyaltyProgramsPage;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivExpandHotelLoyalty')]")
	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeOther' AND name=='Hotel Loyalty Programs' ")
	public MobileElement menuOption_HotelLoyaltyPrograms;

	public TravelNEXTHotelLoyaltyProgramsPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD']")
	@iOSXCUITFindBy(accessibility = "ADD")
	public MobileElement addBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Glober has no Hotel Loyalty Program added.']")
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' AND value='Glober has no Hotel Loyalty Program added.'")
	public MobileElement noHotelLoyaltyProgramAddedMsg;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text='Hotel Loyalty Program added successfully']")
	@iOSXCUITFindBy(accessibility = "Hotel Loyalty Program added successfully")
	public MobileElement toastHotelLoyaltyProgramAddedMsg;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text='Hotel Loyalty Program deleted successfully']")
	@iOSXCUITFindBy(accessibility = "Hotel Loyalty Program deleted successfully")
	public MobileElement toastHotelLoyaltyProgramDeletedMsg;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'rvHotelLoyaltyList')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'expandedDataTVCellsection5_row')]")
	public MobileElement programsList;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTitle')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'expandedDataTVCellsection5_row')]")
	public MobileElement loyaltyPrograms;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvDetails')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'expandedDataTVCellsection5_row')]")
	public MobileElement loyaltyProgramNumbers;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTitle')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'expandedDataTVCellsection5_row')]")
	public List<MobileElement> loyaltyProgramsList;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvDetails')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'expandedDataTVCellsection5_row')]")
	public List<MobileElement> loyaltyProgramNumbersList;

	public String android_loyaltyProgram = "//android.view.ViewGroup/*[contains(@resource-id,'tvTitle')][@text='%s']/../*[contains(@resource-id,'tvDetails')][@text='%s']";
	public String iOS_loyaltyProgram = "//XCUIElementTypeStaticText[contains(@value,'%s')]";

	String loyaltyProgram, loyaltyProgramNumber, locator;
	MobileElement getLoyaltyProgramList = null;

	final String pageName = "Profile -  HotelLoyaltyPrograms Page";

	/**
	 * This method will get Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsPage
	 */
	public TravelNEXTHotelLoyaltyProgramsPage getPage() {
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	/**
	 * This method will tap on loyalty program
	 * return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage tapOnLoyaltyProgram() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(loyaltyPrograms, "Hotel loyalty Program", pageName);
		TravelNEXTViewHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTViewHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will get loyalty program from list
	 * 
	 * @param loyaltyProgram
	 * @param loyaltyProgramNumber
	 * @return MobileElement
	 */
	public MobileElement getLoyaltyProgramFromList(String loyaltyProgram, String loyaltyProgramNumber) {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		MobileElement getLoyaltyProgramList = null;

		this.scroll("up");
		if (mobileDriver instanceof AndroidDriver) {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of Android Driver"));

			locator = String.format(android_loyaltyProgram, loyaltyProgram, loyaltyProgramNumber);
			try {
				getLoyaltyProgramList = mobileDriver.findElement(MobileBy.xpath(locator));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Driver is instance of iOS Driver"));
			
			String locator = String.format(iOS_loyaltyProgram, loyaltyProgram + " " + loyaltyProgramNumber);
			try {
				getLoyaltyProgramList = mobileDriver.findElement(MobileBy.xpath(locator));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return getLoyaltyProgramList;
	}

	/**
	 * This method will tab on Loyalty Program from loyalty list
	 * 
	 * @param loyaltyProgram
	 * @param loyaltyProgramNumber
	 * return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage tapOnLoyaltyProgramFromList(String loyaltyProgram, String loyaltyProgramNumber) {

		tapByElement(getLoyaltyProgramFromList(loyaltyProgram, loyaltyProgramNumber), "Loyalty Program", pageName);
		TravelNEXTViewHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTViewHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on ADD loyalty program button
	 * 
	 * @return TravelNEXTAddHotelLoyaltyProgramsPage
	 */
	public TravelNEXTAddHotelLoyaltyProgramsPage tapOnAddBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(addBtn, "ADD button", pageName);
		TravelNEXTAddHotelLoyaltyProgramsPage page = travelNEXTPageProvider.getTravelNEXTAddHotelLoyaltyProgramsPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

	/**
	 * This method will tap on Hotel Loyalty Programs to hide
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage hideHotelLoyaltyPrograms() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(menuOption_HotelLoyaltyPrograms, "Hotel loyalty programs option", pageName);
		TravelNEXTSideBarPage page = travelNEXTPageProvider.getTravelNEXTSideBarPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

}
