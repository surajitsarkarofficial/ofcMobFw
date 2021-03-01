package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTHotelLoyaltyProgramsService implements IMobileService<TravelNEXTHotelLoyaltyProgramsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	/**
	 * This method will load the Hotel Loyalty Programs Service page
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsService
	 */
	@Override
	public TravelNEXTHotelLoyaltyProgramsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTHotelLoyaltyProgramsPage();
		return this;
	}

	/**
	 * This method will hide the Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService hideHotelLoyaltyPrograms() {
		travelNEXTPageProvider.getTravelNEXTHotelLoyaltyProgramsPage().hideHotelLoyaltyPrograms();
		return sidebarService;
	}

}
