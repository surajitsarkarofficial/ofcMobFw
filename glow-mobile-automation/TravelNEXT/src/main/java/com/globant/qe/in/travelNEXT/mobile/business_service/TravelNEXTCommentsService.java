package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTCommentsService implements IMobileService<TravelNEXTCommentsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTHomeService travelNEXTHomeService;

	/**
	 *
	 * This method will load the Comments Service page
	 * 
	 * @return TravelNEXTCommentsService
	 */
	@Override
	public TravelNEXTCommentsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTCommentsPage();
		return this;
	}

	/**
	 * This method will tap on Back button
	 * 
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTCommentsPage().tapBackBtn();
		return travelNEXTHomeService;
	}

}
