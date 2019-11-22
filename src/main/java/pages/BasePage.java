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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class BasePage extends PageObject {

    private void showElementError(String element) {
        System.out.println("- Element not found (" + element + ")");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(getDriver().getPageSource());
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    protected WebElement findElementByAccessibilityId(String idOrName) {
        System.out.println("Finding element by Accessibility ID: " + idOrName);
        WebElement element = null;
        try {
            element = getDriver().findElement(MobileBy.AccessibilityId(idOrName));
            System.out.println("- Found.");
        } catch (ElementNotFoundException exception) {
            showElementError(idOrName);
        }
        return element;
    }

    protected WebElement findElementById(String id) {
        System.out.println("Searching for element by ID: " + id);
        WebElement element = null;
        try {
            element = getDriver().findElement(By.id(id));
            System.out.println("- Found");
        } catch (NoSuchElementException exception) {
            showElementError(id);
        }
        return element;
    }

    protected WebElement findElementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    protected WebElement findElementByXpath(String xpath) {
        System.out.println("Finding element: " + xpath);
        WebElement element = getDriver().findElement(By.xpath(xpath));
        System.out.println("- Found");
        return element;
    }

    protected List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByClassName(String className) {
        return getDriver().findElements(By.className(className));
    }

    protected List<WebElement> findElementsByAccessibilityId(String idOrName) {
        System.out.println("Finding elements by Accessibility ID: " + idOrName);
        List<WebElement> elements = getDriver().findElements(MobileBy.AccessibilityId(idOrName));
        System.out.println("- Found " + elements.size());
        return elements;
    }

    protected WebElement waitUntilPageIsLoadedById(String id) {
        System.out.println("***************************  PAGE SOURCE  ****************************\n"+getDriver().getPageSource()+"\n***************************   PAGE END   ****************************");
        System.out.println("Waiting for page to load by ID, waiting for item: " + id);
        WebElement element = waitUntilPageIsLoadedByElement(By.id(id), 90, 200);
        System.out.println("- Loaded.");
        return element;
    }

    protected WebElement waitUntilPageIsLoadedByAccessibilityId(String idOrName) {
        System.out.println("***************************  PAGE SOURCE  ****************************\n"+getDriver().getPageSource()+"\n***************************   PAGE END   ****************************");
        System.out.println("Waiting for page to load by Accessibility ID, waiting for item: " + idOrName);
        WebElement element = waitUntilPageIsLoadedByElement(MobileBy.AccessibilityId(idOrName), 60, 200);
        System.out.println("- Loaded.");
        return element;
    }


    protected WebElement shortestUntilPageIsLoadedByAccessibilityId(String idOrName) {
        return waitUntilPageIsLoadedByElement(MobileBy.AccessibilityId(idOrName), 2, 200);
    }

    protected WebElement longWaitUntilPageIsLoadedByIdAndClickable(String id) {
        System.out.println("Waiting (long) for page to be loaded, based on clickable element: " + id);
        WebElement element = waitUntilPageIsLoadedByElementAndClickable(MobileBy.AccessibilityId(id), 300, 400);
        System.out.println("- Loaded.");
        return element;
    }

    protected WebElement shortWaitUntilPageIsLoadedByIdAndClickable(String id) {
        System.out.println("Waiting (short) for page to be loaded, based on clickable element: " + id);
        WebElement element = waitUntilPageIsLoadedByElementAndClickable(By.id(id), 20, 400);
        System.out.println("- Loaded.");
        return element;
    }

    protected WebElement shortestWaitUntilPageIsLoadedByIdAndClickable(String id) {
        System.out.println("Waiting (shortest) for page to be loaded, based on clickable element: " + id);
        WebElement element = waitUntilPageIsLoadedByElementAndClickable(By.id(id), 2, 400);
        System.out.println("- Loaded.");
        return element;
    }

    protected WebElement waitUntilPageIsLoadedByXpath(String xPath) {
        System.out.println("Waiting for page to be loaded, based on xPath: " + xPath);
        WebElement element = waitUntilPageIsLoadedByElement(By.xpath(xPath), 20, 200);
        System.out.println("- Loaded.");
        return element;
    }

    protected void waitUntilNumberOfElementsToBe(By locator, int elementNumber) {
        System.out.println("Waiting for number of elements to be present: (" + locator + ", expecting " + elementNumber + ")");
        FluentWait wait = globalFluentWait(30, 200);
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, elementNumber));
        System.out.println("- Found.");
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

    protected List<WebElement> findAllDataByComposedXpath(String... data) {
        List<String> xpathList = new ArrayList<>();

        for (String value : data) {
            String currentXpathElement = "//*[contains(@name,'" + value + "')] | //*[contains(@label, '" + value + "')] | //*[contains(@value,'" + value + "')] ";
            xpathList.add(currentXpathElement);
        }

        String xpathToSearch = xpathList.stream().collect(Collectors.joining(" | "));

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

        System.out.println("Search using locator: " + locator);

        FluentWait wait = globalFluentWait(timeOut, poolingEvery);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        System.out.println("Found: " + locator);

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
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("Loading...")));
    }


    private WebElement waitUntilPageIsLoadedByElementAndClickable(By locator, int timeOut, int pollingEvery) {

        System.out.println("Waiting for page to be loaded, using element: " + locator +
                " (Timeout is " + timeOut + ", polling every " + pollingEvery + ")...");
        FluentWait wait = globalFluentWait(timeOut, pollingEvery);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator),
                ExpectedConditions.presenceOfAllElementsLocatedBy(locator),
                ExpectedConditions.elementToBeClickable(locator)));
        System.out.println("- Page loaded.");

        System.out.println("- Verifying element is present...");
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
        System.out.println("Getting Time from status bar");
        String time = findElementByXpath("//XCUIElementTypeStatusBar/XCUIElementTypeOther[2]/XCUIElementTypeOther[contains(@name,':')]").getText();
        System.out.println("- " + time);
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
            System.out.println("d: " + d);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public boolean checkElementValue(String element, String value){
        List<WebElement> webElementList = findElementsByClassName("XCUIElementTypeStaticText");
        for(WebElement e : webElementList){
            if(e.getAttribute("name").equals(element)){
                return webElementList.get(webElementList.indexOf(e)+1).getAttribute("name").equals(value);
            }
        }
        return false;
    }

    public void scrollToElement(String id) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "name CONTAINS '" + id + "'");
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void click(WebElement element) {
        System.out.println("Clicking on: " + element.getText());
        try {
            element.click();
            System.out.println("- Clicked.");
        } catch (ElementNotFoundException exception) {
            showElementError(element.getText());
        }
    }
}
