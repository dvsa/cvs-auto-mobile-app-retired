package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RecordDefectPage extends BasePage {

    private static final String RECORD_DEFECT_PAGE_ID = "Record defect";
    private static final String BACK_BUTTON_ID = "arrow back Back";
    private static final String SEARCH_FIELD_CLASS_NAME = "XCUIElementTypeSearchField";


    public void selectItemFromList(String itemName) {
        findElementByXpath("//*[contains(@label, '" + itemName + "')]").click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(RECORD_DEFECT_PAGE_ID);
    }

    public int getElementsNumberFromList(String... values) {
        return findAllDataByComposedXpath(values).size();
    }

    public void clickBack() {
        findElementByAccessibilityIdId(BACK_BUTTON_ID).click();
    }

    public void searchForDefect(String defectName) {
        findElementByClassName(SEARCH_FIELD_CLASS_NAME).sendKeys(defectName);
    }

    public void waitByElement(String element, int expectedResults) {
        waitUntillNumberOfElementsToBe(MobileBy.AccessibilityId(element), expectedResults);
    }


    public List<String> findAllLabelsByClassName() {
        List<WebElement> webElementList = getDriver().findElements(By.className("XCUIElementTypeStaticText"));
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("label"));
        }

        return listOfData;
    }

    public void clearSearch() {

        findElementByClassName(SEARCH_FIELD_CLASS_NAME).clear();
        new TouchAction(((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()))
                .press(PointOption.point(findElementByClassName(SEARCH_FIELD_CLASS_NAME).getLocation().getX() - 1, findElementByClassName(SEARCH_FIELD_CLASS_NAME).getLocation().getY() - 1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .release()
                .perform();
    }
}
