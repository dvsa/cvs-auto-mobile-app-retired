package pages;

public class SiteVisitPage extends BasePage {

    private static final String PAGE_TITLE = "Site Visit";
    private static final String CREATE_TEST_ID = "Create test";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(CREATE_TEST_ID);
    }

    public void clickCreateNewTest() {
        findElementById(CREATE_TEST_ID).click();
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE).isDisplayed();
    }

    public boolean isCancelledlStatusDisplayed(String registrationPlate) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Test (" + registrationPlate + ") CANCELLED')]").isDisplayed();
    }
}
