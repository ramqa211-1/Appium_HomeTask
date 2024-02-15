package com.bluenile.testkit.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
    private static DriverFactory instance;
    private ThreadLocal<AndroidDriver<MobileElement>> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {
        // private constructor to enforce Singleton pattern
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }
        return instance;
    }

    public AndroidDriver<MobileElement> getDriver() {
        if (driverThreadLocal.get() == null) {
            initializeDriver();
        }
        return driverThreadLocal.get();
    }

    private void initializeDriver() {
        // You can initialize the driver here if needed
    }

    public void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
