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
            log(Status.INFO, "Typing text on search field");
            typeTextOnTextFieldGlobal(searchField, "I Will Survive - Alien song");
            log(Status.INFO, "Clicking on mirror glass icon");
            click(mirrorGlassIconButton);
            log(Status.INFO, "Applying video filters");
            click(filterButton);
            click(videoButton);
            click(filterButton);
            click(ViewCountButton);
            log(Status.INFO, "Scrolling to specific video link");
            scrollToElementAction(specificVideoLink);
            log(Status.INFO, "Fetching user channel name");
            String userChannelName = getUserChannelName();
            System.out.println( "The user channel name is : "+ userChannelName+"");
            log(Status.INFO, "Clicking on specific video link");
            click(specificVideoLink);
            log(Status.INFO, "Skipping ad if present");
            clickSkipAdIfPresentIfSoClickOnIt();
            log(Status.INFO, "Scrolling to show more button");
            scrollToElementAction(showMoreButton);
            log(Status.INFO, "Clicking on show more button");
            clickShowMoreButton();
            log(Status.INFO, "Fetching artist's name");
            String ArtistsName = getArtistsName();
            System.out.println("The artist's  name is : "+ ArtistsName+"");
        }

}
