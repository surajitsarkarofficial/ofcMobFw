package com.globant.qe.in.mobile.OSUtils;

import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

@Service
public class iOSService {
    AppiumDriver<MobileElement> driver;

    @Autowired
    public iOSService(AbstractMobileBasePage abstractMobileBasePage){
        this.driver = abstractMobileBasePage.getMobileDriver();
    }

    @SuppressWarnings("rawtypes")
	public void swipeControlCenter(double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int anchor, startPoint, endPoint;
        anchor = (int) (size.width * anchorPercentage);
        startPoint = (int) (size.height * startPercentage);
        endPoint = (int) (size.height * finalPercentage);
        new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(Duration.ofMillis(duration)))
                .moveTo(point(anchor, endPoint)).release().perform();
    }

    /****** Usage *******/
    public void enableBluetooth(MobileElement element) throws Exception {
        this.swipeControlCenter(1, 0.4, 0.5, 2000);
        if (!this.isBluetoothEnabled(element)) {
            element.click();
        }
        this.swipeControlCenter(0,0.4,0.5,2000);
    }


    public void disableBluetooth(MobileElement element) throws Exception{
        this.swipeControlCenter(1, 0.4, 0.5, 2000);
        if (this.isBluetoothEnabled(element)) {
           element.click();
    }
        this.swipeControlCenter(0,0.4,0.5,2000);
    }

    public boolean isBluetoothEnabled(MobileElement element) {
        return element.getAttribute("value").equals("1");
    }
    /*******************/

    // Add for Wifi, Aeroplane Mode, Location Services, etc.
}
