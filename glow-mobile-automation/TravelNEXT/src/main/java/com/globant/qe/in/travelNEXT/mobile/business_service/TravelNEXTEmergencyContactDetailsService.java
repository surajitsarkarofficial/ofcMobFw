package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTEmergencyContactDetailsService
		implements IMobileService<TravelNEXTEmergencyContactDetailsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTEmergencyContactsService emergencyContactsService;

	/**
	 * This method will load Emergency Contact Page
	 * 
	 * @return TravelNEXTEmergencyContactDetailsService
	 */
	@Override
	public TravelNEXTEmergencyContactDetailsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTEmergencyContactDetailsPage();
		return this;
	}

	/**
	 * This method will tap on back button
	 * 
	 * @return TravelNEXTEmergencyContactsService
	 */
	public TravelNEXTEmergencyContactsService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTEmergencyContactDetailsPage().tapBackButton();
		return emergencyContactsService;
	}

}