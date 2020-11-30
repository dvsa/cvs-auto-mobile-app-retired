package pages;

import org.openqa.selenium.NoSuchElementException;

public class ConfirmationPage extends BasePage {

    private static String DONE_BUTTON_ID = "Done";


    public void clickDoneButton() {
        logger.debug(" DONE:  " + getDriver().getPageSource());
        findElementById(DONE_BUTTON_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(DONE_BUTTON_ID);
    }

    public boolean checkElementContainingStringIsDisplayed(String string) {
        boolean status;
        try {
            status = findElementByXpath("//*[contains(@name,'" + string + "')]").isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }

        return status;
    }
}
