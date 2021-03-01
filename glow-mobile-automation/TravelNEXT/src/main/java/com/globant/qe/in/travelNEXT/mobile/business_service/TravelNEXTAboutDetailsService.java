package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTAboutDetailsService implements IMobileService<TravelNEXTAboutDetailsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTAboutDetailsService aboutDetailsService;

	/**
	 * This method will load the About TravelNEXT Page
	 * 
	 * @return TravelNEXTAboutDetailsService
	 */
	@Override
	public TravelNEXTAboutDetailsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTAboutAppPage();
		return this;
	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTAboutDetailsService
	 */
	public TravelNEXTAboutDetailsService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTTravelPolicyPage().tapBackBtn();
		return aboutDetailsService;
	}

	/**
	 * This method will tap Travel policy button
	 * 
	 * @return TravelNEXTAboutDetailsService
	 */
	public TravelNEXTAboutDetailsService tapTravelPolicy() {
		travelNEXTPageProvider.getTravelNEXTAboutAppPage().tapTravelPolicy();
		return aboutDetailsService;
	}

	/**
	 * This method will tap Privacy policy button
	 * 
	 * @return TravelNEXTAboutDetailsService
	 */
	public TravelNEXTAboutDetailsService tapPrivacyPolicy() {
		travelNEXTPageProvider.getTravelNEXTAboutAppPage().tapPrivacyPolicy();
		return aboutDetailsService;
	}
}
