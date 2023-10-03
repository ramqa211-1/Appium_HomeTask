package homeTaskTest;

import com.aventstack.extentreports.Status;
import com.bluenile.testkit.pages.desktop.YoutubePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.bluenile.testkit.base.BrowserDriverFactory.getDriver;

public class tipaltiTaskTest extends YoutubePage {


    public static By hamburgerButton = By.xpath("//*[text()='Menu']");
    public static By menuListOptions = (By.xpath("//ul/li/a"));
    public static By kikaButtonFromMenu = By.xpath("//a[@href='kika.html' and text()='Kika']");
    public static By messageField = (By.id("message"));
    public static By nameField = (By.id("name"));
    public static By emailField = (By.id("email"));
    public static By sendButton = (By.cssSelector("[type*='submit']"));



    @Test(groups = {})
    public void tipaltiSiteTest() throws Exception {
        String tipaltiUrl = "http://qa-tipalti-assignment.tipalti.com/index.html";
        log(Status.INFO, "Navigating to tipalti site");
        openUrl(tipaltiUrl);
        click(hamburgerButton, 10);
        lambdaWait(menuListOptions);

        List<WebElement> links = getDriver().findElements(menuListOptions);

        List<String> texts = new ArrayList<>();
        List<String> hrefs = new ArrayList<>();

        for (WebElement link : links) {
            String text = link.getText();
            if (!"MENU".equalsIgnoreCase(text)) { // This line filters out "MENU"
                texts.add(text);
                hrefs.add(link.getAttribute("href"));
            }
            System.out.println("Texts: " + texts);
        }
        //checking kika value appears in menu
        Assert.assertTrue(texts.contains("Kika"));

        click(kikaButtonFromMenu, 10);
        scrollToElementAction(messageField);
        type("Hello", messageField);
        type("Yossi", nameField);
        type("test@test.com", emailField);
        click(sendButton, 10);

    }

}


