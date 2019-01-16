package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchForAnATFPage extends BasePage {

    private static final String SEARCH_FOR_ATF_TITLE_ID = "Find an ATF";
    private static final String PAGE_ALL_TEXT_XPATH = "XCUIElementTypeStaticText";
    private static final String SEARCH_FIELD_XPATH = "XCUIElementTypeSearchField";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SEARCH_FOR_ATF_TITLE_ID);
    }

    public List<String> findAllLabelsByXpath() {
        List<WebElement> webElementList = getDriver().findElements(By.className("XCUIElementTypeStaticText"));
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("label"));
        }

        return listOfData;
    }

    public boolean isSearchFieldPresent() {
        return getDriver().findElement(By.className(SEARCH_FIELD_XPATH)).isDisplayed();
    }


    public void searchForAtf(String randomData) {
        getDriver().findElement(By.className(SEARCH_FIELD_XPATH)).sendKeys(randomData);

    }

    public void waitUntilFilterIsCompleted(int labelNumber) {
        waitUntilNumberOfElementsToBe(By.className(PAGE_ALL_TEXT_XPATH), labelNumber);
    }

    public void waitByElement(String element, int expectedResults) {
        waitUntilNumberOfElementsToBe(MobileBy.AccessibilityId(element), expectedResults);
    }


    public void clickOnAtf(String atfName) {
        findElementByAccessibilityIdId(atfName).click();
    }

    public void swipeDown() {
        scrollDownTo(500, -300);
    }

    public boolean elementFromListIsDisplayed(String element) {
        return findElementByAccessibilityIdId(element).isDisplayed();
    }

    public int getYPositionForElement(String element) {
        return findElementByAccessibilityIdId(element).getLocation().getY();
    }

    public boolean elementInSearchIsPresent(String data) {
        return getDriver().findElement(MobileBy.iOSNsPredicateString("value == '" + data + "'")).isDisplayed();

    }
}
