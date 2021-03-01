package com.globant.qe.in.podsView.mobile.tests.contacts;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.springframework.beans.factory.annotation.Autowired;

import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewAccountsService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewContactService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewPodsDetailsService;
import com.globant.qe.in.podsView.mobile.pages.PodsViewAccountsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewBasePage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewContactsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewPodsDetailsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewSearch;
import com.globant.qe.in.podsView.mobile.provider.PodsViewServiceProvider;
import com.globant.qe.in.podsView.mobile.tests.PodsViewBaseTestsuite;

public class ContactTests extends PodsViewBaseTestsuite{

	@Autowired
	PodsViewAccountsService podsViewHomeService;
	
	@Autowired
	PodsViewPodsDetailsService podsViewPodsDetailsService;

	@Autowired
	PodsViewContactService podsViewContactService;

	@Autowired
	PodsViewPodsDetailsPage podsViewPodsDetailsPage;

	@Autowired
	PodsViewServiceProvider mobileServiceProvider;

	@Autowired
	PodsViewBasePage podsViewBasePage;

	@Autowired
	PodsViewAccountsPage podsViewHomePage;

	@Autowired
	PodsViewContactsPage podsViewContactsPage;
	
	@Autowired
	PodsViewSearch podsViewSearch;
	
	@Autowired
	PodsViewPodsDetailsPage podsDetailsPage;

	/**
	 * This method will verify display of Contacts menu Items
	 * 
	 * @throws InterruptedException
	 */
	//@Test(priority = 1)
	public void verifyContactsElements() throws IOException {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			String pageName = "Contacts Page";
			mobileServiceProvider.getPodsViewHomeService().loadPage();
			waitHandler.WaitForElementToDisappear(podsViewBasePage.loadingIcon, "Loading Icon", pageName,
					podsViewBasePage.timeOut);
			mobileServiceProvider.getPodsViewHomeService().tapOnAccount();
			
			softAssert.assertTrue(podsViewContactsPage.isElementDisplayed(podsViewContactsPage.backButton, "Back Button", pageName)
					,"Back icon is not present");
			softAssert.assertTrue(podsViewContactsPage.isElementDisplayed(podsViewContactsPage.searchIcon, "Search Icon", pageName)
					,"Search Icon is not present");
			softAssert.assertTrue(podsViewContactsPage.isElementDisplayed(podsViewContactsPage.accountName, "MyAccount Name is displayed", pageName),
					"MyAccount Name is not present");
			softAssert.assertTrue(podsViewContactsPage.isElementDisplayed(podsViewContactsPage.homeIcon, "Home Icon", pageName)
					,"Home Icon is not present");
			softAssert.assertTrue(podsViewContactsPage.isElementDisplayed(podsViewContactsPage.contactCount, "Contact Count is displayed", pageName),
					"Contact Count is not present");
			softAssert.assertTrue(podsViewContactsPage.isElementDisplayed(podsViewContactsPage.contactName, "Contact Name", pageName)
					,"Contact Name is not present");
			softAssert.assertTrue(podsViewContactsPage.isElementDisplayed(podsViewContactsPage.contactRole, "Contact Count is displayed", pageName),
					"Contact Role is not present");
			softAssert.assertAll();


		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}

	}

	/**
	 * This method will verify Contacts Navigation
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void verifyContactsNavigation() throws IOException {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started");
			softAssert = new SoftAssert();
			String pageName = "Contacts Page";
			mobileServiceProvider.getPodsViewHomeService().loadPage();
			waitHandler.WaitForElementToDisappear(podsViewBasePage.loadingIcon, "Loading Icon", pageName,
					podsViewBasePage.timeOut);

			mobileServiceProvider.getPodsViewHomeService().tapOnAccount();
			mobileServiceProvider.getPodsViewContactService().tapOnContact();
			waitHandler.WaitForElementToDisappear(podsViewBasePage.loadingIcon, "Loading Icon", pageName,
					podsViewBasePage.timeOut);

			softAssert.assertTrue(podsDetailsPage.isElementDisplayed(podsDetailsPage.searchIcon, "Search Icon is displayed", pageName),
					"Search Icon is not present");
			softAssert.assertTrue(podsDetailsPage.isElementDisplayed(podsDetailsPage.homeIcon, "Home Icon is displayed", pageName),
					"Home Icon is not present");
			mobileServiceProvider.getPodsViewPodsDetailsService().tapBackButton();
			mobileServiceProvider.getPodsViewContactService().tapOnSearchIcon();
			softAssert.assertTrue(podsViewSearch.isElementDisplayed(podsViewSearch.recentSearchText, "recentSearch Text is displayed", pageName),
					"recentSearch Text not displayed");
			softAssert.assertAll();
			
		
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}

	}



}
