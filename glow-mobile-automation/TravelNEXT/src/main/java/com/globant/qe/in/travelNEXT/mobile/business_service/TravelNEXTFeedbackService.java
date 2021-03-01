package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTFeedbackService implements IMobileService<TravelNEXTFeedbackService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTSideBarService sidebarService;

	@Autowired
	TravelNEXTFeedbackSuccessService feedbackSuccessService;

	/**
	 * This method will load the Feedback Service page
	 * 
	 * @return TravelNEXTFeedbackService
	 */
	@Override
	public TravelNEXTFeedbackService loadPage() {
		travelNEXTPageProvider.getTravelNEXTFeedbackPage();
		return this;
	}

	/**
	 * This method will provide Feedback
	 * 
	 * @return TravelNEXTFeedbackSuccessService
	 */
	public TravelNEXTFeedbackSuccessService provideFeedback() {
		travelNEXTPageProvider.getTravelNEXTFeedbackPage().submitFeedback();
		return feedbackSuccessService;
	}

	/**
	 * This method will tap on back button
	 * 
	 * @return TravelNEXTFeedbackService
	 */
	public TravelNEXTFeedbackService tapBackButton() {
		travelNEXTPageProvider.getTravelNEXTFeedbackPage().tapBackBtn();
		return this;
	}

	/**
	 * This method will Discard the feedback
	 * 
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService discardGloberFeedback() {
		travelNEXTPageProvider.getTravelNEXTFeedbackPage().discardFeedback();
		return sidebarService;
	}

	/**
	 * This method will provide false feedback
	 * 
	 * @return TravelNEXTFeedbackService
	 */
	public TravelNEXTFeedbackService falseFeedback() {
		travelNEXTPageProvider.getTravelNEXTFeedbackPage().provideFlasefeedback();
		return this;
	}

	/**
	 * This method will cancel the feedback
	 * 
	 * @return TravelNEXTFeedbackService
	 */
	public TravelNEXTFeedbackService cancelFeedBack() {
		travelNEXTPageProvider.getTravelNEXTFeedbackPage().clickCancelFeedback();
		return this;
	}

	/**
	 * This method will send the feedback
	 * 
	 * @return TravelNEXTFeedbackSuccessService
	 */
	public TravelNEXTFeedbackSuccessService sendFeedback() {
		travelNEXTPageProvider.getTravelNEXTFeedbackPage().tapSendFeedbackButton();
		return feedbackSuccessService;
	}

}
