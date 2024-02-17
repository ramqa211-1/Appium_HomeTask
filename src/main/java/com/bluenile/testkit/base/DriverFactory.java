package com.bluenile.testkit.base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


    public class DriverFactory {
        private static DriverFactory instance;
        private ThreadLocal<AndroidDriver<MobileElement>> driverThreadLocal = new ThreadLocal<>();

        private DriverFactory() {
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

        public AndroidDriver<MobileElement> getDriver(DesiredCapabilities capabilities) {
            if (driverThreadLocal.get() == null) {
                initializeDriver(capabilities);
            }
            return driverThreadLocal.get();
        }

        private void initializeDriver(DesiredCapabilities capabilities) {
            try {
                AndroidDriver<MobileElement> driverInstance = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                driverThreadLocal.set(driverInstance);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void quitDriver() {
            if (driverThreadLocal.get() != null) {
                driverThreadLocal.get().quit();
                driverThreadLocal.remove();
            }
        }
    }

