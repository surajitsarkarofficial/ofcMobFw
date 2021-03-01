package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTFeedbackSuccessService implements IMobileService<TravelNEXTFeedbackSuccessService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTHomeService homeService;

	/**
	 * This method will load the Feedback Success Service page
	 * @return TravelNEXTFeedbackSuccessService
	 */
	@Override
	public TravelNEXTFeedbackSuccessService loadPage() {
		travelNEXTPageProvider.getTravelNEXTFeedbackSuccessPage();
		return this;
	}

	/**
	 * This method will tap on back button
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService tapBackBtn() {
		travelNEXTPageProvider.getTravelNEXTFeedbackSuccessPage().tapBackBtn();
		return sidebarService;
	}

	/**
	 *  This method will tap on Done button
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService tapDoneBtn() {
		travelNEXTPageProvider.getTravelNEXTFeedbackSuccessPage().tapOnDoneBtn();
		return homeService;
	}
}
