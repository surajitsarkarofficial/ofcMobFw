package com.globant.qe.in.podsView.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

@Component
@Lazy
public class PodsViewAccountsService implements IMobileService<PodsViewAccountsService>{


	@Autowired
	PodsViewPageProvider podsViewPageProvider;

	/**
	 * This method will load the PodsView Home Page
	 * @return PodsViewAccountsService
	 */
	@Override
	public PodsViewAccountsService loadPage() {
		podsViewPageProvider.getPodsViewAccountsPage();
		return this;
	}
	
	/**
	 * This method will tap on Back button
	 * @return PodsViewAccountsService
	 */
	public PodsViewAccountsService tapBackButton() {
		podsViewPageProvider.getPodsViewAccountsPage().tapOnBackButton();
		return this;
	}
	
	/**
	 * This method will tap on Home button
	 * @return PodsViewAccountsService
	 */
	public PodsViewAccountsService tapBackToHome() {
		podsViewPageProvider.getPodsViewAccountsPage().tapBackToHome();
		return this;
	}
	
	
	/**
	 * This method will tap on Hamburger
	 * @return PodsViewAccountsService
	 */
	public PodsViewAccountsService tapOnHamburger() {
		podsViewPageProvider.getPodsViewAccountsPage().tapOnHamburger();
		return this;
	}
	
	
	/**
	 * This method will tap on SearchIcon
	 * @return PodsViewAccountsService
	 */
	public PodsViewAccountsService tapOnSearchIcon() {
		podsViewPageProvider.getPodsViewAccountsPage().tapOnSearchIcon();
		return this;
	}
	
	/**
	 * This method will tap on Account
	 * @return PodsViewAccountsService
	 */
	public PodsViewAccountsService tapOnAccount() {
		podsViewPageProvider.getPodsViewAccountsPage().tapOnAccount();
		return this;
	}
}
