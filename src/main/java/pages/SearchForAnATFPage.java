package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchForAnATFPage extends BasePage {

    private static final String SEARCH_FOR_ATF_TITLE_ID = "Search for an ATF";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";
    private static final String SEARCH_FIELD_XPATH = "//XCUIElementTypeSearchField";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SEARCH_FOR_ATF_TITLE_ID);
    }

    public List<String> findAllLabelsByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("label"));
        }

        return listOfData;
    }

    public boolean isSearchFieldPresent() {
        return findElementByXpath(SEARCH_FIELD_XPATH).isDisplayed();
    }


    public void searchForAtf(String randomData) {
        findElementByXpath(SEARCH_FIELD_XPATH).sendKeys(randomData);

    }

    public void waitUntilFilterIsCompleted(int labelNumber) {
        waitUntillNumberOfElementsToBe(By.xpath(PAGE_ALL_TEXT_XPATH), labelNumber);


    }

    public void clickOnAtf(String atfName) {
        findElementByXpath("//*[@label='" + atfName + "']").click();
    }
}
