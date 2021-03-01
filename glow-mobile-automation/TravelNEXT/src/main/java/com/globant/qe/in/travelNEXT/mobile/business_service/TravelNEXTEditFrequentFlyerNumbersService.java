package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTEditFrequentFlyerNumbersService implements IMobileService<TravelNEXTEditFrequentFlyerNumbersService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTViewFrequentFlyerNumbersService viewFrequentFlyerNumbersService;

	/**
	 * This method will load edit Frequent Flyer numbers Page
	 * 
	 * @return TravelNEXTEditFrequentFlyerNumbersService
	 */
	@Override
	public TravelNEXTEditFrequentFlyerNumbersService loadPage() {
		travelNEXTPageProvider.getTravelNEXTEditFrequentFlyerNumbersPage();
		return this;
	}

	/**
	 * This method will tap on back button
	 * 
	 * @return TravelNEXTViewFrequentFlyerNumbersService
	 */
	public TravelNEXTViewFrequentFlyerNumbersService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTEditFrequentFlyerNumbersPage().tapBackButton();
		return viewFrequentFlyerNumbersService;
	}

}

