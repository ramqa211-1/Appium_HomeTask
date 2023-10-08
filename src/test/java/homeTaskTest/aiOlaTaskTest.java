package homeTaskTest;

import com.aventstack.extentreports.Status;
import com.bluenile.testkit.pages.desktop.ShopSitePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class aiOlaTaskTest extends ShopSitePage {

    @Test(groups = {})
    public void aiOlaTest() {
        log(Status.INFO, "Navigating to the ShopSite...");
        navigateToSiteTestShop();

        log(Status.INFO, "Logging in with credentials...");
        login("standard_user", "secret_sauce");

        log(Status.INFO, "Getting inventory items...");
        List<WebElement> inventoryItems = ShopSitePage.getInventoryItems();
        Assert.assertTrue(inventoryItems.size() == 6);
        log(Status.INFO, "Validated number of inventory items.");

        List<WebElement> inventoryItemsDescription = getInventoryItemDescriptions();
        for (int i = 0; i < inventoryItemsDescription.size(); i++) {
            String actualText = inventoryItemsDescription.get(i).getText();
            Assert.assertTrue(actualText.contains(getItemNames().get(i)),
                    "Expected text not found in actual text at index " + i);
            log(Status.INFO, "Validated item name at index " + i + ".");
        }

        for (int i = 0; i < inventoryItemsDescription.size(); i++) {
            String actualText = inventoryItemsDescription.get(i).getText();
            Assert.assertTrue(actualText.contains(getItemDescriptions().get(i)),
                    "Expected description not found in actual text at index " + i);
            log(Status.INFO, "Validated item description at index " + i + ".");
        }

        for (int i = 0; i < inventoryItems.size(); i++) {
            String actualText = inventoryItems.get(i).getText();
            Assert.assertTrue(actualText.contains(getItemPrices().get(i)),
                    "Expected price not found in actual text at index " + i);
            log(Status.INFO, "Validated item price at index " + i + ".");
        }
    }
}



