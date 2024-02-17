package homeTaskTest;
import com.bluenile.testkit.base.BaseTest;
import com.bluenile.testkit.locators.InstagramAppLocators;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static com.bluenile.testkit.pages.BasePageObject.*;


public class maccabiAppTaskTest extends BaseTest {


    @Severity(SeverityLevel.NORMAL)
    @Description ("check app log in, swipe action , get text. assert text and tap action")
    @Story("test verification")

    @Test(groups = {})
    public void instagramLoginTest() throws Exception {
        InstagramAppLocators instgramAppLocators=new InstagramAppLocators();
        String emailFieldText = "israelIsraeli";
        Thread.sleep(10000);
        AndroidElement profileButtonBottomMenu = (AndroidElement) driver.findElement(instgramAppLocators.profileButtonBottomMenu);
        tapElement(profileButtonBottomMenu);
        AndroidElement storyHighlightsHeader = (AndroidElement) driver.findElement(instgramAppLocators.storyHighlightsHeader);
        String storyHighlightsHeaderText= getTextFromElement(storyHighlightsHeader);
        assertContains(storyHighlightsHeaderText,"Story highlights");
        AndroidElement menuSide = (AndroidElement) driver.findElement(instgramAppLocators.menuSide);
        tapElement(menuSide);
        AndroidElement settingsPrivacyButton = (AndroidElement) driver.findElement(instgramAppLocators.settingsPrivacyButton);
        tapElement(settingsPrivacyButton);
        swipeDown();
        swipeDown();
        AndroidElement logoutAllAccounts = (AndroidElement) driver.findElement(instgramAppLocators.logoutAllAccounts);
        tapElement(logoutAllAccounts);
        AndroidElement logOut = (AndroidElement) driver.findElement(instgramAppLocators.logOut);
        tapElement(logOut);
        Thread.sleep(10000);
        AndroidElement logInAnotherAccount = (AndroidElement) driver.findElement(instgramAppLocators.logInAnotherAccount);
        tapElement(logInAnotherAccount);
        AndroidElement emailField = (AndroidElement) driver.findElement(instgramAppLocators.emailField);
        tapElement(emailField);
        emailField.sendKeys(emailFieldText);
        AndroidElement logInButton = (AndroidElement) driver.findElement(instgramAppLocators.logInButton);
        tapElement(logInButton);
    }

    @Test(groups = {})
    public void instagramInValidLoginTest() throws Exception {
        InstagramAppLocators instgramAppLocators=new InstagramAppLocators();
        String emailFieldText = "israelIsraeli";
        String passwordText = "";
        Thread.sleep(10000);
        AndroidElement profileButtonBottomMenu = (AndroidElement) driver.findElement(instgramAppLocators.profileButtonBottomMenu);
        tapElement(profileButtonBottomMenu);
        AndroidElement storyHighlightsHeader = (AndroidElement) driver.findElement(instgramAppLocators.storyHighlightsHeader);
        String storyHighlightsHeaderText= getTextFromElement(storyHighlightsHeader);
        assertContains(storyHighlightsHeaderText,"Story highlights");
        AndroidElement menuSide = (AndroidElement) driver.findElement(instgramAppLocators.menuSide);
        tapElement(menuSide);
        AndroidElement settingsPrivacyButton = (AndroidElement) driver.findElement(instgramAppLocators.settingsPrivacyButton);
        tapElement(settingsPrivacyButton);
        swipeDown();
        swipeDown();
        AndroidElement logoutAllAccounts = (AndroidElement) driver.findElement(instgramAppLocators.logoutAllAccounts);
        tapElement(logoutAllAccounts);
        AndroidElement logOut = (AndroidElement) driver.findElement(instgramAppLocators.logOut);
        tapElement(logOut);
        Thread.sleep(10000);
        AndroidElement logInAnotherAccount = (AndroidElement) driver.findElement(instgramAppLocators.logInAnotherAccount);
        tapElement(logInAnotherAccount);
        AndroidElement emailField = (AndroidElement) driver.findElement(instgramAppLocators.emailField);
        tapElement(emailField);
        emailField.sendKeys(emailFieldText);
        AndroidElement passWordField = (AndroidElement) driver.findElement(instgramAppLocators.passWordField);
        tapElement(passWordField);
        emailField.sendKeys(passwordText);
        AndroidElement logInButton = (AndroidElement) driver.findElement(instgramAppLocators.logInButton);
        tapElement(logInButton);
        AndroidElement errorMessageLogin = (AndroidElement) driver.findElement(instgramAppLocators.errorMessageLogin);
        String errorMessageLoginText= getTextFromElement(errorMessageLogin);
        assertContains(errorMessageLoginText,"Enter your password to log in");
    }
}


