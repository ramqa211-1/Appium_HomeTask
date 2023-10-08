package com.bluenile.testkit.pages.desktop;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static com.bluenile.testkit.base.BrowserDriverFactory.getDriver;
import static com.bluenile.testkit.locators.GlobalLocators.*;
import static com.bluenile.testkit.locators.ShopSiteLocators.*;

public class YoutubePage extends BasePageObject {




    public static String getFirstItemPriceGallery() {
        log(Status.INFO, "get item Price text From Page");
        return FindElementsGetText(galleryItemMainPrice, 0, 10);
    }

    public static String getUserChannelName() {
        WebElement text = getDriver().findElement(userChannelName);
        return text.getAttribute("innerHTML");
    }
    public static void clickShowMoreButton() throws InterruptedException {
        click(showMoreButton, 20);
    }

    public static String getArtistsName() {
        WebElement artistElement = getDriver().findElement(artistName);
        String artistName = artistElement.getAttribute("innerHTML");
        return artistName;
    }

    public static void clickSkipAdIfPresentIfSoClickOnIt() {
        List<WebElement> skipAdElements = getDriver().findElements(skidAdButton);
        for (WebElement element : skipAdElements) {
            if (element.isDisplayed()) {
                element.click();
            }
        }
    }

    public static void changeSliderGeneric(By locator, Integer offset) throws Exception {
        log(Status.INFO, "change the carat size slider button");
        moveSlider(locator, offset, false);
    }




    public static List<By> getDiamondShapeOptions() {
        log(Status.INFO, "array list for all the diamond shapes locators options from gallery");
        return Arrays.asList(
                galleryShapeFilterRoundButton, galleryShapeFilterPrincessButton, galleryShapeFilterEmeraldButton,
                galleryShapeFilterAsscherButton, galleryShapeFilterCushionButton, galleryShapeFilterMarquiseButton,
                galleryShapeFilterRadiantButton, galleryShapeFilterOvalButton, galleryShapeFilterPearButton,
                galleryShapeFilterHeartButton
        );
    }

    public static List<String> getShapeNames() {
        log(Status.INFO, "array list for all the diamond shapes names from the gallery");
        return Arrays.asList(
                "Round", "Princess", "Emerald", "Asscher", "Cushion", "Marquise", "Radiant", "Oval", "Pear", "Heart"
        );
    }



}