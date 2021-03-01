package com.globant.qe.in.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.qe.in.ConfigParams;

@Component
public class BrowserLauncher {

    @Autowired
    ConfigParams configParams;

    WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            switch (BrowserTypes.valueOf(configParams.browserName.toUpperCase())) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.get(configParams.baseUrl);
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.get(configParams.baseUrl);
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.get(configParams.baseUrl);
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.get(configParams.baseUrl);
                    break;
                case SAFARI:
                    //TODO:
                    break;
                default:
                    throw new IllegalArgumentException(String.format("%s browser is not valid please provide valid browser name", configParams.browserName));
            }
        }
        return driver;
    }
}
