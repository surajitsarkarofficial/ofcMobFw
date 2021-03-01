package com.globant.qe.in.podsView.mobile.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.podsView.mobile.pages.PodsViewConstitutionPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewContactsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewFeedbackHistoryPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewHamburger;
import com.globant.qe.in.podsView.mobile.pages.PodsViewAccountsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewLoginPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewMemberPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewNotificationPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewPodsDetailsPage;
import com.globant.qe.in.podsView.mobile.pages.PodsViewSearch;

@Component
@Lazy
public class PodsViewPageProvider {

	
	@Autowired
	PodsViewLoginPage podsViewLoginPage;
	
	@Autowired
	PodsViewAccountsPage podsViewAccountsPage;
	
	@Autowired
	PodsViewContactsPage podsViewContactPage;
	
	@Autowired
	PodsViewPodsDetailsPage podsViewPodsDetailsPage;
	
	@Autowired
	PodsViewHamburger podsViewHamburger;
	
	@Autowired
	PodsViewSearch podsViewSearch;
	
	@Autowired
	PodsViewNotificationPage podsViewNotificationPage;
	
	@Autowired
	PodsViewMemberPage podsViewMemberPage;
	
	@Autowired
	PodsViewConstitutionPage podsViewConstitutionPage;
	
	@Autowired
	PodsViewFeedbackHistoryPage podsViewFeedbackHistoryPage;
	
	/**
	 * This method will take to PodsViewLoginPage
	 * 
	 * @return podsViewLoginPage
	 */
	public PodsViewLoginPage getPodsViewLoginPage() {
		podsViewLoginPage.getPage();
		return podsViewLoginPage;
	}
	
	
	/**
	 * This method will take to podsViewAccountsPage
	 * 
	 * @return podsViewAccountsPage
	 */
	public PodsViewAccountsPage getPodsViewAccountsPage() {
		podsViewAccountsPage.getPage();
		return podsViewAccountsPage;
	}
	
	/**
	 * This method will take to PodsViewContactsPage
	 * 
	 * @return podsViewContactsPage
	 */
	public PodsViewContactsPage getPodsViewContactPage() {
		podsViewContactPage.getPage();
		return podsViewContactPage;
	}
	
	/**
	 * This method will take to PodsViewPodsDetailsPage
	 * 
	 * @return podsViewPodsDetailsPage
	 */
	public PodsViewPodsDetailsPage getPodsViewPodsDetailsPage() {
		podsViewPodsDetailsPage.getPage();
		return podsViewPodsDetailsPage;
	}
	
	/**
	 * This method will take to PodsViewHamburger
	 * 
	 * @return podsViewHamburger
	 */
	public PodsViewHamburger getPodsViewHamburger() {
		podsViewHamburger.getPage();
		return podsViewHamburger;
	}
	
	/**
	 * This method will take to PodsViewSearch
	 * 
	 * @return podsViewSearch
	 */
	public PodsViewSearch getPodsViewSearch() {
		podsViewSearch.getPage();
		return podsViewSearch;
	}
	
	/**
	 * This method will take to PodsViewNotificationPage
	 * 
	 * @return podsViewNotificationPage
	 */
	public PodsViewNotificationPage getPodsViewNotificationPage() {
		podsViewNotificationPage.getPage();
		return podsViewNotificationPage;
	}
	
	/**
	 * This method will take to PodsViewConstitutionPage
	 * 
	 * @return podsViewConstitutionPage
	 */
	public PodsViewConstitutionPage getPodsViewConstitutionPage() {
		podsViewConstitutionPage.getPage();
		return podsViewConstitutionPage;
	}
	
	/**
	 * This method will take to PodsViewMemberPage
	 * 
	 * @return podsViewMemberPage
	 */
	public PodsViewMemberPage getPodsViewMemberPage() {
		podsViewMemberPage.getPage();
		return podsViewMemberPage;
	}
	
	/**
	 * This method will take to PodsViewFeedbackHistoryPage
	 * 
	 * @return podsViewFeedbackHistoryPage
	 */
	public PodsViewFeedbackHistoryPage getPodsViewFeedbackHistoryPage() {
		podsViewFeedbackHistoryPage.getPage();
		return podsViewFeedbackHistoryPage;
	}
}
