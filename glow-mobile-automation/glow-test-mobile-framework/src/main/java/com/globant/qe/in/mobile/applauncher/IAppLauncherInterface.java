package com.globant.qe.in.mobile.applauncher;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

@Component
public interface IAppLauncherInterface {
	public AppiumDriver<MobileElement> initiateDriver();
}
