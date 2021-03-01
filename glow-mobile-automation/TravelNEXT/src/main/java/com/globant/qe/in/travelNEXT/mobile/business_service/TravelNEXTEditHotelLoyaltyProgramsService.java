package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTEditHotelLoyaltyProgramsService implements IMobileService<TravelNEXTEditHotelLoyaltyProgramsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTViewHotelLoyaltyProgramsService travelNEXTViewHotelLoyaltyProgramsService;
	
	/**
	 * This method will load the Edit Hotel Loyalty Programs Service page
	 * 
	 * @return TravelNEXTEditHotelLoyaltyProgramsService
	 */
	@Override
	public TravelNEXTEditHotelLoyaltyProgramsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTEditHotelLoyaltyProgramsPage();
		return this;
	}

	/**
	 * This method will tap on back button
	 * 
	 * @return TravelNEXTViewHotelLoyaltyProgramsService
	 */
	public TravelNEXTViewHotelLoyaltyProgramsService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTEditHotelLoyaltyProgramsPage().tapBackBtn();
		return travelNEXTViewHotelLoyaltyProgramsService;
	}

}
