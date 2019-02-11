package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BasePage extends PageObject {


    protected WebElement findElementByAccessibilityId(String idOrName) {
        return getDriver().findElement(MobileBy.AccessibilityId(idOrName));
    }

    protected WebElement findElementById(String id) {
        return getDriver().findElement(By.id(id));
    }

    protected WebElement findElementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    protected WebElement findElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByClassName(String className) {
        return getDriver().findElements(By.className(className));
    }

    protected List<WebElement> findElementsByAccesibilityId(String idOrName) {
        return getDriver().findElements(MobileBy.AccessibilityId(idOrName));
    }

    protected WebElement waitUntilPageIsLoadedById(String id) {
        return waitUntilPageIsLoadedByElement(By.id(id), 20, 200 );
    }

    protected WebElement waitUntilPageIsLoadedByAccessibilityId(String idOrName) {
        return waitUntilPageIsLoadedByElement(MobileBy.AccessibilityId(idOrName), 20, 200 );
    }

    protected WebElement longWaitUntilPageIsLoadedByIdAndClickable(String id) {

        return waitUntilPageIsLoadedByElementAndClickable(By.id(id), 150, 400 );
    }

    protected WebElement shortWaitUntilPageIsLoadedByIdAndClickable(String id) {
        return waitUntilPageIsLoadedByElementAndClickable(By.id(id), 20, 400 );

    }

    protected WebElement waitUntilPageIsLoadedByXpath(String xPath) {
        return waitUntilPageIsLoadedByElement(By.xpath(xPath), 20, 200);
    }

    protected void waitUntilNumberOfElementsToBe(By locator, int elementNumber) {
        FluentWait wait = globalFluentWait(20, 200);
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, elementNumber));
    }

    protected void scrollDownTo(int xOffset, int yOffset) {
        scroll(500,596, xOffset, yOffset);
    }

    protected void scroll(int xPressAt, int yPressAt, int xMoveTo, int yMoveTo) {
                new TouchAction(((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()))
                .press(PointOption.point(xPressAt,yPressAt))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .moveTo(PointOption.point(xMoveTo,yMoveTo))
                .release()
                .perform();
    }

    protected void tap(WebElement webElement) {
        new TouchAction(((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()))
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement)))
                .perform();
    }

    protected void tapByCoordinates(int x, int y) {
        new TouchAction(((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()))
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
        return findElementByXpath("//*[@name='" + element + "']").getLocation().getX();
    }

    public int getYPositionForElement(String element) {
        return findElementByXpath("//*[@name='" + element + "']").getLocation().getY();
    }


    private WebElement waitUntilPageIsLoadedByElement(By locator, int timeOut, int poolingEvery) {

        FluentWait wait = globalFluentWait(timeOut, poolingEvery);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        return getDriver().findElement(locator);

    }


    private WebElement waitUntilPageIsLoadedByElementAndClickable(By locator, int timeOut, int poolingEvery) {

        FluentWait wait = globalFluentWait(timeOut, poolingEvery);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator),
                ExpectedConditions.presenceOfAllElementsLocatedBy(locator),
                ExpectedConditions.elementToBeClickable(locator)));

        getDriver().getPageSource();
        return getDriver().findElement(locator);
    }


    private FluentWait globalFluentWait(int timeOut, int poolingEvery) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(poolingEvery))
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
        } catch (SerenityManagedException e) {
            status = false;
        }
        return status;
    }


    public void runAppInBackground() {
        ((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).runAppInBackground(Duration.ofMillis(500));
        getDriver().getPageSource();
    }

    public void closeAndLaunchApp() {
        ((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).closeApp();
        ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).launchApp();
    }

}
