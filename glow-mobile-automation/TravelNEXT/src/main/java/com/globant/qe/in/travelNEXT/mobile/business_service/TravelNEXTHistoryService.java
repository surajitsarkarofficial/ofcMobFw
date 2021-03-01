package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTHistoryService implements IMobileService<TravelNEXTHistoryService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTHomeService travelNEXTHomeService;

	/**
	 *
	 * This method will load the History Service page
	 * 
	 * @return TravelNEXTHistoryService
	 */
	@Override
	public TravelNEXTHistoryService loadPage() {
		travelNEXTPageProvider.getTravelNEXTHistoryPage();
		return this;
	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTHistoryPage().tapBackBtn();
		return travelNEXTHomeService;
	}

}
