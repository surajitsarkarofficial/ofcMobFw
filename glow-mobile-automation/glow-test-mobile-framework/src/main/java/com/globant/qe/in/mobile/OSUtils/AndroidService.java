package com.globant.qe.in.mobile.OSUtils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

@Service
public class AndroidService {

    AppiumDriver<MobileElement> driver;

    @Autowired
    public AndroidService(AbstractMobileBasePage abstractMobileBasePage){
        this.driver = abstractMobileBasePage.getMobileDriver();
    }

    public void disableBluetooth(){
        String[] command = {"adb", "shell", "am", "start", "-a", "android.bluetooth.adapter.action.REQUEST_DISABLE"};
        try {
            Runtime.getRuntime().exec(command);
            Thread.sleep(5000);
            String currentContext = driver.getContext();
            driver.findElementById("android:id/button1").click();
            driver.context(currentContext);
            Thread.sleep(5000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (org.openqa.selenium.NoSuchElementException ignored){}
    }

    public void enableBluetooth(){
        String[] command = {"adb", "shell", "am", "start", "-a", "android.bluetooth.adapter.action.REQUEST_ENABLE"};
        try {
            Runtime.getRuntime().exec(command);
            Thread.sleep(5 * 1000);
            String currentContext = driver.getContext();
            driver.findElementById("android:id/button1").click();
            driver.context(currentContext);
            Thread.sleep(30 * 1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (org.openqa.selenium.NoSuchElementException ignored){}
    }
}
