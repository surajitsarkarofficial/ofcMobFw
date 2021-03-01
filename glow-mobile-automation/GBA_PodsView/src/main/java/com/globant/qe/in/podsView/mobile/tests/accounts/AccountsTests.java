package com.globant.qe.in.podsView.mobile.tests.accounts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewAccountsService;
import com.globant.qe.in.podsView.mobile.pages.PodsViewAccountsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewBasePage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewContactsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewHamburger;
import com.globant.qe.in.podsView.mobile.pages.PodsViewSearch;
import com.globant.qe.in.podsView.mobile.provider.PodsViewServiceProvider;
import com.globant.qe.in.podsView.mobile.tests.PodsViewBaseTestsuite;

public class AccountsTests extends PodsViewBaseTestsuite{

	@Autowired
	PodsViewAccountsService podsViewHomeService;

	@Autowired
	PodsViewServiceProvider mobileServiceProvider;

	@Autowired
	PodsViewBasePage podsViewBasePage;

	@Autowired
	PodsViewAccountsPage podsViewHomePage;

	@Autowired
	PodsViewHamburger podsViewHamburger;

	@Autowired
	PodsViewContactsPage contactsPage;

	@Autowired
	PodsViewSearch podsViewSearch;


	/**
	 * This method will verify display of Accounts menu Items
	 * 
	 * @throws InterruptedException
	 */
	//@Test(priority = 1)
	public void verifyMyAccountsElements() throws IOException {

		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			String pageName = "Hamburger Menu";
			mobileServiceProvider.getPodsViewHomeService().loadPage();
			waitHandler.WaitForElementToDisappear(podsViewBasePage.loadingIcon, "Loading Icon", pageName,
					podsViewBasePage.timeOut);

			softAssert.assertTrue(podsViewHomePage.isElementDisplayed(podsViewHomePage.hamburgerIcon, "Hamburger", pageName)
					,"Hamburger icon is not present");
			softAssert.assertTrue(podsViewHomePage.isElementDisplayed(podsViewHomePage.searchIcon, "Search Icon", pageName)
					,"Search Icon is not present");
			softAssert.assertTrue(podsViewHomePage.isElementDisplayed(podsViewHomePage.myAccountsText, "MyAccount Text is displayed", pageName),
					"MyAccount Text is not present");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

	/**
	 * This method will verify verify MyAccounts Navigation
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void verifyMyAccountsNavigation() throws IOException {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			String pageName = "My Pods Page";

			mobileServiceProvider.getPodsViewHomeService().loadPage();
			mobileServiceProvider.getPodsViewHomeService().tapOnSearchIcon();
			softAssert.assertTrue(podsViewSearch.isElementDisplayed(podsViewSearch.recentSearchText, "recentSearch Text is displayed", pageName),
					"recentSearch Text not displayed");
			mobileServiceProvider.getPodsViewSearchService().tapBackButton();
			waitHandler.WaitForElementToBeClickable(podsViewHomePage.hamburgerIcon, "Hamburger Icon", pageName, podsViewBasePage.timeOut);

			mobileServiceProvider.getPodsViewHomeService().tapOnHamburger();
			softAssert.assertTrue(podsViewHamburger.isElementDisplayed(podsViewHamburger.userNameText, "userNameText is displayed", pageName),
					"userNameText is not present");
			softAssert.assertTrue(podsViewHamburger.isElementDisplayed(podsViewHamburger.logOut, "logOut is displayed", pageName),
					"logOut is not present");
			softAssert.assertAll();
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}
	}

}
