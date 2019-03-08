package pages;

import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.interactions.Actions;

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
        Actions actions = new Actions(((WebDriverFacade) getDriver()).getProxiedDriver());
        actions.moveToElement(findElementById(SAVE_BUTTON_ID)).build().perform();
        actions.click();
    }

    public boolean checkSignatureTitleIsDisplayed() {
        return findElementByXpath(SIGNATURE_TITLE_XPATH).isDisplayed();
    }

    public void confirmSignature() {
        waitUntilPageIsLoadedById(CONFIRM_SIGNATURE_POP_UP_ID);
        Actions actions = new Actions(((WebDriverFacade) getDriver()).getProxiedDriver());
        actions.moveToElement(findElementById(CONFIRM_SIGNATURE_POP_UP_ID)).build().perform();
        actions.click();

//            actions.click();
 //       int i = 0;
//        while (findElementById(CANCEL_SIGNATURE_POP_UP_ID).isDisplayed()) {
//            actions.moveToElement(findElementById(CONFIRM_SIGNATURE_POP_UP_ID)).build().perform();
//            actions.click();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            i++;
//            if (i == 10) break;
//            else continue;}

    }

    public void cancelSignatureConfirmation() {
        findElementById(CANCEL_SIGNATURE_POP_UP_ID).click();
    }

    public void createSignature() {
        tapByCoordinates(50, 100);
    }

    public void waitPageToLoad() {
        waitUntilPageIsLoadedByXpath(SIGNATURE_TITLE_XPATH);
    }
}
