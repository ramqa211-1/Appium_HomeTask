package com.bluenile.testkit.pages.desktop;

import com.aventstack.extentreports.Status;
import com.bluenile.testkit.base.BaseTest;
import com.bluenile.testkit.base.BrowserDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.bluenile.testkit.base.BrowserDriverFactory.getDriver;
import static java.lang.Thread.sleep;

public class BasePageObject extends BaseTest {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");



    public static void openUrl(String URL, int... optionalSleep) {
        log(Status.INFO, "Open URL: " + URL);
        refreshPage();
        getDriver().get(URL);
        //because the redirect link
        try {
            lambdaWaitUrl(URL);

        } catch (Exception e) {
            System.out.println("The Error: " + e + ".");
        }
        if (optionalSleep.length > 0) {
            try {
                sleep(optionalSleep[0]);
            } catch (Exception e) {
                System.out.println("The Error: " + e + ".");
            }
        }
    }

    //Find element using given locator
    protected static WebElement find(By locator, int... timeout) throws InterruptedException {
        lambdaWait(locator, timeout);
        try {
            return getDriver().findElement(locator);
        } catch (Exception e) {
            int count = 0;
            while (count < 10) {
                sleep(200);
                count++;
            }
            return getDriver().findElement(locator);
        }
    }

    protected static WebElement finds(By locator, int i) {
        while (true) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                return getDriver().findElements(locator).get(i);
            }
        }
    }


    //CLEAR INPUT FIELD
    public static void clear(By locator, int... timeout) throws InterruptedException {
        lambdaWait(locator, timeout);
        find(locator).clear();
    }

    //CLICK MAIN METHOD
    public static void click(By locator, int... timeout) throws InterruptedException {
        lambdaWait(locator, timeout);
        find(locator).click();
    }

    public void moveMouseToElementBy(By locator, int... timeout) {
        log(Status.INFO, "move to element " + locator);
        Actions action = new Actions(getDriver());
        BasePageObject.lambdaWait(locator, timeout);
        WebElement we = getDriver().findElement(locator);
        action.moveToElement(we).perform();
    }

    //CLICK BY INDEX MAIN METHOD
    public static void clicks(By locator, int i, int... timeout) {
        lambdaWait(locator, timeout);
        finds(locator, i).click();
    }

    //GET TEXT MAIN METHOD
    public static String getText(By locator, String... textToWait) {
        String textPage;
        if (textToWait.length > 0) {
            WebDriverWait mobile = new WebDriverWait(getDriver(), 30);
            mobile.until((WebDriver dr) ->
                    dr.findElement(locator).getText().contains(textToWait[0])
            );
        }
        lambdaWait(locator);
        textPage = getDriver().findElement(locator).getText();
        if (getDriver().findElements(locator).isEmpty()) {
            return "THE ELEMENT IS EMPTY";
        } else {
            return textPage;
        }
    }

    public static void typeTextOnTextFieldGlobal(By locator, String textToType )  {
        lambdaWait(locator);
        WebElement element = getDriver().findElement(locator);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().sendKeys(textToType).build().perform();
    }

    public static void type(String text, By locator, int... timeout) throws InterruptedException {
        BasePageObject.lambdaWait(locator, timeout);
        find(locator).sendKeys(text);
    }

    //** Get current URL core method with lambda wait for string contains in URL **//
    public static String getCurrentUrl(String... lambdaExpectedTxt) {
        if (lambdaExpectedTxt.length > 0) {
            lambdaWaitUrl(lambdaExpectedTxt[0]);
            String currentURL = (String) ((JavascriptExecutor) BrowserDriverFactory.getDriver()).executeScript("return window.location.href");
            log(Status.INFO, "Get Current URL: " + currentURL);
            return currentURL;
        } else {
            String currentURL = (String) ((JavascriptExecutor) BrowserDriverFactory.getDriver()).executeScript("return window.location.href");
            log(Status.INFO, "Get Current URL: " + currentURL);
            return currentURL;
        }
    }

    //Switch to another frame/iFrame by locator
    //The optionalSleep parameter allows you to add a hard sleep after switching to a frame (useful for screenshots for example)
    //This can save up lines of code in the tests - instead of writing "Thread.sleep(x)"
    public static void switchToFrame(By frameLocator, int... optionalSleep) throws InterruptedException {
        log(Status.INFO, "Switch To Frame " + frameLocator);
        lambdaWait(frameLocator, 30);
        getDriver().switchTo().frame(find(frameLocator));
        // Perform optional sleep after switching to the desired frame if parameter is passed
        if (optionalSleep.length > 0) {
            try {
                sleep(optionalSleep[0]);
            } catch (Exception e) {
                // Do nothing and handle exception silently
            }
        }
    }


    public static String FindElementsGetText(By locator, int num, int... timeout) {
        lambdaWait(locator, timeout);
        log(Status.INFO, "Clicking on element by locator: " + locator);
        WebElement text = BrowserDriverFactory.getDriver().findElements(locator).get(num);
        return text.getText();
    }

    public static void clickFindElements(By locator, int num) {
        lambdaWait(locator);
        log(Status.INFO, "Clicking on element by locator: " + locator);
        getDriver().findElements(locator).get(num).click();
    }

    public static void moveSlider(By sliderLocator, int offset, boolean isVertically) throws Exception {
        Actions move;
        Action action;
        WebElement slider;
        slider = getElement(sliderLocator);
        move = new Actions(getDriver());
        if (isVertically) {
            action = move.dragAndDropBy(slider, 0, offset).build();
        } else {
            action = move.dragAndDropBy(slider, offset, 0).build();
        }
        action.perform();
    }

    public static void refreshPage() {
        log(Status.INFO, "click on browser Refresh button");
        getDriver().navigate().refresh();
    }

    public void hoverMouseBy(By locator, int... timeout) throws Exception {
        log(Status.INFO, "hover over " + locator);
        Actions action = new Actions(getDriver());
        BasePageObject.lambdaWait(locator, timeout);
        WebElement we = getDriver().findElement(locator);
        action.moveToElement(we).build().perform();
    }

    public static void scrollDown() throws InterruptedException {
        log(Status.INFO, "scrollDown");
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,500)", "");
    }


    public String getCurrentPageSource() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) BrowserDriverFactory.getDriver();
        // Get all the text from the page using JavaScript
        String pageText = (String) jsExecutor.executeScript("return document.body.innerText");
        while (true) {
            JavascriptExecutor js = (JavascriptExecutor) BrowserDriverFactory.getDriver();
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                return pageText;
            }
        }
    }

    public static void scrollTopPage() {
        log(Status.INFO, "scroll top page");
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollTo(0, 0);", "");
        while (true) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                return;
            }
        }
    }

    public static void pageDownScroll(String number) {
        log(Status.INFO, "page scroll down");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        log(Status.INFO, "Scroll down page with java script to specific place");
        js.executeScript("window.scrollBy(0," + number + ")");
        while (true) {
            log(Status.INFO, "JavaScript Wait for page to be loaded");
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                return;
            }
        }
    }

    public static WebElement getElement(By locator, int... timeOut) {
        WebElement element;
        lambdaWait(locator, timeOut);
        element = getDriver().findElement(locator);
        return element;
    }

    public static void JSClickLocator(By locator, int... timeout) {
        lambdaWait(locator, timeout);
        WebElement element = getDriver().findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


    public static void sendText(By locator, String text, int... timeout) {
        BasePageObject.lambdaWait(locator, timeout);
        getDriver().findElement(locator).sendKeys(text);
    }

    public static void overwriteWebFieldText(By fieldElement, String stringToSend, int... timeOut) {
        lambdaWait(fieldElement, timeOut);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10); // 10 seconds timeout
        wait.until(ExpectedConditions.elementToBeClickable(fieldElement));

        WebElement toClear = getDriver().findElement(fieldElement);
        toClear.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        toClear.sendKeys(Keys.DELETE);
        getDriver().findElement(fieldElement).sendKeys(stringToSend);
    }

    public static void hitEnter(By locator, int... timeOut) {
        lambdaWait(locator, timeOut);
        getElement(locator).sendKeys(Keys.RETURN);
    }

    //** SCROLL TO ELEMENT CORE METHOD **//
    public static void scrollToElementAction(By locator, String... textToWait) {
        Actions actions = new Actions(getDriver());
        lambdaWait(locator);
        try {
            if (textToWait.length > 0) {
                WebDriverWait mobile = new WebDriverWait(getDriver(), 30);
                mobile.until((WebDriver dr) ->
                        dr.findElement(locator).getText().contains(textToWait[0]));
            }
            log(Status.INFO, "Smart Scroll To Element");
            WebElement element = BrowserDriverFactory.getDriver().findElement(locator);
            //Get the current position of the element on the current web page
            Point location = element.getLocation();
            //Get the Width and Height of the element
            Dimension size = element.getSize();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            //Get the width of the visible area of the web page in the browser
            int viewportWidth = ((Number) js.executeScript("return window.innerWidth || document.documentElement.clientWidth;")).intValue();
            //Get the height of the visible area of the web page in the browser
            int viewportHeight = ((Number) js.executeScript("return window.innerHeight || document.documentElement.clientHeight;")).intValue();
            //Determine if the element is outside the visible area of the current web page in the browser
            boolean isOutOfBounds =
                    //Check if the element's left edge is out of the left side of the visible area
                    location.getX() < 0 ||
                            //Check if the element's top edge is out of the top side of the visible area
                            location.getY() < 0 ||
                            //Check if the element's right edge is out the right side of the visible area
                            location.getX() + size.getWidth() > viewportWidth ||
                            //Check if the element's bottom edge is out of the bottom side of the visible area
                            location.getY() + size.getHeight() > viewportHeight;
            //If the element is out the screen Or is not clickable,
            // we'll use JS scrollIntoView to show the element
            //The {block: 'center'} will center the element on the screen
            boolean elementIsClickable;
            //Check if the element is clickable on the current page
            WebDriverWait checkClickable = new WebDriverWait(getDriver(), 30);
            try {
                checkClickable.until(ExpectedConditions.elementToBeClickable(element));
                elementIsClickable = true;
            } catch (TimeoutException e) {
                elementIsClickable = false;
            }
            //If the element is out the screen or is not clickable, we'll use JS scrollIntoView to show the element
            //The {block: 'center'} will center the element on the screen
            if (isOutOfBounds || elementIsClickable) {
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            } else {
                //We'll use action move to element if isOutOfBounds = false and the elementIsClickable = true
                actions.moveToElement(element).perform();
            }
        } catch (Exception e) {
            System.out.println("Element Not Exist Or Page Is not Loaded. The error is: \n" + e + ".");
        }
    }

    public static void lambdaWait(By elementCondition, int... timeout) {
        WebDriverWait wait = new WebDriverWait(BrowserDriverFactory.getDriver(), timeout.length > 0 ? timeout[0] : 10);
        String conditionDescription = "element condition: " + elementCondition.toString();
        try {
            wait.withMessage("Timeout occurred while waiting for " + conditionDescription)
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver dr) -> {
                        WebElement element = dr.findElement(elementCondition);
                        List<WebElement> elements = dr.findElements(elementCondition);
                        String currentUrl = dr.getCurrentUrl();
                        String readyState = (String) ((JavascriptExecutor) dr).executeScript("return document.readyState");
                        long loadEventEnd = (long) ((JavascriptExecutor) dr).executeScript("return window.performance.timing.loadEventEnd");

                        return (!elements.isEmpty() || element.isDisplayed())
                                && currentUrl != null
                                && "complete".equals(readyState)
                                && loadEventEnd > 0;
                    });
        } catch (TimeoutException e) {
            try {
                System.out.println("Waiting 2.5 sec to element before failing");
                sleep(2500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            throw new TimeoutException("Timeout occurred while waiting for " + conditionDescription + " on lambda method ", e);
        }
    }

    public static void lambdaWaitUrl(String urlString, int... timeout) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        int timeoutParam = 10;
        if (timeout.length > 0) {
            timeoutParam = timeout[0];
        }
        try {
            WebDriverWait mobile = (WebDriverWait) new WebDriverWait(getDriver(), timeoutParam).pollingEvery(Duration.ofSeconds(2));
            mobile.until((WebDriver dr) ->
                    dr.getCurrentUrl().contains(urlString)
                            && js.executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            WebDriverWait mobile = new WebDriverWait(getDriver(), timeoutParam);
            mobile.until((WebDriver dr) ->
                    dr.getCurrentUrl().contains(urlString)
                            && js.executeScript("return document.readyState").equals("complete"));
        }
    }


    public static void lambdaForString(String stringToWait, int... timeout) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) BrowserDriverFactory.getDriver();
        // Get all the text from the page using JavaScript
        String pageText = (String) jsExecutor.executeScript("return document.body.innerText");
        int timeoutParam = 25;
        if (timeout.length > 0) {
            timeoutParam = timeout[0];
        }
        try {
            WebDriverWait mobile = (WebDriverWait) new WebDriverWait(BrowserDriverFactory.getDriver(), timeoutParam).pollingEvery(Duration.ofMillis(500));
            mobile.until((WebDriver dr) ->
                    pageText.contains(stringToWait)
            );
        } catch (Exception e) {
            //DO NOTHING
        }
    }

}