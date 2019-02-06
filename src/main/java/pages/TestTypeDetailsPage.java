package pages;

public class TestTypeDetailsPage extends BasePage {
    private static final String TEST_TYPE_DETAILS_PAGE_TITLE = "Test type details";
    private static final String SAVE_BUTTON_ID = "Save";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_TYPE_DETAILS_PAGE_TITLE);
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(TEST_TYPE_DETAILS_PAGE_TITLE).isDisplayed();
    }

    public void clickSave() {
        findElementById(SAVE_BUTTON_ID).click();
    }
}
