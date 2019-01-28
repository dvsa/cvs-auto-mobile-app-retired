package pages;

public class SiteVisitPage extends BasePage {

    private static final String CREATE_TEST_ID = "Create test";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(CREATE_TEST_ID);
    }

    public void clickCreateNewTest() {
        findElementById(CREATE_TEST_ID).click();
    }
}
