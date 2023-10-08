package homeTaskTest;

import com.aventstack.extentreports.Status;
import com.bluenile.testkit.base.AssertMethod;
import com.bluenile.testkit.pages.desktop.YoutubePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.bluenile.testkit.base.BrowserDriverFactory.getDriver;

public class aiOlaTaskTest extends YoutubePage {





    @Test(groups = {})
    public void aiOlaTest() {


        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        String demoSiteUrl = "https://www.saucedemo.com/";
        log(Status.INFO, "Navigating to  site");
        getDriver().get(demoSiteUrl);
        WebElement typeUserName = getDriver().findElement(userNameField);
        typeUserName = wait.until(ExpectedConditions.elementToBeClickable(userNameField));
        typeUserName.sendKeys("standard_user");
        WebElement passwordField = getDriver().findElement(passWordField);
        passwordField.sendKeys("secret_sauce");
        getDriver().findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(getDriver().findElement(itemNumberBuInventory)));
        List<WebElement> invetoryItems = getDriver().findElements(itemNumberBuInventory);


        AssertMethod.assertTrue(invetoryItems.size() == 6);
        List<WebElement> invetoryItemsDescription = getDriver().findElements(inventoryItemDescription);

        List<String> itemNames = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Onesie", "Test.allTheThings");

        for (int i = 0; i < invetoryItemsDescription.size(); i++) {
            String actualText = invetoryItemsDescription.get(i).getText();
            Assert.assertTrue(actualText.contains(itemNames.get(i)),
                    "Expected text not found in actual text at index " + i);
        }


        List<String> invetoryItemsDescriptionText = Arrays.asList(
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection",
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."
        );
        List<WebElement> actualDescriptionsFromPage = getDriver().findElements(inventoryItemDescription);


        for (int i = 0; i < actualDescriptionsFromPage.size(); i++) {
            String actualText = actualDescriptionsFromPage.get(i).getText();
            Assert.assertTrue(actualText.contains(invetoryItemsDescriptionText.get(i)),
                    "Expected text not found in actual text at index " + i);
        }

        List<String> itemPrices = Arrays.asList(
                "$29.99",
                "$9.99",
                "$15.99",
                "$49.99",
                "$7.99",
                "$15.99"
        );
        for (int i = 0; i < invetoryItems.size(); i++) {
            String actualText = invetoryItems.get(i).getText();
            Assert.assertTrue(actualText.contains(itemPrices.get(i)),
                    "Expected text not found in actual text at index " + i);
        }

    }
}




