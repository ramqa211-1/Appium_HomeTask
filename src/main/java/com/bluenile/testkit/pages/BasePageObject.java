package com.bluenile.testkit.pages;
import com.bluenile.testkit.base.BaseTest;
import com.bluenile.testkit.locators.InstagramAppLocators;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class BasePageObject extends BaseTest {
    static InstagramAppLocators instgramAppLocators = new InstagramAppLocators();

    public static void tapElement(AndroidElement element) {
        Duration timeout = Duration.ofSeconds(10);
        new WebDriverWait(driver, 15000)
                .until(ExpectedConditions.visibilityOf(element));
        new TouchAction(driver)
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .perform();
    }

    public static void swipeDown() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int starty = (int) (height * 0.8);
        int endy = (int) (height * 0.2);
        int x = width / 2;

        new TouchAction<>(driver)
                .press(PointOption.point(x, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, endy))
                .release()
                .perform();
    }

    public static String getTextFromElement(AndroidElement element) {
        return element.getText();
    }
    public static void assertContains(String currentTXT, String containsTXT) {
        String message = "The Text: " + containsTXT + " Is Not Appears In: " + currentTXT + " Text.";
        Assert.assertTrue(currentTXT.contains(containsTXT), message);
    }
}