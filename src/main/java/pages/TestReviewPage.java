package pages;

import org.openqa.selenium.*;

import java.util.List;

public class TestReviewPage extends BasePage {
    private static final String SUBMIT_BUTTON_ID = "Submit test";
    private static final String SUBMIT_TESTS_BUTTON_ID = "Submit tests";
    private static final String NEXT_VEHICLE_BUTTON_ID = "Next vehicle";
    private static final String BACK_TO_TEST_ID = "arrow back Test";
    private static final String TEST_REVIEW_TITLE_ID = "Test";
    private static final String TEST_REVIEW_LONG_TITLE_ID = "Test review";
    private static final String CHANGE_DETAILS_BUTTON_ID = "Change details";
    private static final String CHANGE_VEHICLE_DETAILS_BUTTON_XPATH = "(//XCUIElementTypeButton[@name='Change details'][1])";
    private static final String CHANGE_TEST_DETAILS_BUTTON_XPATH = "(//XCUIElementTypeButton[@name='Change details'][2])";
    private static final String SAVE_CHANGED_DETAILS = "Save";
    private static final String POP_UP_SUBMIT_XPATH = "(//XCUIElementTypeButton[@name='Submit'])";
    private static final String POP_UP_CANCEL_XPATH = "(//XCUIElementTypeButton[@name='Cancel'])";
    private static final String POP_UP_TITLE_XPATH = "(//XCUIElementTypeOther[@name='Submit test'])";
    private static final String POP_UP_TEXT = "You will not be able to make changes to this test after it has been submitted.";
    private static final String LOADING_INDICATOR = "Loading...";
    private static final String ERROR_TITLE = "Unable to submit test";
    private static final String ERROR_TEXT = "Make sure you are connected to the Internet and try again.";
    private static final String ERROR_SETTINGS = "Settings";
    private static final String ERROR_TRY_AGAIN = "Try again";
    private static final String PREVIOUS_TEST_BUTTON_XPATH = "//XCUIElementTypeButton[contains(@name,'arrow back')]";
    private static final String ELEMENT_TEXT_ID = "XCUIElementTypeStaticText";

    public void goToTestPage() {
        findElementById(BACK_TO_TEST_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_REVIEW_LONG_TITLE_ID);
    }

    public boolean checkPageTitleIsDisplayed() {
        WebElement element;
        element = findElementById(TEST_REVIEW_TITLE_ID);
        if (element == null) {
            element = findElementById(TEST_REVIEW_LONG_TITLE_ID);
            return element.isDisplayed();
        }
        else {
            return element.isDisplayed();
        }
    }

    public boolean checkDisplayedElement(String element) {
        // waitUntilPageIsLoaded();
        logger.info("Checking element is displayed: " + element);
        int numberOfElements = findElementsByXpath("//*[@name=\"" + element + "\"]").size();
        boolean status = false;
        if (numberOfElements == 1) {
            try {
                status = findElementByXpath("//*[@name=\"" + element + "\"]").isDisplayed();
                logger.info("Found (Displayed: " + status + ")");
            } catch (ElementNotVisibleException e) {
                status = false;
                logger.info("Element was found but is not visible");
            }
        }
        if (numberOfElements > 1) {
            try {
                status = findElementByXpath("//*[@name=\"" + element + "\"][@visible=\"true\"]").isDisplayed();
                logger.info("Found (Displayed: " + status + ")");
            } catch (ElementNotVisibleException e) {
                status = false;
                logger.info("Element was found but is not visible");
            }
        }
        if (numberOfElements == 0) {
            throw new NoSuchElementException("No elements found");
        }
        return status;
    }

    public void clickChangeDetailsButton() {
        findElementById(CHANGE_DETAILS_BUTTON_ID).click();
    }

    public boolean isChangeDetailsButtonDisplayed() {
        boolean status;
        logger.info("Checking if element is displayed: " + CHANGE_DETAILS_BUTTON_ID);
        try {
            status = findElementById(CHANGE_DETAILS_BUTTON_ID).isDisplayed();
            logger.info("Found");
        } catch (NoSuchElementException e) {
            status = false;
            logger.info("- NOT found");
        }

        return status;
    }

    public void clickChangeVehicleDetailsButton() {
        findElementByXpath(CHANGE_VEHICLE_DETAILS_BUTTON_XPATH).click();
    }

    public void clickChangeTestDetailsButton() {
        findElementByXpath(CHANGE_TEST_DETAILS_BUTTON_XPATH).click();
    }

    public boolean isChangeTestDetailsButtonDisplayed() {
        boolean status;
        try {
            status = findElementByXpath(CHANGE_TEST_DETAILS_BUTTON_XPATH).isDisplayed();
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
        List<WebElement> allTexts = findElementsByClassName(ELEMENT_TEXT_ID);
        for(int i  = 0; i < allTexts.size() - 1; i++){
            if(allTexts.get(i).getAttribute("name").equals(testType) && allTexts.get(i+1).getAttribute("name").equals(status)){
                return true;
            }
        }
        return false;
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
            status = findElementByXpath(POP_UP_TITLE_XPATH).isDisplayed() && findElementByAccessibilityId(POP_UP_TEXT).isDisplayed()
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

    public void clickNextVehicle() {
        findElementByAccessibilityId(NEXT_VEHICLE_BUTTON_ID).click();
    }

    public void clickSubmitTestsButton() {
        findElementByAccessibilityId(SUBMIT_TESTS_BUTTON_ID).click();

    }

    public void goToPreviousVehicle() {
        findElementByXpath(PREVIOUS_TEST_BUTTON_XPATH).click();
    }

    public void checkOnlyOneChangeDetailsIsDisplayed() {
        assert (findElementsByAccessibilityId(CHANGE_DETAILS_BUTTON_ID).size() == 1);
    }
}
