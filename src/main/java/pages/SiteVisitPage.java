package pages;

public class SiteVisitPage extends BasePage {

    private static final String CREATE_NEW_TEST_ID = "Create new test";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(CREATE_NEW_TEST_ID);
    }

    public void clickCreateNewTest() {
        findElementById(CREATE_NEW_TEST_ID).click();
    }
}
