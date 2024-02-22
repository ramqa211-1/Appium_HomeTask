package com.bluenile.testkit.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestNew {
    protected static AndroidDriver<AndroidElement> driver;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.UDID, "93a5a6f7");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability("appPackage", "com.instagram.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.instagram.android.activity.MainTabActivity");


        try {
            if (driver == null) {
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }


}