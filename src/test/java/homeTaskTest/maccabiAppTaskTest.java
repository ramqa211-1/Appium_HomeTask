package homeTaskTest;
import com.bluenile.testkit.base.BaseTest;
import com.bluenile.testkit.locators.InstgramAppLocators;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import static com.bluenile.testkit.pages.desktop.BasePageObject.*;


public class maccabiAppTaskTest extends BaseTest {



    @Test(groups = {})
    public void instgramLoginTest() throws Exception {
        InstgramAppLocators instgramAppLocators=new InstgramAppLocators();
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
        AndroidElement logInAnotherAccount = (AndroidElement) driver.findElement(instgramAppLocators.logInAnotherAccount);
        tapElement(logInAnotherAccount);
        AndroidElement emailField = (AndroidElement) driver.findElement(instgramAppLocators.emailField);
        tapElement(emailField);
        emailField.sendKeys(emailFieldText);
        AndroidElement logInButton = (AndroidElement) driver.findElement(instgramAppLocators.logInButton);
        tapElement(logInButton);
    }
}


