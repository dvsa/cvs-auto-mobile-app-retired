package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PreparerPage extends BasePage {

    private static final String PAGE_TITLE_ID = "Enter preparer ID";
    private static final String VEHICLE_DETAILS_BACK_ID = "arrow back Vehicle details";
    private static final String LABEL_ID = "If you are shown a preparer ID, add this to the test now";
    private static final String SEARCH_PREPARER_ID = "//XCUIElementTypeTextField";
    private static final String START_TEST_BUTTON_ID = "Start Test";
    private static final String CANCEL_BUTTON_ID = "Cancel";
    private static final String CONFIRM_BUTTON_ID = "Confirm";
    private static final String CONTINUE_BUTTON_ID = "Continue";
    private static final String SEARCH_AGAIN_BUTTON_ID = "Search again";

    private static final String PREPARER_FOUND_LABEL_ID = "You are about to add this preparer to the test.";

    private static final String PREPARER_NOT_FOUND_MESSAGE_XPATH = "//XCUIElementTypeStaticText[@name=\"Preparer not found\"]";
    private static final String PREPARER_NOT_FOUND_LABEL_ID = "You can continue without adding a preparer ID or search again.";

    private static final String WITHOUT_PREPARER_MESSAGE_XPATH = "//XCUIElementTypeStaticText[@name=\"Continue without preparer ID\"]";
    private static final String WITHOUT_PREPARER_LABEL_ID = "You won't be able to add this information later.";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public boolean isTitleDisplayed() {
        return findElementById(LABEL_ID).isDisplayed();
    }

    public boolean isPreparerFoundPopUpDisplayed(String preparerId) {
        boolean isLabelDisplayed = findElementById(PREPARER_FOUND_LABEL_ID).isDisplayed();
        boolean isCancelOptionDisplayed = findElementById(CANCEL_BUTTON_ID).isDisplayed();
        boolean isConfirmOptionDisplayed = findElementById(CONFIRM_BUTTON_ID).isDisplayed();
        boolean isPreparerFoundMessageDisplayed = findElementByXpath("//XCUIElementTypeStaticText[@name=\"Durrell Vehicles Limited (" + preparerId + ")\"]").isDisplayed();

        if (isPreparerFoundMessageDisplayed && isCancelOptionDisplayed && isConfirmOptionDisplayed && isLabelDisplayed) {
            return true;
        } else return false;
    }

    public boolean isPreparerNotFoundPopUpDisplayed() {
        boolean isMessageDisplayed = findElementByXpath(PREPARER_NOT_FOUND_MESSAGE_XPATH).isDisplayed();
        boolean isSearchAgainOptionDisplayed = findElementById(SEARCH_AGAIN_BUTTON_ID).isDisplayed();
        boolean isContinueOptionDisplayed = findElementById(CONTINUE_BUTTON_ID).isDisplayed();
        boolean isLabelDisplayed = findElementById(PREPARER_NOT_FOUND_LABEL_ID).isDisplayed();

        if (isMessageDisplayed && isSearchAgainOptionDisplayed && isContinueOptionDisplayed && isLabelDisplayed) {
            return true;
        } else return false;
    }

    public boolean isWithoutPreparerPopUpDisplayed() {
        boolean isMessageDisplayed = findElementByXpath(WITHOUT_PREPARER_MESSAGE_XPATH).isDisplayed();
        boolean isCancelOptionDisplayed = findElementById(CANCEL_BUTTON_ID).isDisplayed();
        boolean isConfirmOptionDisplayed = findElementById(CONFIRM_BUTTON_ID).isDisplayed();
        boolean isLabelDisplayed = findElementById(WITHOUT_PREPARER_LABEL_ID).isDisplayed();

        if (isMessageDisplayed && isCancelOptionDisplayed && isConfirmOptionDisplayed && isLabelDisplayed) {
            return true;
        } else return false;
    }

    public boolean isLableDisplayed() {
        return findElementById(PAGE_TITLE_ID).isDisplayed();
    }

    public void confirmPopUpOption() {
        findElementById(CONFIRM_BUTTON_ID).click();
    }

    public void cancelPopUpOption() {
        findElementById(CANCEL_BUTTON_ID).click();
    }

    public void searchAgainPopUpOption() {
        findElementById(SEARCH_AGAIN_BUTTON_ID).click();
    }

    public void continuePopUpOption() {
        findElementById(CONTINUE_BUTTON_ID).click();
    }

    public void clickBackButton() {
        findElementById(VEHICLE_DETAILS_BACK_ID).click();
    }

    public void clickStartTest() {
        findElementById(START_TEST_BUTTON_ID).click();
    }

    public void searchForPreparerId(String preparerId) {
        WebElement searchBar = findElementByXpath(SEARCH_PREPARER_ID);
        searchBar.clear();
        searchBar.sendKeys(preparerId);
        clickStartTest();
    }
}
