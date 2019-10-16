package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class SignaturePage extends BasePage {

    private static final String CLEAR_BUTTON_ID = "Clear";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String SIGNATURE_TITLE_XPATH = "//XCUIElementTypeOther[@name=\"Signature\"]";
    private static final String SIGNATURE_TEXT_INSTRUCTIONS_ID = "USE YOUR FINGER TO SIGN BELOW";
    private static final String SIGNATURE_TEXT_INSTRUCTIONS_2_ID = "Once you are happy with your signature, select 'Save'. After it has been saved, it cannot be edited and will be used each time you need to sign a certificate.";
    private static final String CANCEL_SIGNATURE_POP_UP_ID = "Cancel";
    private static final String CONFIRM_SIGNATURE_POP_UP_ID = "Confirm";


    public void clickClearButton() {
        findElementById(CLEAR_BUTTON_ID).click();
    }

    public void clickSaveButton() {
        System.out.println("Saving signature...");
        WebElement we = findElementByAccessibilityId(SAVE_BUTTON_ID);
        tapByCoordinates(700, 20);
        System.out.println("- Signature saved.");
    }

    public boolean checkSignatureTitleIsDisplayed() {
        return findElementByXpath(SIGNATURE_TITLE_XPATH).isDisplayed();
    }

    public void confirmSignature() {
        WebElement we = waitUntilPageIsLoadedByElementPresent(MobileBy.AccessibilityId(CONFIRM_SIGNATURE_POP_UP_ID), 50, 200);
        tapByCoordinates(we.getLocation().getX(), we.getLocation().getY());
    }

    public void cancelSignatureConfirmation() {
        findElementById(CANCEL_SIGNATURE_POP_UP_ID).click();
    }

    public void createSignature() {
//        longWaitUntilPageIsLoadedByIdAndClickable(SAVE_BUTTON_ID);
        System.out.println("Creating signature...");
        tapByCoordinates(50, 100);
        System.out.println("- Signed.");
    }

    public void waitPageToLoad() {
        System.out.println("Waiting for Signature page to load...");
        waitUntilPageIsLoadedByAccessibilityId(SIGNATURE_TEXT_INSTRUCTIONS_2_ID);
        waitForLoadingToFinish();
        System.out.println(getDriver().getPageSource());
        System.out.println("- Signature page loaded.");
    }

    public void shortestWaitPageToLoad() {
        shortestUntilPageIsLoadedByAccessibilityId(SIGNATURE_TEXT_INSTRUCTIONS_2_ID);
    }
}
