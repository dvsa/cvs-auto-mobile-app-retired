package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class CancelTestPage extends BasePage {

    private static final String PAGE_TITLE_ID = "Cancel test";
    private static final String REASON_INPUT_TITLE_ID = "REASON FOR CANCELLATION (REQUIRED)";
    private static final String BACK_BUTTON_ID = "arrow back Back";
    private static final String SUBMIT_BUTTON_ID = "Submit";
    private static final String REASON_TEXT_INPUT_XPATH = "//*[@type='XCUIElementTypeTextView']";
    private static final String INPUT_FIELD_TEXT_TIP_XPATH = "//*[@value='You are about to cancel all tests for this vehicle." +
            " You will not be able to edit this test later. The test will not be recorded against the vehicle and no certificate will be issued.']";
    private static final String NO_REASON_POP_UP_TITLE_ID = "Reason not entered";
    private static final String NO_REASON_POP_UP_TEXT_ID = "You must add a reason for cancelling this test to submit the cancellation.";
    private static final String NO_REASON_POP_UP_OK_ID = "Ok";
    private static final String SUBMIT_BUTTON_POP_UP_ID = "Submit";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE_ID).isDisplayed();
    }

    public boolean isTextTipDisplayed() {
        return findElementByXpath(INPUT_FIELD_TEXT_TIP_XPATH).isDisplayed();
    }

    public void clickOnBackButton() {
        findElementById(BACK_BUTTON_ID).click();
    }

    public boolean isInputTitleDisplayed() {
        return findElementById(REASON_INPUT_TITLE_ID).isDisplayed();
    }

    public void clickSubmit() {
        findElementById(SUBMIT_BUTTON_ID).click();
    }

    public boolean isInputFieldDisplayed() {
        return findElementByXpath(REASON_TEXT_INPUT_XPATH).isDisplayed();
    }

    public boolean isNoReasonPopUpTitleDisplayed() {
        WebElement title = null;
        try {
            title = findElementById(NO_REASON_POP_UP_TITLE_ID);
        } catch (Exception e) {
            System.out.println("The element with the id" + NO_REASON_POP_UP_TITLE_ID + "was not found!");
        }
        if (title != null) {
            return title.isDisplayed();
        } else
            return false;
    }

    public boolean isNoReasonPopUpTextDisplayed() {
        WebElement text = null;
        try {
            text = findElementById(NO_REASON_POP_UP_TEXT_ID);
        } catch (Exception e) {
            System.out.println("The element with the id" + NO_REASON_POP_UP_TEXT_ID + "was not found!");
        }
        if (text != null) {
            return text.isDisplayed();
        } else
            return false;
    }

    public boolean isNoReasonPopUpButtonDisplayed() {
        WebElement button = null;
        try {
            button = findElementById(NO_REASON_POP_UP_OK_ID);
        } catch (Exception e) {
            System.out.println("The element with the id" + NO_REASON_POP_UP_OK_ID + "was not found!");
        }
        if (button != null) {
            return button.isDisplayed();
        } else
            return false;
    }

    public void clickOnNoReasonPopUpOkButton() {
        findElementById(NO_REASON_POP_UP_OK_ID).click();
    }

    public void addReason(String text) {
        findElementByXpath(REASON_TEXT_INPUT_XPATH).sendKeys(text);
    }

    public void clickOutsideOfTextField() {
        findElementById(REASON_INPUT_TITLE_ID).click();
        findElementById(REASON_INPUT_TITLE_ID).click();
    }

    public String getReasonTextFromInput() {
        return findElementByXpath(REASON_TEXT_INPUT_XPATH).getAttribute("value");
    }

    public void clickSubmitInPopUp() {
        waitUntilNumberOfElementsToBe(MobileBy.AccessibilityId(SUBMIT_BUTTON_POP_UP_ID),2);
        findElementsByAccessibilityId(SUBMIT_BUTTON_POP_UP_ID).get(1).click();
    }
}
