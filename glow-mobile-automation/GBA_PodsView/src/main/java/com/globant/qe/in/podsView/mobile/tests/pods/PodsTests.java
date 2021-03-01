package com.globant.qe.in.podsView.mobile.tests.pods;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewAccountsService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewContactService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewPodsDetailsService;
import com.globant.qe.in.podsView.mobile.pages.PodsViewAccountsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewBasePage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewContactsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewFeedbackHistoryPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewPodsDetailsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewSearch;
import com.globant.qe.in.podsView.mobile.provider.PodsViewServiceProvider;
import com.globant.qe.in.podsView.mobile.tests.PodsViewBaseTestsuite;

public class PodsTests extends PodsViewBaseTestsuite{

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
	
	@Autowired
	PodsViewFeedbackHistoryPage podsViewFeedbackHistoryPage;

	/**
	 * This method will verify display of Pods Page menu Items
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void verifyPodElements() throws IOException {
		try {
			AbstractMobileBasePage.getLogger().log(Status.INFO, "Test Case Execution Started.");
			String pageName = "Pod Details Page";
			mobileServiceProvider.getPodsViewHomeService().loadPage();
			waitHandler.WaitForElementToDisappear(podsViewBasePage.loadingIcon, "Loading Icon", pageName,
					podsViewBasePage.timeOut);
			mobileServiceProvider.getPodsViewHomeService().tapOnAccount();
			mobileServiceProvider.getPodsViewContactService().tapOnContact();
			
			softAssert.assertTrue(podsDetailsPage.isElementDisplayed(podsDetailsPage.backButton, "Back Button", pageName)
					,"Back icon is not present");
			softAssert.assertTrue(podsDetailsPage.isElementDisplayed(podsDetailsPage.searchIcon, "Search Icon", pageName)
					,"Search Icon is not present");
			softAssert.assertTrue(podsDetailsPage.isElementDisplayed(podsDetailsPage.homeIcon, "Home Icon", pageName)
					,"Home Icon is not present");
			softAssert.assertTrue(podsDetailsPage.isElementDisplayed(podsDetailsPage.contactTitle, "Contact Title is displayed", pageName),
					"Contact Title is not present");
			softAssert.assertTrue(podsDetailsPage.isElementDisplayed(podsDetailsPage.podTitle, "Pod header Title", pageName)
					,"Pod Title is not present");
			softAssert.assertTrue(podsDetailsPage.isElementDisplayed(podsDetailsPage.feedbackHistory, "feedbackHistory is displayed", pageName),
					"feedbackHistory is not present");
			softAssert.assertAll();


		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.FAIL, e.getMessage());
			throw e;
		}

	}

	
	
}
