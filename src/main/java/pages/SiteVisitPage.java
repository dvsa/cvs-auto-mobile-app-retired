package pages;

public class SiteVisitPage extends BasePage {

    private static final String CREATE_NEW_TEST_ID = "Create new test";
    private static final String PAGE_TITLE = "Site Visit";
    private static final String FAIL_STATUS_XPATH = "//*[@value='Fail']";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(CREATE_NEW_TEST_ID);
    }

    public void clickCreateNewTest() {
        findElementById(CREATE_NEW_TEST_ID).click();
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE).isDisplayed();
    }

    public boolean isFailStatusDisplayed() {
        return findElementByXpath(FAIL_STATUS_XPATH).isDisplayed();
    }
}
