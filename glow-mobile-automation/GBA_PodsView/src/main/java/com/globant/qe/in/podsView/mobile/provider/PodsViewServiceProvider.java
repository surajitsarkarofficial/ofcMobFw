package com.globant.qe.in.podsView.mobile.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.qe.in.podsView.mobile.business_service.PodsViewConstitutionService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewContactService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewFeedbackHistoryService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewHamburgerService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewAccountsService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewLoginService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewMemberService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewNotificationService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewPodsDetailsService;
import com.globant.qe.in.podsView.mobile.business_service.PodsViewSearchService;

@Service
public class PodsViewServiceProvider {

	@Autowired
	PodsViewAccountsService podsViewHomeService;
	
	@Autowired
	PodsViewLoginService podsViewLoginService;
	
	@Autowired
	PodsViewPodsDetailsService podsViewPodsDetailsService;
	
	@Autowired
	PodsViewContactService podsViewContactService;
	
	@Autowired
	PodsViewHamburgerService podsViewHamburgerService;
	
	@Autowired
	PodsViewSearchService podsViewSearchService;
	
	@Autowired
	PodsViewNotificationService podsViewNotificationService;
	
	@Autowired
	PodsViewConstitutionService podsViewConstitutionService;
	
	@Autowired
	PodsViewMemberService podsViewMemberService;
	
	@Autowired
	PodsViewFeedbackHistoryService podsViewFeedbackHistoryService;
	
	/**
	 * This method will take to PodsViewLoginService
	 * 
	 * @return podsViewLoginService
	 */
	public PodsViewLoginService getPodsViewLoginService() {
		return podsViewLoginService;
	}

	/**
	 * This method will take to PodsViewAccountsService
	 * 
	 * @return podsViewAccountsService
	 */
	public PodsViewAccountsService getPodsViewHomeService() {
		return podsViewHomeService;
	}
	
	/**
	 * This method will take to PodsViewPodsDetailsService
	 * 
	 * @return podsViewPodsDetailsService
	 */
	public PodsViewPodsDetailsService getPodsViewPodsDetailsService() {
		return podsViewPodsDetailsService;
	}

	/**
	 * This method will take to PodsViewContactService
	 * 
	 * @return podsViewContactService
	 */
	public PodsViewContactService getPodsViewContactService() {
		return podsViewContactService;
	}
	
	/**
	 * This method will take to PodsViewHamburgerService
	 * 
	 * @return podsViewHamburgerService
	 */
	public PodsViewHamburgerService getPodsViewHamburgerService() {
		return podsViewHamburgerService;
	}

	/**
	 * This method will take to PodsViewNotificationService
	 * 
	 * @return podsViewNotificationService
	 */
	public PodsViewNotificationService getPodsViewNotificationService() {
		return podsViewNotificationService;
	}
	
	/**
	 * This method will take to PodsViewConstitutionService
	 * 
	 * @return podsViewConstitutionService
	 */
	public PodsViewConstitutionService getPodsViewConstitutionService() {
		return podsViewConstitutionService;
	}

	/**
	 * This method will take to PodsViewSearchService
	 * 
	 * @return podsViewSearchService
	 */
	public PodsViewSearchService getPodsViewSearchService() {
		return podsViewSearchService;
	}
	
	/**
	 * This method will take to PodsViewMemberService
	 * 
	 * @return podsViewMemberService
	 */
	public PodsViewMemberService getPodsViewMemberService() {
		return podsViewMemberService;
	}
	
	/**
	 * This method will take to PodsViewFeedbackHistoryService
	 * 
	 * @return podsViewFeedbackHistoryService
	 */
	public PodsViewFeedbackHistoryService getPodsViewFeedbackHistoryService() {
		return podsViewFeedbackHistoryService;
	}
}
