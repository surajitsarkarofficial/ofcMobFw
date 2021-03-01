package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTPassportDetailsService implements IMobileService<TravelNEXTPassportDetailsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	/**
	 * This method will load the Passport Details Service page
	 * 
	 * @return TravelNEXTPassportDetailsService
	 */
	@Override
	public TravelNEXTPassportDetailsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTPassportDetailsPage();
		return this;
	}

	/**
	 * This method will hide the passport details
	 * 
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService hidePassportDetails() {
		travelNEXTPageProvider.getTravelNEXTPassportDetailsPage().hidePassportDetails();
		return sidebarService;
	}
}
