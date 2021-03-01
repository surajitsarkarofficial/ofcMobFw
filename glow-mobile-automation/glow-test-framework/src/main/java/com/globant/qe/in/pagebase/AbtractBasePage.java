package com.globant.qe.in.pagebase;

import com.globant.qe.in.ConfigParams;
import com.globant.qe.in.browsers.BrowserLauncher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbtractBasePage {

    protected WebDriver driver;
    protected ConfigParams configParams;
    protected WebDriverWait wait;

    @Autowired
    public AbtractBasePage(BrowserLauncher browserLauncher, ConfigParams configParams) {
        this.driver = browserLauncher.getDriver();
        this.configParams = configParams;
        wait = new WebDriverWait(driver, configParams.maxSmallWait);
        PageFactory.initElements(driver, this);
    }

}
