package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestTypeSubcategoryPage extends BasePage {
    private static final String TEST_TYPE_PAGE_TITLE = "Test type";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_TYPE_PAGE_TITLE);
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if(findElementById(TEST_TYPE_PAGE_TITLE).isDisplayed())
            status = true;
        return status;
    }

    public List<String> findAllTestTypesFromListByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("name"));
        }

        return listOfData;
    }

    public void selectTestTypeFromListByXpath(String testType) {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        for (WebElement webElement : webElementList) {
            if(webElement.getAttribute("name").equalsIgnoreCase(testType)) {
                webElement.click();
                break;
            }
        }

    }


}
