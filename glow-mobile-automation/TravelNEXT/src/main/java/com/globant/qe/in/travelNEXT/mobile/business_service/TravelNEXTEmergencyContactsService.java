package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTEmergencyContactsService implements IMobileService<TravelNEXTEmergencyContactsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTAddEmergencyContactsService addEmergencyContactsService;

	@Autowired
	TravelNEXTEmergencyContactDetailsService emergecnyContactDetailsService;

	/**
	 *
	 * This method will load the Emergency Contacts Service page
	 * 
	 * @return TravelNEXTEmergencyContactsService
	 */
	@Override
	public TravelNEXTEmergencyContactsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTEmergencyContactsPage();
		return this;
	}

	/**
	 * This method will tap on Add contact button
	 * 
	 * @return TravelNEXTAddEmergencyContactsService
	 */
	public TravelNEXTAddEmergencyContactsService tapAddContactBtn() {
		travelNEXTPageProvider.getTravelNEXTEmergencyContactsPage().tapAddButton();
		return addEmergencyContactsService;
	}

	/**
	 * This method will hide Emergency Contacts Page
	 * 
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService hideEmergencyContacts() {
		travelNEXTPageProvider.getTravelNEXTEmergencyContactsPage().hideEmergencyContactDetails();
		return sidebarService;
	}

	/**
	 * This method will tap on Emergency Contact Card
	 * 
	 * @param contactName
	 * @return TravelNEXTEmergencyContactDetailsService
	 */
	public TravelNEXTEmergencyContactDetailsService tapOnEmergencyContactCard(String contactName) {
		travelNEXTPageProvider.getTravelNEXTEmergencyContactsPage().tapEmergencyContactCard(contactName);
		return emergecnyContactDetailsService;
	}

}
