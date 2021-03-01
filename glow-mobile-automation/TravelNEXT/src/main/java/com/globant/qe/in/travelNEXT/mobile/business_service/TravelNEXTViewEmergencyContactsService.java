package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTViewEmergencyContactsService implements IMobileService<TravelNEXTViewEmergencyContactsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTEmergencyContactsService emergencyContactService;

	/**
	 * This method will load the view Emergency Contacts Page
	 * 
	 * @return TravelNEXTViewEmergencyContactsService
	 */
	@Override
	public TravelNEXTViewEmergencyContactsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTViewEmergencyContactsPage();
		return this;
	}

	/**
	 * This method will navigate back to Emergency Contact Page
	 * 
	 * @return TravelNEXTEmergencyContactsService
	 */
	public TravelNEXTEmergencyContactsService navigateBackToEmergecnyContactPage() {
		travelNEXTPageProvider.getTravelNEXTEditEmergencyContactsPage().tapBackBtn();
		return emergencyContactService;
	}

}
