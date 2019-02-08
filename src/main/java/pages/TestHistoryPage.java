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

    public boolean isRegPlateDisplayed(String regPlate) {
        return findElementByXpath("//XCUIElementTypeStaticText[@name='" + regPlate + "']").isDisplayed();
    }

    public boolean isTestTypeRecordPresentInList(String testTypeRecord) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name, '" + testTypeRecord + "')]").isDisplayed();
    }

    public boolean isTestTypeRecordPresentInListByStatus(String status) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name, '" + status + "')]").isDisplayed();
    }

    public void clickOnTestTypeRecord(String testTypeRecord) {
        findElementByXpath("//XCUIElementTypeButton[contains(@name, '" + testTypeRecord + "')]").click();
    }

}
