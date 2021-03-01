package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTHomeService implements IMobileService<TravelNEXTHomeService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sideBarService;

	/**
	 * This method will load the Home Service page
	 * 
	 * @return TravelNEXTHomeService
	 */
	@Override
	public TravelNEXTHomeService loadPage() {
		travelNEXTPageProvider.getTravelNEXTHomePage();
		return this;
	}

	/**
	 * This method will tap on hamburger menu
	 * 
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService tapHamburger() {
		travelNEXTPageProvider.getTravelNEXTHomePage().tapHamburger();
		return sideBarService.loadPage();
	}

	/**
	 * This method will tap on Ongoing button
	 * 
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService goToOngoingTrips() {
		travelNEXTPageProvider.getTravelNEXTHomePage().tapOngoingTrip();
		return this;
	}

	/**
	 * This method will tap on Upcoming button
	 * 
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService goToUpcomingTrips() {
		travelNEXTPageProvider.getTravelNEXTHomePage().tapUpcomingTrips();
		return this;
	}

	/**
	 * This method will tap on Older button
	 * 
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService goToOlderTrips() {
		travelNEXTPageProvider.getTravelNEXTHomePage().tapOlderTrips();
		return this;
	}

}
