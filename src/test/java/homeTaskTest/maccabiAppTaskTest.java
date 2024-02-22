package homeTaskTest;
import com.bluenile.testkit.base.BaseTest;
import com.bluenile.testkit.locators.InstagramAppLocators;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static com.bluenile.testkit.pages.BasePageObject.*;
import static com.bluenile.testkit.pages.instagramPage.*;
import static com.bluenile.testkit.pages.instagramPage.clickOnEmailFieldAndEnterText;


public class maccabiAppTaskTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description ("check app log in, swipe action , get text. assert text and tap action")
    @Story("test verification")

    @Test(groups = {})
    public void instagramLoginTest() throws Exception {
        InstagramAppLocators instagramAppLocators=new InstagramAppLocators();
        String emailFieldText = "israelIsraeli";
        Thread.sleep(10000);
        clickOnProfileButtonBottomMenu();
        AndroidElement storyHighlightsHeader = (AndroidElement) driver.findElement(instagramAppLocators.storyHighlightsHeader);
        String storyHighlightsHeaderText= getTextFromElement(storyHighlightsHeader);
        assertContains(storyHighlightsHeaderText,"Story highlights");
        clickOnMenuSideButton();
        clickOnSettingsPrivacyButton();
        swipeDown();
        swipeDown();
        clickOnLogoutAllAccounts();
        clickOnLogOutButton();
        Thread.sleep(10000);
        clickOnLogInAnotherAccount();
        clickOnEmailFieldAndEnterText(emailFieldText);
        clickOnLogInButton();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description ("check app log in if failed, swipe action , get text. assert text and tap action")
    @Story("test verification of failed login")
    @Test(groups = {})
    public void instagramInValidLoginTest() throws Exception {
        InstagramAppLocators instagramAppLocators=new InstagramAppLocators();
        String emailFieldText = "israelIsraeli";
        String passwordText = "";
        Thread.sleep(10000);
        clickOnProfileButtonBottomMenu();
        AndroidElement storyHighlightsHeader = (AndroidElement) driver.findElement(instagramAppLocators.storyHighlightsHeader);
        String storyHighlightsHeaderText= getTextFromElement(storyHighlightsHeader);
        assertContains(storyHighlightsHeaderText,"Story highlights");
        clickOnMenuSideButton();
        clickOnSettingsPrivacyButton();
        swipeDown();
        swipeDown();
        clickOnLogoutAllAccounts();
        clickOnLogOutButton();
        Thread.sleep(10000);
        clickOnLogInAnotherAccount();
        clickOnEmailFieldAndEnterText(emailFieldText);
        clickOnPasswordFieldAndEnterText(passwordText);
        clickOnLogInButton();
        AndroidElement errorMessageLogin = (AndroidElement) driver.findElement(instagramAppLocators.errorMessageLogin);
        String errorMessageLoginText= getTextFromElement(errorMessageLogin);
        assertContains(errorMessageLoginText,"Enter your password to log in");
    }
    //
}


