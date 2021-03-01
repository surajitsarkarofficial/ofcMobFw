package com.globant.qe.in.podsView.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

@Component
@Lazy
public class PodsViewConstitutionService implements IMobileService<PodsViewConstitutionService>{


	@Autowired
	PodsViewPageProvider podsViewPageProvider;


	/**
	 * This method will load the PodsView Constitution Page
	 * @return PodsViewConstitutionService
	 */
	@Override
	public PodsViewConstitutionService loadPage() {
		podsViewPageProvider.getPodsViewConstitutionPage();
		return this;
	}
	
	/**
	 * This method will slide elements
	 * @return PodsViewConstitutionService
	 */
	public PodsViewConstitutionService sliderView() {
		podsViewPageProvider.getPodsViewConstitutionPage().slide();
		return this;
	}

}
