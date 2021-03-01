package com.globant.qe.in.travelNEXT.mobile.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Component
@Lazy
public class TravelNEXTCostAllocationPage extends TravelNEXTBasePage {

	public TravelNEXTCostAllocationPage(IAppLauncherInterface iAppLauncherInterface,
			ConfigMobileParams configMobileParams) {
		super(iAppLauncherInterface, configMobileParams);
	}

	final String pageName = "Cost Allocation Page";

	/**
	 * This method will take to Cost Allocation Page
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage getPage() {
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		waitHandler.WaitForElementToDisappear(loadingIcon, "Loading Icon", pageName, timeOut);
		AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' is fetched successfully.", pageName));
		return this;
	}

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'toolbar_title')]")
	@iOSXCUITFindBy(accessibility = "navigationTitleLabel")
	public static MobileElement tripHeader;

	@AndroidFindBy(accessibility = "Navigate up")
	@iOSXCUITFindBy(accessibility = "backButton")
	public static MobileElement backButton;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'toolbar_title')]")
	@iOSXCUITFindBy(accessibility = "navigationTitleLabel")
	public static MobileElement costHeader;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'chip')]")
	@iOSXCUITFindBy(accessibility = "nameLabelsection0_row0")
	public static MobileElement ownerName;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'btnBack')]")
	@iOSXCUITFindBy(accessibility = "leftButton")
	public static MobileElement cancelbtn;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'btnNext')]")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public static MobileElement nextBtn;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvWatcherLabel')]")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public static MobileElement watchersTitle;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvAddWatcher')]")
	@iOSXCUITFindBy(accessibility = "rightButton")
	public static MobileElement addWatcherBtn;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'chip')]")
	@iOSXCUITFindBy(accessibility = "profileImageViewsection0_row0")
	public static MobileElement globerImage;

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'tvProjectAndPercentageTitle')]")
	@iOSXCUITFindBy(accessibility = "projectTextLabelsection2_row0")
	public static MobileElement projectAndPercentageTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivAddProject')]")
	@iOSXCUITFindBy(accessibility = "addButtonsection2_row0")
	public static MobileElement addProjectPlusBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvMaxProjectTitle')]")
	@iOSXCUITFindBy(accessibility = "maxTextLabelsection2_row0")
	public static MobileElement maxProjectLimit;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvTotalAllocationTitle')]")
	@iOSXCUITFindBy(accessibility = "profileImageViewsection0_row0")
	public static MobileElement totalProjectAllocationTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvAddProjectText')]")
	@iOSXCUITFindBy(accessibility = "totalTextLabelsection2_row0")
	public static MobileElement costAllocationPageTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvLabel')]")
	@iOSXCUITFindBy(accessibility = "screenTitleLabel")
	public static MobileElement addProjectTitle;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etFirstField')]")
	@iOSXCUITFindBy(accessibility = "nameTextField")
	public static MobileElement selectProjectField;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etSecondField')]")
	@iOSXCUITFindBy(accessibility = "percentageTextField")
	public static MobileElement percentagefield;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnCancel')]")
	@iOSXCUITFindBy(accessibility = "cancelButton")
	public static MobileElement cancelButton;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnDone')]")
	@iOSXCUITFindBy(accessibility = "doneButton")
	public static MobileElement addProjectButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'textinput_helper_text')]")
	@iOSXCUITFindBy(accessibility = "percentageErrorLabel")
	public static MobileElement helperTextAvailableAllocation;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'etSearchTitle')]")
	@iOSXCUITFindBy(accessibility = "searchTextField")
	public static MobileElement addProjectSearchField;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivClearText')]")
	@iOSXCUITFindBy(accessibility = "clearButton")
	public static MobileElement searchProjectCrossBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivBackArrow')]")
	@iOSXCUITFindBy(accessibility = "backArrow")
	public static MobileElement searchProjectBackBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'item_layout')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'SearchProjectTableViewCellsection0_row')]")
	public static MobileElement projectSearchList;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvProjectName')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'projectNameLabelsection2_row')]")
	public static MobileElement projectName;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'ivViewProjectOption')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'moreInfoButtonsection2_row')]")
	public static MobileElement optionBtnforAddedProject;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvMenuFirst')]")
	@iOSXCUITFindBy(accessibility = "titleLabel0")
	public static MobileElement editOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvMenuSecond')]")
	@iOSXCUITFindBy(accessibility = "titleLabel1")
	public static MobileElement removeOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvMenuThird')]")
	@iOSXCUITFindBy(accessibility = "titleLabel2")
	public static MobileElement detailsOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvLabel')]")
	@iOSXCUITFindBy(accessibility = "projDetailTextLabel")
	public static MobileElement projectDetailsTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivClose')]")
	@iOSXCUITFindBy(accessibility = "closeButton")
	public static MobileElement projectDetailsCloseBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Billability']")
	@iOSXCUITFindBy(accessibility = "approverTVCellsection0_row0")
	public static MobileElement billabilityTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Billability Type']")
	@iOSXCUITFindBy(accessibility = "billabilityTypeLabelsection0_row0")
	public static MobileElement billabilityTypeSubtitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='moreOptionTableView']//XCUIElementTypeStaticText[contains(@name,'titleLabel')]")
	public static MobileElement billabilityList;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='moreOptionTableView']//XCUIElementTypeStaticText[contains(@name,'titleLabel')]")
	public static List<MobileElement> billabilityTypeList;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvEdit')]")
	@iOSXCUITFindBy(accessibility = "editButtonsection0_row0")
	public static MobileElement editBillabilityBtn;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'atvBillability')]")
	@iOSXCUITFindBy(accessibility = "selectBillabilityButtonsection0_row0")
	public static MobileElement selectBillabilityField;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'ivBillabilityDropdown')]")
	@iOSXCUITFindBy(accessibility = "arrowButtonsection0_row0")
	public static MobileElement billablityDropdown;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnCancel')]")
	@iOSXCUITFindBy(accessibility = "cancelButtonsection0_row0")
	public static MobileElement cancelBillablityBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnDone')]")
	@iOSXCUITFindBy(accessibility = "doneButtonsection0_row0")
	public static MobileElement doneBillablityBtn;

	/**
	 * This method will tap on Add project plus button
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnAddProjectPlusBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(addProjectPlusBtn, "Add Project Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will select project name
	 * 
	 * @return TravelNEXTCostAllocationPage
	 * @param projectName
	 */
	public TravelNEXTCostAllocationPage selectProject(String projectName) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(selectProjectField, "Select Project field", projectName);
		enterText(addProjectSearchField, projectName, true, "Project Name", pageName);
		tapByElement(projectSearchList, "Project List", projectName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Add project button
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnAddProjectBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(addProjectButton, "Add Project Button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on option button for added project
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnOptionButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tap(optionBtnforAddedProject, "Option button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on details button for added project
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnDetailsOptionButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(detailsOption, "Details button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on project button for added project
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnCloseButtonOfProjectDetails() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(projectDetailsCloseBtn, "Close button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on back button
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnBackBtn() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(backButton, "Back button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on select billability field
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnSelectBillabilityType() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(selectBillabilityField, "Select billability field", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will select billability field
	 * 
	 * @return TravelNEXTCostAllocationPage
	 * @param billabiltyType
	 */
	public TravelNEXTCostAllocationPage SelectBillabilityType(String billabiltyType) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));

		if (mobileDriver instanceof AndroidDriver) {
			enterText(selectBillabilityField, billabiltyType, true, "Billability Type", pageName);
		} else {

			tap(selectBillabilityField, "Billability dropdown", pageName);
			int size = this.billabilityTypeList.size();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
			billabilityTypeList.get(randomNumber).click();
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on done billability button
	 * 
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage tapOnDoneBillabilityType() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(doneBillablityBtn, "Done button", pageName);
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return this;
	}

	/**
	 * This method will tap on Next button
	 * 
	 * @return TravelNEXTPassengerPage
	 */
	public TravelNEXTPassengerPage tapOnNextButton() {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("Inside '%s' method.", this.getClass().getSimpleName()));
		tapByElement(nextBtn, "Next button", pageName);
		TravelNEXTPassengerPage page = travelNEXTPageProvider.getTravelNEXTPassengerPage();
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' method executed successfully.", this.getClass().getSimpleName()));
		return page;
	}

}
