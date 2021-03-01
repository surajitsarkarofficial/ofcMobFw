package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTTravelPolicyService implements IMobileService<TravelNEXTTravelPolicyService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTHomeService homeService;

	/**
	 * This method will load the Travel Policy Service page
	 * 
	 * @return TravelNEXTTravelPolicyService
	 */
	@Override
	public TravelNEXTTravelPolicyService loadPage() {
		travelNEXTPageProvider.getTravelNEXTFeedbackSuccessPage();
		return this;
	}

}
