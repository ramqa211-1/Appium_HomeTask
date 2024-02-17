package homeTaskTest;

import com.bluenile.testkit.base.BaseTest;
import com.bluenile.testkit.locators.InstgramAppLocators;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class youtubeTaskTest extends BaseTest {

    public static void tapElement(AndroidElement element) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(ElementOption.element(element)).perform();
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

    public static void sendTextToField( String text, String elementId) {
        AndroidElement textField = driver.findElementById(elementId);
        textField.sendKeys(text);
    }


    public static String getTextFromElement(AndroidElement element) {
            return element.getText();
    }
    public static void assertContains(String currentTXT, String containsTXT) {
        String message = "The Text: " + containsTXT + " Is Not Appears In: " + currentTXT + " Text.";
        Assert.assertTrue(currentTXT.contains(containsTXT), message);
    }

    @Test(groups = {})
    public void instgramLoginTest() throws Exception {
        InstgramAppLocators instgramAppLocators=new InstgramAppLocators();
        String emailFieldText = "israelIsraeli";
        AndroidElement profileButtonBottomMenu = (AndroidElement) driver.findElement(instgramAppLocators.profileButtonBottomMenu);
        tapElement(profileButtonBottomMenu);
        AndroidElement menuSide = (AndroidElement) driver.findElement(instgramAppLocators.menuSide);
        tapElement(menuSide);
        AndroidElement settingsPrivacyButton = (AndroidElement) driver.findElement(instgramAppLocators.settingsPrivacyButton);
        String settingsPrivacyButtonText= getTextFromElement(settingsPrivacyButton);
        assertContains(settingsPrivacyButtonText,"Settings and privacy");
        tapElement(settingsPrivacyButton);
        swipeDown();
        swipeDown();
        AndroidElement logoutAllAccounts = (AndroidElement) driver.findElement(instgramAppLocators.logoutAllAccounts);
        tapElement(logoutAllAccounts);
        AndroidElement logOut = (AndroidElement) driver.findElement(instgramAppLocators.logOut);
        tapElement(logOut);
        AndroidElement logInAnotherAccount = (AndroidElement) driver.findElement(instgramAppLocators.logInAnotherAccount);
        tapElement(logInAnotherAccount);
        AndroidElement emailField = (AndroidElement) driver.findElement(instgramAppLocators.emailField);
        tapElement(emailField);
        emailField.sendKeys(emailFieldText);
        AndroidElement logInButton = (AndroidElement) driver.findElement(instgramAppLocators.logInButton);
        tapElement(logInButton);
    }
}


