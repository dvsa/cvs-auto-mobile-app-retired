package pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class BasePage extends PageObject {

    Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    
    private void showElementError(String element) {
        logger.info("Element not found(" + element + ")");
    }

    protected WebElement findElementByAccessibilityId(String idOrName) {
        logger.info("Finding element by Accessibility ID: " + idOrName);
        WebElement element = null;
        try {
            element = getDriver().findElement(MobileBy.AccessibilityId(idOrName));
            logger.info("Found.");
        } catch (ElementNotFoundException exception) {
            showElementError(idOrName);
        }
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        return element;
    }

    protected WebElement findElementById(String id) {
        logger.info("Searching for element by ID: " + id);
        WebElement element = null;
        try {
            element = getDriver().findElement(By.id(id));
            logger.info("Found");
        } catch (NoSuchElementException exception) {
            showElementError(id);
        }
        logger.debug("Page source after wait: " + getDriver().getPageSource());

        return element;
    }

    protected WebElement findElementByClassName(String className) {
        logger.info("Finding element by class: " + className);
        WebElement element = getDriver().findElement(By.className(className));
        logger.info("Found");
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        return element;
    }

    protected WebElement findElementByXpath(String xpath) {
        logger.info("Finding element: " + xpath);
        WebElement element = getDriver().findElement(By.xpath(xpath));
        logger.info("Found");
        logger.debug("Page source after wait: " + getDriver().getPageSource());

        return element;
    }

    protected List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByClassName(String className) {
        return getDriver().findElements(By.className(className));
    }

    protected List<WebElement> findElementsByAccessibilityId(String idOrName) {
        logger.info("Finding elements by Accessibility ID: " + idOrName);
        List<WebElement> elements = getDriver().findElements(MobileBy.AccessibilityId(idOrName));
        logger.info("Found " + elements.size());
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        return elements;
    }

    protected WebElement waitUntilPageIsLoadedByEitherId(String id1, String id2) {
        logger.info("Waiting for page to load, using these IDs: #1: " + id1 + ", #2: " + id2);
        WebElement element = null;
        while (element == null) {
            try {
                logger.info("Searching for title #1: " + id1);
                element = waitUntilPageIsLoadedByElement(By.id(id1), 40, 100);
            } catch (Exception e) {
                try {
                    logger.info("Searching for title #2: " + id2);
                    element = waitUntilPageIsLoadedByElement(By.id(id2), 40, 100);
                } catch (ElementNotVisibleException e1) {
                    showElementError(id2);
                }
            }
        }
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        return element;
    }

    protected WebElement waitUntilPageIsLoadedById(String id) {
        logger.info("Waiting for page to load by ID, waiting for item: " + id );
        WebElement element = null;
        if (id.equals("Test review")) {
            element = waitUntilPageIsLoadedByEitherId(id, "Test");
        }
        else if (id.equals("Trailer details")) {
            element = waitUntilPageIsLoadedByEitherId(id, "Vehicle details");
        }
        else if (id.equals("Vehicle details")) {
            element = waitUntilPageIsLoadedByEitherId(id, "Trailer details");
        }
        else {
            element = waitUntilPageIsLoadedByElement(By.id(id), 60, 100);
        }
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        logger.info("Loaded.");
        return element;
    }

    protected WebElement waitUntilPageIsLoadedByAccessibilityId(String idOrName) {
        logger.info("Waiting for page to load by Accessibility ID, waiting for item: " + idOrName);
        WebElement element = waitUntilPageIsLoadedByElement(MobileBy.AccessibilityId(idOrName), 40, 100);
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        logger.info("Loaded.");
        return element;
    }


    protected WebElement longWaitUntilPageIsLoadedByIdAndClickable(String id) {
        logger.info("Waiting (long) for page to be loaded, based on clickable element: " + id);
        WebElement element = waitUntilPageIsLoadedByElementAndClickable(MobileBy.AccessibilityId(id), 60, 100);
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        logger.info("Loaded.");
        return element;
    }

    protected WebElement shortWaitUntilPageIsLoadedByIdAndClickable(String id) {
        logger.info("Waiting (short) for page to be loaded, based on clickable element: " + id);
        WebElement element = waitUntilPageIsLoadedByElementAndClickable(By.id(id), 40, 100);
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        logger.info("Loaded.");
        return element;
    }

    protected WebElement shortestWaitUntilPageIsLoadedByIdAndClickable(String id) {
        logger.info("Waiting (shortest) for page to be loaded, based on clickable element: " + id);
        WebElement element = waitUntilPageIsLoadedByElementAndClickable(By.id(id), 40, 100);
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        logger.info("Loaded.");
        return element;
    }

    protected WebElement waitUntilPageIsLoadedByXpath(String xPath) {
        logger.info("Waiting for page to be loaded, based on xPath: " + xPath);
        WebElement element = waitUntilPageIsLoadedByElement(By.xpath(xPath), 40, 100);
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        logger.info("Loaded.");
        return element;
    }

    protected void waitUntilNumberOfElementsToBe(By locator, int elementNumber) {
        logger.info("Waiting for number of elements to be present: (" + locator + ", expecting " + elementNumber + ")");
        FluentWait wait = globalFluentWait(60, 100);
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, elementNumber));
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        logger.info("Found.");
    }

    protected void scrollDownTo(int xOffset, int yOffset) {
        scroll(500, 596, xOffset, yOffset);
    }

    protected void scroll(int xPressAt, int yPressAt, int xMoveTo, int yMoveTo) {
        new TouchAction(((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()))
                .press(PointOption.point(xPressAt, yPressAt))
                .waitAction(waitOptions(ofMillis(100)))
                .moveTo(PointOption.point(xMoveTo, yMoveTo))
                .release()
                .perform();
    }

    protected void tap(WebElement webElement) {
        new TouchAction(((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()))
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement)))
                .perform();
    }

    protected void tapByCoordinates(int x, int y) {
        new TouchAction(((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()))
                .tap(PointOption.point(x, y))
                .perform();
    }

    public List<WebElement> findAllDataByComposedXpath(String... data) {
        List<String> xpathList = new ArrayList<>();

        for (String value : data) {
            String currentXpathElement = "//*[contains(@name,'" + value + "')] | //*[contains(@label, '" + value + "')] | //*[contains(@value,'" + value + "')] ";
            xpathList.add(currentXpathElement);
        }

        String xpathToSearch = String.join(" | ", xpathList);

        return findElementsByXpath(xpathToSearch);

    }

    public int getXPositionForElement(String element) {
        return findElementByXpath("//*[contains(@name, '" + element + "')]").getLocation().getX();
    }

    public int getYPositionForElement(String element) {
        return findElementByXpath("//*[contains(@name, '" + element + "')]").getLocation().getY();
    }

    public void scrollDetailPage() {
        scrollDownTo(500, -100);
    }

    private WebElement waitUntilPageIsLoadedByElement(By locator, int timeOut, int poolingEvery) {

        logger.info("Search using locator: " + locator);

        FluentWait wait = globalFluentWait(timeOut, poolingEvery);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        logger.info("Found: " + locator);

        return getDriver().findElement(locator);

    }

    public WebElement waitUntilPageIsLoadedByElementPresent(By locator, int timeOut, int poolingEvery) {

        FluentWait wait = globalFluentWait(timeOut, poolingEvery);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        return getDriver().findElement(locator);

    }

    protected void waitElementToDisappear(By locator, int timeOut, int poolingEvery){
        FluentWait wait = globalFluentWait(timeOut, poolingEvery);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForLoadingToFinish(){
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("Loading...")));
    }


    public WebElement waitUntilPageIsLoadedByElementAndClickable(By locator, int timeOut, int pollingEvery) {

        logger.info("Waiting for page to be loaded, using element: " + locator +
                " (Timeout is " + timeOut + ", polling every " + pollingEvery + ")...");
        FluentWait wait = globalFluentWait(timeOut, pollingEvery);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator),
                ExpectedConditions.presenceOfAllElementsLocatedBy(locator),
                ExpectedConditions.elementToBeClickable(locator)));
        logger.info("Page loaded.");

        logger.info("Verifying element is present...");
        WebElement element = null;
        try {
            element = getDriver().findElement(locator);
        } catch (NoSuchElementException exception) {
            showElementError(locator.toString());
        }
        return element;
    }

    private FluentWait globalFluentWait(int timeOutSeconds, int pollingEveryMilliseconds) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeOutSeconds))
                .pollingEvery(ofMillis(pollingEveryMilliseconds))
                .ignoring(NoSuchElementException.class);

        return wait;
    }

    public void clickSearch() {
        ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).getKeyboard().sendKeys(Keys.RETURN);
    }

    public boolean isFieldEditableById(String id) {
        String text = "Te";
        boolean status = true;
        WebElement element = findElementByAccessibilityId(id);
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    public boolean isFieldEditableByXPathName(String name) {
        String text = "Te";
        boolean status = true;
        WebElement element = findElementByXpath("//XCUIElementTypeStaticText[@name='" + name + "']");
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    public String getStatusBarTime() {
        logger.info("Getting Time from status bar");
        String time = findElementByXpath("//XCUIElementTypeStatusBar/XCUIElementTypeOther[2]/XCUIElementTypeOther[contains(@name,':')]").getText();
        logger.info(time);
        return time;
    }

    public void runAppInBackground() {
        ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).runAppInBackground(ofMillis(500));
        getDriver().getPageSource();
    }

    public void closeAndLaunchApp() {
        ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).closeApp();
        ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).launchApp();
    }

    public boolean isNumeric(String element) {
        try {
            int d = Integer.parseInt(element);
            logger.info("d: " + d);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public boolean checkElementValue(String element, String value){
        logger.info("Verifying that element " + element + " equals " + value);
        List<WebElement> webElementList = findElementsByClassName("XCUIElementTypeStaticText");
        for(WebElement e : webElementList){
            if(e.getAttribute("name").equals(element)){
                if (webElementList.get(webElementList.indexOf(e)+1).getAttribute("name").equals(value)) {
                    logger.info("Value matches.");
                    return true;
                } else {
                    logger.info("Value mismatch.");
                    return false;
                }
            }
        }
        logger.info("Element not found.");
        return false;
    }

    public String getElementValueByLabel(String element){
        String elementValue = "";
        logger.info("Getting value for element following after label: " + element);
        List<WebElement> webElementList = findElementsByClassName("XCUIElementTypeStaticText");
        for(WebElement e : webElementList){
            if(e.getAttribute("name").equals(element)){
                elementValue = webElementList.get(webElementList.indexOf(e)+1).getAttribute("value");
                logger.info("Value found: " + elementValue);
                return elementValue;
            }
        }
        logger.info("Element not found.");
        return elementValue;
    }

    public void scrollToElement(String name) {
        logger.info("Scrolling to element with name '" + name + "' ...");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "name CONTAINS '" + name + "'");
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void scrollToElementWithAttribute(String attributeName, String attributeValue) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", attributeName + "== '" + attributeValue + "'");
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void click(WebElement element) {
        logger.info("Clicking on: " + element.getText());
        try {
            element.click();
            logger.info("Clicked.");
        } catch (ElementNotFoundException exception) {
            showElementError(element.getText());
        }
    }
}
