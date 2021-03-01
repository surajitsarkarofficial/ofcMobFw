package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTAboutAppService implements IMobileService<TravelNEXTAboutAppService> {
	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	/**
	 * This method will load the About TravelNEXT Page
	 * @return TravelNEXTAboutAppService
	 */
	@Override
	public TravelNEXTAboutAppService loadPage() {
		travelNEXTPageProvider.getTravelNEXTAboutAppPage();
		return this;
	}

	/**
	 * This method will tap on Back button
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService tapBackButton() {
		travelNEXTPageProvider.getTravelNEXTAboutAppPage().tapBackButton();
		return sidebarService;
	}
}
