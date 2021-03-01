package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTCreateTripService implements IMobileService<TravelNEXTCreateTripService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;
	
	@Autowired
	TravelNEXTCreateTripService travelNEXTCreateTripService;
	
	@Autowired
	TravelNEXTHomeService travelNEXTHomeService;
	
	/**
	 *
	 * This method will load the create page
	 * 
	 * @return TravelNEXTCreateTripService
	 */
	@Override
	public TravelNEXTCreateTripService loadPage() {
		travelNEXTPageProvider.getTravelNEXTCreateTripPage();
		return this;
	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTCreateTripPage().tapBackBtn();
		return travelNEXTHomeService;
	}


}
