package com.bluenile.testkit.pages.desktop;

import com.bluenile.testkit.base.BrowserDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static com.bluenile.testkit.base.BrowserDriverFactory.getDriver;
import static com.bluenile.testkit.locators.ShopSiteLocators.*;

public class ShopSitePage extends BasePageObject {


    public static void navigateToSiteTestShop() {
        getDriver().get("https://www.saucedemo.com/");
    }

    public static void login(String username, String password) {
        lambdaWait(passWordField);
        getDriver().findElement(passWordField).sendKeys(password);
        getDriver().findElement(userNameField).sendKeys(username);
        getDriver().findElement(loginButton).click();
    }

    public static List<WebElement> getInventoryItems() {
        lambdaWait(itemNumberBuInventory);
        return getDriver().findElements(itemNumberBuInventory);
    }

    public static List<WebElement> getInventoryItemDescriptions() {
        return getDriver().findElements(inventoryItemDescription);
    }

    public static List<String> getItemNames() {
        return Arrays.asList("Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Onesie",
                "Test.allTheThings");
    }

    public static List<String> getItemDescriptions() {
        return Arrays.asList(
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection",
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."
        );
    }

    public static List<String> getItemPrices() {
        return Arrays.asList("$29.99", "$9.99", "$15.99", "$49.99", "$7.99", "$15.99");
    }
}
