package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTAddHotelLoyaltyProgramsService implements IMobileService<TravelNEXTAddHotelLoyaltyProgramsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTHotelLoyaltyProgramsService travelNEXTHotelLoyaltyProgramsService;
	
	/**
	 * 
	 * This method will load the Add Hotel Loyalty Programs Service page
	 * 
	 * @return TravelNEXTAddHotelLoyaltyProgramsService
	 */
	@Override
	public TravelNEXTAddHotelLoyaltyProgramsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTAddHotelLoyaltyProgramsPage();
		return this;
	}
	
	/**
	 * This method will tap on back button
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsService
	 */
	public TravelNEXTHotelLoyaltyProgramsService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTAddHotelLoyaltyProgramsPage().tapBackBtn();
		return travelNEXTHotelLoyaltyProgramsService;
	}


}
