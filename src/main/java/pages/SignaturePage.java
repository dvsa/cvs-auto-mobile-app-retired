package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignaturePage extends BasePage {

    Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    private static final String CLEAR_BUTTON_ID = "Clear";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String SIGNATURE_TITLE_XPATH = "//XCUIElementTypeOther[@name=\"Signature\"]";
    private static final String SIGNATURE_TEXT_INSTRUCTIONS_ID = "USE YOUR FINGER TO SIGN BELOW";
    private static final String SIGNATURE_TEXT_INSTRUCTIONS_2_ID = "Once you are happy with your signature, select 'Save'. After it has been saved, it cannot be edited and will be used each time you need to sign a certificate.";
    private static final String CANCEL_SIGNATURE_POP_UP_ID = "Cancel";
    private static final String CONFIRM_SIGNATURE_POP_UP_ID = "Confirm";
    private static final String UNABLE_TO_LOAD_DATA_ID = "Unable to load data";


    public void clickClearButton() {
        findElementById(CLEAR_BUTTON_ID).click();
    }

    public void clickSaveButton() {
       logger.info("Saving signature...");
        WebElement we = findElementByAccessibilityId(SAVE_BUTTON_ID);
        tapByCoordinates(700, 20);
       logger.info("Signature saved.");
    }

    public boolean checkSignatureTitleIsDisplayed() {
        return findElementByXpath(SIGNATURE_TITLE_XPATH).isDisplayed();
    }

    public void confirmSignature() {
       logger.info("Confirming signature...");
        WebElement we = waitUntilPageIsLoadedByElementPresent(MobileBy.AccessibilityId(CONFIRM_SIGNATURE_POP_UP_ID), 50, 200);
        tapByCoordinates(we.getLocation().getX(), we.getLocation().getY());
       logger.info("- Confirmed");
    }

    public void cancelSignatureConfirmation() {
        findElementById(CANCEL_SIGNATURE_POP_UP_ID).click();
    }

    public void createSignature() {
//        longWaitUntilPageIsLoadedByIdAndClickable(SAVE_BUTTON_ID);
       logger.info("Creating signature...");
        tapByCoordinates(50, 100);
       logger.info("Signed.");
    }

    public boolean isErrorMessageDisplayed() {
        boolean status;
       logger.info("Checking if error message is displayed: " + UNABLE_TO_LOAD_DATA_ID);
        try {
            if (findElementById(UNABLE_TO_LOAD_DATA_ID) != null) {
                status = findElementById(UNABLE_TO_LOAD_DATA_ID).isDisplayed();
            }
            else {
                status = false;
            }
           logger.info("Found");
        } catch (NoSuchElementException e) {
            status = false;
           logger.info("- Not found");
        }
        return status;
    }

    public void waitPageToLoad() throws Exception {
       logger.info("Waiting for Signature page to load...");
        waitUntilPageIsLoadedByAccessibilityId(SIGNATURE_TEXT_INSTRUCTIONS_ID);
        waitForLoadingToFinish();
       logger.info("- Signature page loaded.");

        // Check to see if there was an error shown (either caused by
        // 1. The Signature service not being available, or
        // 2. Reference data not being present, e.g. defects, test types, etc.
        if (isErrorMessageDisplayed()) {
           logger.info("*** Error starting the app - unable to load setup data.");
            throw new Exception("Signature service or Reference Data unavailable.  Unable to proceed with app initialisation.");
        }
    }

    public void shortestWaitPageToLoad() {
        shortestUntilPageIsLoadedByAccessibilityId(SIGNATURE_TEXT_INSTRUCTIONS_2_ID);
    }
}
