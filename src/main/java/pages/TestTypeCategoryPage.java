package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTypeCategoryPage extends BasePage {

    private static final String TEST_TYPE_PAGE_TITLE = "Test type";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";
    private static final String PAGE_ALL_BUTTON_XPATH = "//XCUIElementTypeButton";
    private static final String CANCEL_ID = "Cancel";
    private static final String POPUP_SUGGESTED_TEST_TYPE = "//XCUIElementTypeOther[contains(@name, 'Suggested test types, web dialog')]";
    private static final String SELECT_DIFFERENT_TEST_TYPE = "//XCUIElementTypeButton[@name='Select a different test type']";

    public void waitUntilPageIsLoaded() {
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        if (isPopUpDisplayed())
            findElementByXpath(SELECT_DIFFERENT_TEST_TYPE).click();
        waitUntilPageIsLoadedById(TEST_TYPE_PAGE_TITLE);
    }

    public void waitUntilPageIsLoaded(String testType) {
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        if (isPopUpDisplayed())
            findElementByXpath(SELECT_DIFFERENT_TEST_TYPE).click();
        waitUntilPageIsLoadedById(testType);
    }

    public boolean isPopUpDisplayed() {
        boolean status = true;
        if(findElementsByXpath(POPUP_SUGGESTED_TEST_TYPE).isEmpty())
            status = false;
        return status;
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

    public List<String> findAllSuggestedTestTypesFromListByXpath() {
        logger.debug("Page source after wait: " + getDriver().getPageSource());
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_BUTTON_XPATH);
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
                waitUntilPageIsLoadedByElementAndClickable(By.id(testType), 30, 200);
                webElement.click();
                break;
            }
        }
    }

    public void selectSuggestedTestTypeFromListByXpath(String testType) {
        logger.debug("Page source after wait 2: " + getDriver().getPageSource());
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_BUTTON_XPATH);
        for (WebElement webElement : webElementList) {
            String text = webElement.getAttribute("name");
            if(text.equalsIgnoreCase(testType)) {
                waitUntilPageIsLoadedByElementAndClickable(By.id(testType), 30, 200);
                webElement.click();
                break;
            }
        }
    }

    public void selectCancel() {
        findElementById(CANCEL_ID).click();
    }


}
