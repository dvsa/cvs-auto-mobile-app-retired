package pages;

public class SearchCriteriaPage extends BasePage {

    private static final String SEARCH_CRITERIA_PAGE_TITLE = "Search criteria";
    private static final String SAVE_BUTTON = "Save";

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

