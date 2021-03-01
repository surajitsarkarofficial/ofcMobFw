package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTAddFrequentFlyerNumbersService
		implements IMobileService<TravelNEXTAddFrequentFlyerNumbersService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTFrequentFlyerNumbersService frequentFlyerNumbersService;

	/**
	 * This method will load add Frequent Flyer numbers Page
	 * 
	 * @return TravelNEXTAddFrequentFlyerNumbersService
	 */
	@Override
	public TravelNEXTAddFrequentFlyerNumbersService loadPage() {
		travelNEXTPageProvider.getTravelNEXTAddFrequentFlyerNumbersPage();
		return this;
	}

	/**
	 * This method will tap on back button
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersService
	 */
	public TravelNEXTFrequentFlyerNumbersService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTAddFrequentFlyerNumbersPage().tapBackButton();
		return frequentFlyerNumbersService;
	}

}
