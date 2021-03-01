package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTWelcomePage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTWelcomeService implements IMobileService<TravelNEXTWelcomeService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	private static TravelNEXTWelcomePage welcomePage;

	/**
	 * This method will load the Welcome Service page
	 * 
	 * @return TravelNEXTWelcomeService
	 */
	@Override
	public TravelNEXTWelcomeService loadPage() {
		welcomePage = travelNEXTPageProvider.getTravelNEXTWelcomePage();
		return this;
	}

	/**
	 * This method will select Google Sign in button
	 * 
	 * @return TravelNEXTWelcomeService
	 */
	public TravelNEXTWelcomeService selectGoogleSignInButton() {
		welcomePage.signinWithGoogle();
		return this;
	}
}
