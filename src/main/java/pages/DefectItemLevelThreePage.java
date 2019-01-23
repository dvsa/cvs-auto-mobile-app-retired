package pages;

import com.gargoylesoftware.htmlunit.html.DomNode;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DefectItemLevelThreePage extends BasePage {

    private static final String ADVISORY_LABEL_ID = "ADVISORY";
    private static final String ADVISORY_NOTE_ID = "Add an advisory note";
    private static final String BACK_BUTTON_ID = "arrow back Back";
    private static final String SEARCH_FIELD_CLASS_NAME = "XCUIElementTypeSearchField";



    public void clickAddAdvisoryNote() {
        findElementById(ADVISORY_NOTE_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(ADVISORY_LABEL_ID);
    }

    public void selectById(String defectId) {
        findElementById(defectId).click();
    }

    public void clickBack() {
        findElementByAccessibilityIdId(BACK_BUTTON_ID).click();
    }

    public void searchForDefect(String defectName) {
        findElementByClassName(SEARCH_FIELD_CLASS_NAME).sendKeys(defectName);
    }

    public WebElement findItemInList(String itemName) {
        return findElementByAccessibilityIdId(itemName);
    }

    public int getElementsNumberFromList(String... values) {
        return findAllDataByComposedXpath(values).size();
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
}
