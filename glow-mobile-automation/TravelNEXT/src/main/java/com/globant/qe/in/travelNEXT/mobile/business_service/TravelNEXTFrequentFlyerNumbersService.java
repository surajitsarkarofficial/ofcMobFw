package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTFrequentFlyerNumbersService implements IMobileService<TravelNEXTFrequentFlyerNumbersService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	/**
	 * This method will load the page
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersService
	 */
	@Override
	public TravelNEXTFrequentFlyerNumbersService loadPage() {
		travelNEXTPageProvider.getTravelNEXTFrequentFlyerNumbersPage();
		return this;
	}

	/**
	 * This method will hide the Frequent Flyer Numbers
	 * 
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService hideFrequentFlyerNumbers() {
		travelNEXTPageProvider.getTravelNEXTFrequentFlyerNumbersPage().hideFrequentFlyerNumbers();
		return sidebarService;
	}

}
