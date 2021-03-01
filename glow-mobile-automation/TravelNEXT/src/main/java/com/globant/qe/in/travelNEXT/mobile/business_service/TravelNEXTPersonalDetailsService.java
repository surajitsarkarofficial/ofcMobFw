package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTPersonalDetailsService implements IMobileService<TravelNEXTPersonalDetailsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	/**
	 * This method will load the Personal Details Service page
	 * 
	 * @return TravelNEXTPersonalDetailsService
	 */
	@Override
	public TravelNEXTPersonalDetailsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTPersonalDetailsPage();
		return this;
	}

	/**
	 * This method will hide the personal details
	 * 
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService hidePersonalDetails() {
		travelNEXTPageProvider.getTravelNEXTPersonalDetailsPage().hidePersonalDetails();
		return sidebarService;
	}
}
