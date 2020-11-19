package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestTypeCategoryPage extends BasePage {

    private static final String TEST_TYPE_PAGE_TITLE = "Test type";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";
    private static final String CANCEL_ID = "Cancel";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_TYPE_PAGE_TITLE);
    }

    public void waitUntilPageIsLoaded(String testType) {
        waitUntilPageIsLoadedById(testType);
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if(findElementById(TEST_TYPE_PAGE_TITLE).isDisplayed())
            status = true;
        return status;
    }

    public List<String> findAllTestTypesFromListByXpath() {
        waitUntilPageIsLoaded();
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("name"));
        }
        listOfData.remove(TEST_TYPE_PAGE_TITLE);
        return listOfData;
    }

    public List<WebElement> findAllTestTypesWebElements() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        return webElementList;
    }

    public void selectTestTypeFromListByXpath(String testType) {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        for (WebElement webElement : webElementList) {
            String text = webElement.getAttribute("name");
            if(text.equalsIgnoreCase(testType)) {
                webElement.click();
                break;
            }
        }
    }

    public void selectCancel() {
        findElementById(CANCEL_ID).click();
    }
}
