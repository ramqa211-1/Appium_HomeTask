package homeTaskTest;

import com.bluenile.testkit.base.BaseTest;
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
        String emailFieldText = "israelIsraeli";

        AndroidElement profileButtonBottomMenu = (AndroidElement) driver.findElementById("com.instagram.android:id/tab_avatar");
        tapElement(profileButtonBottomMenu);
        AndroidElement menuSide = (AndroidElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Options\"]");
        tapElement(menuSide);
        AndroidElement settingsPrivacyButton = (AndroidElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Settings and privacy\"]");
        String settingsPrivacyButtonText= getTextFromElement(settingsPrivacyButton);
        assertContains(settingsPrivacyButtonText,"Settings and privacy");
        tapElement(settingsPrivacyButton);
        swipeDown();
        swipeDown();
        AndroidElement logoutAllAccounts = (AndroidElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Log out all accounts. Logs out all accounts\"]");
        tapElement(logoutAllAccounts);
        AndroidElement logOut = (AndroidElement) driver.findElementById("com.instagram.android:id/bb_primary_action_container");
        tapElement(logOut);
        AndroidElement logInAnotherAccount = (AndroidElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Log into another account\"]/android.view.ViewGroup");
        tapElement(logInAnotherAccount);
        AndroidElement emailField = (AndroidElement) driver.findElementByXPath("//android.widget.EditText[@text=\"ramivelestal\"]");
        tapElement(emailField);
        emailField.sendKeys(emailFieldText);

        AndroidElement logInButton = (AndroidElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Log in\"]/android.view.ViewGroup");
        tapElement(logInButton);

    }
}


