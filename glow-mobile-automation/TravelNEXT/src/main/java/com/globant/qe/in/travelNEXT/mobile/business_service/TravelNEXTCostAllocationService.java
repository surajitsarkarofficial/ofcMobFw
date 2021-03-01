package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTCostAllocationService implements IMobileService<TravelNEXTCostAllocationService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;
	
	@Autowired
	TravelNEXTHomeService travelNEXTHomeService;
	
	/**
	 *
	 * This method will load the cost allocation page
	 * 
	 * @return TravelNEXTCostAllocationService
	 */
	@Override
	public TravelNEXTCostAllocationService loadPage() {
		travelNEXTPageProvider.getTravelNEXTCostAllocationPage();
		return this;
	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTCostAllocationPage().tapOnBackBtn();
		return travelNEXTHomeService;
	}
}
