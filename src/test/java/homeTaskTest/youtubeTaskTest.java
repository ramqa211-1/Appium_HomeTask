package homeTaskTest;

import com.aventstack.extentreports.Status;
import com.bluenile.testkit.pages.desktop.YoutubePage;
import org.testng.annotations.Test;

import static com.bluenile.testkit.locators.YoutubeLocators.*;

public class youtubeTaskTest extends YoutubePage {

        @Test(groups = {})
        public void youtubeTest() throws Exception {
            String youTubeUrl = "https://www.youtube.com/";
            log(Status.INFO, "Navigating to YouTube site");
            openUrl(youTubeUrl);

        }

}
