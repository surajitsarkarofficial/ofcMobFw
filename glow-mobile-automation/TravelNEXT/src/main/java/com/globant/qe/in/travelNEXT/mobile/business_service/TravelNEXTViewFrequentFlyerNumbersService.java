package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTViewFrequentFlyerNumbersService implements IMobileService<TravelNEXTViewFrequentFlyerNumbersService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTFrequentFlyerNumbersService frequentFlyerNumbersService;

	/**
	 * This method will load view Frequent Flyer numbers Page
	 * 
	 * @return TravelNEXTViewFrequentFlyerNumbersService
	 */
	@Override
	public TravelNEXTViewFrequentFlyerNumbersService loadPage() {
		travelNEXTPageProvider.getTravelNEXTViewFrequentFlyerNumbersPage();
		return this;
	}

	/**
	 * This method will tap on back button
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersService
	 */
	public TravelNEXTFrequentFlyerNumbersService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTViewFrequentFlyerNumbersPage().tapBackButton();
		return frequentFlyerNumbersService;
	}

}

