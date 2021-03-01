package com.globant.qe.in.podsView.mobile.business_service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;

	import com.globant.qe.in.IMobileService;
	import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

	@Component
	@Lazy
	public class PodsViewMemberService implements IMobileService<PodsViewMemberService>{


		@Autowired
		PodsViewPageProvider podsViewPageProvider;


		/**
		 * This method will load the PodsView Member Page
		 * @return PodsViewMemberService
		 */
		@Override
		public PodsViewMemberService loadPage() {
			podsViewPageProvider.getPodsViewMemberPage();
			return this;
		}
		
		/**
		 * This method will tap on Account
		 * @return PodsViewMemberService
		 */
		public PodsViewMemberService tapOnAccount() {
			podsViewPageProvider.getPodsViewMemberPage().tapOnBackButton();
			return this;
		}
	
	
	
	}
	