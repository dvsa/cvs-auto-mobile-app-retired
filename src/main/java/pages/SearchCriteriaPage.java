package pages;

import org.openqa.selenium.WebElement;
import util.SearchCriteria;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCriteriaPage extends IdentifyVehiclePage {

    private static final String PAGE_ALL_TEXTS = "XCUIElementTypeStaticText";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String SEARCH_CRITERIA_PAGE_TITLE = "Search criteria";
    private static final String SAVE_BUTTON = "Save";

    public boolean isPageTitleDisplayed() {
        try {
            return findElementByAccessibilityId(SEARCH_CRITERIA_PAGE_TITLE).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean areSearchCriteriaDisplayed() {
        List<WebElement> allElements = findElementsByClassName(PAGE_ALL_TEXTS);
        List<String> allTexts = allElements.stream().map(name -> name.getAttribute("name")).collect(Collectors.toList());
        List<String> allCriteriaTexts = Arrays.stream(SearchCriteria.values()).map(name -> name.getDescription()).collect(Collectors.toList());
            return allTexts.containsAll(allCriteriaTexts);
    }

    public void selectCriteria(SearchCriteria criteria) {
        waitUntilPageIsLoaded();
        findElementByAccessibilityId(criteria.getDescription()).click();
    }

    public void pressSave() {
        waitUntilPageIsLoaded();
        findElementByAccessibilityId(SAVE_BUTTON_ID).click();
    }

    public void clickSave() {

        findElementById(SAVE_BUTTON).click();
    }

    public void waitUntilPageIsLoaded() {

        waitUntilPageIsLoadedById(SEARCH_CRITERIA_PAGE_TITLE);
    }

    public void setSearchCriteriaOption(String searchCriteriaOption) {

        waitUntilPageIsLoaded();
        findElementById(searchCriteriaOption).click();
    }
}

