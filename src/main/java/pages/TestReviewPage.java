package pages;

import org.openqa.selenium.*;

public class TestReviewPage extends BasePage {
    private static final String SUBMIT_BUTTON_ID = "Submit";
    private static final String BACK_TO_TEST_ID = "arrow back Test";
    private static final String TEST_REVIEW_TITLE_ID = "Test review";
    private static final String CHANGE_DETAILS_BUTTON_ID = "Change details";
    private static final String SAVE_CHANGED_DETAILS = "Save";
    private static final String POP_UP_SUBMIT_XPATH = "(//XCUIElementTypeButton[@name='Submit'])[2]";
    private static final String POP_UP_CANCEL_XPATH = "(//XCUIElementTypeButton[@name='Cancel'])";
    private static final String POP_UP_TITLE = "Submit test";
    private static final String POP_UP_TEXT = "You will not be able to make changes to this test after it has been submitted.";
    private static final String LOADING_INDICATOR = "Loading...";
    private static final String ERROR_TITLE = "Unable to submit test";
    private static final String ERROR_TEXT = "Make sure you are connected to the Internet and try again.";
    private static final String ERROR_SETTINGS = "Settings";
    private static final String ERROR_TRY_AGAIN = "Try again";


    public void goToTestPage() {
        findElementById(BACK_TO_TEST_ID).click();
    }

    public void clickGoToTestOverviewScreen() {
        findElementById(BACK_TO_TEST_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_REVIEW_TITLE_ID);
    }

    public boolean checkPageTitleIsDisplayed() {
        return findElementById(TEST_REVIEW_TITLE_ID).isDisplayed();
    }

    public boolean checkDisplayedElement(String element) {
        boolean status;
        try {
            status = findElementByXpath("//*[@name=\"" + element + "\"]").isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }

        return status;
    }

    public void clickChangeDetailsButton() {
        findElementById(CHANGE_DETAILS_BUTTON_ID).click();
    }

    public boolean isChangeDetailsButtonDisplayed() {
        boolean status;
        try {
            status = findElementById(CHANGE_DETAILS_BUTTON_ID).isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }

        return status;
    }

    public void clickSaveChangedDetailsButton() {
        findElementById(SAVE_CHANGED_DETAILS).click();
    }

    public boolean checkEditableElement(String element) {
        WebElement we = findElementByXpath("//*[@name=\"" + element + "\"]");
        try {
            we.sendKeys("Test");
            return true;
        } catch (WebDriverException ex) {
            return false;
        }
    }

    public boolean verifyTestStatus(String testType, String status) {
        boolean isTestTypeDisplayed = checkDisplayedElement(testType);
        boolean isStatusDisplayed = checkDisplayedElement(status);

        if (isStatusDisplayed && isTestTypeDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    public void scrollPageDown() {
        scrollDownTo(500, -200);
    }

    public void clickSubmitButton() {
        findElementByAccessibilityId(SUBMIT_BUTTON_ID).click();
    }

    public void clickSubmitInPopUp() {
        findElementByXpath(POP_UP_SUBMIT_XPATH).click();
    }

    public void scrollPageUp() {
        scrollDownTo(500, 1000);
    }

    public boolean checkPopUpIsDisplayed() {
        boolean status;
        try {
            status = findElementByAccessibilityId(POP_UP_TITLE).isDisplayed() && findElementByAccessibilityId(POP_UP_TEXT).isDisplayed()
                    && findElementByXpath(POP_UP_SUBMIT_XPATH).isDisplayed() && findElementByXpath(POP_UP_CANCEL_XPATH).isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public void clickCancelInPopUp() {
        findElementByXpath(POP_UP_CANCEL_XPATH).click();
    }

    public boolean isLoadingIndicatorDisplayed() {
        return findElementByAccessibilityId(LOADING_INDICATOR).isDisplayed();
    }

    public boolean isErrorPopUpDisplayed() {
        boolean status;
        try {
            status = findElementByAccessibilityId(ERROR_TITLE).isDisplayed() && findElementByAccessibilityId(ERROR_TEXT).isDisplayed()
                    && findElementByAccessibilityId(ERROR_SETTINGS).isDisplayed() && findElementByAccessibilityId(ERROR_TRY_AGAIN).isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public void clickSettings() {
        findElementByAccessibilityId(ERROR_SETTINGS).click();
    }

    public boolean isDeviceSettingsPageDisplayed() {
        return findElementByAccessibilityId("Settings").isDisplayed();
    }

    public void clickTryAgain() {
        findElementByAccessibilityId(ERROR_TRY_AGAIN).click();
    }

    public boolean isLoadingIndicatorNotDisplayed() {
        waitUntilNumberOfElementsToBe(By.id(LOADING_INDICATOR), 0);
        return true;
    }
}
