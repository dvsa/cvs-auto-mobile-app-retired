package pages;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
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
        Point point = findElementByAccessibilityId(SAVE_BUTTON_ID).getLocation();
        int x = point.getX();
        int y = point.getY();
        tapByCoordinates(x, y);
    }

    public boolean checkSignatureTitleIsDisplayed() {
        return findElementByXpath(SIGNATURE_TITLE_XPATH).isDisplayed();
    }

    public void confirmSignature() {
        findElementById(CONFIRM_SIGNATURE_POP_UP_ID).click();
    }

    public void cancelSignatureConfirmation() {
        findElementById(CANCEL_SIGNATURE_POP_UP_ID).click();
    }

    public void createSignature() {
        tapByCoordinates(50,100);
    }

    public void waitPageToLoad() {
        waitUntilPageIsLoadedByXpath(SIGNATURE_TITLE_XPATH);
    }
}
