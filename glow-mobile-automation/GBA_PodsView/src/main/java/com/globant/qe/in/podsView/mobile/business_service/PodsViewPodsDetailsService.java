package com.globant.qe.in.podsView.mobile.business_service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;

	import com.globant.qe.in.IMobileService;
	import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

	@Component
	@Lazy
	public class PodsViewPodsDetailsService implements IMobileService<PodsViewPodsDetailsService>{


		@Autowired
		PodsViewPageProvider podsViewPageProvider;


		/**
		 * This method will load the PodsView Pods Page
		 * @return PodsViewPodsDetailsService
		 */
		@Override
		public PodsViewPodsDetailsService loadPage() {
			podsViewPageProvider.getPodsViewPodsDetailsPage();
			return this;
		}
		
		/**
		 * This method will tap on Back button
		 * @return PodsViewPodsDetailsService
		 */
		public PodsViewPodsDetailsService tapBackButton() {
			podsViewPageProvider.getPodsViewPodsDetailsPage().tapOnBackButton();
			return this;
		}
		
		
		/**
		 * This method will tap on Home button
		 * @return PodsViewPodsDetailsService
		 */
		public PodsViewPodsDetailsService tapOnHome() {
			podsViewPageProvider.getPodsViewPodsDetailsPage().tapOnHome();
			return this;
		}
		
		
		/**
		 * This method will tap on Search Icon
		 * @return PodsViewPodsDetailsService
		 */
		public PodsViewPodsDetailsService tapOnSearchIcon() {
			podsViewPageProvider.getPodsViewPodsDetailsPage().tapOnSearchIcon();
			return this;
		}
		
		/**
		 * This method will tap on FeedBackHistory
		 * @return PodsViewPodsDetailsService
		 */
		public PodsViewPodsDetailsService tapOnFeedBackHistory() {
			podsViewPageProvider.getPodsViewPodsDetailsPage().tapOnFeedBackHistory();
			return this;
		}
	}