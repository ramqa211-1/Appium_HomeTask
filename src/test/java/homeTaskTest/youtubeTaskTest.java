package homeTaskTest;

import com.bluenile.testkit.base.BaseTest;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;



public class youtubeTaskTest extends BaseTest {

        @Test(groups = {})
        public void instgramLoginTest() throws Exception {
            String username="";
            String password="";
                // Identify elements and perform login actions
                // Example: Locate username and password fields by resource-id and enter credentials
                AndroidElement usernameField = (AndroidElement) driver.findElementById("com.facebook.katana:id/login_username");
                AndroidElement passwordField = (AndroidElement) driver.findElementById("com.facebook.katana:id/login_password");
                AndroidElement loginButton = (AndroidElement) driver.findElementById("com.facebook.katana:id/login_login");

                usernameField.sendKeys(username);
                passwordField.sendKeys(password);
                loginButton.click();

                // Additional actions if needed, e.g., handling login success or failure
            }
        }


