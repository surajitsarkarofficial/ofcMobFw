package com.globant.qe.in.podsView.mobile.business_service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;

	import com.globant.qe.in.IMobileService;
	import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

	@Component
	@Lazy
	public class PodsViewSearchService implements IMobileService<PodsViewSearchService>{


		@Autowired
		PodsViewPageProvider podsViewPageProvider;

	

		/**
		 * This method will load the PodsView Search Page
		 * @return PodsViewSearchService
		 */
		@Override
		public PodsViewSearchService loadPage() {
			podsViewPageProvider.getPodsViewSearch();
			return this;
		}
		
		/**
		 * This method will tap on Back button
		 * @return PodsViewSearchService
		 */
		public PodsViewSearchService tapBackButton() {
			podsViewPageProvider.getPodsViewSearch().tapOnBackButton();
			return this;
		}
}
