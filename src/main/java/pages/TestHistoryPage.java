package pages;

public class TestHistoryPage extends BasePage {
    private static final String TEST_HISTORY_PAGE_TITLE = "Test history";
    private static final String BACK_BUTTON_ID = "arrow back Vehicle details";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_HISTORY_PAGE_TITLE);
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(TEST_HISTORY_PAGE_TITLE).isDisplayed();
    }

    public void clickBackButton() {
        findElementById(BACK_BUTTON_ID).click();
    }
}
